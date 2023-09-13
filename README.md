# secured-services

![logo](https://github.com/raptor-23/secured-services/assets/142492599/9375daeb-b3a7-4008-b20a-bbf2ecea7b11)


This project is about introducing the security aspect (authentication and authorization) into the web applications, mobile applications, microservices etc. using OpenIDConnect (OIDC) protocol powered by Oauth2.0 protocol. The [Oauth2.0](https://oauth.net/2/) is the standard authorization protocol which is highly used across the industry. The OpenIDConnect protocol is built on top of Oauth2.0 providing authentication, user profile etc. services in addition to Oauth2.0 features. This project covers major aspects of OIDC and Oauth2.0 protocols including SSO (Single Sign On). This project is packaged with Microservice applications which are configured to use [Keycloak](https://www.keycloak.org/) as an OIDC provider. However, these microservice applications are not specific to Keycloak and can work with any OIDC compliant provider e.g. OpenAM, Ping Fedrate, Okta etc. with some changes in configurations in the properties file.


## Keycloak

KeyCloak is an OIDC server which offers authentication and authorization features. The Keycloak configuration required to run the applications is provided in this project and could be imported into Keycloak easily through Admin GUI. We can also manually create the Keycloak configurations by referring to the properties file in the Microservice applications. The main entitles to be created are realm, clients (public and confidential) and user in the realm.


## SpringBoot Web application (Authorization code with PKCE)

This application handles the [OAuth2.0 Authorization code with PKCE](https://oauth.net/2/pkce/) grant type (default config) which is considered as the most secured authorization flow. Some of the OIDC provider many not support PCKE as yet. In that case, refer to properties file and enable standard Authorization code grant without PKCE. We need to create a public client as client secret is not required for Authorization with PKCE flow. This [Oauth2.0](https://aaronparecki.com/oauth-2-simplified/) grant type is generally suitable for Web applications and Mobile applications. 

This Micorservice application has following features:

  1. UI components which uses OIDC to authenticates with Keycloak and uses Oauth2.0 Authorization Code with PKCE grant type for authorization. This flow could be triggered by invoke the root conext url: http://localhost:8082/. The Authorization Code with PKCE grant type confirms the validity of the client and makes sure that the authorization code is not hacked by the attackers.
  2. It has SSO (Single Sign On) feature which means once authorized, the user need not login again within the browser till the access token expires.
  3. The Swagger UI which is configured with all OIDC authorization grants (without PKCE). Once the user/client does login successfully, Swagger will automatically insert Authorization (Bearer) header on all the subsquent REST APIs calls. If we want to generate the access token manually, we can use the Quarkus Microservice open endpoint (packaged with this project) to generate the access token and use it directly in the Bearer authorization type section.


## Quarkus Microservice application (Client Credentials)

This application mainly handles the [Oauth2.0 Client Credentails](https://oauth.net/2/grant-types/client-credentials/) grant type. However it also supports Authorization code (without PKCE) grant type through Swagger UI. We need to create a confidential client for this flow as client secret is required in this flow. The Client Credentials grant type is generally suitable for Microservices, Scheduled jobs etc. used within the internal systems. 

This Micorservice application has following features:

  1. An open Token generation REST API to generate access tokens for any client and those tokens could be used with any REST client (Swagger, Insomnia, Postman etc.) by setting the Authorization (Bearer) header.
  2. A sample Message REST API to communicate with SpringBoot Microservice securely using OIDC OAuth2.0 Client Credentials grant type. This API internally uses a filter to generate the new access token for the SpringBoot application using client-id and secret. 
  3. The Swagger UI which is configured with all OIDC authorization flows (without PKCE). Once the user/client does login successfully, Swagger will automatically insert Authorization (Bearer) header on all the subsequent REST APIs calls. If we want to generate the access token manually, we can use the REST API mentioned above to generate the access token and use it directly in the Bearer authorization type section.

## Configuration

Keycloak 22.0.1 with Java 17  
The Micorservice applications require Java 11.  

For configuration, we need to import the Keycloak configuration and update the properties file with the custom Keycloak (or any other OIDC provider) configuration before we can start these applications.


