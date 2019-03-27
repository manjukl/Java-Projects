/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manjukl
 */
public class SeniorMember extends GolfLeagueMember
{
   /**
    * A Senior member constructor 
    * @param name
    * @param initialScore 
   */
   public SeniorMember(String name, int initialScore)
   {
      super(name, initialScore);
      coursePar = 74;
   }
   
   /**
   Gets the handicap of a senior member.
   @return the calculated value of the handicap of the senior member in the 
   * array and 0 if it is less than  handicap 0.
   */
   @Override
   public int handicap()
   {
      int sum = 0;
      int divisor = 3;
      float average = 0.0f;
      int indexMax = indexOfMax();
      int indexMin = indexOfMin();
      for(int i = 0; i < NUM_STORED_SCORES; i++) 
      {
         sum += scores[i];
      }  
      sum -= scores[indexMax];
      sum -= scores[indexMin];
      average = ((float)sum / divisor);
      float result = average - coursePar;
      int value = (int)(result * HANDICAP_PERCENT);

      if(value < 0)
         return 0;
      else
         return value;
   }
   
   /**
    * A string method to display the output for senior member
    * @return the desired string for the program.
   */
   @Override
   public String toString()
   {
      return "Senior Member " + super.toString();
   }
}
