package com.nimbuscloud.fit_a_roo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class selectWorkoutActivity extends AppCompatActivity
{
   public static ArrayList<Exercise> allExercises;
   public Workout currentWorkout;

   @Override protected void onCreate(Bundle savedInstanceState)
   {
      //typical creation
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_start_work_out);
      init();

      // creates recyclerview and adapter for arraylist of exercises
      RecyclerView recyclerView = findViewById(R.id.beginWorkoutBtn);
      CustomAdapter adapter = new CustomAdapter(this, allExercises);
      LinearLayoutManager layout = new LinearLayoutManager(this);
      recyclerView.setLayoutManager(new LinearLayoutManager(this));

      // adds divider for recyclerview list
      DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
            recyclerView.getContext(), layout.getOrientation());

      // adapter for converting allExercises ArrayList to a recyclerview list
      recyclerView.setAdapter(adapter);
      recyclerView.addItemDecoration(dividerItemDecoration);
      System.out.println(allExercises);

      // Handles onclick actions
      recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(this, recyclerView,
                  new RecyclerItemClickListener.OnItemClickListener()
                  {
                     @Override public void onItemClick(View view, int position)
                     {
                        Exercise selected = allExercises.get(position);
                        if (currentWorkout.contains(selected))
                        {
                           currentWorkout.remove(selected);
                           view.setBackgroundColor(0xffffffff);
                        }
                        else
                        {
                           currentWorkout.add(selected);
                           view.setBackgroundColor(0xffcccccc);
                        }
                     }

                     @Override
                     public void onLongItemClick(View view, int position)
                     {

                        Intent details = new Intent(getApplicationContext(),
                              DetailsActivity.class);
                        details.putExtra("exercises", allExercises);
                        details.putExtra("position", position);
                        startActivity(details);

                     }
                  }));

   }

   /**
    * Initializes all exercise data.
    */
   private void init()
   {
      currentWorkout = new Workout();
      allExercises = new ArrayList<Exercise>();
      Exercise pushUps = new Exercise("Push Ups", "Chest",
            "Stand facing the " + "counter-top. " + "Place hands wider" +
            " than " + "shoulder-width on" + " its " + "surface. Move the" +
            " feet back till " + "the arms are " + "perpendicular to" +
            " the body. Lower " + "chest by bending " + "the arms and push" +
            " the body " + "up until arms are" + " extended; repeat" + ".");
      Exercise sitUps = new Exercise("Sit Ups", "Abs",
            "\n" + "The Basic Sit Up for Beginners\n" +
            "1. Lie down on your back, with your feet on the floor, knees " +
            "bent" + ".\n" +
            "2. Place your hands on either side of your head in a comfortable" +
            " " + "position.\n" +
            "3. Bend your hips and waist to raise your body off the ground. ." +
            "." + ".\n" +
            "4. Lower your body back to the ground into the starting position" +
            ".\n" + "5. Repeat.");
      Exercise pullUps = new Exercise("Pull Ups",
            "Back, Lats, Chest and Shoulder Muscles",
            "1. Start with your hands on the bar approximately shoulder-width" +
            " apart with your palms facing forward. \n" + "\n" +
            "2. With arms extended above you, stick your chest out and " +
            "curve your back slightly. That is your starting position. \n" +
            "\n" +
            "3. Pull yourself up towards the bar using your back until the " +
            "bar is at chest level while breathing out. \n" + "\n" +
            "4. Slowly lower yourself to the starting position while " +
            "breathing in. That is one rep.");
      Exercise Lunges = new Exercise("Lunges",
            "legs, glutes",
            "With Legs something");
      Exercise JumpingJacks = new Exercise("Jumping Jacks",
            "legs, glutes",
            "Jump and spread arms");
      Exercise bicepCurls = new Exercise("Bicep curl",
            "arms",
            "find weights, curl them biceps");
      allExercises.add(pushUps);
      allExercises.add(sitUps);
      allExercises.add(pullUps);
      allExercises.add(Lunges);
      allExercises.add(JumpingJacks);
      allExercises.add(bicepCurls);


   }
   public void workingOut(View view) {
      if(currentWorkout.numberSelectedExercises() > 0)
      {
         Intent startWorkOut = new Intent(getApplicationContext(),
               WorkOutTimeActivity.class);
         startWorkOut.putExtra("currentWorkOut", currentWorkout);
         startActivity(startWorkOut);
      }
      else
      {
         Toast nope = Toast.makeText(getApplicationContext(), "Please select " +
                                                           "your " +
                                                 "exercises", Toast.LENGTH_LONG);
         nope.show();

      }
   }
}



