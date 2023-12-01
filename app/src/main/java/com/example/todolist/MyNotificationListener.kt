package com.example.todolist

import android.media.MediaPlayer
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification

class MyNotificationListener : NotificationListenerService() {
    lateinit var player: MediaPlayer

    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer.create(applicationContext, R.raw.videoplayback)
        val button = findViewById<Button>(R.id.your_button_id)
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        if (sbn.packageName == "com.upwork.android.apps.main") {
            playMusic()
        }
    }

    private fun playMusic() {
        if (!player.isPlaying) {
            player.start()
        }
    }
}