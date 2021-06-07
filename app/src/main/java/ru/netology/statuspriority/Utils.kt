package ru.netology.statuspriority

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class Utils {
    companion object {
        fun determiningPriorityLevelOfNote(planeDateTime: LocalDateTime) : StatusPriority {

            val hours: Long = ChronoUnit.MINUTES.between(LocalDateTime.now(), planeDateTime)
            if (hours <= 120) {
                return StatusPriority.RED
            }

            val nowPlusTwoHours = LocalDateTime.now().plusHours(2)
            val nextSixOClock: LocalDateTime

            if(LocalDateTime.now().hour < 6) {
                nextSixOClock = LocalDateTime.of(
                    LocalDate.now().year,
                    LocalDate.now().monthValue,
                    LocalDate.now().dayOfMonth,
                    6,
                    0
                    )
            } else {
                nextSixOClock = LocalDateTime.of(
                    LocalDate.now().year,
                    LocalDate.now().monthValue,
                    LocalDate.now().plusDays(1).dayOfMonth,
                    6,
                    0
                )
            }

            return if (nowPlusTwoHours.isBefore(planeDateTime)  && planeDateTime.isBefore(nextSixOClock)) {
                StatusPriority.YELLOW
            } else {
                StatusPriority.GREEN
            }
        }
    }
}