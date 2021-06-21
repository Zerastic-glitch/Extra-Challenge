package com.angelo.myapplication

interface Winbaar {
    fun winnaar() : Speler?
    fun isGewonnen(): Boolean { return winnaar() != null; }
}