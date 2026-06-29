package com.whateverer.feature.auth.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "TB_USER")
class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Long? = null,

    @Column(name = "USERNAME", nullable = false, unique = true, length = 100)
    var username: String,

    @Column(name = "PASSWORD", nullable = false)
    var password: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", nullable = false, length = 20)
    var role: Role = Role.ROLE_USER
)