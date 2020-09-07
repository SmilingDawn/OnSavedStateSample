package com.smilingdawn.onsavedstatesample.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private var count = 0

    private val _countForm: MutableLiveData<Int> = MutableLiveData(count)
    val countState: LiveData<Int> = _countForm

    fun incCounter() {
        ++count
        Log.i("TAG", "Click => Count = $count")
        _countForm.value = count
    }
}