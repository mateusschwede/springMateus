package com.whateverer.feature.auth.service

import com.whateverer.feature.auth.model.dto.LoginRequest
import com.whateverer.feature.auth.model.dto.LoginResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val authenticationManager: AuthenticationManager,
    private val tokenService: TokenService
) {

    fun login(request: LoginRequest): LoginResponse {
        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                request.username,
                request.password
            )
        )

        val accessToken = tokenService.generateToken(authentication)

        return LoginResponse(
            accessToken = accessToken,
            expiresIn = tokenService.getExpirationTime()
        )
    }
}