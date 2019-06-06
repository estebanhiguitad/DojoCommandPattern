package command.ceiba.com.co.dojocommandpattern;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

public class NotificationInvoker {

    private Map<String, ICommand> commands;

    private final String firstActivity = "first.activity";
    private final String secondActivity = "second.activity";

    public NotificationInvoker(Context context, Map<String, String> notification){

        commands = new HashMap<>();

        commands.put(firstActivity, new FirstActivityCommand(context, notification));
        commands.put(secondActivity, new SecondActivityCommand(context, notification));
    }

    public void excute(String key){
        if (key != null){
            commands.get(key).execute();
        }
    }
}
