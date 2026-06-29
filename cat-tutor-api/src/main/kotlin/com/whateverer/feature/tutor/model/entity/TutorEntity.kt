package com.whateverer.feature.tutor.model.entity

import com.whateverer.feature.cat.model.entity.CatEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "TB_TUTOR")
class TutorEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Long? = null,

    @Column(name = "CPF", nullable = false, unique = true, length = 11)
    var cpf: String,

    @Column(name = "NAME", nullable = false, length = 100)
    var name: String,

    @Column(name = "BIRTH_DATE", nullable = false)
    var birthDate: LocalDate,

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER", nullable = false, length = 20)
    var gender: TutorGender,

    @OneToMany(
        mappedBy = "tutor",
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL]
    )
    var cats: MutableList<CatEntity> = mutableListOf()
)