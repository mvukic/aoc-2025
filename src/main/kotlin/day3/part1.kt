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


// First digit:
// 2[34234234234278] -> index=0 digit=2
// Second digit
// 2[34234234234278] -> max = 8
// currentLargest=28

// First digit:
// 23[4234234234278] -> index=1 digit=3
// Second digit
// 23[4234234234278] -> max = 8
// currentLargest=38

// First digit:
// 234[234234234278] -> index=2 digit=4
// Second digit
// 234[234234234278] -> max = 8
// currentLargest=48

// First digit:
// 2342[34234234278] -> index=3 digit=2
// Second digit
// 2342[34234234278] -> max = 8
// currentLargest=48