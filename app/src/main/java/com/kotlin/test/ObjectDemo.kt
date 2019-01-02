package com.kotlin.test

open class ObjectDemo(x: Int) {
   public open var demo: Int = x
}
interface TT{

}
private fun foo() = object {
    val x: String = "x"
}

// Public function, so the return type is Any
 fun publicFoo() = object {
    val x: String = "x"
}

fun bar() {
    val x1 = foo().x        // Works
  var  x2: Any  = publicFoo()

          // ERROR: Unresolved reference 'x'
}
interface Factory<T> {
    fun create(): T
}

class MyClass {
    companion object : Factory<MyClass> {
        override fun create():MyClass = MyClass()
    }
}
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}
public fun main(args: Array<String>) {
    val adHoc = object {
        var x: Int = 0
        var y: Int = 0
    }
    ProtocolState.TALKING.signal()
 //   val cc:Factory<MyClass> = MyClass()

    /*val combinedemo:A =object : A(1), TT{
        //override var demo=222
    }*/
    println(adHoc.x )
}