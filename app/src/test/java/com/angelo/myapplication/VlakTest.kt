package com.angelo.myapplication
import org.junit.Assert
import org.junit.Test

class VlakTest {

    var cirkelId = R.drawable.cirkel
    @Test
    fun vlakGekozenDoor(){

        val vlak = Vlak()
        Assert.assertNull(vlak.gekozenDoor)
        vlak.gekozenDoor=Speler("testSpeler", cirkelId)
        Assert.assertTrue(vlak.gekozenDoor is Speler)

    }
}