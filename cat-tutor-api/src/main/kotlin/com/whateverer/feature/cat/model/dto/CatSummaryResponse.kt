package com.whateverer.feature.cat.model.dto

import com.whateverer.feature.cat.model.entity.CatStatus

data class CatSummaryResponse(
    val id: Long,
    val name: String,
    val breed: String,
    val status: CatStatus
)