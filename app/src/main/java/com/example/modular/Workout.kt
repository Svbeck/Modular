package com.example.modular

import java.time.DayOfWeek
import java.util.*

class Workout(
    var date: String?,
    var focus: String?,
    var weekday: DayOfWeek?,
    var workoutNote: String?,
    var workoutLengthMin: Int?
){
    constructor() : this(
        "","",DayOfWeek.MONDAY,"",0
    )
}