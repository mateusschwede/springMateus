package com.whateverer.feature.tutor.service

import com.whateverer.feature.tutor.model.dto.CreateTutorRequest
import com.whateverer.feature.tutor.model.dto.TutorResponse
import com.whateverer.feature.tutor.model.dto.TutorSummaryResponse
import com.whateverer.feature.tutor.model.dto.TutorWithCatsResponse
import com.whateverer.feature.tutor.model.dto.UpdateTutorRequest
import org.springframework.stereotype.Service

@Service
class TutorService(
    private val createTutorService: CreateTutorService,
    private val updateTutorService: UpdateTutorService,
    private val deleteTutorService: DeleteTutorService,
    private val getTutorService: GetTutorService,
    private val listTutorService: ListTutorService
) {

    fun create(request: CreateTutorRequest): TutorResponse =
        createTutorService.execute(request)

    fun update(id: Long, request: UpdateTutorRequest): TutorResponse =
        updateTutorService.execute(id, request)

    fun findById(id: Long): TutorWithCatsResponse =
        getTutorService.execute(id)

    fun findAll(): List<TutorSummaryResponse> =
        listTutorService.execute()

    fun delete(id: Long) =
        deleteTutorService.execute(id)
}