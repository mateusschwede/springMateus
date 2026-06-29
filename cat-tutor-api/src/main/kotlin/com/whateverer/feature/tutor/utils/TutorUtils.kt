package com.whateverer.feature.tutor.utils

import com.whateverer.feature.tutor.model.entity.TutorEntity
import java.time.LocalDate
import java.time.Period

object TutorUtils {

    fun calculateAge(birthDate: LocalDate): Int =
        Period.between(birthDate, LocalDate.now()).years

    fun isAdult(tutor: TutorEntity): Boolean =
        calculateAge(tutor.birthDate) >= 18

    fun formatCpf(cpf: String): String =
        cpf.replaceFirst(
            Regex("(\\d{3})(\\d{3})(\\d{3})(\\d{2})"),
            "$1.$2.$3-$4"
        )

    fun hasCats(tutor: TutorEntity): Boolean =
        tutor.cats.isNotEmpty()

    fun totalCats(tutor: TutorEntity): Int =
        tutor.cats.size
}