package com.developnic.jjmichael.choose.Notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.developnic.jjmichael.choose.MainActivity;
import com.developnic.jjmichael.choose.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by jjmic on 26/11/2017.
 */

public class firebaseMjsServer extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String from = remoteMessage.getFrom();
        Log.d("MJS" , "MENSAJE RECIBIDO DE : " + from);

        if (remoteMessage.getNotification() != null)
        {
            Log.d("MJS ", "Notificacion " + remoteMessage.getNotification().getBody());
            mostrarNotification(remoteMessage.getNotification().getTitle() , remoteMessage.getNotification().getBody());
        }

        if(remoteMessage.getData().size() > 0)
        {
            Log.d("MJS ", "DATA " + remoteMessage.getData());
        }

    }

    private void mostrarNotification(String title, String body) {

        Uri sonUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Intent intent = new Intent(this , MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0 , intent,PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder notificationBuiler = new NotificationCompat.Builder(this)
                .setBadgeIconType(R.drawable.ic_notifications_ch)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(sonUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuiler.build());

    }
}
