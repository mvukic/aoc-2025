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
                (current - amount).mod(size)
            }

            'R' -> {
                (current + amount).mod(size)
            }

            else -> error("Invalid Direction $direction")
        }

        println("To: $current")

        if (current == 0) zero++
        println()
    }

    println("Zeroes: $zero")

}