package com.angelo.myapplication

class Spel (private val id : Int, private val spelers : Array<Speler>){
    private val n = 3
    private val vlakken : Array<MetaVlak> = Array<MetaVlak>(n*n) { i -> MetaVlak() }

    init {

    }

    fun isGewonnen(): Speler? {
        return Veld.isGewonnen(spelers, vlakken, n)
    }

    fun nieuweBeurt(vlak : Vlak){
        val beurt = Beurt(vlak)
    }

    fun getMetaVlak (punt : Vector) : MetaVlak {
        return vlakken[punt.x+punt.y*3]
    }

    fun isBeschikbaar (vlak : Vlak) : Boolean {
        return true
    }
}