package com.angelo.myapplication

data class Vector(val x: Int, val y: Int) {
    fun add(vector: Vector): Vector {
        return Vector(this.x + vector.x, this.y + vector.y);
    }
}