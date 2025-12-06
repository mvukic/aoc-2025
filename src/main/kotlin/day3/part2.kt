package com.mvukic.aoc.day3

import com.mvukic.aoc.linesForDay

fun main() {
    val lines = linesForDay(3)

    var sum = 0L
    for (line in lines) {
        val digits = line.map { it.digitToInt() }

        var currentLargest = 0

        for (firstIndex in 0..line.length - 2) {
            val firstDigit = digits[firstIndex]
            val secondDigit = digits.drop(firstIndex + 1).asSequence().max()
            val n = firstDigit * 10 + secondDigit
            if (n > currentLargest) {
                currentLargest = n
            }
        }
        println(currentLargest)
        sum += currentLargest
    }

    println(sum)
}