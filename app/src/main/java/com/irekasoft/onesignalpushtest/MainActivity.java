package com.irekasoft.onesignalpushtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);
    setTitle("Main App");

  }

  public void onButtonClick(View view){

    Log.i("hello","hello");

    Intent intent = new Intent(getApplicationContext(), PushContentViewActivity.class);
    intent.putExtra("NOTIF_ID", "0");
    startActivity(intent);

  }

  public void onButtonClick2(View view){

//    android.support.v4.app.NotificationCompat.Builder mBuilder =
//      new NotificationCompat.Builder(this)
//        .setSmallIcon(R.drawable.ic_os_notification_fallback_white_24dp)
//        .setContentTitle("My notification")
//        .setContentText("Hello World!");

    // TODO: where is the error on the right


//    NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
//    builder.setSmallIcon(R.drawable.ic_wald_poi)
//      .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_poi))
//      .setColor(getResources().getColor(R.color.primary))
//      .setContentTitle(getString(R.string.hello))
//      .setContentIntent(notificationPendingIntent)
//      .setContentText(String.format(getString(R.string.notification), viewObject.getTitle()))
//      .setDefaults(Notification.DEFAULT_ALL)
//      .setStyle(bigText)
//      .setPriority(Notification.PRIORITY_HIGH);

  }

}
