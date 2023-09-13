package com.example.oidc.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author irfan.nagoo
 */

@RequiredArgsConstructor
@Getter
public class ErrorResponse {

    private final String status;
    private final String message;
    private final String errorId;
}
