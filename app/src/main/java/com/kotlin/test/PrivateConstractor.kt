package com.kotlin.test

import java.util.*

open class PrivateConstractor private constructor(){
    var list=ArrayList<Int>();
    val isEmpty: Boolean get() = list.size == 0
}
    class Customer(val customerName: String = "")

fun main(){
    val ssa=Customer("FFF")
}