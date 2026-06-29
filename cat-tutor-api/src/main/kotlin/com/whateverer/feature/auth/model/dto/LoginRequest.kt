package com.whateverer.feature.auth.model.dto

import jakarta.validation.constraints.NotBlank

data class LoginRequest(

    @field:NotBlank(message = "Username is required.")
    val username: String,

    @field:NotBlank(message = "Password is required.")
    val password: String
)