package com.example.etegocars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class premiumSedans : Fragment() {

lateinit var v:View
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      v= inflater.inflate(R.layout.fragment_premium_sedans, container, false)
        init(container)
        return v
    }

    private fun init(container: ViewGroup?) {

    }


}