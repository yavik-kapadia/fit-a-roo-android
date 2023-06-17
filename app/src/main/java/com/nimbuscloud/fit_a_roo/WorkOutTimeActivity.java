package com.nimbuscloud.fit_a_roo;

import android.content.Intent;
import android.view.View;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class WorkOutTimeActivity extends AppCompatActivity
{

   @Override protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_work_out_time);
      Workout current =
            (Workout) getIntent().getSerializableExtra("currentWorkOut");



   }
}