package com.smilingdawn.onsavedstatesample.viewmodelsave

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SaveStateCounterViewModel(private val handle: SavedStateHandle) : ViewModel() {
    private var count = handle.get<Int>("count") ?: 0
        set(value) {
            handle.set("count", value)
            field = value
        }

    private val _countForm: MutableLiveData<Int> = MutableLiveData(count)
    val countState: LiveData<Int> = _countForm

    fun incCounter() {
        ++count
        Log.i("TAG", "Click => Count = $count")
        _countForm.value = count
    }
}