package com.angelo.myapplication

import org.junit.Assert
import org.junit.Test

class SpelTest {
    @Test
    fun isGewonnen() {
        var spelers = Array<Speler>(2){i -> Speler("speler ${i+1}", if (i==0) "kruis" else "rondje" ) }
        val speler = spelers[0]
        val spel = Spel(spelers)

        Assert.assertNull(spel.isGewonnen())

        val metavlakken = Array<MetaVlak>(3){i -> spel.getMetaVlak(Vector(i,i))}
        for(metavlak in metavlakken) {
            for(i in 0..2) {
                metavlak.getVlak(Vector(i,i)).gekozenDoor = speler
            }
        }
        Assert.assertEquals(speler, spel.isGewonnen())
    }
}