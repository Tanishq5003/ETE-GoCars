package com.example.etegocars

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class SUV : Fragment() {


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }
    lateinit var v:View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_s_u_v, container, false)
        init(container)
        return v
    }

    private fun init(container: ViewGroup?) {
        val btncrysta: Button = v.findViewById(R.id.btncrysta)
        val btncreta: Button = v.findViewById(R.id.btncreta)
        val btnthar: Button = v.findViewById(R.id.btnthar)
        val btnbreeza: Button = v.findViewById(R.id.btnbreeza)
        val btnscorpio: Button = v.findViewById(R.id.btnscorpio)
        btncrysta.setOnClickListener {
            val intent: Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "Crysta")
            intent.putExtra("milage", "14KmPL")
            intent.putExtra("price", "INR3400/Day")
            intent.putExtra("image", R.drawable.crysta)
            startActivity(intent)
        }
        btncreta.setOnClickListener {
            val intent: Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "Creta")
            intent.putExtra("milage", "16KmPL")
            intent.putExtra("price", "INR3200/Day")
            intent.putExtra("image", R.drawable.creta)
            startActivity(intent)
        }
        btnthar.setOnClickListener {
            val intent: Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "Thar")
            intent.putExtra("milage", "15KmPL")
            intent.putExtra("price", "INR3600/Day")
            intent.putExtra("image", R.drawable.thar)
            startActivity(intent)
        }
        btnbreeza.setOnClickListener {
            val intent: Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "Breeza")
            intent.putExtra("milage", "20KmPL")
            intent.putExtra("price", "INR2500/Day")
            intent.putExtra("image", R.drawable.breeza)
            startActivity(intent)
        }
        btnscorpio.setOnClickListener {
            val intent: Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "Scorpio")
            intent.putExtra("milage", "15KmPL")
            intent.putExtra("price", "INR3200/Day")
            intent.putExtra("image", R.drawable.scorpio)
            startActivity(intent)
        }
    }


}