package com.angelo.myapplication
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class VeldTest {
    var kruisId = R.drawable.kruis
    var cirkelId = R.drawable.cirkel

    @ParameterizedTest
    @CsvSource("0,1,2,true", "0,3,6,true","1,4,7,true","0,4,8,true","2,4,6,true","0,1,6,false")
    fun isGewonnenDoorSpeler(int1:Int,int2:Int,int3:Int, gewonnen: Boolean) {
        var speler1 = Speler("speler 1", kruisId)
        val metaVlak = MetaVlak()
        metaVlak.getVlak(int1).gekozenDoor = speler1;
        metaVlak.getVlak(int2).gekozenDoor = speler1;
        metaVlak.getVlak(int3).gekozenDoor = speler1;

        Assertions.assertEquals(gewonnen, metaVlak.isGewonnen())
    }

//    @Test
//    fun isGewonnenDoorSpeler2() {
//        var speler1 = Speler("speler 1", kruisId)
//        val metaVlak = MetaVlak()
//        metaVlak.getVlak(0).gekozenDoor = speler1;
//        metaVlak.getVlak(3).gekozenDoor = speler1;
//        metaVlak.getVlak(6).gekozenDoor = speler1;
//
//        Assert.assertTrue(metaVlak.isGewonnen())
//    }
//
//    @Test
//    fun isGewonnenDoorSpeler6() {
//        var speler1 = Speler("speler 1", kruisId)
//        var speler2 = Speler("speler 2", cirkelId)
//        val spelers = arrayOf(speler1, speler2)
//        val vlakken: Array<Vlak> = Array<Vlak>(3 * 3) { i -> Vlak() }
//        vlakken[1].gekozenDoor = speler1;
//        vlakken[4].gekozenDoor = speler1;
//        vlakken[7].gekozenDoor = speler1;
//        Assert.assertTrue(Veld.isGewonnenDoorSpeler(speler1, spelers, vlakken, 3))
//    }
//
//    @Test
//    fun isGewonnenDoorSpeler3() {
//        var speler1 = Speler("speler 1", kruisId)
//        var speler2 = Speler("speler 2", cirkelId)
//        val spelers = arrayOf(speler1, speler2)
//        val vlakken: Array<Vlak> = Array<Vlak>(3 * 3) { i -> Vlak() }
//        vlakken[0 + 0].gekozenDoor = speler1;
//        vlakken[3 + 1].gekozenDoor = speler1;
//        vlakken[6 + 2].gekozenDoor = speler1;
//        Assert.assertTrue(Veld.isGewonnenDoorSpeler(speler1, spelers, vlakken, 3))
//    }
//
//    @Test
//    fun isGewonnenDoorSpeler4() {
//        var speler1 = Speler("speler 1", kruisId)
//        var speler2 = Speler("speler 2", cirkelId)
//        val spelers = arrayOf(speler1, speler2)
//        val vlakken: Array<Vlak> = Array<Vlak>(3 * 3) { i -> Vlak() }
//        vlakken[0 + 2].gekozenDoor = speler1;
//        vlakken[3 + 1].gekozenDoor = speler1;
//        vlakken[6 + 0].gekozenDoor = speler1;
//        Assert.assertTrue(Veld.isGewonnenDoorSpeler(speler1, spelers, vlakken, 3))
//    }

//    @Test
//    fun isGewonnenDoorSpeler5() {
//        var speler1 = Speler("speler 1", kruisId)
//        var speler2 = Speler("speler 2", cirkelId)
//        val spelers = arrayOf(speler1, speler2)
//        val vlakken: Array<Vlak> = Array<Vlak>(3 * 3) { i -> Vlak() }
//        vlakken[0].gekozenDoor = speler1;
//        vlakken[1].gekozenDoor = speler1;
//        //vlakken[2].gekozenDoor = speler1;
//        Assert.assertFalse(Veld.isGewonnenDoorSpeler(speler1, spelers, vlakken, 3))
//    }
}