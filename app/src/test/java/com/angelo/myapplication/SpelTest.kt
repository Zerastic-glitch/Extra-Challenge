package com.angelo.myapplication

import org.junit.Assert
import org.junit.Test

class SpelTest {

    var kruisId = R.drawable.kruis
    var cirkelId = R.drawable.cirkel

    @Test
    fun isGewonnen() {
        val spelers = Array<Speler>(2){i -> Speler("speler ${i+1}", if (i==0) kruisId else cirkelId ) }
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

    @Test
    fun isValideZet() {
        val spelers = Array<Speler>(2){i -> Speler("speler ${i+1}", if (i==0) kruisId else cirkelId ) }
        val spel = Spel(spelers)

        spel.nieuweBeurt(spel.getMetaVlak(0).getVlak(2))
        // Test wanneer er nog géén beurt gedaan is door de huidige speler (moet 'true' returnen)
        Assert.assertTrue(spel.isValideZet(spel.getMetaVlak(0).getVlak(3)))

        spel.nieuweBeurt(spel.getMetaVlak(0).getVlak(3))
        // Test wanneer de speler vorige beurt het vlakje van rechtsboven selecteerde,
        // en als deze nu een vlak in het metavlak rechtsboven probeert te selecteren
        // (moet 'false' returnen)
        Assert.assertFalse(spel.isValideZet(spel.getMetaVlak(0).getVlak(2)))

        // Test wanneer de speler vorige beurt het vlakje van rechtsboven selecteerde,
        // en als deze nu een vlak in het metavlak linksboven probeert te selecteren
        // (moet 'true' returnen)
        Assert.assertTrue(spel.isValideZet(spel.getMetaVlak(2).getVlak(2)))

        spel.nieuweBeurt(spel.getMetaVlak(2).getVlak(3))
        // Test wanneer de speler vorige beurt het vlakje van linksmidden selecteerde,
        // en als deze nu een vlak in het metavlak rechtsboven probeert te selecteren
        // (moet 'false' returnen)
        Assert.assertFalse(spel.isValideZet(spel.getMetaVlak(0).getVlak(2)))

        // Test wanneer de speler vorige beurt het vlakje van linksmidden selecteerde,
        // en als deze nu een vlak in het metavlak linksmidden probeert te selecteren
        // (moet 'true' returnen)
        Assert.assertTrue(spel.isValideZet(spel.getMetaVlak(3).getVlak(2)))
    }

    @Test
    fun isBeschikbaar() {
        val spelers = Array<Speler>(2){i -> Speler("speler ${i+1}", if (i==0) kruisId else cirkelId ) }
        val spel = Spel(spelers)

        spel.nieuweBeurt(spel.getMetaVlak(0).getVlak(2))
        Assert.assertTrue(spel.isBeschikbaar(spel.getMetaVlak(0).getVlak(3)))
        spel.nieuweBeurt(spel.getMetaVlak(0).getVlak(0))
        Assert.assertFalse(spel.isBeschikbaar(spel.getMetaVlak(0).getVlak(2)))
        Assert.assertTrue(spel.isBeschikbaar(spel.getMetaVlak(2).getVlak(2)))
        spel.nieuweBeurt(spel.getMetaVlak(2).getVlak(3))
        Assert.assertFalse(spel.isBeschikbaar(spel.getMetaVlak(3).getVlak(2)))
        Assert.assertFalse(spel.isBeschikbaar(spel.getMetaVlak(0).getVlak(0)))
        Assert.assertFalse(spel.isBeschikbaar(spel.getMetaVlak(0).getVlak(2)))
        Assert.assertTrue(spel.isBeschikbaar(spel.getMetaVlak(0).getVlak(3)))
    }
}