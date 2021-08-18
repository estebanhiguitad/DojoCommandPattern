package command.ceiba.com.co.dojocommandpattern

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class NotificationReceiver(private val context: Context) {
    fun buildNotification(title: String?, body: String?, intent: Intent?) {
        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 1, intent, 0)
        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification: Notification =
            NotificationCompat.Builder(context, context.getString(R.string.default_notification_channel_id))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setStyle(NotificationCompat.BigTextStyle().bigText(body))
                .build()
        notificationManager.notify(1, notification)
    }
}