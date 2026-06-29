package com.whateverer.feature.tutor.service

import com.whateverer.exception.BusinessException
import com.whateverer.feature.tutor.model.dto.CreateTutorRequest
import com.whateverer.feature.tutor.model.dto.TutorResponse
import com.whateverer.feature.tutor.model.entity.TutorEntity
import com.whateverer.feature.tutor.repository.TutorRepository
import com.whateverer.feature.tutor.utils.TutorMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateTutorService(
    private val tutorRepository: TutorRepository,
    private val tutorMapper: TutorMapper
) {

    @Transactional
    fun execute(request: CreateTutorRequest): TutorResponse {

        if (tutorRepository.existsByCpf(request.cpf)) {
            throw BusinessException("A tutor with this CPF already exists.")
        }

        val tutor = TutorEntity(
            cpf = request.cpf,
            name = request.name,
            birthDate = request.birthDate,
            gender = request.gender
        )

        val savedTutor = tutorRepository.save(tutor)

        return tutorMapper.toResponse(savedTutor)
    }
}