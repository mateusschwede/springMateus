package com.whateverer.feature.cat.model.entity

import com.whateverer.feature.tutor.model.entity.TutorEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "TB_CAT")
class CatEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Long? = null,

    @Column(name = "NAME", nullable = false, length = 100)
    var name: String,

    @Column(name = "BREED", nullable = false, length = 100)
    var breed: String,

    @Column(name = "BIRTH_DATE", nullable = false)
    var birthDate: LocalDate,

    @Column(name = "WEIGHT", nullable = false)
    var weight: Float,

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false, length = 20)
    var status: CatStatus = CatStatus.AVAILABLE,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TUTOR_ID")
    var tutor: TutorEntity? = null
)