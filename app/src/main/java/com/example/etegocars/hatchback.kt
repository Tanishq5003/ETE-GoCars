package com.example.etegocars

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast



class hatchback : Fragment() {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//
//        }
    lateinit var v:View

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            v = inflater.inflate(R.layout.fragment_hatchback, container, false)
            init(container)
            return v
        }
    private fun init(root: ViewGroup?) {
        val but: Button = v.findViewById(R.id.btnswift)
        val buttiago:Button = v.findViewById(R.id.btntiago)
        val btni20:Button = v.findViewById(R.id.btni20)
        val btnaltroz:Button = v.findViewById(R.id.btnaltroz)
        val btnbaleno:Button = v.findViewById(R.id.btnbalenoi)
        but.setOnClickListener {
            val intent:Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "Swift")
            intent.putExtra("milage", "22KmPL")
            intent.putExtra("price", "INR2200/Day")
            intent.putExtra("image", R.drawable.swift1)
            startActivity(intent)
        }
        buttiago.setOnClickListener {
            val intent:Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "Tiago")
            intent.putExtra("milage", "24KmPL")
            intent.putExtra("price", "INR2100/Day")
            intent.putExtra("image", R.drawable.tiago)
            startActivity(intent)
        }
        btni20.setOnClickListener {
            val intent:Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "i20")
            intent.putExtra("milage", "19KmPL")
            intent.putExtra("price", "INR2400/Day")
            intent.putExtra("image", R.drawable.i20)
            startActivity(intent)
        }
        btnaltroz.setOnClickListener {
            val intent:Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "Altroz")
            intent.putExtra("milage", "20KmPL")
            intent.putExtra("price", "INR2300/Day")
            intent.putExtra("image", R.drawable.altroz)
            startActivity(intent)
        }
        btnbaleno.setOnClickListener {
            val intent:Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "Baleno")
            intent.putExtra("milage", "22KmPL")
            intent.putExtra("price", "INR2200/Day")
            intent.putExtra("image", R.drawable.baleno1)
            startActivity(intent)
        }

    }

    }



