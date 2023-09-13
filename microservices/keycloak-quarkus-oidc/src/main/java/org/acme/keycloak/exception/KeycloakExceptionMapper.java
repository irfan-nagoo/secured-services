package org.acme.keycloak.exception;

import io.netty.handler.codec.http.HttpResponseStatus;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;
import org.acme.keycloak.response.ErrorResponse;
import org.jboss.resteasy.reactive.ClientWebApplicationException;

import java.util.UUID;

import static org.acme.keycloak.constants.MessagingConstants.INVALID_CLIENT_MSG;
import static org.acme.keycloak.constants.MessagingConstants.PROCESSING_ERROR;

/**
 * @author irfan.nagoo
 */

@Provider
@Slf4j
public class KeycloakExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable e) {
        String errorId = UUID.randomUUID().toString();
        log.error("Processing error occurred with errorId[{}]: ", errorId, e);
        if (e instanceof ClientWebApplicationException) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(new ErrorResponse(HttpResponseStatus.UNAUTHORIZED.reasonPhrase(), INVALID_CLIENT_MSG, errorId))
                    .build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ErrorResponse(HttpResponseStatus.INTERNAL_SERVER_ERROR.reasonPhrase(), PROCESSING_ERROR, errorId))
                    .build();
        }
    }

}
