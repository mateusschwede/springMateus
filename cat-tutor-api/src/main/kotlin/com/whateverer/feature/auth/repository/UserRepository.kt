package com.whateverer.feature.auth.repository

import com.whateverer.feature.auth.model.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository : JpaRepository<UserEntity, Long> {

    fun findByUsername(username: String): Optional<UserEntity>

    fun existsByUsername(username: String): Boolean
}