package command.ceiba.com.co.dojocommandpattern;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MessagingService extends FirebaseMessagingService {

    private String key;
    private NotificationInvoker invoker;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Map<String, String> notification = remoteMessage.getData();

        key = notification.get("key");

        invoker = new NotificationInvoker(this, notification);
        invoker.excute(key);
    }
}
