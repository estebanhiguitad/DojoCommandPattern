package command.ceiba.com.co.dojocommandpattern

import android.annotation.SuppressLint
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

@SuppressLint("MissingFirebaseInstanceTokenRefresh")
class MessagingService : FirebaseMessagingService() {
    private var key: String? = null
    private var invoker: NotificationInvoker? = null
    private var receiver: NotificationReceiver = NotificationReceiver(this)

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        val notification = remoteMessage.data
        var command : ICommand? = null
        key = notification["key"]

        when (key) {
            firstActivity -> {
                command = FirstActivityCommand(this, notification, receiver)
            }
            secondActivity -> {
                command = SecondActivityCommand(this, notification, receiver)
            }
        }

        invoker = command?.let { NotificationInvoker(it) }
        invoker?.execute()
    }

    companion object {
        private const val firstActivity = "first.activity"
        private const val secondActivity = "second.activity"
    }
}