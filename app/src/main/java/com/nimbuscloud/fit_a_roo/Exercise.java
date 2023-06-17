package com.nimbuscloud.fit_a_roo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class to hold data related to exercise
 */
public class Exercise implements Serializable,
      Cloneable
{
   private String exerciseName;
   private String bodyPart;
   private String howTo;
   private ArrayList<Integer> repsArray;
   private int sets;
   private int selectedSet;

   /**
    * default constructor
    *
    * @param exerciseName name of this exercise
    * @param bodyPart body party this exercise focuses
    * @param howTo how to perform this exercise
    */
   public Exercise(String exerciseName, String bodyPart, String howTo)
   {
      this.exerciseName = exerciseName;
      this.bodyPart = bodyPart;
      this.howTo = howTo;
      repsArray = new ArrayList<Integer>();
      sets = 0;
      selectedSet = 0;

   }
      public Exercise(Exercise exercise)
   {
      this.exerciseName =  exercise.getExerciseName();
      this.bodyPart = exercise.getBodyPart();
      this.howTo = exercise.getHowTo();
      repsArray = new ArrayList<Integer>();
      sets = 0;
      selectedSet = 0;
   }

   /**
    * Returns an integer a
    *
    * @return
    */
   public ArrayList<Integer> getReps()
   {
      return repsArray;
   }

   /**
    * gets number of reps done for a particular set
    *
    * @param set to check
    * @return number of reps
    */
   public int getRep(int set)
   {
      if (!(set < 0))
      {
         return repsArray.get(set);
      }
      return 0;
   }

   /**
    * adds number of reps done a set
    *
    * @param reps number of times exercise is repeated
    */
   public void addReps(int reps)
   {
      if (!(reps <= 0))
         this.repsArray.add(reps);
      sets++;
   }

   /**
    * gets number of sets performed for this exercise
    *
    * @return
    */
   public int getSets()
   {
      return sets;
   }

   /**
    * @param sets
    */
   public void setSets(int sets)
   {
      if (sets > 0)
         this.sets = sets;
   }

   /**
    * Gets name of exercise
    *
    * @return name of exercise
    */
   public String getExerciseName()
   {
      return exerciseName;
   }

   /**
    * Sets name of exercise, used for changing names
    *
    * @param exerciseName name of exervise
    */
   public void setExerciseName(String exerciseName)
   {
      if (!exerciseName.equals(""))
      {
         this.exerciseName = exerciseName;
      }
   }

   /**
    * gets bodypart that this exercise focuses on
    *
    * @return body part this exercise focuses on
    */
   public String getBodyPart()
   {
      return bodyPart;
   }

   /**
    * Sets bodyPart this exercises focuses on
    *
    * @param bodyPart body party
    */
   public void setBodyPart(String bodyPart)
   {
      this.bodyPart = bodyPart;
   }

   /**
    * @return instructions on how to do this exercise
    */
   public String getHowTo()
   {
      return howTo;
   }

   /**
    * sets how to do this exercise r
    *
    * @param howTo description on how
    */
   public void setHowTo(String howTo)
   {
      this.howTo = howTo;
   }

   public void repIncrease()
   {
      if (selectedSet >= 0)
      {
         int temp = repsArray.get(selectedSet);
         temp = repsArray.get(selectedSet) + 1;
      }
   }

   public void repDecrease()
   {
      if (selectedSet >= 0)
      {
         if (repsArray.get(selectedSet) > 0)
         {
            int temp = repsArray.get(selectedSet);
            temp = repsArray.get(selectedSet) + 1;
         }
      }
   }

   @Override public Exercise clone()
   {
      try
      {
         Exercise clone = (Exercise) super.clone();
         // TODO: copy mutable state here, so the clone can't change the
         //  internals of the original
         return clone;
      } catch (CloneNotSupportedException e)
      {
         throw new AssertionError();
      }
   }
   public String toString()
   {
      return getExerciseName();
   }
}
