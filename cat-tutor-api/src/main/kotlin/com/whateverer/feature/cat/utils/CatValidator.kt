package com.whateverer.feature.cat.utils

import com.whateverer.exception.BusinessException
import com.whateverer.feature.cat.model.dto.CreateCatRequest
import com.whateverer.feature.cat.model.dto.UpdateCatRequest
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class CatValidator {

    fun validateCreate(request: CreateCatRequest) {
        validateName(request.name)
        validateBreed(request.breed)
        validateBirthDate(request.birthDate)
        validateWeight(request.weight)
    }

    fun validateUpdate(request: UpdateCatRequest) {
        validateName(request.name)
        validateBreed(request.breed)
        validateBirthDate(request.birthDate)
        validateWeight(request.weight)
    }

    private fun validateName(name: String) {
        if (name.isBlank()) {
            throw BusinessException("Name is required.")
        }
    }

    private fun validateBreed(breed: String) {
        if (breed.isBlank()) {
            throw BusinessException("Breed is required.")
        }
    }

    private fun validateBirthDate(birthDate: LocalDate) {
        if (birthDate.isAfter(LocalDate.now())) {
            throw BusinessException("Birth date cannot be in the future.")
        }
    }

    private fun validateWeight(weight: Float) {
        if (weight <= 0f) {
            throw BusinessException("Weight must be greater than zero.")
        }
    }
}