package com.irekasoft.onesignalpushtest;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.onesignal.OSNotification;
import com.onesignal.OSNotificationAction;
import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OneSignal;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hijazi on 16/6/16.
 */
public class MyApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    Log.i("MYAPP","onCreate");

    // SETUP ONE SIGNAL
    OneSignal.startInit(this)
      .setNotificationReceivedHandler(new NotificationReceivedHandler())
      .setNotificationOpenedHandler(new NotificationOpenedHandler())
      .init();

    OneSignal.setInFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification);

    OneSignal.idsAvailable(new OneSignal.IdsAvailableHandler() {
      @Override
      public void idsAvailable(String userId, String registrationId) {

        Log.d("debug registrationId", "User:" + userId);

        if (registrationId != null)
          Log.d("debug registrationId", "registrationId:" + registrationId);

      }
    });


  }

  class NotificationReceivedHandler implements OneSignal.NotificationReceivedHandler {
    @Override
    public void notificationReceived(OSNotification notification) {

      JSONObject data = notification.payload.additionalData;
      String customKey;

      Log.i("notificationReceived","data");

      if (data != null) {

        Log.i("notificationReceived", "data: " + data.toString());

      }
    }
  }

  class NotificationOpenedHandler implements OneSignal.NotificationOpenedHandler {

    @Override
    public void notificationOpened(OSNotificationOpenResult result) {

      OSNotificationAction.ActionType actionType = result.action.type;
      JSONObject data = result.notification.payload.additionalData;
      String customKey;

      Log.i("notificationOpened","data");

      if (data != null) {
        Log.i("notificationOpened", "data: " + data.toString());

        Toast.makeText(getApplicationContext(), "aa sd asd asdf", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(), PushContentViewActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);



        String notif_id = "9999";
        try {
          notif_id = "" + data.getJSONObject("body").getInt("notif_id");

        }catch (JSONException e){

        }

        intent.putExtra("NOTIF_ID", notif_id);
        startActivity(intent);

      }


    }

  }



}
