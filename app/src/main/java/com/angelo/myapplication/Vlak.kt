package com.angelo.myapplication

class Vlak () : Winbaar{
    var gekozenDoor : Speler? = null
    override fun winnaar(): Speler? {
        return gekozenDoor
    }
}