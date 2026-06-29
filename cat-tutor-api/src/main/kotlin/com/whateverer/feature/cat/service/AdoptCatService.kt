package com.whateverer.feature.cat.service

import com.whateverer.exception.BusinessException
import com.whateverer.exception.ResourceNotFoundException
import com.whateverer.feature.cat.model.dto.AdoptCatRequest
import com.whateverer.feature.cat.model.dto.CatResponse
import com.whateverer.feature.cat.model.entity.CatStatus
import com.whateverer.feature.cat.repository.CatRepository
import com.whateverer.feature.cat.utils.CatMapper
import com.whateverer.feature.tutor.repository.TutorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdoptCatService(
    private val catRepository: CatRepository,
    private val tutorRepository: TutorRepository,
    private val catMapper: CatMapper
) {

    @Transactional
    fun execute(
        catId: Long,
        request: AdoptCatRequest
    ): CatResponse {

        val cat = catRepository.findById(catId)
            .orElseThrow {
                ResourceNotFoundException("Cat not found.")
            }

        val tutor = tutorRepository.findById(request.tutorId)
            .orElseThrow {
                ResourceNotFoundException("Tutor not found.")
            }

        if (cat.status == CatStatus.ADOPTED) {
            throw BusinessException("This cat has already been adopted.")
        }

        cat.tutor = tutor
        cat.status = CatStatus.ADOPTED

        val savedCat = catRepository.save(cat)

        return catMapper.toResponse(savedCat)
    }
}