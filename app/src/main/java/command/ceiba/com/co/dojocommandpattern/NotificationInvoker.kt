package command.ceiba.com.co.dojocommandpattern

import android.content.Context
import java.util.*

class NotificationInvoker(context: Context, notification: Map<String, String>) {
    private val commands: MutableMap<String, ICommand>
    private val firstActivity = "first.activity"
    private val secondActivity = "second.activity"
    fun excute(key: String?) {
        if (key != null) {
            commands[key]!!.execute()
        }
    }

    init {
        commands = HashMap()
        commands[firstActivity] = FirstActivityCommand(context, notification)
        commands[secondActivity] = SecondActivityCommand(context, notification)
    }
}