package com.angelo.myapplication

class Veld () {

    companion object{
        fun <T:Winbaar>isGewonnen(spelers : Array<Speler>, vlakken: Array<T>, n: Int): Speler?{
            for (speler in spelers) {
                if (isGewonnenDoorSpeler(speler, spelers, vlakken, n)) {
                    return speler
                }
            }
            return null
        }

        fun <T:Winbaar>isGewonnenDoorSpeler(speler:Speler, spelers: Array<Speler>, vlakken : Array<T>, n : Int): Boolean {
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
    }

}