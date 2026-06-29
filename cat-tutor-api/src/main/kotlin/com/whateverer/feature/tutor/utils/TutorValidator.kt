package com.whateverer.feature.tutor.utils

import com.whateverer.exception.BusinessException
import com.whateverer.feature.tutor.model.dto.CreateTutorRequest
import com.whateverer.feature.tutor.model.dto.UpdateTutorRequest
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class TutorValidator {

    fun validateCreate(request: CreateTutorRequest) {
        validateCpf(request.cpf)
        validateName(request.name)
        validateBirthDate(request.birthDate)
    }

    fun validateUpdate(request: UpdateTutorRequest) {
        validateCpf(request.cpf)
        validateName(request.name)
        validateBirthDate(request.birthDate)
    }

    private fun validateCpf(cpf: String) {
        if (!cpf.matches(Regex("\\d{11}"))) {
            throw BusinessException("CPF must contain exactly 11 digits.")
        }
    }

    private fun validateName(name: String) {
        if (name.isBlank()) {
            throw BusinessException("Name is required.")
        }
    }

    private fun validateBirthDate(birthDate: LocalDate) {
        if (birthDate.isAfter(LocalDate.now())) {
            throw BusinessException("Birth date cannot be in the future.")
        }
    }
}