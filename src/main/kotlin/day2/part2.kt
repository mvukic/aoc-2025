package com.mvukic.aoc.day2

import com.mvukic.aoc.linesForDay

fun main() {
    val lines = linesForDay(2)
    val ranges = lines
        .first()
        .split(",")
        .map { it.split("-") }
        .map { it[0] to it[1] }
        .map { it.first.toLong()..it.second.toLong() }

    var s = 0L
    for (range in ranges) {
        println("${range.first} - ${range.last}")
        val invalid = range.filter { v -> !isValid(v.toString()) }.sum()
        s += invalid
        println("Sum: $invalid")
        println()
    }

    println("Total sum $s")
}

private fun isValid(input: String): Boolean {
    var isValid = true
    for (len in 1 until input.length) {
        val sequences = input
            .windowedSequence(len)
            .map { it to countOccurrencesRegex(input, it) }
            .filter { it.second > 1 }
            .toMap()
        if (sequences.isEmpty()) isValid = true
        if (sequences.any { it.value > 1 }) isValid = false
    }
    if (!isValid) println("Invalid: $input")
    return isValid
}

fun countOccurrencesRegex(text: String, sequence: String): Int {
    if (sequence.isEmpty()) return 0
    val regex = "(?=${Regex.escape(sequence)})".toRegex()
    return regex.findAll(text).count()
}