package com.angelo.myapplication
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class VlakTest {

    var cirkelId = R.drawable.cirkel
    @Test
    fun vlakGekozenDoor(){

        val vlak = Vlak(MetaVlak(),1)
        Assertions.assertNull(vlak.gekozenDoor)
        vlak.gekozenDoor=Speler("testSpeler", cirkelId)
        Assertions.assertTrue(vlak.gekozenDoor is Speler)

    }
}