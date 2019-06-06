package command.ceiba.com.co.dojocommandpattern;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import static android.content.Context.NOTIFICATION_SERVICE;

public class NotificationReceiver {

    private Context context;

    public NotificationReceiver(Context context){
        this.context = context;
    }

    public void buildNotification(String title, String body, Intent intent) {
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, intent, 0);
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(NOTIFICATION_SERVICE);

        Notification notification = new NotificationCompat.Builder(context, context.getString(R.string.default_notification_channel_id))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .build();
        notificationManager.notify(1, notification);
    }



}
