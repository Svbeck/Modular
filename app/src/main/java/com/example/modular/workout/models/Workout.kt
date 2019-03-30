package com.example.modular.workout.models

import java.time.DayOfWeek
import java.util.*

class Workout(
    var date: String?,
    var focus: String?,
    var weekday: DayOfWeek?,
    var exercises: List<Exercise>?,
    var workoutNote: String?,
    var workoutLengthMin: Int?
){
    constructor() : this(
        "","",DayOfWeek.MONDAY,
        listOf<Exercise>(Exercise("", 0, arrayOf(0f), arrayOf(0), 0, "", ""))
        ,"",0)
}