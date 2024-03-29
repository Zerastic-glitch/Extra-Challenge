package com.angelo.myapplication

class Spel (val spelers : Array<Speler>) : TicTacToe<MetaVlak>(3) {
    private val beurten = ArrayList<Beurt>()
    private val id : Int

    companion object{
        private var lastId : Int = 0
    }

    init {
        vlakken = Array<MetaVlak>(9) {i -> MetaVlak()}
        id=lastId++
    }

    fun nieuweBeurt(vlak : Vlak) : Speler{
        val beurt = Beurt(vlak)
        val speler = spelers[beurten.size % 2]
        vlak.gekozenDoor=speler
        beurten.add(beurt)
        return speler
    }

    fun isBeschikbaar (vlak : Vlak) : Boolean {
        return vlak.gekozenDoor==null && isValideZet(vlak)
    }

    fun isValideZet(gekozenVlak : Vlak) : Boolean {
        if(beurten.size < 2) return true
        val vorigeVlak = beurten.get(beurten.size-2).vlak
        val valideMetavlak = vlakken.get(vorigeVlak.positie)
        return !gekozenVlak.isGewonnen() && !gekozenVlak.metaVlak.isGewonnen() &&
                (valideMetavlak.isGewonnen() || gekozenVlak.metaVlak==valideMetavlak)
    }
}