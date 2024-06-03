package com20.task5.api;

import com20.task5.dto.authenticationDto.AuthenticationResponse;
import com20.task5.dto.authenticationDto.SignInRequest;
import com20.task5.dto.authenticationDto.SignUpRequest;
import com20.task5.dto.userDto.UserResponse;
import com20.task5.serivce.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/")
@Tag(name = "Authentication API")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationApi {
    private final AuthenticationService authenticationService;

    @PostMapping("/signUp")
    @Operation(summary = "for sign up click here")
    public AuthenticationResponse signUp(@RequestBody SignUpRequest signUpRequest) {
        return authenticationService.signUp(signUpRequest);
    }

    @PostMapping("/signIn")
    @Operation(summary = "for sign in click here")
    public AuthenticationResponse signIn(@RequestBody SignInRequest signInRequest) {
        return authenticationService.signIn(signInRequest);
    }

    @GetMapping("/showAllUser")
    @Operation(summary = "to show all users")
    public List<UserResponse> getAllUsers() {
        return authenticationService.getAllUsers();
    }
}
