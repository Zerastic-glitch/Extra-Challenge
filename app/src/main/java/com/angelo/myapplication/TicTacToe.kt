package com.angelo.myapplication


abstract class TicTacToe <T : Winbaar> (val n : Int) {
    lateinit var vlakken : Array<T>

    fun isGewonnen(spelers : Array<Speler>, n: Int): Speler?{
        for (speler in spelers) {
            if (isGewonnenDoorSpeler(speler, spelers, n)) {
                return speler
            }
        }
        return null
    }

    fun isGewonnenDoorSpeler(speler:Speler, spelers: Array<Speler>, n : Int): Boolean {
        var endResDiag1 = true
        var endResDiag2 = true
        for (i in 0 until n) {
            var endResColom = true
            var endResRij = true
            endResDiag1 = endResDiag1 && (speler==vlakken[i * n + i].isGewonnen(spelers, n))
            endResDiag2 = endResDiag2 && (speler==vlakken[i * n + 2-i].isGewonnen(spelers, n))
            for(b in 0 until n) {
                endResColom = endResColom && speler==vlakken[i * n + b].isGewonnen(spelers, n)
                endResRij = endResRij && speler==vlakken[b * n + i].isGewonnen(spelers, n)
            }
            if (endResColom || endResRij) {
                return true
            }
        }
        if (endResDiag1 || endResDiag2) {
            return true
        }
        return false
    }

    fun getVlak(punt : Vector) : T {
        return vlakken[punt.x+punt.y*3]
    }

    fun getVlak(positie : Int) : T {
        return vlakken[positie]
    }

}