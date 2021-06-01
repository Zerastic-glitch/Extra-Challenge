package com.angelo.myapplication


abstract class TicTacToe <T : Winbaar> (val n : Int) {
    lateinit var vlakken : Array<T>
    fun isGewonnen(): Boolean { return winnaar() != null; }
    fun winnaar(): Speler? {
        var endResDiag1 : Speler? = null
        var endResDiag2 : Speler? = null
        for (i in 0 until n) {
            var endResColom : Speler? = null
            var endResRij : Speler? = null
            if (vlakken[i * n + i].winnaar() != endResDiag1) endResDiag1 = null;
            if (vlakken[i * n + 2-i].winnaar() != endResDiag1) endResDiag1 = null;
            for(b in 0 until n) {
                if (vlakken[i * n + b].winnaar() != endResColom) endResColom = null;
                if (vlakken[b * n + i].winnaar() != endResRij) endResRij = null;
            }
            if (endResColom != null) return endResColom
            if (endResRij != null) return endResRij
        }
        if (endResDiag1 != null) return endResDiag1
        if (endResDiag2 != null) return endResDiag2
        return null
    }

    fun getVlak(punt : Vector) : T {
        return vlakken[punt.x+punt.y*3]
    }

    fun getVlak(positie : Int) : T {
        return vlakken[positie]
    }
}