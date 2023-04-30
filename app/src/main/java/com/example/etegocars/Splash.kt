package com.example.etegocars

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        var image = findViewById<ImageView>(R.id.image)
        Handler(Looper.getMainLooper()).postDelayed(
            {
            image.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.start()
                 },2000 )
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val i = Intent(this, Login::class.java)
                startActivity(i)
                finish() },5000 )
    }
}