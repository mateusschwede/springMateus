package com.whateverer.feature.auth.service

import com.whateverer.feature.auth.model.dto.LoginRequest
import com.whateverer.feature.auth.model.dto.LoginResponse
import org.springframework.stereotype.Service

@Service
class LoginService(
    private val authService: AuthService
) {

    fun execute(request: LoginRequest): LoginResponse =
        authService.login(request)
}