package com.whateverer.feature.cat.model.dto

import jakarta.validation.constraints.NotNull

data class AdoptCatRequest(

    @field:NotNull(message = "Tutor ID is required.")
    val tutorId: Long
)