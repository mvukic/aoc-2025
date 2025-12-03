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
        println("Invalid sum in range $invalid")
        println()
    }

    println("Total sum $s")
}

private fun isValid(value: String): Boolean {
    return true
}