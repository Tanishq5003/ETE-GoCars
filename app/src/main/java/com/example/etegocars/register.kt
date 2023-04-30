package com.example.etegocars

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
const val CHANNEL_ID = "ChannelId"
class register : AppCompatActivity() {
    private lateinit var first:EditText
    private lateinit var last:EditText
    private lateinit var mail:EditText
    private lateinit var pass:EditText
    private lateinit var sign:TextView
    private lateinit var register: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        first = findViewById(R.id.editTextFirstName)
        last = findViewById(R.id.editTextLastName)
        mail = findViewById(R.id.editTextMail)
        pass = findViewById(R.id.editTextPass)
        register = findViewById(R.id.button)
        auth = FirebaseAuth.getInstance()
        database = Firebase.database.reference
        sign = findViewById(R.id.text4)
        register.setOnClickListener {
            var txt_email:String = mail.text.toString()
            var txt_password:String = pass.text.toString()

            if (TextUtils.isEmpty(txt_email)|| TextUtils.isEmpty(txt_password)){
                Toast.makeText(this , "Empty Credential" , Toast.LENGTH_SHORT).show()
            }
            else if (txt_password.length<6){
                Toast.makeText(this , "Password should contain at least 6 characters" , Toast.LENGTH_SHORT).show()
            }
            else{
                registerUser(txt_email , txt_password)
            }
        }
        sign.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        // Notification code

    }
    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){task ->
            if (task.isSuccessful()){
                var txt_name:String = first.text.toString()
                var reg_no:String = last.text.toString()
                var email:String = mail.text.toString()
                Toast.makeText(this , "User Registered Successfully", Toast.LENGTH_SHORT).show()
                //Notification Code
                createNotificationChannel()
                var builder = NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.logo)

                    .setContentTitle("User Registered")
                    .setContentText("New user registration Successful")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                with(NotificationManagerCompat.from(this)){
                    if (ActivityCompat.checkSelfPermission(
                            applicationContext,
                            Manifest.permission.POST_NOTIFICATIONS
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        return@addOnCompleteListener
                    }
                    notify(1, builder.build())
                }
                //Database addition
                database.child("First Name").child(Firebase.auth.currentUser!!.uid).child(Firebase.auth.currentUser!!.uid).setValue(txt_name)
                database.child("Last Name").child(Firebase.auth.currentUser!!.uid).child(Firebase.auth.currentUser!!.uid).setValue(reg_no)
                database.child("Email").child(Firebase.auth.currentUser!!.uid).child(Firebase.auth.currentUser!!.uid).setValue(email)

                var intent = Intent(this , Login::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this , "User Registration Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID, "First Channel", NotificationManager.IMPORTANCE_DEFAULT)
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}