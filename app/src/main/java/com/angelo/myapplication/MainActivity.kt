package com.angelo.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    val menuFragment = MenuFragment()
    val spelFragment = SpelFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.container, menuFragment).commit()
    }

    fun startSpel(){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.remove(menuFragment).add(R.id.container, spelFragment).commit()
    }

}