/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manjukl
*/
public abstract class GolfLeagueMember 
{
   //declaring and instantiate constants
   protected final int NUM_STORED_SCORES = 5;
   protected final double HANDICAP_PERCENT = 0.96;
   
   //declaring variables
   protected int coursePar = 72;
   private String name;
   protected int scores[] = new int[NUM_STORED_SCORES];
   protected int curIndex;

   /**
    * A Golf league member constructor 
    * @param name
    * @param initialScore 
   */
   protected GolfLeagueMember(String name, int initialScore)
   {
      this.name = name;
      curIndex = 0;
      for (int i = 0; i < NUM_STORED_SCORES; i++)
      {
         scores[i] = initialScore;
      }
   }

   /** 
    * Same as that of class Golfer of Lab1. Gets the name.
    * @return the name  
   */
   public String getName() 
   {
      return name;
   }

   /**
    * Same as that of class Golfer of Lab1
    * @return the desired string for the program.
   */
   public String toString() 
   {
      String string;
      string = name + ": " + curIndex + "," + scores[0] + ","
              + scores[1] + "," + scores[2] + "," + scores[3]
              + "," + scores[4];
      return string;
   }

   /** Same as that of class Golfer of Lab1. Scores score in the array scores.
    * @param score 
   */
   public void storeScore(int score) 
   {
      scores[curIndex] = score;
      curIndex++;
      if (curIndex >= NUM_STORED_SCORES) 
      {
         curIndex = 0;
      }
   }

   // Returns the member's handicap 
   abstract public int handicap();

   /** Same as that of class Golfer of Lab1, but protected. finds the
    * maximum value in the array scores.
    * @returns the index of the maximum score.
    */
   protected int indexOfMax() 
   {
      int max = 0;
      int index = 0;
      for (int i = 0; i < NUM_STORED_SCORES; i++) 
      {
         if (scores[i] > max) 
         {
            max = scores[i];
            index = i;
         }
      }
      return index;
   }

   /**
    * Similar to indexOfMax, but finds the minimum value in the array scores.
    * @returns the index of the smallest score 
   */
   protected int indexOfMin() 
   {
      int min = 0;
      int index = 0;
      for (int i = 0; i < NUM_STORED_SCORES; i++) 
      {
         min = scores[i];
         if (scores[i] < min) 
         {
            min = scores[i];
            index = i;
         }

      }
      return index;
   }

}
