package com.whateverer.feature.tutor.repository

import com.whateverer.feature.tutor.model.entity.TutorEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface TutorRepository : JpaRepository<TutorEntity, Long> {

    fun findByCpf(cpf: String): Optional<TutorEntity>

    fun existsByCpf(cpf: String): Boolean
}