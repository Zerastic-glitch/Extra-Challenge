package com.angelo.myapplication

class Vlak () : Winbaar{
    var gekozenDoor : Speler? = null
    override fun isGewonnen(spelers : Array<Speler>, n : Int): Speler? {
        return gekozenDoor
    }
}