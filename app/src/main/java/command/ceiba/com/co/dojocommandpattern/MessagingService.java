package command.ceiba.com.co.dojocommandpattern;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MessagingService extends FirebaseMessagingService {

    private static final String firstActivity = "first.activity";
    private static final String secondActivity = "second.activity";

    private String key;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Map<String, String> notification = remoteMessage.getData();

        String title = notification.get("title");
        String body = notification.get("body");

        key = notification.get("key");
        if(key != null) {
            switch (key){
                case firstActivity:
                    Intent firstActivityIntent = new Intent(this, FirstActivity.class);
                    buildNotification(title, body, firstActivityIntent);
                    break;
                case secondActivity:
                    Intent secondActivityIntent = new Intent(this, SecondActivity.class);
                    buildNotification(title, body, secondActivityIntent);
            }
        }


    }

    private void buildNotification(String title, String body, Intent intent) {
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, intent, 0);
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        Notification notification = new NotificationCompat.Builder(this, getString(R.string.default_notification_channel_id))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .build();
        notificationManager.notify(1, notification);
    }
}
