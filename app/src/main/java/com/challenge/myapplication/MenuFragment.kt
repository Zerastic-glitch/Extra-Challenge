package com.challenge.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class MenuFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_menu, container, false)

        //startknop
        v.findViewById<Button>(R.id.startButton).setOnClickListener {
            (activity as MainActivity).startSpel()
        }

        return v
    }
}