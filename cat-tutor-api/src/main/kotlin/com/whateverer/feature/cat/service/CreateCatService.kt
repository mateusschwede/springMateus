package com.whateverer.feature.cat.service

import com.whateverer.exception.BusinessException
import com.whateverer.feature.cat.model.dto.CatResponse
import com.whateverer.feature.cat.model.dto.CreateCatRequest
import com.whateverer.feature.cat.model.entity.CatEntity
import com.whateverer.feature.cat.model.entity.CatStatus
import com.whateverer.feature.cat.repository.CatRepository
import com.whateverer.feature.cat.utils.CatMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateCatService(
    private val catRepository: CatRepository,
    private val catMapper: CatMapper
) {

    @Transactional
    fun execute(request: CreateCatRequest): CatResponse {

        if (catRepository.existsByNameIgnoreCase(request.name)) {
            throw BusinessException("A cat with this name already exists.")
        }

        val cat = CatEntity(
            name = request.name,
            breed = request.breed,
            birthDate = request.birthDate,
            weight = request.weight,
            status = CatStatus.AVAILABLE,
            tutor = null
        )

        val savedCat = catRepository.save(cat)

        return catMapper.toResponse(savedCat)
    }
}