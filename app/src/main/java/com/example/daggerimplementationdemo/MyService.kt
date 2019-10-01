package com.example.daggerimplementationdemo

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat

class MyService: Service() {
    var NOTIFICATION_CHANNEL_ID = "com.example.simpleapp";
    var channelName = "My Background Service";
    override fun onCreate() {
        super.onCreate()

        var chan =  NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName, NotificationManager.IMPORTANCE_NONE);
        chan.setLightColor(Color.BLUE);
        chan.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
      //  var manager  = getSystemService(Context.NOTIFICATION_SERVICE)
       // if( manager != null)
       // manager as NotificationManager.createNotificationChannel(chan);
//        val notificationManager =
//            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//
//        notificationManager .createNotificationChannel(chan)
//        var notificationBuilder =  NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
//        var notification = notificationBuilder.setOngoing(true)
//            .setSmallIcon(R.drawable.ic_launcher_background)
//            .setContentTitle("App is running in background")
//            .setPriority(NotificationManager.IMPORTANCE_MIN)
//            .setCategory(Notification.CATEGORY_SERVICE)
//            .build();
//        startForeground(2, notification)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)

        Log.d("My Service","Start service")
    }
    override fun onBind(intent: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}