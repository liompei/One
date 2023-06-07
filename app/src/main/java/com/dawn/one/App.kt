package com.dawn.one

import android.app.ActivityManager
import android.app.Application
import android.content.Context

class App : Application() {

    companion object {

        private lateinit var app: App

        fun getIns(): App {
            return app
        }
    }

    override fun onCreate() {
        super.onCreate()
        if (isMainProcess()){
            app=this
        }

    }

    private fun isMainProcess(): Boolean {
        val am = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val runningApps = am.runningAppProcesses
        val pid = android.os.Process.myPid()
        for (processInfo in runningApps) {
            if (processInfo.pid == pid) {
                return processInfo.processName == packageName
            }
        }
        return false
    }

}