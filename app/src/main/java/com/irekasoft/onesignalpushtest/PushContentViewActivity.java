package com.irekasoft.onesignalpushtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class PushContentViewActivity extends AppCompatActivity {

  TextView textView;

  @Override
  public void onStart() {
    super.onStart();
    EventBus.getDefault().register(this);
  }

  @Override
  public void onStop() {
    super.onStop();
    EventBus.getDefault().unregister(this);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    setContentView(R.layout.activity_push_content_view);

    setTitle("Secondary Page");

    textView = (TextView)findViewById(R.id.textView);

    String article_id = getIntent().getStringExtra("NOTIF_ID");
    Log.i("onCreate", article_id);

    textView.setText(article_id);

  }

  @Subscribe
  public void onMessageEvent(MessageEvent event) {

    textView.setText("GET new notif");

  }

  @Override
  protected void onNewIntent(Intent intent) {
    String article_id;

    Log.i("onNewIntent", "onNewIntent");

    if (intent != null) {
      article_id= intent.getExtras().getString("NOTIF_ID");
      Log.i("intent", article_id);
      textView.setText(article_id);
    }

  }

}
