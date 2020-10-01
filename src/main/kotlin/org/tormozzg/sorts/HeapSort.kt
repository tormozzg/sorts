package org.tormozzg.sorts

import kotlin.random.Random

class HeapSort : Sort() {
    override fun doSort(array: IntArray): IntArray {
        buildHeap(array)
        for (i in (array.lastIndex  downTo 1)) {
            swap(array, 0, i)
            heapify(array, 0, i)
        }
        return array
    }

    private fun buildHeap(array: IntArray) {
        val middle = array.size / 2 - 1
        for (i in (middle downTo 0))
            heapify(array, i, array.size)
    }

    private fun heapify(array: IntArray, i: Int, max: Int) {
        var largest = i
        val left = 2 * i + 1
        val right = 2 * i + 2
        if (left < max && array[left] > array[i]) largest = left
        if (right < max && array[right] > array[largest]) largest = right
        if (largest != i) {
            swap(array, i, largest)
            heapify(array, largest, max)
        }
    }

    private fun swap(array: IntArray, i: Int, largest: Int) {
        val tmp = array[i]
        array[i] = array[largest]
        array[largest] = tmp
    }

}

fun main(args: Array<String>) {
    val size = (if (args.isNotEmpty()) args[0].toIntOrNull() else null) ?: 10
    val array = IntArray(size) {
        Random.nextInt(0, 101)
    }

    println("Array: ${array.joinToString()}")
    val insertionSort = HeapSort()
    val (sorted, time) = insertionSort.sort(array)
    println("Sorted: ${sorted.joinToString()}")
    println("Time: $time")
}