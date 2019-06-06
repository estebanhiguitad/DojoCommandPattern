package command.ceiba.com.co.dojocommandpattern;

import android.content.Context;

import java.util.Map;

public abstract class BaseActivityCommand {

    protected Context context;
    protected NotificationReceiver receiver;
    protected Map<String, String> notification;


    protected BaseActivityCommand(Context context, Map<String, String> notification){
        this.context = context;
        this.notification = notification;

        receiver = new NotificationReceiver(context);
    }
}
