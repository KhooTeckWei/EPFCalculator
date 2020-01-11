package com.example.epfcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.DatePickerDialog
import android.view.View
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var epfCalculator = Calendar.getInstance()
        val date = Calendar.getInstance()

        val datePicker = object : DatePickerDialog.OnDateSetListener{

            override fun onDateSet(view : DatePicker, year : Int, month: Int, day: Int){

                // Select and Set the date to calendar
                epfCalculator.set(year, month, day)
                // Update date in EditText view
                val dateFormat = "dd/MM/yyyy"
                val simpleDateFormat = SimpleDateFormat(dateFormat, Locale.CHINA)

                // Get age
                val age =  date.get(Calendar.YEAR) - epfCalculator.get(Calendar.YEAR)

                Age.setText("Age(years): " + age.toString())

                var savings : Int

                // Get min savings
                if(age in 16..20) {
                    savings = 5000
                }
                else if(age in 21..25){
                    savings = 14000
                }
                else if(age in 26..30) {
                    savings = 29000
                }
                else if(age in 31..35) {
                    savings = 50000
                }
                else if(age in 36..40) {
                    savings = 78000
                }
                else if(age in 41..45) {
                    savings = 116000
                }
                else if(age in 46..50) {
                    savings = 165000
                }
                else if (age in 51..55) {
                    savings = 228000
                }
                else {
                    savings = 0
                }
                savingAmount.text = "Your Minimum Savings Amount: RM" + savings.toString()
            }
        }

        selectDateButton.setOnClickListener{

            val birthDate = DatePickerDialog(this, datePicker, epfCalculator.get(Calendar.YEAR), epfCalculator.get(
                Calendar.MONTH), epfCalculator.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    public fun reset(view : View){

        Age.text = "Age: "
        savingAmount.text = "Your Minimum Savings Amount:"
    }

}

