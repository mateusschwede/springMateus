package com.whateverer.feature.tutor.service

import com.whateverer.exception.BusinessException
import com.whateverer.exception.ResourceNotFoundException
import com.whateverer.feature.tutor.repository.TutorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeleteTutorService(
    private val tutorRepository: TutorRepository
) {

    @Transactional
    fun execute(tutorId: Long) {

        val tutor = tutorRepository.findById(tutorId)
            .orElseThrow {
                ResourceNotFoundException("Tutor not found.")
            }

        if (tutor.cats.isNotEmpty()) {
            throw BusinessException(
                "Cannot delete a tutor who has adopted cats."
            )
        }

        tutorRepository.delete(tutor)
    }
}