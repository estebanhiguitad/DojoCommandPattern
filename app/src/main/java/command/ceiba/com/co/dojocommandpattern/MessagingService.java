package command.ceiba.com.co.dojocommandpattern;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MessagingService extends FirebaseMessagingService {

    private static String TAG = "MessagingService";
    public MessagingService(){

    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.i(TAG, "mensaje de notificación " + remoteMessage);
        Log.i(TAG, "mensaje de notificación " + remoteMessage.getData());
        Log.i(TAG, "mensaje de notificación body " + remoteMessage.getNotification().getBody());
        Log.i(TAG, "mensaje de notificación key " + remoteMessage.getData().get("key"));
    }
}
