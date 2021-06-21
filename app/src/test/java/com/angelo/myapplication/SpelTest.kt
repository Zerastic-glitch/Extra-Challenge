package com.angelo.myapplication

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SpelTest {

    var kruisId = R.drawable.kruis
    var cirkelId = R.drawable.cirkel

    @Test
    fun isGewonnen() {
        val spelers = Array<Speler>(2){i -> Speler("speler ${i+1}", if (i==0) kruisId else cirkelId ) }
        val speler = spelers[0]
        val spel = Spel(spelers)

        Assertions.assertNull(spel.isGewonnen())

        val metavlakken = Array<MetaVlak>(3){i -> spel.getVlak(Vector(i,i))}
        for(metavlak in metavlakken) {
            for(i in 0..2) {
                metavlak.getVlak(Vector(i,i)).gekozenDoor = speler
            }
        }
        Assertions.assertEquals(speler, spel.isGewonnen())
    }

    @Test
    fun isValideZet() {
        val spelers = Array<Speler>(2){i -> Speler("speler ${i+1}", if (i==0) kruisId else cirkelId ) }
        val spel = Spel(spelers)

        spel.nieuweBeurt(spel.getVlak(0).getVlak(2))
        // Test wanneer er nog géén beurt gedaan is door de huidige speler (moet 'true' returnen)
        Assertions.assertTrue(spel.isValideZet(spel.getVlak(0).getVlak(3)))

        spel.nieuweBeurt(spel.getVlak(0).getVlak(3))
        // Test wanneer de speler vorige beurt het vlakje van rechtsboven selecteerde,
        // en als deze nu een vlak in het metavlak rechtsboven probeert te selecteren
        // (moet 'false' returnen)
        Assertions.assertFalse(spel.isValideZet(spel.getVlak(0).getVlak(2)))

        // Test wanneer de speler vorige beurt het vlakje van rechtsboven selecteerde,
        // en als deze nu een vlak in het metavlak linksboven probeert te selecteren
        // (moet 'true' returnen)
        Assertions.assertTrue(spel.isValideZet(spel.getVlak(2).getVlak(2)))

        spel.nieuweBeurt(spel.getVlak(2).getVlak(3))
        // Test wanneer de speler vorige beurt het vlakje van linksmidden selecteerde,
        // en als deze nu een vlak in het metavlak rechtsboven probeert te selecteren
        // (moet 'false' returnen)
        Assertions.assertFalse(spel.isValideZet(spel.getVlak(0).getVlak(2)))

        // Test wanneer de speler vorige beurt het vlakje van linksmidden selecteerde,
        // en als deze nu een vlak in het metavlak linksmidden probeert te selecteren
        // (moet 'true' returnen)
        Assertions.assertTrue(spel.isValideZet(spel.getVlak(3).getVlak(2)))
    }

    @Test
    fun isBeschikbaar() {
        val spelers = Array<Speler>(2){i -> Speler("speler ${i+1}", if (i==0) kruisId else cirkelId ) }
        val spel = Spel(spelers)

        spel.nieuweBeurt(spel.getVlak(0).getVlak(2))
        Assertions.assertTrue(spel.isBeschikbaar(spel.getVlak(0).getVlak(3)))
        spel.nieuweBeurt(spel.getVlak(0).getVlak(0))
        Assertions.assertFalse(spel.isBeschikbaar(spel.getVlak(0).getVlak(2)))
        Assertions.assertTrue(spel.isBeschikbaar(spel.getVlak(2).getVlak(2)))
        spel.nieuweBeurt(spel.getVlak(2).getVlak(3))
        Assertions.assertFalse(spel.isBeschikbaar(spel.getVlak(3).getVlak(2)))
        Assertions.assertFalse(spel.isBeschikbaar(spel.getVlak(0).getVlak(0)))
        Assertions.assertFalse(spel.isBeschikbaar(spel.getVlak(0).getVlak(2)))
        Assertions.assertTrue(spel.isBeschikbaar(spel.getVlak(0).getVlak(3)))
    }
}