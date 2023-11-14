package com.airconmoa.airconmoa.user.controller;

import com.airconmoa.airconmoa.domain.User;
import com.airconmoa.airconmoa.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Operation(summary = "업체 정보 출력", description = "업체 정보")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "업체정보 출력 성공"),
    })
    @GetMapping("/info")
    public String userInfo(Authentication auth) {
        Optional<User> op_loginUser = userService.getUserByEmail(auth.getName());
        User loginUser = op_loginUser.get();

        return String.format("email : %s\nnickname : %s\nrole : %s",
                loginUser.getEmail(), loginUser.getNickname(), loginUser.getRole().name());
    }
}
