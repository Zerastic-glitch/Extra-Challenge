package com.angelo.myapplication

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class VectorTest {
    @Test
    fun optelTest(){
        assertEquals(Vector(0,0), Vector(0,0).telOp(Vector(0,0)))
        assertEquals(Vector(1,1), Vector(1,0).telOp(Vector(0,1)))
        assertEquals(Vector(2,1), Vector(2,0).telOp(Vector(0,1)))
    }
}