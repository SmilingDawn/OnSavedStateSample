package com.smilingdawn.onsavedstatesample

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityPaused(acitivty: Activity) {
                Log.i("TAG", "Paused : ${acitivty.localClassName}")
            }

            override fun onActivityStarted(acitivty: Activity) {
                Log.i("TAG", "Started : ${acitivty.localClassName}")
            }

            override fun onActivityDestroyed(acitivty: Activity) {
                Log.i("TAG", "Destroyed : ${acitivty.localClassName}")
            }

            override fun onActivitySaveInstanceState(acitivty: Activity, bundle: Bundle) {
                Log.i("TAG", "SaveInstanceState : ${acitivty.localClassName}")
            }

            override fun onActivityStopped(acitivty: Activity) {
                Log.i("TAG", "Stopped : ${acitivty.localClassName}")
            }

            override fun onActivityCreated(acitivty: Activity, bundle: Bundle?) {
                Log.i("TAG", "Created : ${acitivty.localClassName}")
            }

            override fun onActivityResumed(acitivty: Activity) {
                Log.i("TAG", "Resumed : ${acitivty.localClassName}")
            }
        })
    }
}