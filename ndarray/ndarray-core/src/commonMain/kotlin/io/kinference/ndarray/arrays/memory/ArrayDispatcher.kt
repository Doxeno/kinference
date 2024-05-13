package io.kinference.ndarray.arrays.memory

import io.kinference.ndarray.arrays.ArrayTypes
import io.kinference.utils.PlatformQueue

internal object ArrayDispatcher {
    private const val INIT_SIZE_VALUE: Int = 2
    private val typeSize: Int = ArrayTypes.entries.size

    private val unusedArrays: PlatformQueue<ArrayStorage> = PlatformQueue()

    fun getStorage(): ArrayStorage {
        return unusedArrays.removeFirstOrNull() ?: ArrayStorage(typeSize, INIT_SIZE_VALUE)
    }

    fun returnStorage(storage: ArrayStorage) {
        unusedArrays.addLast(storage)
    }
}
