package command.ceiba.com.co.dojocommandpattern;

import android.content.Context;
import android.content.Intent;

import java.util.Map;

public class FirstActivityCommand extends BaseActivityCommand implements ICommand {

    public FirstActivityCommand(Context context, Map<String, String> notification){
        super(context, notification);
    }

    @Override
    public void execute() {
        Intent intent = new Intent(context, FirstActivity.class);
        receiver.buildNotification(notification.get("title"), notification.get("body"), intent);
    }
}
