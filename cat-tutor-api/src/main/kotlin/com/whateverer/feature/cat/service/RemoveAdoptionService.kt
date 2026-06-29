package com.whateverer.feature.cat.service

import com.whateverer.exception.BusinessException
import com.whateverer.exception.ResourceNotFoundException
import com.whateverer.feature.cat.model.dto.CatResponse
import com.whateverer.feature.cat.model.dto.RemoveAdoptionRequest
import com.whateverer.feature.cat.model.entity.CatStatus
import com.whateverer.feature.cat.repository.CatRepository
import com.whateverer.feature.cat.utils.CatMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RemoveAdoptionService(
    private val catRepository: CatRepository,
    private val catMapper: CatMapper
) {

    @Transactional
    fun execute(
        catId: Long,
        request: RemoveAdoptionRequest
    ): CatResponse {

        val cat = catRepository.findById(catId)
            .orElseThrow {
                ResourceNotFoundException("Cat not found.")
            }

        if (cat.status == CatStatus.AVAILABLE) {
            throw BusinessException("This cat is not adopted.")
        }

        cat.tutor = null
        cat.status = CatStatus.AVAILABLE

        val savedCat = catRepository.save(cat)

        return catMapper.toResponse(savedCat)
    }
}