package com.angelo.myapplication


abstract class TicTacToe <T : Winbaar> (val n : Int) {
    lateinit var vlakken : Array<T>
    fun isGewonnen(): Boolean { return winnaar() != null; }
    fun winnaar(): Speler? {
        var winnaarDiag1 : Speler? = getVlak(Vector(0,0)).winnaar()
        var winnaarDiag2 : Speler? = getVlak(Vector(n-1,0)).winnaar()
        for (i in 0 until n) {
            var winnaarColom : Speler? = getVlak(Vector(i,0)).winnaar()
            var winnaarRij : Speler? = getVlak(Vector(0,i)).winnaar()

            winnaarDiag1 = getZelfdeWinnaar(winnaarDiag1, i, i)

            winnaarDiag2 = getZelfdeWinnaar(winnaarDiag2, i,(n-1)-i)

            for(b in 1 until n) {
                winnaarColom = getZelfdeWinnaar(winnaarColom, i, b)

                winnaarRij = getZelfdeWinnaar(winnaarRij, b, i)
            }
            if (winnaarColom != null) return winnaarColom
            if (winnaarRij != null) return winnaarRij
        }
        if (winnaarDiag1 != null) return winnaarDiag1
        if (winnaarDiag2 != null) return winnaarDiag2
        return null
    }


    private fun getZelfdeWinnaar(endRes : Speler?, x : Int, y : Int) : Speler?{
        return if(getVlak(Vector(x,y)).winnaar() == endRes) endRes else null
    }

    fun getVlak(punt : Vector) : T {
        return vlakken[punt.x+punt.y*n]
    }

    fun getVlak(positie : Int) : T {
        return vlakken[positie]
    }
}