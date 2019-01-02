package com.kotlin.test

class Test {

    fun main(args: Array<String>) {

        var lambdaFunctionMe: (String) -> Unit = { s: String -> println(s) }

        lambdaFunctionMe("Kotlin Lambda Functions")

        //or
        lambdaFunctionMe = { println(it) }
        lambdaFunctionMe("1")

        val noArgFunction: () -> Unit = { println("Another function") }

        noArgFunction()

        functionReferencesExample("JournalDev.com", ::printFunction)

        var printFunctionG: (Int) -> Unit = { println(it) }
        functionReferencesExample("JournalDev.com", printFunctionG)

        printMe({ println("Lambda Inside a function") })
        var mm=Num()
        mm addNum 4

        normalFunction()

        val numbers = arrayListOf(15, -5, 11, -39)

        val nonNegativeNumbers = numbers.filter {
            it >= 0
        }

        fun(x: Int, y: Int): Int = x + y


        val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }

        val twoParameters: (String, Int) -> String = repeatFun // OK

        fun runTransformation(f: (String, Int) -> String): String {
            return f("hello", 3)
        }
        val result = runTransformation(repeatFun) // OK

        println("result = $result")

        val stringPlus: (String, String) -> String = String::plus
        val intPlus: Int.(Int) -> Int = Int::plus

        println(stringPlus.invoke("<-", "->"))
        println(stringPlus("Hello, ", "world!"))

        println(intPlus.invoke(1, 1))
        println(intPlus(1, 2))
        println(2.intPlus(3))
    }

    fun <T, R> Collection<T>.fold(initial: R, combine: (acc: R, nextElement: T) -> R): R {
        var accumulator: R = initial
        for (element: T in this) {
            accumulator = combine(accumulator, element)
        }
        return accumulator
    }

    fun functionReferencesExample(str: String, hhhhDDD: (Int) -> Unit) {
        print("Welcome To Kotlin Series @")
        hhhhDDD(1)
    }

    fun printFunction(str: Int) {
        println(str + 1)
    }

    fun printMe(string1: () -> Unit) {
        string1()
    }

    class Num {
        var x = 10
        infix fun addNum(num: Int) {
            this.x = this.x + num
        }
    }

    fun normalFunction() {
        println("This is normal function.")
        inlineFunctionExample({ println("Inlined Functions")},{ println("Instead of object creation it copies the code.")} )
    }

   inline  fun inlineFunctionExample(myFunction: () -> Unit, another: () -> Unit  ) {
        myFunction()
        another()
        print("Finally it's working fine!")
    }

}