package com.example.etegocars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Checkout : AppCompatActivity() {
    private lateinit var name:TextView
    private lateinit var model:TextView
    private lateinit var from:TextView
    private lateinit var to:TextView
    private lateinit var image:ImageView
    private lateinit var uid:TextView
    private lateinit var auth: FirebaseAuth
    private lateinit var logout:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
        image = findViewById(R.id.imgswift)
        val img:Int = intent.getIntExtra("image", 0)
        image.setImageResource(img)
        model = findViewById(R.id.nmeswift)
        from = findViewById(R.id.from)
        to = findViewById(R.id.to)
        model.text = intent.getStringExtra("model").toString()
        from.text = intent.getStringExtra("from").toString()
        to.text = intent.getStringExtra("to").toString()



        auth = FirebaseAuth.getInstance()
        name = findViewById(R.id.firstName)
        uid = findViewById(R.id.userid)
        uid.text = auth.currentUser!!.uid
        val firstName:DatabaseReference = FirebaseDatabase.getInstance().getReference("First Name")
        firstName.child(auth.currentUser!!.uid).get().addOnSuccessListener{
            if(it.exists()){
                val name2 = it.child(auth.currentUser!!.uid).value
                name.text = name2.toString()
            }
        }
        logout = findViewById(R.id.button)
        logout.setOnClickListener {
            Toast.makeText(this, "Your Booking has been received successfully!!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }

    }
}