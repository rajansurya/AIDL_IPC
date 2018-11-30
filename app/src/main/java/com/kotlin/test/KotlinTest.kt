package com.kotlin.test

import android.util.Log.println

class KotlinTest public constructor (var  data: String, val d: String) {
    constructor(ss: String) : this(ss, "f") {

    }
    init {
//        println("First initializer block that prints ${data}")
//        println("Second initializer block that prints ${data.length}")
    }
}