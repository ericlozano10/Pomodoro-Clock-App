package com.example.pomodoroclock

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build


class App:Application() {
    val CHANNEL_ID = "ALARM_SERVICE_CHANNEL"

    override fun onCreate() {
        super.onCreate()
        createNotificationChannnel()
    }

    private fun createNotificationChannnel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Alarm Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(
                NotificationManager::class.java
            )
            manager.createNotificationChannel(serviceChannel)
        }
    }
}