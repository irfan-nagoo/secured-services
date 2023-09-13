package org.acme.keycloak.response;

import lombok.Getter;
import org.acme.keycloak.domain.Token;

/**
 * @author irfan.nagoo
 */

@Getter
public class TokenResponse extends BaseResponse {
    private final Token jwt;

    public TokenResponse(String status, String message, Token token) {
        super(status, message);
        this.jwt = token;
    }
}
