package com.whateverer.feature.tutor.model.dto

import com.whateverer.feature.tutor.model.entity.TutorGender
import java.time.LocalDate

data class TutorResponse(
    val id: Long,
    val cpf: String,
    val name: String,
    val birthDate: LocalDate,
    val gender: TutorGender
)