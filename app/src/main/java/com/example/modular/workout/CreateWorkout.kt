package com.example.modular.workout

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.modular.R
import com.example.modular.workout.models.Workout
import java.time.DayOfWeek

class CreateWorkout : Fragment(), AdapterView.OnItemSelectedListener {

    private var newWorkout: Workout = Workout()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val createWorkout = inflater.inflate(R.layout.create_workout, container, false)
        val datePicker = DatePicker(activity)
        val focusDescription = createWorkout.findViewById<EditText>(R.id.et_focus)
        val weekdaySpinner: Spinner = createWorkout.findViewById(R.id.s_weekday_spinner)
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
        setDateButton.setOnClickListener {
            val day = datePicker.dayOfMonth.toString()
            val month = datePicker.month.toString()
            val year = datePicker.year.toString()
            newWorkout.date = day + month + year
            Toast.makeText(context, "Date set to: " + newWorkout.date, Toast.LENGTH_LONG).show()
        }

        //Set weekday value
        weekdaySpinner.onItemSelectedListener = this

        return createWorkout
    }

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