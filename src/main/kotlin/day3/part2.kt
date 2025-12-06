package com.mvukic.aoc.day3

import com.mvukic.aoc.linesForDay
import kotlin.math.pow

fun main() {
    val lines = linesForDay(3)

    var sum = 0.toULong()
    for (line in lines) {
        val digits = line.map { it.digitToInt() }

        var currentLargest = 0.toULong()

        for (index1 in 0..line.length - 12) {
            val index2 = getIndexOfLargestIn(digits, index1)
            val index3 = getIndexOfLargestIn(digits, index2)
            val index4 = getIndexOfLargestIn(digits, index3)
            val index5 = getIndexOfLargestIn(digits, index4)
            val index6 = getIndexOfLargestIn(digits, index5)
            val index7 = getIndexOfLargestIn(digits, index6)
            val index8 = getIndexOfLargestIn(digits, index7)
            val index9 = getIndexOfLargestIn(digits, index8)
            val index10 = getIndexOfLargestIn(digits, index9)
            val index11 = getIndexOfLargestIn(digits, index10)
            val index12 = getIndexOfLargestIn(digits, index11)
            val indexes = listOf(
                index1,
                index2,
                index3,
                index4,
                index5,
                index6,
                index7,
                index8,
                index9,
                index10,
                index11,
                index12
            )
            val n = digitsToNumber(digits, indexes)
            if (n > currentLargest) {
                currentLargest = n
            }
        }
        println(currentLargest)
        sum += currentLargest
    }

    println(sum)
}

private fun getIndexOfLargestIn(digits: List<Int>, prevIndex: Int): Int {
    return digits
        .drop(prevIndex + 1)
        .indexOf(digits.asSequence().drop(prevIndex + 1).max())
}

private fun digitsToNumber(digits: List<Int>, indexes: List<Int>): ULong {
    return indexes
        .map { digits[it] }
        .asReversed()
        .asSequence()
        .mapIndexed { index, value -> value * 10.toDouble().pow(index.toDouble()) }
        .sum()
        .toULong()
}