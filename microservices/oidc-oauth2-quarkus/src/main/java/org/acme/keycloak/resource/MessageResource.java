package org.acme.keycloak.resource;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.acme.keycloak.response.BaseResponse;
import org.acme.keycloak.restclient.SpringBootClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/message")
@ApplicationScoped
@Slf4j
public class MessageResource {

    @RestClient
    private SpringBootClient springBootClient;

    /**
     * This is a sample REST API to securely (using OIDC) invoke downstream microservice
     * and fetch response.
     *
     * @return - Response
     */
    @GET
    @Path("/fetch")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<BaseResponse> getMessage() {
        log.info("getMessage: Start");
        return springBootClient.getMessage();
    }

}
