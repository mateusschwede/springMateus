package com.whateverer.feature.cat.utils

import com.whateverer.feature.cat.model.entity.CatEntity
import java.time.LocalDate
import java.time.Period

object CatUtils {

    fun calculateAge(birthDate: LocalDate): Int =
        Period.between(birthDate, LocalDate.now()).years

    fun isAdult(cat: CatEntity): Boolean =
        calculateAge(cat.birthDate) >= 1

    fun formatWeight(weight: Float): String =
        "%.2f kg".format(weight)

    fun hasTutor(cat: CatEntity): Boolean =
        cat.tutor != null

    fun isAdopted(cat: CatEntity): Boolean =
        hasTutor(cat)
}