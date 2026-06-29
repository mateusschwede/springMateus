package com.whateverer.feature.tutor.model.dto

import com.whateverer.feature.tutor.model.entity.TutorGender
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Pattern
import java.time.LocalDate

data class UpdateTutorRequest(

    @field:NotBlank(message = "CPF is required.")
    @field:Pattern(
        regexp = "\\d{11}",
        message = "CPF must contain exactly 11 digits."
    )
    val cpf: String,

    @field:NotBlank(message = "Name is required.")
    val name: String,

    @field:NotNull(message = "Birth date is required.")
    @field:Past(message = "Birth date must be in the past.")
    val birthDate: LocalDate,

    @field:NotNull(message = "Gender is required.")
    val gender: TutorGender
)