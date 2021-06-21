package com.angelo.myapplication

class Vlak (val metaVlak : MetaVlak, var positie: Int) : Winbaar{
    var gekozenDoor : Speler? = null
    override fun winnaar(): Speler? {
        return gekozenDoor
    }
}