package com.example.ashish.notificationdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
NotificationCompat.Builder notification;
private static final int uniqueID=0712;     //could be any number as id
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notification=new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
    }
    public void notificationClicked(View view){
        //Build for the notification
        notification.setSmallIcon(R.drawable.ic_launcher_background);           //set icon for notification
        notification.setTicker("This is the ticker");                           //set ticker for notification
        notification.setWhen(System.currentTimeMillis());                       //set when we get notification
        notification.setContentTitle("Notification Demo");                      //set title for notification normally its app
        notification.setContentText("This is the body text of notification");   //set text for the notification

        Intent intent=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);//with this whenever we click on notificatio
        notification.setContentIntent(pendingIntent);                                                                              // we go to our notification app

        //Build notification and issue it
        NotificationManager n=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        n.notify(uniqueID,notification.build());        //notification.build function combine all icon,ticker,when,title and text
    }
}
