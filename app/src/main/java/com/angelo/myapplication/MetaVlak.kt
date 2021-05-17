package com.angelo.myapplication

class MetaVlak () : Winbaar{
    private val vlakken : Array<Vlak> = Array<Vlak>(9) { i -> Vlak() }

    override fun isGewonnen (spelers : Array<Speler>, n : Int) : Speler?{
        return Veld.isGewonnen(spelers, vlakken, n)
    }

    fun getVlak(punt : Vector) : Vlak {
        return vlakken[punt.x+punt.y*3]
    }

    fun getVlak(positie : Int) : Vlak {
        return vlakken[positie]
    }

    fun getVlakken() : Array<Vlak> {
        return vlakken
    }
}