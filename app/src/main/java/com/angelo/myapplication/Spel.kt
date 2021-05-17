package com.angelo.myapplication

class Spel (val spelers : Array<Speler>){
    private val n = 3

    private val vlakken : Array<MetaVlak> = Array<MetaVlak>(n*n) { i -> MetaVlak() }
    private val beurten = ArrayList<Beurt>()
    private val id : Int

    companion object{
        private var lastId : Int = 0
    }

    init {
        id=lastId++
    }

    fun isGewonnen(): Speler? {
        return Veld.isGewonnen(spelers, vlakken, n)
    }

    fun nieuweBeurt(vlak : Vlak) : Speler{
        val beurt = Beurt(vlak)
        val speler = spelers[beurten.size % 2]
        vlak.gekozenDoor=speler
        beurten.add(beurt)
        return speler
    }

    fun getMetaVlak (punt : Vector) : MetaVlak {
        return vlakken[punt.x+punt.y*3]
    }

    fun isBeschikbaar (vlak : Vlak) : Boolean {
        return vlak.gekozenDoor==null
    }
}