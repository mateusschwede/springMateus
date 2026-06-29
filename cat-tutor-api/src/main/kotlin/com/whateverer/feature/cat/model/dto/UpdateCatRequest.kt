package com.whateverer.feature.cat.model.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import java.time.LocalDate

data class UpdateCatRequest(

    @field:NotBlank(message = "Name is required.")
    val name: String,

    @field:NotBlank(message = "Breed is required.")
    val breed: String,

    @field:NotNull(message = "Birth date is required.")
    @field:Past(message = "Birth date must be in the past.")
    val birthDate: LocalDate,

    @field:NotNull(message = "Weight is required.")
    @field:Min(value = 1, message = "Weight must be greater than zero.")
    val weight: Float
)