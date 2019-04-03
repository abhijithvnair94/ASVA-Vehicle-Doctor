package com.example.edoctor_beta;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.TimePicker;
import android.widget.Toast;


import java.sql.Time;
import java.util.Calendar;

import static com.example.edoctor_beta.Applicationnotify.CHANNEL_1_ID;

public class Main4Activity extends AppCompatActivity {

   //
    TimePicker timePicker;
    public NotificationUtils mNotificationUtils;
    public NotificationManagerCompat notificationManager;
    private EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);



        notificationManager = NotificationManagerCompat.from(this);
        //notificationManager = NotificationManagerCompat.from(this);

        editText = (EditText) findViewById(R.id.textNotification);


        timePicker = (TimePicker) findViewById(R.id.timePicker);
        //mNotificationUtils = (NotificationUtils) findViewById(R.id.notify)
        //getting the timepicker object

        //attaching click listner on button
        findViewById(R.id.buttonSetAlarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //use a calender object -- to get time in milliseconds
                Calendar calender = Calendar.getInstance();
                calender.set(
                        calender.get(Calendar.YEAR),
                        calender.get(Calendar.MONTH),
                        calender.get(Calendar.DAY_OF_MONTH),
                        timePicker.getHour(),
                        timePicker.getMinute(),
                        0
                );

                //public void sendOnChannel1(View vv)
                String title = editText.getText().toString();
               /* Notification.Builder nb = mNotificationUtils.
                       getAndroidChannelNotification(title1);
                mNotificationUtils.getManager().notify(101, nb.build());*/
               Notification notification = new NotificationCompat.Builder(Main4Activity.this,CHANNEL_1_ID)
                       .setSmallIcon(R.drawable.ic_assignment)
                       .setContentTitle(title)
                       .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                       .build();


               /*notification = new NotificationCompat.Builder(Context, CHANNEL_1_ID)
                        .setSmallIcon(R.drawable.ic_assignment)
                        .setContent(title)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .build();*/

                notificationManager.notify(1,notification);


                setAlarm(calender.getTimeInMillis());


            }


        });

    }

    private void setAlarm(long timeInMillis) {
        //setting the alarm manager
        AlarmManager alamManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

        //craete a new intent specifying the broadcast receiver
        Intent intent = new Intent(this, MyAlarm.class);

        //creating a pending intent using the intent
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        alamManager.setRepeating(AlarmManager.RTC, timeInMillis, AlarmManager.INTERVAL_DAY, pendingIntent);
        //type of alarm(while sleep or normal), time unit, at what interval the alarm to ring

        Toast.makeText(this, "Alarm is set", Toast.LENGTH_SHORT).show();

    }

    public void notificationcall(){
        //NotificationManager myNotificationManager =
          //      (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationUtils = new NotificationUtils(this);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("Test notification")
                .setContentText("notification");


        // Creates the intent needed to show the notification
        Intent notificationIntent = new Intent(this, Main4Activity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //manager.notify(0, builder.build());
    }

}
