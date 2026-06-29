package com.whateverer.feature.auth.model.dto

data class LoginResponse(
    val accessToken: String,
    val tokenType: String = "Bearer",
    val expiresIn: Long
)