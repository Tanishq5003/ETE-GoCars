package com.example.etegocars

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Details : AppCompatActivity() {
    private lateinit var toDate:TextView
    private lateinit var img:ImageView
    private lateinit var model:TextView
    private lateinit var milage:TextView
    private lateinit var price:TextView
    private lateinit var fromDate:TextView
    private lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        toDate = findViewById(R.id.to)
        fromDate = findViewById(R.id.from)
        button = findViewById(R.id.button)
        model = findViewById(R.id.nmeswift)
        milage = findViewById(R.id.milage)
        price = findViewById(R.id.price)
        img = findViewById(R.id.imgswift)
        model.text =intent.getStringExtra("model").toString()
        milage.text = intent.getStringExtra("milage").toString()
        price.text = intent.getStringExtra("price").toString()
        var image:Int = intent.getIntExtra("image",0)
        img.setImageResource(image)

        val myCallender = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener{view,year, month, dayOfMonth ->
            myCallender.set(Calendar.YEAR, year)
            myCallender.set(Calendar.MONTH, month)
            myCallender.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(myCallender)
        }
        fromDate.setOnClickListener {
            DatePickerDialog(this, datePicker, myCallender.get(Calendar.YEAR), myCallender.get(Calendar.MONTH),
            myCallender.get(Calendar.DAY_OF_MONTH)).show()
        }
        val myCallender2 = Calendar.getInstance()
        val datePicker2 = DatePickerDialog.OnDateSetListener{view,year, month, dayOfMonth ->
            myCallender2.set(Calendar.YEAR, year)
            myCallender2.set(Calendar.MONTH, month)
            myCallender2.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel2(myCallender2)
        }
        toDate.setOnClickListener {
            DatePickerDialog(this, datePicker2, myCallender2.get(Calendar.YEAR), myCallender2.get(Calendar.MONTH),
            myCallender2.get(Calendar.DAY_OF_MONTH)).show()
        }
        button.setOnClickListener {
            val intent = Intent(this, Checkout::class.java)
            intent.putExtra("image", image)
            intent.putExtra("model", model.text.toString())
            intent.putExtra("to", toDate.text.toString())
            intent.putExtra("from", fromDate.text.toString())
            startActivity(intent)
            finish()
        }
    }

    private fun updateLabel2(myCallender2: Calendar) {
        val myFormat = "dd-MM-YYYY"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        toDate.setText(sdf.format(myCallender2.time))
    }

    private fun updateLabel(myCallender: Calendar) {
        val myFormat = "dd-MM-YYYY"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        fromDate.setText(sdf.format(myCallender.time))
    }
}