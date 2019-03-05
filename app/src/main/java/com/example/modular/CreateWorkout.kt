package com.example.modular

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.add_workout.*
import kotlinx.android.synthetic.main.create_workout.*
import kotlinx.android.synthetic.main.create_workout.view.*
import java.time.DayOfWeek

class CreateWorkout : Fragment(), AdapterView.OnItemSelectedListener{
    var newWorkout: Workout = Workout()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val createWorkout = inflater.inflate(R.layout.create_workout,container,false)
        val datePicker = DatePicker(activity)
        val focusDescription = createWorkout.findViewById<EditText>(R.id.et_focus)
        val weekdaySpinner: Spinner = createWorkout.findViewById(R.id.s_weekday_spinner)
        val startWorkoutButton = createWorkout.findViewById<Button>(R.id.b_start_workout)
        val dateSpinner = createWorkout.findViewById<Spinner>(R.id.s_weekday_spinner)
        val setDateButton = createWorkout.findViewById<Button>(R.id.b_set_date)

        //Set spinner content
        ArrayAdapter.createFromResource(
            context,
            R.array.weekdays,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            dateSpinner.adapter = adapter
        }

        //set date if current date should be used
        setDateButton.setOnClickListener { view: View? ->
            val day = datePicker.dayOfMonth.toString()
            val month = datePicker.month.toString()
            val year = datePicker.year.toString()
            newWorkout.date = day + month + year
            Toast.makeText(context, "Date set to: "+newWorkout.date, Toast.LENGTH_LONG).show()
        }

        //Set weekday value
        weekdaySpinner.onItemSelectedListener = this

        //Start workout value
        startWorkoutButton.setOnClickListener {
            newWorkout.focus = focusDescription.text.toString()
            Log.e("Supertest", newWorkout.date.toString() +
                    newWorkout.weekday.toString() + newWorkout.focus.toString())

        }
        return createWorkout
    }//TODO https://stackoverflow.com/questions/49662707/exampledynamic-fragments-inter-fragment-communication-fragment-getting-re-add
    override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when {
            position == 1 -> newWorkout.weekday = DayOfWeek.MONDAY
            position == 2 -> newWorkout.weekday = DayOfWeek.TUESDAY
            position == 3 -> newWorkout.weekday = DayOfWeek.WEDNESDAY
            position == 4 -> newWorkout.weekday = DayOfWeek.THURSDAY
            position == 5 -> newWorkout.weekday = DayOfWeek.FRIDAY
            position == 6 -> newWorkout.weekday = DayOfWeek.SATURDAY
            position == 7 -> newWorkout.weekday = DayOfWeek.SUNDAY
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}