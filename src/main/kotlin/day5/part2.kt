package com.mvukic.aoc.day5

import com.mvukic.aoc.linesForDay

fun main() {
    val lines = linesForDay(5)
    // 1. Parse ranges and sort them by their starting point.
    val initialRanges = lines.take(lines.indexOf(""))
        .map { it.split("-") }
        .map { it[0].toULong()..it[1].toULong() }
        .sortedBy { it.first }

    // 2. Merge overlapping or adjacent ranges.
    val mergedRanges = mutableListOf<ULongRange>()
    var currentRange = initialRanges.first()

    for (i in 1 until initialRanges.size) {
        val nextRange = initialRanges[i]
        if (nextRange.first <= currentRange.last + 1u) {
            // Overlap or adjacent: extend the current range to include the next one.
            currentRange = currentRange.first..maxOf(currentRange.last, nextRange.last)
        } else {
            // No overlap: the current merged range is complete.
            mergedRanges.add(currentRange)
            currentRange = nextRange
        }
    }
    mergedRanges.add(currentRange) // Add the last processed range.

    // 3. Sum the lengths of the final merged ranges.
    val totalCount = mergedRanges.sumOf { it.last - it.first + 1u }
    println(totalCount)
}