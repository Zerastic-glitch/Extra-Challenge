package com.angelo.myapplication

class Spel (private val id : Int, private val spelers : Array<Speler>){
    private val n
    private val vlakken : Array<MetaVlak> = Array<MetaVlak>(n*n) { i -> MetaVlak() }

    init {

    }

    fun isGewonnen (): Speler?{
        for (speler in spelers) {
            if (isGewonnenDoorSpeler(speler)) {
                return speler
            }
        }
        return null
    }

    fun isGewonnenDoorSpeler(speler:Speler): boolean {
        endResDiag1 = true
        endResDiag2 = true
        for (i in 0..n-1) {
            endResColom = true
            endResRij = true
            endResDiag1 = endResDiag1 && (vlakken[i * n + i].isGewonnen?.equals(speler))
            endResDiag2 = endResDiag2 && (vlakken[i * n + 2-i].isGewonnen?.equals(speler))
            for(b in 0..n-1) {
                endResColom = endResColom && (vlakken[i * n + b].isGewonnen?.equals(speler))
                endResRij = endResRij && (vlakken[b * n + i].isGewonnen?.equals(speler))
            }
            if (endResColom || endResRij) {
                return true
            }
        }
        if (endResDiag1 || endResDiag2) {
            return true
        }
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