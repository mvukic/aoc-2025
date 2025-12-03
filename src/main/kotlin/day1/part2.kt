package com.mvukic.aoc.day1

import com.mvukic.aoc.linesForDay

fun main() {
    val lines = linesForDay(1)

    val size = 100
    var current = 50
    var zero = 0


    for (line in lines) {
        val direction = line.first()
        val amount = line.drop(1).toInt()

        println("From: $current")
        println("Direction: $direction, Amount: $amount")


        current = when (direction) {
            'L' -> {
                val result = loopLeft(current, amount)
                zero += result.second
                result.first
            }

            'R' -> {
                val result = loopRight(current, amount)
                zero += result.second
                result.first
            }

            else -> error("Invalid Direction $direction")
        }

        println("To: $current")
        println()
    }

    println("Zeroes: $zero")
}

fun loopLeft(current: Int, amount: Int): Pair<Int, Int> {
    var zero = 0
    var newCurrent = current
    repeat(amount) {
        newCurrent -= 1
        if (newCurrent < 0) newCurrent = 99
        if (newCurrent == 0) zero++
    }
    return newCurrent to zero
}

fun loopRight(current: Int, amount: Int): Pair<Int, Int> {
    var zero = 0
    var newCurrent = current
    repeat(amount) {
        newCurrent += 1
        if (newCurrent > 99) newCurrent = 0
        if (newCurrent == 0) zero++
    }
    return newCurrent to zero
}