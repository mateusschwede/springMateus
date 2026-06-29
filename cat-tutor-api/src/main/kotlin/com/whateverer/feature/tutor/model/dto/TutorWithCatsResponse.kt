package com.whateverer.feature.tutor.model.dto

import com.whateverer.feature.tutor.model.entity.TutorGender
import java.time.LocalDate

data class TutorWithCatsResponse(
    val id: Long,
    val cpf: String,
    val name: String,
    val birthDate: LocalDate,
    val gender: TutorGender,
    val cats: List<CatSummaryResponse>
)

data class CatSummaryResponse(
    val id: Long,
    val name: String,
    val breed: String
)