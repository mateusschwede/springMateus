package com.whateverer.security.provider

import com.whateverer.feature.auth.service.TokenService
import org.springframework.stereotype.Component

@Component
class JwtTokenProvider(
    private val tokenService: TokenService
) {

    fun generateToken(username: String): String =
        tokenService.generateToken(username)

    fun validateToken(token: String): Boolean =
        tokenService.validateToken(token)

    fun extractUsername(token: String): String =
        tokenService.extractUsername(token)
}