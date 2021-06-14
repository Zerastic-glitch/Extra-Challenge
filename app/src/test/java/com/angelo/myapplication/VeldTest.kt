package com.angelo.myapplication

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class VeldTest {
    var kruisId = R.drawable.kruis
    var cirkelId = R.drawable.cirkel

    fun testIsGewonnenDoorSpeler(expected: Boolean, vararg posities: Int) {
        var speler1 = Speler("speler 1", kruisId)
        val metaVlak = MetaVlak()
        for (positie: Int in posities) {
            metaVlak.getVlak(positie).gekozenDoor = speler1;
        }
        Assertions.assertEquals(expected, metaVlak.isGewonnen());
    }

    @Test
    fun testIsGewonnenDoorSpelerHorizontaal() {
        testIsGewonnenDoorSpeler(true, 0, 1, 2);
        testIsGewonnenDoorSpeler(true, 3, 4, 5);
        testIsGewonnenDoorSpeler(true, 6, 7, 8);
    }

    @Test
    fun testIsGewonnenDoorSpelerVerticaal() {
        testIsGewonnenDoorSpeler(true, 0, 3, 6);
        testIsGewonnenDoorSpeler(true, 1, 4, 7);
        testIsGewonnenDoorSpeler(true, 2, 5, 8);
    }

    @Test
    fun testIsGewonnenDoorSpelerDiagonaal() {
        testIsGewonnenDoorSpeler(true, 0, 4, 8);
        testIsGewonnenDoorSpeler(true, 2, 4, 6);
    }

    @Test
    fun testIsGewonnenDoorSpelerExtra() {
        testIsGewonnenDoorSpeler(true, 0, 1, 2, 3);
        testIsGewonnenDoorSpeler(true, 0, 1, 2, 3, 4, 5, 6, 7, 8);
    }

    @Test
    fun testIsGewonnenDoorSpelerFalse() {
        testIsGewonnenDoorSpeler(false, 0, 1);
        testIsGewonnenDoorSpeler(false, 2, 3, 4);
    }
}