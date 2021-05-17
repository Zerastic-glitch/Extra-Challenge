package com.angelo.myapplication

import org.junit.Assert
import org.junit.Test

class MetaVlakTest {
    var kruisId = R.drawable.kruis
    var cirkelId = R.drawable.cirkel

    @Test
    fun isGewonnen() {
        var spelers = Array<Speler>(2){i -> Speler("speler ${i+1}", if (i==0) kruisId else cirkelId ) }
        val speler = spelers[0]
        val metavlak = MetaVlak()

        Assert.assertNull(metavlak.isGewonnen(spelers, 3))

        for(i in 0..2) {
            metavlak.getVlak(Vector(i,i)).gekozenDoor = speler
        }

        Assert.assertEquals(speler, metavlak.isGewonnen(spelers, 3))
    }
}