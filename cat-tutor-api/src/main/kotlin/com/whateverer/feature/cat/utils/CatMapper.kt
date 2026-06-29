package com.whateverer.feature.cat.utils

import com.whateverer.feature.cat.model.dto.CatResponse
import com.whateverer.feature.cat.model.dto.CatSummaryResponse
import com.whateverer.feature.cat.model.entity.CatEntity
import org.springframework.stereotype.Component

@Component
class CatMapper {

    fun toResponse(cat: CatEntity): CatResponse =
        CatResponse(
            id = cat.id!!,
            name = cat.name,
            breed = cat.breed,
            birthDate = cat.birthDate,
            weight = cat.weight,
            status = cat.status,
            tutorId = cat.tutor?.id,
            tutorName = cat.tutor?.name
        )

    fun toSummaryResponse(cat: CatEntity): CatSummaryResponse =
        CatSummaryResponse(
            id = cat.id!!,
            name = cat.name,
            breed = cat.breed,
            status = cat.status
        )
}