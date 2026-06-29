package com.whateverer.feature.auth.controller

import com.whateverer.feature.auth.model.dto.LoginRequest
import com.whateverer.feature.auth.model.dto.LoginResponse
import com.whateverer.feature.auth.service.AuthService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService
) {

    @PostMapping("/login")
    fun login(
        @Valid @RequestBody request: LoginRequest
    ): ResponseEntity<LoginResponse> =
        ResponseEntity.ok(authService.login(request))
}