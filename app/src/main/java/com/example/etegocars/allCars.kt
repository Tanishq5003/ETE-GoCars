package com.example.etegocars

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class allCars : Fragment() {

lateinit var v:View
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         v = inflater.inflate(R.layout.fragment_all_cars, container, false)
        init(container)
        return v
    }

    private fun init(container: ViewGroup?) {
        val but: Button = v.findViewById(R.id.btnswift)
        val buttiago: Button = v.findViewById(R.id.btntiago)
        val btni20: Button = v.findViewById(R.id.btni20)
        val btnaltroz: Button = v.findViewById(R.id.btnaltroz)
        val btnbaleno: Button = v.findViewById(R.id.btnbalenoi)
        but.setOnClickListener {
            val intent: Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "Swift")
            intent.putExtra("milage", "22KmPL")
            intent.putExtra("price", "INR2200/Day")
            intent.putExtra("image", R.drawable.swift1)
            startActivity(intent)
        }
        buttiago.setOnClickListener {
            val intent: Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "Tiago")
            intent.putExtra("milage", "24KmPL")
            intent.putExtra("price", "INR2100/Day")
            intent.putExtra("image", R.drawable.tiago)
            startActivity(intent)
        }
        btni20.setOnClickListener {
            val intent: Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "i20")
            intent.putExtra("milage", "19KmPL")
            intent.putExtra("price", "INR2400/Day")
            intent.putExtra("image", R.drawable.i20)
            startActivity(intent)
        }
        btnaltroz.setOnClickListener {
            val intent: Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "Altroz")
            intent.putExtra("milage", "20KmPL")
            intent.putExtra("price", "INR2300/Day")
            intent.putExtra("image", R.drawable.altroz)
            startActivity(intent)
        }
        btnbaleno.setOnClickListener {
            val intent: Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "Baleno")
            intent.putExtra("milage", "22KmPL")
            intent.putExtra("price", "INR2200/Day")
            intent.putExtra("image", R.drawable.baleno1)
            startActivity(intent)
        }
        val btncity: Button = v.findViewById(R.id.btncity)
        val btndzire: Button = v.findViewById(R.id.btndzire)
        val btnvitrus: Button = v.findViewById(R.id.btnvitrus)
        val btnamaze: Button = v.findViewById(R.id.btnamaze)
        val btnsalvia: Button = v.findViewById(R.id.btnsalvia)
        btncity.setOnClickListener {
            val intent: Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "City")
            intent.putExtra("milage", "21KmPL")
            intent.putExtra("price", "INR2800/Day")
            intent.putExtra("image", R.drawable.city)
            startActivity(intent)
        }
        btndzire.setOnClickListener {
            val intent: Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "Dzire")
            intent.putExtra("milage", "22KmPL")
            intent.putExtra("price", "INR2500/Day")
            intent.putExtra("image", R.drawable.dzire1)
            startActivity(intent)
        }
        btnvitrus.setOnClickListener {
            val intent: Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "Vitrus")
            intent.putExtra("milage", "19KmPL")
            intent.putExtra("price", "INR3200/Day")
            intent.putExtra("image", R.drawable.vitrus)
            startActivity(intent)
        }
        btnamaze.setOnClickListener {
            val intent: Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "Amaze")
            intent.putExtra("milage", "20KmPL")
            intent.putExtra("price", "INR2700/Day")
            intent.putExtra("image", R.drawable.amaze)
            startActivity(intent)
        }
        btnsalvia.setOnClickListener {
            val intent: Intent = Intent(context, Details::class.java)
            intent.putExtra("model", "Salvia")
            intent.putExtra("milage", "18KmPL")
            intent.putExtra("price", "INR3500/Day")
            intent.putExtra("image", R.drawable.salvia)
            startActivity(intent)
        }
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