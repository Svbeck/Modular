package com.example.modular


import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.widget.*

//Split into fragments
class AddWorkout : AppCompatActivity(), CreateWorkoutFragHandler, AddExcerciseFragHandler {

    val fragManager: FragmentManager = supportFragmentManager

    val CREATE_WORKOUT_TAG = "CREATE_WORKOUT_FRAG"
    val ADD_EXERCISE_TAG = "ADD_EXERCISE_FRAG"

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

    }

    override fun onStart() {
        super.onStart()
        setContentView(R.layout.add_workout)

        //fragManager.beginTransaction().add(R.id.ll_add_workout, CreateWorkout(), CREATE_WORKOUT_TAG).commit()
        fragManager.beginTransaction().add(R.id.fl_create_workout, AddExercise(), ADD_EXERCISE_TAG).commit()

    }

    override fun addWorkoutFrag() {
        if (fragManager.findFragmentByTag(CREATE_WORKOUT_TAG) == null)
            fragManager.beginTransaction().add(R.id.fl_create_workout, CreateWorkout(), CREATE_WORKOUT_TAG).commit()
        else
            Toast.makeText(this, "Fragment already present", Toast.LENGTH_LONG).show()
    }

    override fun closeWorkoutFrag() {
        val createWorkout = fragManager.findFragmentByTag(CREATE_WORKOUT_TAG)
        if (createWorkout != null)
            fragManager.beginTransaction().remove(createWorkout).commit()
        else
            Toast.makeText(this, "Fragment already not present", Toast.LENGTH_LONG).show()
    }

    override fun addExerciseFrag() {
        if (fragManager.findFragmentByTag(ADD_EXERCISE_TAG) == null)
            fragManager.beginTransaction().add(R.id.fl_create_workout, AddExercise(), ADD_EXERCISE_TAG).commit()
        else
            Toast.makeText(this, "Fragment already present", Toast.LENGTH_LONG).show()
    }

    override fun closeExerciseFrag() {
        val addExercise = fragManager.findFragmentByTag(ADD_EXERCISE_TAG)
        if (addExercise != null)
            fragManager.beginTransaction().remove(addExercise).commit()
        else
            Toast.makeText(this, "Fragment already not present", Toast.LENGTH_LONG).show()    }
}

interface CreateWorkoutFragHandler {
    fun addWorkoutFrag()
    fun closeWorkoutFrag()
}

interface AddExcerciseFragHandler {
    fun addExerciseFrag()
    fun closeExerciseFrag()
}
