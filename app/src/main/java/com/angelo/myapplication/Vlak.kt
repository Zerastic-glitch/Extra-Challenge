package com.angelo.myapplication

class Vlak (val metaVlak : MetaVlak, var positie: Int) : Winbaar{
    var gekozenDoor : Speler? = null
    override fun isGewonnen(spelers : Array<Speler>, n : Int): Speler? {
        return gekozenDoor
    }
}