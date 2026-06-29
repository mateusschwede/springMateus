package com.whateverer.feature.auth.model.dto

import jakarta.validation.constraints.NotBlank

data class RefreshTokenRequest(

    @field:NotBlank(message = "Refresh token is required.")
    val refreshToken: String
)