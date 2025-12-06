package com.mvukic.aoc.day5

import com.mvukic.aoc.linesForDay

fun main() {
    val lines = linesForDay(5)
    val ranges = lines.take(lines.indexOf(""))
        .map { it.split("-") }
        .map { it[0].toULong()..it[1].toULong() }
    val items = lines.drop(lines.indexOf("") + 1).map { it.toULong() }

    val fresh = mutableListOf<ULong>()
    for (item in items) {
        for (range in ranges) {
            if (item in range) {
                fresh.add(item)
                break
            }
        }
    }

    println(fresh.size)
}