package com.angelo.myapplication

class Vlak (val metaVlak : MetaVlak, val positie: Int) : Winbaar{
    var gekozenDoor : Speler? = null
    override fun winnaar(): Speler? {
        return gekozenDoor
    }
}