package org.tormozzg.sorts

import java.util.concurrent.TimeUnit

abstract class Sort {

    fun sort(input: IntArray): Pair<IntArray, Long> {
        val clone = intArrayOf(*input)
        val startTime: Long = System.nanoTime()
        val sorted = doSort(clone)
        val spentTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime)
        return sorted to spentTime
    }


    protected abstract fun doSort(array: IntArray): IntArray

}