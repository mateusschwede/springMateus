package com.whateverer.feature.cat.service

import com.whateverer.feature.cat.model.dto.CatSummaryResponse
import com.whateverer.feature.cat.repository.CatRepository
import com.whateverer.feature.cat.utils.CatMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ListCatService(
    private val catRepository: CatRepository,
    private val catMapper: CatMapper
) {

    @Transactional(readOnly = true)
    fun execute(): List<CatSummaryResponse> =
        catRepository.findAll()
            .map(catMapper::toSummaryResponse)
}