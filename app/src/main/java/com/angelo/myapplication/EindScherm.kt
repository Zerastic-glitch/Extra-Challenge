package com.angelo.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class EindScherm(private var winnaar: Speler) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_eind_scherm, container, false)
        v.findViewById<TextView>(R.id.gameStatus).text="${winnaar.toString()} heeft gewonnen"
        return v
    }
}