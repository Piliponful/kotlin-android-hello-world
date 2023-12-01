package com.example.todolist

import android.content.Context
import android.media.MediaPlayer

class Player {
    lateinit var player: MediaPlayer

    fun onCreate(applicationContext: Context) {
        if (player != null) {
            return
        }
        player = MediaPlayer.create(applicationContext, R.raw.videoplayback)
    }

    fun getPlayer () {

    }

    fun playMusic() {
        if (!player.isPlaying) {
            player.start()
        }
    }
}