package com.smilingdawn.onsavedstatesample.viewmodelsave

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.smilingdawn.onsavedstatesample.R
import com.smilingdawn.onsavedstatesample.databinding.ActivitySaveLiveCountBinding

class SaveStateViewModelActivity : AppCompatActivity() {
    // Use the Kotlin property extension in the fragment-ktx / activity-ktx artifacts
    private val viewModel: SaveStateCounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivitySaveLiveCountBinding>(this, R.layout.activity_save_live_count)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        Log.i("TAG", "ViewMode = ${viewModel.hashCode()}")
    }
}