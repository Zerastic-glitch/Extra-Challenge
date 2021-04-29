package com.challenge.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    val menuFragment = MenuFragment()
    val spelFragment = SpelFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //stel menu in
        supportFragmentManager.beginTransaction().add(R.id.container, menuFragment).commit()

    }

    //methode voor startknop
    fun startSpel(){
        supportFragmentManager.beginTransaction().remove(menuFragment).add(R.id.container, spelFragment).commit()
    }

}