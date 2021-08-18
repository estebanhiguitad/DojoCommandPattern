package command.ceiba.com.co.dojocommandpattern

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import command.ceiba.com.co.dojocommandpattern.MessagingService
import android.content.Intent
import command.ceiba.com.co.dojocommandpattern.FirstActivity
import command.ceiba.com.co.dojocommandpattern.SecondActivity
import android.app.PendingIntent
import android.app.NotificationManager
import androidx.core.app.NotificationCompat
import command.ceiba.com.co.dojocommandpattern.R

class MessagingService : FirebaseMessagingService() {
    private var key: String? = null
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        val notification = remoteMessage.data
        val title = notification["title"]
        val body = notification["body"]
        key = notification["key"]
        if (key != null) {
            when (key) {
                firstActivity -> {
                    val firstActivityIntent = Intent(this, FirstActivity::class.java)
                    buildNotification(title, body, firstActivityIntent)
                }
                secondActivity -> {
                    val secondActivityIntent = Intent(this, SecondActivity::class.java)
                    buildNotification(title, body, secondActivityIntent)
                }
            }
        }
    }

    private fun buildNotification(title: String?, body: String?, intent: Intent) {
        val pendingIntent = PendingIntent.getActivity(this, 1, intent, 0)
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val notification =
            NotificationCompat.Builder(this, getString(R.string.default_notification_channel_id))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setStyle(NotificationCompat.BigTextStyle().bigText(body))
                .build()
        notificationManager.notify(1, notification)
    }

    companion object {
        private const val firstActivity = "first.activity"
        private const val secondActivity = "second.activity"
    }
}