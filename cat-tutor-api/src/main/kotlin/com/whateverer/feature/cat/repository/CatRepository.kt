package com.whateverer.feature.cat.repository

import com.whateverer.feature.cat.model.entity.CatEntity
import com.whateverer.feature.cat.model.entity.CatStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CatRepository : JpaRepository<CatEntity, Long> {

    fun findAllByStatus(status: CatStatus): List<CatEntity>

    fun existsByNameIgnoreCase(name: String): Boolean
}