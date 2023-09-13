package org.acme.keycloak.resource;

import io.netty.handler.codec.http.HttpResponseStatus;
import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.acme.keycloak.response.BaseResponse;

import static org.acme.oidc.constants.MessagingConstants.CLIENT_AUTHORIZED_MSG;

@Path("/authorization")
@ApplicationScoped
@Slf4j
public class AuthorizationResource {

    @Inject
    private SecurityIdentity identity;

    /**
     * This is a sample REST API to validate the access credentials provided.
     *
     * @return - Response
     */
    @GET
    @Path("/decision")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<BaseResponse> isAuthorized() {
        log.info("isAuthorized: Start");
        return Uni.createFrom().item(new BaseResponse(HttpResponseStatus.OK.reasonPhrase(),
                String.format(CLIENT_AUTHORIZED_MSG, identity.getPrincipal().getName())));
    }

}
