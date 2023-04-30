package com.example.etegocars

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var mail:EditText
    private lateinit var pass:EditText
    private lateinit var signup:TextView
    private lateinit var login: Button
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mail = findViewById(R.id.editTextMail)
        pass = findViewById(R.id.editTextPass)
        login = findViewById(R.id.button)
        signup = findViewById(R.id.sign)
        auth = FirebaseAuth.getInstance()
        login.setOnClickListener {
            var txt_email:String = mail.text.toString()
            var txt_password:String = pass.text.toString()
            login_user(txt_email, txt_password)
        }
        signup.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }
    }
    private fun login_user(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(this){ task->
            Toast.makeText(this , "Login Successful", Toast.LENGTH_SHORT).show()
            createNotificationChannel()
            var builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("User Logged-in")
                .setContentText("User Logged-in Successfully")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            with(NotificationManagerCompat.from(this)){
                if (ActivityCompat.checkSelfPermission(
                        applicationContext,
                        Manifest.permission.POST_NOTIFICATIONS
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    return@addOnSuccessListener
                }
                notify(1, builder.build())
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
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