package com.whateverer.feature.tutor.service

import com.whateverer.feature.tutor.model.dto.TutorSummaryResponse
import com.whateverer.feature.tutor.repository.TutorRepository
import com.whateverer.feature.tutor.utils.TutorMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ListTutorService(
    private val tutorRepository: TutorRepository,
    private val tutorMapper: TutorMapper
) {

    @Transactional(readOnly = true)
    fun execute(): List<TutorSummaryResponse> =
        tutorRepository.findAll()
            .map(tutorMapper::toSummaryResponse)
}