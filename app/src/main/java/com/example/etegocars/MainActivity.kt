package com.example.etegocars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var toggle:ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    lateinit var view: View
    private lateinit var dataBase:DatabaseReference
    private lateinit var auth:FirebaseAuth
    lateinit var first:TextView
    lateinit var last:TextView
    lateinit var email:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navView = findViewById(R.id.navView)
        drawerLayout = findViewById(R.id.drawerLayout)
        auth = FirebaseAuth.getInstance()
        dataBase = FirebaseDatabase.getInstance().getReference("First Name")
        view = navView.getHeaderView(0)
        first = view.findViewById(R.id.firstName)
        last = view.findViewById(R.id.lastName)
        email = view.findViewById(R.id.mail)

        dataBase.child(auth.currentUser!!.uid).get().addOnSuccessListener{
            if(it.exists()){
                val name2 = it.child(auth.currentUser!!.uid).value
                first.text = name2.toString()
            }
        }
        val lastName:DatabaseReference = FirebaseDatabase.getInstance().getReference("Last Name")
        lastName.child(auth.currentUser!!.uid).get().addOnSuccessListener {
            if (it.exists()) {
                val name2 = it.child(auth.currentUser!!.uid).value
                last.text = name2.toString()
            }
        }
        val Email:DatabaseReference = FirebaseDatabase.getInstance().getReference("Email")
        Email.child(auth.currentUser!!.uid).get().addOnSuccessListener {
            if (it.exists()) {
                val name2 = it.child(auth.currentUser!!.uid).value
                email.text = name2.toString()
            }
        }

        supportFragmentManager.beginTransaction().apply {
            val all = allCars()
            replace(R.id.frameLayout, all)
            addToBackStack(null)
            commit()
        }
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.allCars -> {
                    val all = allCars()
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayout, all)
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                R.id.hatchback -> {
                    val hatch = hatchback()
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayout, hatch)
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                R.id.sedans ->{
                    val sedan = BlankFragment()
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayout, sedan)
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                R.id.suv->{
                    val suv = SUV()
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayout, suv)
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                R.id.premium->{
                    val premiumSedans = premiumSedans()
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayout, premiumSedans)
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                R.id.premiumSuv->{
                    val premiumSUV =premiumSUV()
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayout, premiumSUV)
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                R.id.logout->{
                    val intent = Intent(this, Login::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                else -> {
                    false
                }
            }
        }

    }

    override fun onBackPressed() {

    }
}