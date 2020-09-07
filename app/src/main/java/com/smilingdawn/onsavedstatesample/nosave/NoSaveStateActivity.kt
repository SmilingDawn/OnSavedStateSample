package com.smilingdawn.onsavedstatesample.nosave

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.smilingdawn.onsavedstatesample.R
import com.smilingdawn.onsavedstatesample.databinding.ActivityCountBinding
import kotlinx.android.synthetic.main.activity_count.*

/**
 * Activity 상태를 저장하지 않는 샘플
 *
 */
class NoSaveStateActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityCountBinding>(
            this,
            R.layout.activity_count
        )
        // 카운트 증가 버튼
        btn_count.setOnClickListener {
            ++count
            Log.i("TAG", "Click => Count = $count")
            text_counter.text = count.toString()
        }
    }
}