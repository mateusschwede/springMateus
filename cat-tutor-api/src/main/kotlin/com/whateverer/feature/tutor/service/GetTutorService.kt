package com.whateverer.feature.tutor.service

import com.whateverer.exception.ResourceNotFoundException
import com.whateverer.feature.tutor.model.dto.TutorWithCatsResponse
import com.whateverer.feature.tutor.repository.TutorRepository
import com.whateverer.feature.tutor.utils.TutorMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetTutorService(
    private val tutorRepository: TutorRepository,
    private val tutorMapper: TutorMapper
) {

    @Transactional(readOnly = true)
    fun execute(tutorId: Long): TutorWithCatsResponse {

        val tutor = tutorRepository.findById(tutorId)
            .orElseThrow {
                ResourceNotFoundException("Tutor not found.")
            }

        return tutorMapper.toWithCatsResponse(tutor)
    }
}