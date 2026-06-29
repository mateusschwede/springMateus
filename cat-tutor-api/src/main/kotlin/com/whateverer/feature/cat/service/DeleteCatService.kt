package com.whateverer.feature.cat.service

import com.whateverer.exception.BusinessException
import com.whateverer.exception.ResourceNotFoundException
import com.whateverer.feature.cat.model.entity.CatStatus
import com.whateverer.feature.cat.repository.CatRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeleteCatService(
    private val catRepository: CatRepository
) {

    @Transactional
    fun execute(catId: Long) {

        val cat = catRepository.findById(catId)
            .orElseThrow {
                ResourceNotFoundException("Cat not found.")
            }

        if (cat.status == CatStatus.ADOPTED) {
            throw BusinessException("An adopted cat cannot be deleted.")
        }

        catRepository.delete(cat)
    }
}