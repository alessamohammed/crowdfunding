package com.example.crowdfunding.controller;

import com.example.crowdfunding.config.UserAuthProvider;
import com.example.crowdfunding.dto.CredentialDto;
import com.example.crowdfunding.dto.SignUpDto;
import com.example.crowdfunding.dto.UserDto;
import com.example.crowdfunding.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final UserService userService;
    private final UserAuthProvider userAuthProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody CredentialDto credentialDto) {
        UserDto user = userService.login(credentialDto);

        user.setToken(userAuthProvider.createToken(user.getLogin()));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody SignUpDto signUpDto) {
        UserDto user = userService.register(signUpDto);

        user.setToken(userAuthProvider.createToken(user.getLogin()));
        return ResponseEntity
                .created(URI.create("/users/"
                        + user.getId())).body(user);
    }
}
