package com.whateverer.feature.auth.utils

import com.whateverer.exception.BusinessException
import com.whateverer.feature.auth.model.dto.LoginRequest
import org.springframework.stereotype.Component

@Component
class AuthValidator {

    fun validateLoginRequest(request: LoginRequest) {
        if (request.username.isBlank()) {
            throw BusinessException("Username is required.")
        }

        if (request.password.isBlank()) {
            throw BusinessException("Password is required.")
        }
    }
}