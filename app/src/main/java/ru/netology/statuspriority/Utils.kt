package ru.netology.statuspriority

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class Utils {
    companion object {
//        fun determiningPriorityLevelOfNote(planeDateTime: LocalDateTime) : StatusPriority {
//
//            val hours: Long = ChronoUnit.MINUTES.between(LocalDateTime.now(), planeDateTime)
//            if (hours <= 120) {
//                return StatusPriority.RED
//            }
//
//            val nowPlusTwoHours = LocalDateTime.now().plusHours(2)
//            val nextSixOClock: LocalDateTime
//
//            if(LocalDateTime.now().hour < 6) {
//                nextSixOClock = LocalDateTime.of(
//                    LocalDate.now().year,
//                    LocalDate.now().monthValue,
//                    LocalDate.now().dayOfMonth,
//                    6,
//                    0
//                    )
//            } else {
//                nextSixOClock = LocalDateTime.of(
//                    LocalDate.now().year,
//                    LocalDate.now().monthValue,
//                    LocalDate.now().plusDays(1).dayOfMonth,
//                    6,
//                    0
//                )
//            }
//
//            return if (nowPlusTwoHours.isBefore(planeDateTime) && planeDateTime.isBefore(nextSixOClock)) {
//                StatusPriority.YELLOW
//            } else {
//                StatusPriority.GREEN
//            }
//        }


        fun determiningPriorityLevelOfNote(planeDateTime: LocalDateTime) : StatusPriority {

            val now = LocalDateTime.now()
            val mins: Long = ChronoUnit.MINUTES.between(now, planeDateTime)
            if (mins <= 120) {
                return StatusPriority.RED
            }

            val nextSixOClock = LocalDateTime.of(
            LocalDate.now().year,
            LocalDate.now().monthValue,
            LocalDate.now().dayOfMonth,
            6,
            0
            )

            if(now.hour > 6) {
                nextSixOClock.plusDays(1)
            }

            if ( mins > 120 && planeDateTime.isBefore(nextSixOClock)) {
                return StatusPriority.YELLOW
            }

            return StatusPriority.GREEN
        }
    }
}