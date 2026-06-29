package com.whateverer.feature.tutor.utils

import com.whateverer.feature.cat.model.dto.CatSummaryResponse
import com.whateverer.feature.tutor.model.dto.TutorResponse
import com.whateverer.feature.tutor.model.dto.TutorSummaryResponse
import com.whateverer.feature.tutor.model.dto.TutorWithCatsResponse
import com.whateverer.feature.tutor.model.entity.TutorEntity
import org.springframework.stereotype.Component

@Component
class TutorMapper {

    fun toResponse(tutor: TutorEntity): TutorResponse =
        TutorResponse(
            id = tutor.id!!,
            cpf = tutor.cpf,
            name = tutor.name,
            birthDate = tutor.birthDate,
            gender = tutor.gender
        )

    fun toSummaryResponse(tutor: TutorEntity): TutorSummaryResponse =
        TutorSummaryResponse(
            id = tutor.id!!,
            cpf = tutor.cpf,
            name = tutor.name
        )

    fun toWithCatsResponse(tutor: TutorEntity): TutorWithCatsResponse =
        TutorWithCatsResponse(
            id = tutor.id!!,
            cpf = tutor.cpf,
            name = tutor.name,
            birthDate = tutor.birthDate,
            gender = tutor.gender,
            cats = tutor.cats.map {
                CatSummaryResponse(
                    id = it.id!!,
                    name = it.name,
                    breed = it.breed,
                    status = it.status
                )
            }
        )
}