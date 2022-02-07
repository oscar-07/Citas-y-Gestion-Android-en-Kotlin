package com.example.hospital.FechasyCitas

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.DialogFragment
import java.util.*

class FechaFragment(val listener: (dia: Int, mes: Int, año: Int) -> Unit): DialogFragment(), DatePickerDialog.OnDateSetListener{
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        listener(dayOfMonth, month, year)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c= Calendar.getInstance()
        val año= c.get(Calendar.YEAR)
        val mes= c.get(Calendar.MONTH)
        val dia= c.get(Calendar.DAY_OF_MONTH)
        //val sabado= c.get(Calendar.SATURDAY)
        //setDisabledDays(Calendar[] days)

        val picker = DatePickerDialog(activity as Context, this, año, mes, dia)
        c.add(Calendar.DAY_OF_MONTH,+1)
        picker.datePicker.minDate = c.timeInMillis
        c.add(Calendar.MONTH, +1)
        picker.datePicker.maxDate = c.timeInMillis
        //picker.datePicker.dayOfMonth
        //Toast.makeText(context, dia, Toast.LENGTH_LONG).show()
        //Toast.makeText(this@MainActivity, "Doctor ", Toast.LENGTH_SHORT).show()
        return picker
    }


}