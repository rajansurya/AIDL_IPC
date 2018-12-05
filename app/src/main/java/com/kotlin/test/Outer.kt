package com.kotlin.test

class Outer {
    companion object SIG{

    }
    object SingletonA {

    }
    private val bar: Int = 1

    inner class Nested {
        fun foo() = bar
    }

    fun main() {
        val b = BaseImpl(10)
        Derived(b).printT()
    }
}


interface Base {
    fun printT()
}

class BaseImpl(val x: Int) : Base {
    override fun printT() {
        printT()
    }
}

class Derived(b: Base) : Base by b

