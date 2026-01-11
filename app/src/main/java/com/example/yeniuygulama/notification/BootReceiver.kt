package com.example.yeniuygulama.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BootReceiver : BroadcastReceiver() {
    
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            // Telefon yeniden başladığında bildirimi tekrar ayarla
            NotificationScheduler.scheduleDailyNotification(context)
        }
    }
}
