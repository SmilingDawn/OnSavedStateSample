package com.smilingdawn.onsavedstatesample.defaultsave

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.smilingdawn.onsavedstatesample.R
import com.smilingdawn.onsavedstatesample.databinding.ActivityCountBinding
import kotlinx.android.synthetic.main.activity_count.*
/**
 * savedInstanceState를 이용한 Activity 상태 저저장하는 샘플
 * 하지만 Bundle이 Bitmap이나 대용량 데이터에 적합하지 않는 문제가 있다.
 */
class DefaultSaveStateActivity : AppCompatActivity() {
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityCountBinding>(
            this,
            R.layout.activity_count
        )
        // 데이터 복구
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count")
            Log.i("TAG", "Restore Count = $count")
            text_counter.text = count.toString()
        }

        // 카운트 증가 버튼
        btn_count.setOnClickListener {
            ++count
            Log.i("TAG", "Click => Count = $count")
            text_counter.text = count.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // 데이터 저장
        outState.putInt("count", count)
        Log.i("TAG", "Save Count = $count")
        super.onSaveInstanceState(outState)
    }
}