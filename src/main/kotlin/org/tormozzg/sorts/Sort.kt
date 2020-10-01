package org.tormozzg.sorts

abstract class Sort {

    fun sort(input: IntArray): Pair<IntArray, Long> {
        val clone = intArrayOf(*input)
        val startTime: Long = System.nanoTime()
        val sorted = doSort(clone)
        val spentTime = System.nanoTime() - startTime
        return sorted to spentTime
    }


    protected abstract fun doSort(input: IntArray): IntArray

}