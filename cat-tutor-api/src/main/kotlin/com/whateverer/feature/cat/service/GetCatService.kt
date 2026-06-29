package com.whateverer.feature.cat.service

import com.whateverer.exception.ResourceNotFoundException
import com.whateverer.feature.cat.model.dto.CatResponse
import com.whateverer.feature.cat.repository.CatRepository
import com.whateverer.feature.cat.utils.CatMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetCatService(
    private val catRepository: CatRepository,
    private val catMapper: CatMapper
) {

    @Transactional(readOnly = true)
    fun execute(catId: Long): CatResponse {

        val cat = catRepository.findById(catId)
            .orElseThrow {
                ResourceNotFoundException("Cat not found.")
            }

        return catMapper.toResponse(cat)
    }
}