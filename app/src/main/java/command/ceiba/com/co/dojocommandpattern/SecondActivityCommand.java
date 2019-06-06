package command.ceiba.com.co.dojocommandpattern;

import android.content.Context;
import android.content.Intent;

import java.util.Map;

public class SecondActivityCommand extends BaseActivityCommand implements ICommand {

    public SecondActivityCommand(Context context, Map<String, String> notification){
        super(context, notification);
    }

    @Override
    public void execute() {
        Intent intent = new Intent(context, SecondActivity.class);
        receiver.buildNotification(notification.get("title"), notification.get("body"), intent);
    }
}
