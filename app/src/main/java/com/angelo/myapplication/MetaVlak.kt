package com.angelo.myapplication

class MetaVlak (){
    private val vlakken : Array<Vlak> = Array<Vlak>(9) { i -> Vlak() }

    fun isGewonnen () : Speler?{
        //TODO: implementeren
        return null
    }

    fun getVlak(punt : Vector) : Vlak {
        return vlakken[punt.x+punt.y*3]
    }
}