package com.angelo.myapplication

import org.junit.Assert
import org.junit.Test

class VeldTest {
    @Test
    fun isGewonnenDoorSpeler() {
        var speler1 = Speler("speler 1", "kruisje")
        var speler2 = Speler("speler 2", "rondje")
        val spelers = arrayOf(speler1, speler2)
        val vlakken: Array<Vlak> = Array<Vlak>(3 * 3) { i -> Vlak() }
        vlakken[0].gekozenDoor = speler1;
        vlakken[1].gekozenDoor = speler1;
        vlakken[2].gekozenDoor = speler1;
        Assert.assertTrue(Veld.isGewonnenDoorSpeler(speler1, spelers, vlakken, 3))
    }

    @Test
    fun isGewonnenDoorSpeler2() {
        var speler1 = Speler("speler 1", "kruisje")
        var speler2 = Speler("speler 2", "rondje")
        val spelers = arrayOf(speler1, speler2)
        val vlakken: Array<Vlak> = Array<Vlak>(3 * 3) { i -> Vlak() }
        vlakken[0].gekozenDoor = speler1;
        vlakken[3].gekozenDoor = speler1;
        vlakken[6].gekozenDoor = speler1;
        Assert.assertTrue(Veld.isGewonnenDoorSpeler(speler1, spelers, vlakken, 3))
    }

    @Test
    fun isGewonnenDoorSpeler6() {
        var speler1 = Speler("speler 1", "kruisje")
        var speler2 = Speler("speler 2", "rondje")
        val spelers = arrayOf(speler1, speler2)
        val vlakken: Array<Vlak> = Array<Vlak>(3 * 3) { i -> Vlak() }
        vlakken[1].gekozenDoor = speler1;
        vlakken[4].gekozenDoor = speler1;
        vlakken[7].gekozenDoor = speler1;
        Assert.assertTrue(Veld.isGewonnenDoorSpeler(speler1, spelers, vlakken, 3))
    }

    @Test
    fun isGewonnenDoorSpeler3() {
        var speler1 = Speler("speler 1", "kruisje")
        var speler2 = Speler("speler 2", "rondje")
        val spelers = arrayOf(speler1, speler2)
        val vlakken: Array<Vlak> = Array<Vlak>(3 * 3) { i -> Vlak() }
        vlakken[0 + 0].gekozenDoor = speler1;
        vlakken[3 + 1].gekozenDoor = speler1;
        vlakken[6 + 2].gekozenDoor = speler1;
        Assert.assertTrue(Veld.isGewonnenDoorSpeler(speler1, spelers, vlakken, 3))
    }

    @Test
    fun isGewonnenDoorSpeler4() {
        var speler1 = Speler("speler 1", "kruisje")
        var speler2 = Speler("speler 2", "rondje")
        val spelers = arrayOf(speler1, speler2)
        val vlakken: Array<Vlak> = Array<Vlak>(3 * 3) { i -> Vlak() }
        vlakken[0 + 2].gekozenDoor = speler1;
        vlakken[3 + 1].gekozenDoor = speler1;
        vlakken[6 + 0].gekozenDoor = speler1;
        Assert.assertTrue(Veld.isGewonnenDoorSpeler(speler1, spelers, vlakken, 3))
    }

    @Test
    fun isGewonnenDoorSpeler5() {
        var speler1 = Speler("speler 1", "kruisje")
        var speler2 = Speler("speler 2", "rondje")
        val spelers = arrayOf(speler1, speler2)
        val vlakken: Array<Vlak> = Array<Vlak>(3 * 3) { i -> Vlak() }
        vlakken[0].gekozenDoor = speler1;
        vlakken[1].gekozenDoor = speler1;
        //vlakken[2].gekozenDoor = speler1;
        Assert.assertFalse(Veld.isGewonnenDoorSpeler(speler1, spelers, vlakken, 3))
    }
}