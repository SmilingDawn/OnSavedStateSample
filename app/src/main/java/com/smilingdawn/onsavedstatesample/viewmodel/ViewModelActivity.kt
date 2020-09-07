package com.smilingdawn.onsavedstatesample.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.smilingdawn.onsavedstatesample.R
import com.smilingdawn.onsavedstatesample.databinding.ActivityLiveCountBinding
/**
 * ViewModel을 이용한 Activity 상태를 저장하는 방법.
 * ViewModel도 메모리 내에 위치하므로 메모리 부족과 같은 일이 발생 될 경우
 * 시스템에서 Background된 앱을 강제 종료할 수도 있다.
 *
 *  console) adb shell am kill [package name]
 *  ex) adb shell am kill com.smilingdawn.onsavedstatesample
 */
class ViewModelActivity : AppCompatActivity() {
    private val viewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityLiveCountBinding>(this,
            R.layout.activity_live_count
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        Log.i("TAG", "ViewMode = ${viewModel.hashCode()}")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        /**
         * Bundle은 Bitmap이나 대량의 데이터에는 적합하지 않으며 직렬화가 가능한 작은 데이터에 적합하다.
         */
        super.onSaveInstanceState(outState)
    }
}