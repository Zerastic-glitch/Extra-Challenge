package com.angelo.myapplication

class Spel (private val id : Int){
    private val vlakken : Array<MetaVlak> = Array<MetaVlak>(9) { i -> MetaVlak() }

    init {

    }

    fun isGewonnen (): Speler?{
        return null
    }

    fun nieuweBeurt(vlak : Vlak){

    }

    fun getMetaVlak (punt : Vector) : MetaVlak {
        return vlakken[punt.x+punt.y*3]
    }

    fun isBeschikbaar (vlak : Vlak) : Boolean {
        return true
    }




}