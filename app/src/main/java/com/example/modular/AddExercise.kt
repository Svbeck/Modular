package com.example.modular

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.*
import java.util.function.ToIntFunction

class AddExercise : Fragment(), AdapterView.OnItemSelectedListener {

    var newExercise = Exercise("", 0, arrayOf(0f), arrayOf(0), 0, "", "")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val exerciseView = inflater.inflate(R.layout.add_exercise, container, false)
        //val setsSpinner = exerciseView.findViewById<Spinner>(R.id.s_sets_spinner)
        val emomSpinner = exerciseView.findViewById<Spinner>(R.id.s_emom_spinner)
        val exerciseNameInput = exerciseView.findViewById<EditText>(R.id.et_exercise_name)
        val repsInput = exerciseView.findViewById<EditText>(R.id.et_reps_input)
        val kgInput = exerciseView.findViewById<EditText>(R.id.et_kg_input)
        val pauseSecInput = exerciseView.findViewById<EditText>(R.id.et_rest_sec)
        val noteInput = exerciseView.findViewById<EditText>(R.id.et_exercise_note)
        val finishWorkoutButton = exerciseView.findViewById<Button>(R.id.b_finish_workout)

        //Set spinner content
        /*ArrayAdapter.createFromResource(
            context,
            R.array.sets,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            setsSpinner.adapter = adapter
        }

        //Set sets spinner value
        setsSpinner.onItemSelectedListener = this*/

        ArrayAdapter.createFromResource(
            context,
            R.array.emom,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            emomSpinner.adapter = adapter
        }

        //Set emom spinner value
        emomSpinner.onItemSelectedListener = this

        var repsInputConv = repsInput.text.toString()
        var kgInputCheck = kgInput.text.toString()
        var pauseSecInputCheck = pauseSecInput.text.toString()

        if (repsInputConv == "")
            repsInputConv = "0"

        if (kgInputCheck == "")
            kgInputCheck = "0"

        if (pauseSecInputCheck == "")
            pauseSecInputCheck = "0"

        newExercise.exerciseName = exerciseNameInput.toString()
        newExercise.reps[newExercise.reps.size - 1] = repsInputConv.toInt()
        newExercise.sets = kgInputCheck.toInt()
        newExercise.restTimeSec = pauseSecInputCheck.toInt()
        newExercise.exerciseNote = noteInput.toString()
        finishWorkoutButton.setOnClickListener { v -> }

        return exerciseView
    }

    override fun onItemSelected(adapterView: AdapterView<*>, view: View?, position: Int, id: Long) {
        if (adapterView.id == R.id.s_emom_spinner) {
            when (position) {
                0 -> newExercise.emom = ""
                1 -> newExercise.emom = "EMOM"
                2 -> newExercise.emom = "E2MOM"
                3 -> newExercise.emom = "E3MOM"
                4 -> newExercise.emom = "E4MOM"
                5 -> newExercise.emom = "E5MOM"
                6 -> newExercise.emom = "E6MOM"
                7 -> newExercise.emom = "E7MOM"
            }
        } else {
            newExercise.sets = position
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}