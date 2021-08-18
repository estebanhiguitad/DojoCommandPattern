package command.ceiba.com.co.dojocommandpattern

import android.content.Context

abstract class BaseActivityCommand protected constructor(
    protected var context: Context,
    protected var notification: Map<String, String>
) {
    protected var receiver: NotificationReceiver

    init {
        receiver = NotificationReceiver(context)
    }
}