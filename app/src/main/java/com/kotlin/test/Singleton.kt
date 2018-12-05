package com.kotlin.test

import java.sql.DriverManager.println

object Singleton {
    init {
//        print()
        println("")
    }
    var name = "Kotlin Objects"

    fun printName(): String {
        return ""
    }
   /* fun main(args: Array<String>) {
        Singleton.printName()
        Singleton.name = "KK"

    }*/
    fun main(aa: Array<String>){
       Singleton.printName()
       Singleton.name = "KK"
   }
}
