package com.angelo.myapplication
import org.junit.Assert
import org.junit.Test

class VlakTest {
    @Test
    fun vlakGekozenDoor(){

        val vlak = Vlak()
        Assert.assertNull(vlak.gekozenDoor)
        vlak.gekozenDoor=Speler()
        Assert.assertTrue(vlak.gekozenDoor is Speler)

    }
}