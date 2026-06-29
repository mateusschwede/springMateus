package com.whateverer.feature.cat.model.dto

import com.whateverer.feature.cat.model.entity.CatStatus
import java.time.LocalDate

data class CatResponse(
    val id: Long,
    val name: String,
    val breed: String,
    val birthDate: LocalDate,
    val weight: Float,
    val status: CatStatus,
    val tutorId: Long?,
    val tutorName: String?
)