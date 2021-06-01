package com.angelo.myapplication

class MetaVlak () : Winbaar, TicTacToe<Vlak>(3) {
    init {
        vlakken = Array<Vlak>(9) {i -> Vlak()}
    }
}