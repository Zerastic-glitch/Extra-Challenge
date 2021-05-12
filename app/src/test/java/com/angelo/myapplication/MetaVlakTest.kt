package com.angelo.myapplication

import org.junit.Assert
import org.junit.Test

class MetaVlakTest {
    @Test
    fun isGewonnen() {
        var spelers = Array<Speler>(2){i -> Speler() }
        val speler = spelers[0]
        val metavlak = MetaVlak()

        Assert.assertNull(metavlak.isGewonnen(spelers, 3))

        for(i in 0..2) {
            metavlak.getVlak(Vector(i,i)).gekozenDoor = speler
        }

        Assert.assertEquals(speler, metavlak.isGewonnen(spelers, 3))
    }
}