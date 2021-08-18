package command.ceiba.com.co.dojocommandpattern

import android.content.Context
import android.content.Intent

class SecondActivityCommand(context: Context, notification: Map<String, String>) :
    BaseActivityCommand(context, notification), ICommand {
    override fun execute() {
        val intent = Intent(context, SecondActivity::class.java)
        receiver.buildNotification(notification["title"], notification["body"], intent)
    }
}