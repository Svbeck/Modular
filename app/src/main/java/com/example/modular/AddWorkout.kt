package com.example.modular

import android.app.Activity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.add_workout.*
import java.time.DayOfWeek

//Split into fragments
class AddWorkout : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var newWorkout: Workout = Workout()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

    }

    override fun onStart() {
        super.onStart()
        val datePicker = DatePicker(this)
        val focusDescription = findViewById<EditText>(R.id.et_focus)
        val weekdaySpinner: Spinner = findViewById(R.id.s_weekday_spinner)
        val startWorkoutButton = findViewById<Button>(R.id.b_start_workout)
        setContentView(R.layout.add_workout)

        //Set spinner content
        ArrayAdapter.createFromResource(
            this,
            R.array.weekdays,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            s_weekday_spinner.adapter = adapter
        }

        //set date if current date should be used
        b_set_date.setOnClickListener { view: View? ->
            val day = datePicker.dayOfMonth.toString()
            val month = datePicker.month.toString()
            val year = datePicker.year.toString()
            newWorkout.date = day + month + year
        }

        //Set weekday value
        weekdaySpinner.onItemSelectedListener = this

        //Start workout value
        startWorkoutButton.setOnClickListener {
            newWorkout.focus = focusDescription.text.toString()
            Log.e("Supertest", newWorkout.date.toString() +
                    newWorkout.weekday.toString() + newWorkout.focus.toString())
        }
    }

    //TODO Make adapterview own class and value from that object
    override fun onItemSelected(adaperView: AdapterView<*>?, view: View?, position: Int, id: Long) {
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

    //TODO do something here??
    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}