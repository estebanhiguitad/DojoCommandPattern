package command.ceiba.com.co.dojocommandpattern

import android.content.Context
import android.content.Intent

class SecondActivityCommand(
    private val context: Context,
    private val notification: Map<String, String>,
    private val receiver: NotificationReceiver
    ) : ICommand {

    override fun execute() {
        val intent = Intent(context, SecondActivity::class.java)
        intent.putExtra("recordId", notification["record"])
        receiver.buildNotification(notification["title"], notification["body"], intent)
    }
}