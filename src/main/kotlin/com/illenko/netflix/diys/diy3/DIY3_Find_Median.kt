package com.illenko.netflix.diys.diy3 // ktlint-disable filename

import java.util.*

internal class MedianOfAStream {

    private var maxHeap: PriorityQueue<Int> = PriorityQueue { a: Int, b: Int -> b - a }
    private var minHeap: PriorityQueue<Int> = PriorityQueue { a: Int, b: Int -> a - b }

    fun insertNum(num: Int): Boolean {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) maxHeap.add(num) else minHeap.add(num)
        if (maxHeap.size > minHeap.size + 1) minHeap.add(maxHeap.poll())
        else if (maxHeap.size < minHeap.size) maxHeap.add(minHeap.poll())
        return true
    }

    fun findMedian(): Double {
        return if (maxHeap.size == minHeap.size) {
            maxHeap.peek() / 2.0 + minHeap.peek() / 2.0
        } else maxHeap.peek().toDouble()
    }
}

fun main() {
    val medianOfAStream = MedianOfAStream()
    medianOfAStream.insertNum(1)
    medianOfAStream.insertNum(3)
    medianOfAStream.insertNum(-1)
    println(medianOfAStream.findMedian())
    medianOfAStream.insertNum(2)
    println(medianOfAStream.findMedian())
}
