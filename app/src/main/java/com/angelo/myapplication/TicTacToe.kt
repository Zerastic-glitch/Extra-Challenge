package com.angelo.myapplication


abstract class TicTacToe<T : Winbaar>(val n: Int) {
    lateinit var vlakken: Array<T>
    fun isGewonnen(): Boolean {
        return winnaar() != null; }

    fun or(speler: Speler?, winnaar: Speler?): Speler? {
        return if (speler == null) {
            winnaar
        } else {
            speler
        };
    }

    fun winnaar(start: Vector, direction: Vector): Speler? {
        var position = start;
        var result = getVlak(position).winnaar();
        for (i in 1..(n - 1)) {
            position = position.add(direction);
            if (result != getVlak(position).winnaar()) {
                result = null;
            }
        }
        return result;
    }

    fun winnaar(): Speler? {
        var result: Speler? = null;
        for (i in 0..(n-1))
        {
            result = or(result, winnaar(Vector(0, i), Vector(1, 0)));
            result = or(result, winnaar(Vector(i, 0), Vector(0, 1)));

        }
        result = or(result, winnaar(Vector(0, 0), Vector(1, 1)));
        result = or(result, winnaar(Vector(0, n -1), Vector(1, -1)));
        return result;
    }

    fun getVlak(punt: Vector): T {
        return vlakken[punt.x + punt.y * 3]
    }

    fun getVlak(positie: Int): T {
        return vlakken[positie]
    }
}