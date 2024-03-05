package com.airconmoa.airconmoa.company.controller;

import com.airconmoa.airconmoa.company.dto.CompanyLoginReq;
import com.airconmoa.airconmoa.company.dto.CompanySignupReq;
import com.airconmoa.airconmoa.company.dto.CompanySignupRes;
import com.airconmoa.airconmoa.company.service.CompanyService;
import com.airconmoa.airconmoa.domain.Company;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/company")
public class CompanyController {
    private final CompanyService companyService;

    @Operation(summary = "업체 회원가입", description = "업체 회원가입 후 DB에 저장")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "업체 회원가입 성공"),
            @ApiResponse(responseCode = "400", description = "요청 변수 에러",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{ \"msg\": \"같은 이메일이 이미 존재합니다\","
                                    + " \"data\": \"null\"}")))
    })
    @PostMapping("/signup")
    public ResponseEntity<CompanySignupRes> signUp(@RequestBody CompanySignupReq request) {
        Company company = companyService.signup(request);
        if (company == null) return null; //예회처리 할 예정
        CompanySignupRes res = CompanySignupRes.builder()
                .companyId(company.getCompanyId())
                .email(company.getCompanyEmail())
                .companyName(company.getCompanyName())
                .build();
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "업체 로그인", description = "업체 로그인")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "업체 로그인 성공"),
            @ApiResponse(responseCode = "400", description = "요청 변수 에러",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(value = "{ \"msg\": \"아이디 또는 비밀번호가 틀렸습니다\","
                                    + " \"data\": \"null\"}")))
    })
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody CompanyLoginReq request) {
        return ResponseEntity.ok(companyService.login(request));

    }

    //업체 정보 출력
    @Operation(summary = "업체 정보 출력", description = "업체 정보")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "업체정보 출력 성공"),
    })
    @GetMapping("/info")
    public ResponseEntity<String> companyInfo(Authentication auth) {
        Company company = companyService.getCompanyByEmail(auth.getName());

        return ResponseEntity.ok(String.format("email : %s\nnickname : %s\nrole : %s",
                company.getCompanyEmail(), company.getCompanyName(), company.getRole().name()));
    }
}
