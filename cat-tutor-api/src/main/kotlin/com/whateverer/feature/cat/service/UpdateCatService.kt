package com.whateverer.feature.cat.service

import com.whateverer.exception.BusinessException
import com.whateverer.exception.ResourceNotFoundException
import com.whateverer.feature.cat.model.dto.CatResponse
import com.whateverer.feature.cat.model.dto.UpdateCatRequest
import com.whateverer.feature.cat.repository.CatRepository
import com.whateverer.feature.cat.utils.CatMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateCatService(
    private val catRepository: CatRepository,
    private val catMapper: CatMapper
) {

    @Transactional
    fun execute(
        catId: Long,
        request: UpdateCatRequest
    ): CatResponse {

        val cat = catRepository.findById(catId)
            .orElseThrow {
                ResourceNotFoundException("Cat not found.")
            }

        val duplicatedName = catRepository.existsByNameIgnoreCase(request.name)

        if (duplicatedName && !cat.name.equals(request.name, ignoreCase = true)) {
            throw BusinessException("A cat with this name already exists.")
        }

        cat.name = request.name
        cat.breed = request.breed
        cat.birthDate = request.birthDate
        cat.weight = request.weight

        val savedCat = catRepository.save(cat)

        return catMapper.toResponse(savedCat)
    }
}