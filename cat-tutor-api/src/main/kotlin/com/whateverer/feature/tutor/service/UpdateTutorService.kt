package com.whateverer.feature.tutor.service

import com.whateverer.exception.BusinessException
import com.whateverer.exception.ResourceNotFoundException
import com.whateverer.feature.tutor.model.dto.TutorResponse
import com.whateverer.feature.tutor.model.dto.UpdateTutorRequest
import com.whateverer.feature.tutor.repository.TutorRepository
import com.whateverer.feature.tutor.utils.TutorMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateTutorService(
    private val tutorRepository: TutorRepository,
    private val tutorMapper: TutorMapper
) {

    @Transactional
    fun execute(
        tutorId: Long,
        request: UpdateTutorRequest
    ): TutorResponse {

        val tutor = tutorRepository.findById(tutorId)
            .orElseThrow {
                ResourceNotFoundException("Tutor not found.")
            }

        val duplicatedCpf = tutorRepository.findByCpf(request.cpf)
            .filter { it.id != tutor.id }
            .isPresent

        if (duplicatedCpf) {
            throw BusinessException("A tutor with this CPF already exists.")
        }

        tutor.cpf = request.cpf
        tutor.name = request.name
        tutor.birthDate = request.birthDate
        tutor.gender = request.gender

        val savedTutor = tutorRepository.save(tutor)

        return tutorMapper.toResponse(savedTutor)
    }
}