package com.example.etegocars

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class BlankFragment : Fragment() {


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
        v = inflater.inflate(R.layout.fragment_blank, container, false)
        init(container)
        return v
    }

    private fun init(container: ViewGroup?) {
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

    }


}