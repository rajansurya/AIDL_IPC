package com.kotlin.test

class A {

    companion object SingletonB {

        init {
//            println("SingletonB class invoked.")
//            println()
        }

    }

    object SingletonA {

        init {
//            println("SingletonA class invoked.")
        }
    }

    init {
//        println("Class init method.")
    }
}