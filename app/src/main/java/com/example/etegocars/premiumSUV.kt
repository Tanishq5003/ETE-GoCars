package com.example.etegocars

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class premiumSUV : Fragment() {

    lateinit var v:View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_premium_s_u_v, container, false)
        init(container)
        return v
    }

    private fun init(container: ViewGroup?) {
        val btnfortuner: Button = v.findViewById(R.id.btnfortuner)
        val btnx7: Button = v.findViewById(R.id.btnx7)
        val btngclass: Button = v.findViewById(R.id.btngclass)
        val btnrange: Button = v.findViewById(R.id.btnrange)
        val btnq7: Button = v.findViewById(R.id.btnq7)
        btnfortuner.setOnClickListener {
            val intent: Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "Fortuner")
            intent.putExtra("milage", "12KmPL")
            intent.putExtra("price", "INR5200/Day")
            intent.putExtra("image", R.drawable.fortuner)
            startActivity(intent)
        }
        btnx7.setOnClickListener {
            val intent: Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "X7")
            intent.putExtra("milage", "14KmPL")
            intent.putExtra("price", "INR7200/Day")
            intent.putExtra("image", R.drawable.x7)
            startActivity(intent)
        }
        btngclass.setOnClickListener {
            val intent: Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "G-Class")
            intent.putExtra("milage", "10KmPL")
            intent.putExtra("price", "INR20000/Day")
            intent.putExtra("image", R.drawable.gclass)
            startActivity(intent)
        }
        btnrange.setOnClickListener {
            val intent: Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "Range Rover")
            intent.putExtra("milage", "13KmPL")
            intent.putExtra("price", "INR18000/Day")
            intent.putExtra("image", R.drawable.altroz)
            startActivity(intent)
        }
        btnq7.setOnClickListener {
            val intent: Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "Q7")
            intent.putExtra("milage", "14KmPL")
            intent.putExtra("price", "INR9200/Day")
            intent.putExtra("image", R.drawable.q7)
            startActivity(intent)
        }
    }


}