package com.whateverer.feature.auth.utils

import com.whateverer.feature.auth.model.dto.LoginResponse
import org.springframework.stereotype.Component

@Component
class AuthMapper {

    fun toLoginResponse(
        accessToken: String,
        expiresIn: Long
    ): LoginResponse =
        LoginResponse(
            accessToken = accessToken,
            expiresIn = expiresIn
        )
}