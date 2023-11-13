package com.airconmoa.airconmoa.user.controller;

import com.airconmoa.airconmoa.domain.User;
import com.airconmoa.airconmoa.user.dto.UserSignupReq;
import com.airconmoa.airconmoa.user.dto.UserSignupRes;
import com.airconmoa.airconmoa.user.service.AuthService;
import com.airconmoa.airconmoa.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class AuthController {

    private final UserService userService;

    private final AuthService authService;

    @Operation(summary = "유저 회원가입", description = "유저 회원가입 후 DB에 저장")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "유저 회원가입 성공"),
            @ApiResponse(responseCode = "400", description = "요청 변수 에러",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{ \"msg\": \"이미 존재하는 회원입니다\","
                                    + " \"data\": \"null\"}")))
    })
    @PostMapping("/signup")
    public ResponseEntity<UserSignupRes> signUp(@RequestBody UserSignupReq request) {
        //프런트에게 받을 accessToken을 테스트용으로 발급한 코드
//        String token = authService.getKakaoAccessToken
//                ("CbM0_fMMugxT6r5EJvtRyPbQx1P3NEjTKa9riaSxD2o5D1YnQJq4-DV9UVQKKiVOAAABi3XSdRKi-KZYUq23DA");
        User user = authService.saveUser(request.getAuthType(), request.getAccessToken());
        return ResponseEntity.ok(new UserSignupRes(user.getNickname(), user.getUserId()));
    }

    @Operation(summary = "유저 로그인", description = "유저 로그인")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "유저 로그인 성공"),
            @ApiResponse(responseCode = "400", description = "요청 변수 에러",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{ \"msg\": \"잘못된 토큰입니다\","
                                    + " \"data\": \"null\"}")))
    })
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserSignupReq request) {
        //프런트에게 받을 accessToken을 테스트용으로 발급한 코드
//        String token = authService.getKakaoAccessToken
//                ("E0217FS-3faKpiheVTRELn9ERbHFx3X-ogxvVJfYbFGZLQE9nmHN6mrAdc4KKiUQAAABi3XTKcqm1x-HnlkNwQ");
        return ResponseEntity.ok(authService.login(request.getAuthType(), request.getAccessToken()));
    }

}
