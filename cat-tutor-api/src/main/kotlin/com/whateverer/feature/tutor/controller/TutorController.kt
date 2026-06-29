package com.whateverer.feature.tutor.controller

import com.whateverer.feature.tutor.model.dto.CreateTutorRequest
import com.whateverer.feature.tutor.model.dto.TutorResponse
import com.whateverer.feature.tutor.model.dto.TutorSummaryResponse
import com.whateverer.feature.tutor.model.dto.TutorWithCatsResponse
import com.whateverer.feature.tutor.model.dto.UpdateTutorRequest
import com.whateverer.feature.tutor.service.CreateTutorService
import com.whateverer.feature.tutor.service.DeleteTutorService
import com.whateverer.feature.tutor.service.GetTutorService
import com.whateverer.feature.tutor.service.ListTutorService
import com.whateverer.feature.tutor.service.UpdateTutorService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tutors")
class TutorController(
    private val createTutorService: CreateTutorService,
    private val updateTutorService: UpdateTutorService,
    private val deleteTutorService: DeleteTutorService,
    private val getTutorService: GetTutorService,
    private val listTutorService: ListTutorService
) {

    @PostMapping
    fun create(
        @Valid @RequestBody request: CreateTutorRequest
    ): ResponseEntity<TutorResponse> =
        ResponseEntity.status(HttpStatus.CREATED)
            .body(createTutorService.execute(request))

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @Valid @RequestBody request: UpdateTutorRequest
    ): ResponseEntity<TutorResponse> =
        ResponseEntity.ok(updateTutorService.execute(id, request))

    @GetMapping("/{id}")
    fun findById(
        @PathVariable id: Long
    ): ResponseEntity<TutorWithCatsResponse> =
        ResponseEntity.ok(getTutorService.execute(id))

    @GetMapping
    fun findAll(): ResponseEntity<List<TutorSummaryResponse>> =
        ResponseEntity.ok(listTutorService.execute())

    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable id: Long
    ): ResponseEntity<Void> {
        deleteTutorService.execute(id)
        return ResponseEntity.noContent().build()
    }
}