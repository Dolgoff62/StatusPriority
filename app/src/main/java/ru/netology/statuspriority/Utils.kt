package ru.netology.statuspriority

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class Utils {
    companion object {

        fun determiningPriorityLevelOfNote(
            currentDateTime: LocalDateTime,
            planeDateTime: LocalDateTime
        ): StatusPriority {

            val hoursToMinutes: Long = ChronoUnit.MINUTES.between(currentDateTime, planeDateTime)
            if (hoursToMinutes <= 120) {
                return StatusPriority.RED
            }

            val nextSixOClock = LocalDateTime.of(
                currentDateTime.year,
                currentDateTime.monthValue,
                currentDateTime.dayOfMonth,
                6,
                0
            )

            if (currentDateTime.hour > 6) {
                nextSixOClock.plusDays(1)
            }

            if (hoursToMinutes > 120 && planeDateTime.isBefore(nextSixOClock)) {
                return StatusPriority.YELLOW
            }

            return StatusPriority.GREEN
        }
    }
}