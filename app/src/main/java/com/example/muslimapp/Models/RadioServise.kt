package com.example.muslimapp.Models

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.muslimapp.R

class RadioService : Service() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            "START_RADIO" -> {
                val url = intent.getStringExtra("RADIO_URL")
                if (url != null) startRadio(url)
            }
            "STOP_RADIO" -> stopRadio()
        }
        return START_STICKY
    }

    private fun startRadio(url: String) {
        stopRadio()
        mediaPlayer = MediaPlayer().apply {
            setAudioStreamType(AudioManager.STREAM_MUSIC)
            setDataSource(url)
            prepareAsync()
            setOnPreparedListener { start() }
            setOnErrorListener { _, _, _ ->
                stopSelf()
                true
            }
        }
        showNotification()
    }

    private fun stopRadio() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        stopForeground(true)
    }

    private fun showNotification() {
        val notification = NotificationCompat.Builder(this, "RADIO_CHANNEL")
            .setContentTitle("Radio Playing")
            .setContentText("Streaming your favorite radio!")
            .setSmallIcon(R.drawable.radio_ic)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()

        startForeground(1, notification)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "RADIO_CHANNEL",
                "Radio Playback",
                NotificationManager.IMPORTANCE_LOW
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
