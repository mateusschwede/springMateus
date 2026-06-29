package com.whateverer.feature.cat.model.dto

import jakarta.validation.constraints.NotBlank

data class RemoveAdoptionRequest(

    @field:NotBlank(message = "Reason is required.")
    val reason: String
)