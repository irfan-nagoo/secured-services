package com.example.oidc.controller;

import com.example.oidc.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.oidc.constants.MessagingConstants.SUCCESS_MSG;

/**
 * @author irfan.nagoo
 */

@RestController
@RequestMapping("/sample")
@Slf4j
public class SampleController {


    @GetMapping("/message")
    public BaseResponse getMessage(@AuthenticationPrincipal OAuth2User principalUser) {
        log.info("getMessage: Start");
        String userName = principalUser != null ? principalUser.getAttribute("name") : "Unknown";
        return new BaseResponse(HttpStatus.OK.name(),
                String.format(SUCCESS_MSG, userName));
    }
}
