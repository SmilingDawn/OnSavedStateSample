package com.smilingdawn.onsavedstatesample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.smilingdawn.onsavedstatesample.databinding.ActivityMainBinding
import com.smilingdawn.onsavedstatesample.defaultsave.DefaultSaveStateActivity
import com.smilingdawn.onsavedstatesample.nosave.NoSaveStateActivity
import com.smilingdawn.onsavedstatesample.viewmodel.ViewModelActivity
import com.smilingdawn.onsavedstatesample.viewmodelsave.SaveStateViewModelActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.executePendingBindings()

        // No saved state sample
        btn_nosaved.setOnClickListener {
            startActivity(Intent(this, NoSaveStateActivity::class.java))
        }
        // Default saved state
        btn_default_saved.setOnClickListener {
            startActivity(Intent(this, DefaultSaveStateActivity::class.java))
        }
        // ViewModel saved state
        btn_live_data.setOnClickListener {
            startActivity(Intent(this, ViewModelActivity::class.java))
        }
        // SaveState + ViewModel
        btn_savestate_viewmodel.setOnClickListener {
            startActivity(Intent(this, SaveStateViewModelActivity::class.java))
        }
    }
}