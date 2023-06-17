package com.nimbuscloud.fit_a_roo;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import static com.nimbuscloud.fit_a_roo.selectWorkoutActivity.allExercises;

public class DetailsActivity extends AppCompatActivity
{

   @Override protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_details);
      int position = getIntent().getIntExtra("position", 0);
      TextView title = findViewById(R.id.txtExerciseName);
      TextView instruction = findViewById(R.id.txtHowToDo);
      String titleHow =
            "Learn how to do: " + allExercises.get(position).getExerciseName();
      title.setText(titleHow);
      instruction.setText(allExercises.get(position).getHowTo());
   }
}