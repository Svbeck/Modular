package com.example.modular.workout.models

class Exercise(
    var exerciseName: String,
    var sets: Int,
    var kg: Array<Float>,
    var reps: Array<Int>,
    var restTimeSec: Int?,
    var emom: String?,
    var exerciseNote: String?
)