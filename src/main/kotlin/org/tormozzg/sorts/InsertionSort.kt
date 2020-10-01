package org.tormozzg.sorts

import kotlin.random.Random

class InsertionSort : Sort() {

    override fun doSort(input: IntArray): IntArray {
        for (i in (1 until input.size))
            insert(input, i, input[i])
        return input
    }

    private fun insert(array: IntArray, pos: Int, value: Int) {
        var i = pos - 1
        while (i >= 0 && array[i] > value) {
            array[i + 1] = array[i]
            i -= 1
        }
        array[i + 1] = value
    }
}

fun main(args: Array<String>) {
    val size = (if (args.isNotEmpty()) args[0].toIntOrNull() else null) ?: 10
    val array = IntArray(size) {
        Random.nextInt(0, 101)
    }

    val insertionSort = InsertionSort()
    val (sorted, time) = insertionSort.sort(array)
    println("Time: $time")
    println("Sorted: ${sorted.joinToString()}")
}