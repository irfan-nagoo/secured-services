package org.acme.keycloak.restclient;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.acme.keycloak.domain.Token;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * @author irfan.nagoo
 */

@RegisterRestClient(configKey = "keycloak")
@Path("/protocol/openid-connect")
public interface KeyCloakClient {

    @POST
    @Path("/token")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Uni<Token> getAccessToken(@RequestBody String grantType, @HeaderParam("Authorization") String authorization);

}
