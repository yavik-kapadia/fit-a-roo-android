package com.nimbuscloud.fit_a_roo;

import java.io.Serializable;
import java.util.ArrayList;


public class Workout implements Serializable
{
   private ArrayList<Exercise> selectedExercises;

   public Workout() {
      this.selectedExercises = new ArrayList<>();

   }

   public void add(Exercise exercise) {
      if(exercise != null)
         selectedExercises.add(exercise);
   }
   public void remove(Exercise exercise)
   {
      selectedExercises.remove(exercise);
   }

   public void setSelectedExercises(ArrayList<Exercise> selectedExercises) {
      this.selectedExercises = selectedExercises;
   }
   public boolean contains(Exercise exercise)
   {
      return selectedExercises.contains(exercise);
   }
   public int numberSelectedExercises()
   {
      return selectedExercises.size();
   }

   @Override public String toString()
   {
      StringBuilder selected = new StringBuilder();
      for (int i = 0;
            i < selectedExercises.size();
            i++)
      {
         if(i == selectedExercises.size() - 1)
         {
            selected.append(selectedExercises.get(i));
         }
         else
         {
            selected.append(selectedExercises.get(i))
                  .append(", ");
         }
      }
      return selected.toString();
   }
}
