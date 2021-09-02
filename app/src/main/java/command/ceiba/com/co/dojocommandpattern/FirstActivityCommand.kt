package command.ceiba.com.co.dojocommandpattern

import android.content.Context
import android.content.Intent

class FirstActivityCommand(
    private val context: Context,
    private val notification: Map<String, String>,
    private val receiver: NotificationReceiver
    ) : ICommand {

    override fun execute() {
        val intent = Intent(context, FirstActivity::class.java)
        receiver.buildNotification(notification["title"], notification["body"], intent)
    }
}