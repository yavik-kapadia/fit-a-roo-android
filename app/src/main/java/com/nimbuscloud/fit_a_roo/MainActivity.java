package com.nimbuscloud.fit_a_roo;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
   }

   public void startApp(View view) {
      Intent workout = new Intent(getApplicationContext(),
              selectWorkoutActivity.class);
      startActivity(workout);
   }
}
