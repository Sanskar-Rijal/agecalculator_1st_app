
package com.example.age
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private var dateinminutes:TextView?=null
    private var date:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn:Button=findViewById(R.id.btndatepicker)
        date=findViewById(R.id.seldate)
        dateinminutes=findViewById(R.id.finaldate)
        btn.setOnClickListener {
            clickdatepicker()
        }
    }
    private fun clickdatepicker()
    {
        val mycalander=Calendar.getInstance()
        val year=mycalander.get(Calendar.YEAR)
        val month=mycalander.get(Calendar.MONTH)
        val day=mycalander.get(Calendar.DAY_OF_MONTH)
       val dpd= DatePickerDialog(this,
        DatePickerDialog.OnDateSetListener{view,Selectedyear,Selectedmonth,Selectedday->
            Toast.makeText(this,"your date is $Selectedyear/${Selectedmonth+1}/$Selectedday",Toast.LENGTH_SHORT).show()
            val selectedDate="$Selectedyear/0${Selectedmonth+1}/$Selectedday"
            date?.text=selectedDate
            val sdf=SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH)
            val minconverter=sdf.parse(selectedDate)
            minconverter?.let {

                val selecteddateinminutes =Selectedyear
                val curretdate = Calendar.getInstance().get(Calendar.YEAR)
                curretdate?.let {
                    //val currentdateinminutes = curretdate.time/ (60000)
                    val differencee= curretdate-selecteddateinminutes
                    dateinminutes?.text = differencee.toString()
                }
            } }
        ,year,month,day)
        dpd.datePicker.maxDate=System.currentTimeMillis()-86400000
        dpd.show()

    }
}