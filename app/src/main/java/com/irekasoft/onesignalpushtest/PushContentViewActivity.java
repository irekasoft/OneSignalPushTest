package com.irekasoft.onesignalpushtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class PushContentViewActivity extends AppCompatActivity {

  TextView textView;

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
