package com.angelo.myapplication

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MetaVlakTest {
    var kruisId = R.drawable.kruis
    var cirkelId = R.drawable.cirkel

    @Test
    fun isGewonnen() {
        var spelers = Array<Speler>(2){i -> Speler("speler ${i+1}", if (i==0) kruisId else cirkelId ) }
        val speler = spelers[0]
        val metavlak = MetaVlak()

        Assertions.assertNull(metavlak.isGewonnen())

        for(i in 0..2) {
            metavlak.getVlak(Vector(i,i)).gekozenDoor = speler
        }

        Assertions.assertEquals(speler, metavlak.isGewonnen())
    }
}