package com.whateverer.feature.cat.controller

import com.whateverer.feature.cat.model.dto.AdoptCatRequest
import com.whateverer.feature.cat.model.dto.CatResponse
import com.whateverer.feature.cat.model.dto.RemoveAdoptionRequest
import com.whateverer.feature.cat.service.AdoptCatService
import com.whateverer.feature.cat.service.RemoveAdoptionService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cats")
class CatAdoptionController(
    private val adoptCatService: AdoptCatService,
    private val removeAdoptionService: RemoveAdoptionService
) {

    @PatchMapping("/{id}/adopt")
    fun adopt(
        @PathVariable id: Long,
        @Valid @RequestBody request: AdoptCatRequest
    ): ResponseEntity<CatResponse> =
        ResponseEntity.ok(
            adoptCatService.execute(id, request)
        )

    @PatchMapping("/{id}/remove-adoption")
    fun removeAdoption(
        @PathVariable id: Long,
        @Valid @RequestBody request: RemoveAdoptionRequest
    ): ResponseEntity<CatResponse> =
        ResponseEntity.ok(
            removeAdoptionService.execute(id, request)
        )
}