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

    fun isGewonnen(): Speler? {
        return super.isGewonnen(spelers, n)
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

    fun isValideZet(vlak : Vlak) : Boolean {
        if(beurten.size < 2) return true
        val vorigVlak = beurten.get(beurten.size-2).vlak
        var valideMetavlakPositie = 0
        for(metavlak in vlakken) {
            for(i in 0..8) {
                if(metavlak.getVlak(i) == vorigVlak) {
                    valideMetavlakPositie = i
                }
            }
        }
        val valideMetavlak = vlakken.get(valideMetavlakPositie)
        val valideVlakken = vlakken.get(valideMetavlakPositie).vlakken
        return ((vlak in valideVlakken && valideMetavlak.isGewonnen(spelers, n) == null)
                || valideMetavlak.isGewonnen(spelers, n) != null)
    }

}