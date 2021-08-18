package command.ceiba.com.co.dojocommandpattern

import android.annotation.SuppressLint
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

@SuppressLint("MissingFirebaseInstanceTokenRefresh")
class MessagingService : FirebaseMessagingService() {
    private var key: String? = null
    private var invoker: NotificationInvoker? = null
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        val notification = remoteMessage.data
        key = notification["key"]
        invoker = NotificationInvoker(this, notification)
        invoker!!.excute(key)
    }
}