package org.acme.keycloak.restclient;

import io.quarkus.oidc.client.reactive.filter.OidcClientRequestReactiveFilter;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.acme.keycloak.response.BaseResponse;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * @author irfan.nagoo
 */

@RegisterRestClient(configKey = "springboot")
@RegisterProvider(OidcClientRequestReactiveFilter.class)
@Path("/sample")
public interface SpringBootClient {

    @GET
    @Path("/message")
    Uni<BaseResponse> getMessage();

}
