package com.whateverer.feature.cat.service

import com.whateverer.feature.cat.model.dto.CatResponse
import com.whateverer.feature.cat.model.dto.CatSummaryResponse
import com.whateverer.feature.cat.model.dto.CreateCatRequest
import com.whateverer.feature.cat.model.dto.UpdateCatRequest
import org.springframework.stereotype.Service

@Service
class CatService(
    private val createCatService: CreateCatService,
    private val updateCatService: UpdateCatService,
    private val deleteCatService: DeleteCatService,
    private val getCatService: GetCatService,
    private val listCatService: ListCatService,
    private val adoptCatService: AdoptCatService,
    private val removeAdoptionService: RemoveAdoptionService
) {

    fun create(request: CreateCatRequest): CatResponse =
        createCatService.execute(request)

    fun update(id: Long, request: UpdateCatRequest): CatResponse =
        updateCatService.execute(id, request)

    fun findById(id: Long): CatResponse =
        getCatService.execute(id)

    fun findAll(): List<CatSummaryResponse> =
        listCatService.execute()

    fun delete(id: Long) =
        deleteCatService.execute(id)
}