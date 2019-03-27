/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manjukl
 */
public class RegularMember extends GolfLeagueMember
{
   /**
    * A Regular member constructor 
    * @param name
    * @param initialScore 
   */
   public RegularMember(String name, int initialScore )
   {
      super(name, initialScore);
      //coursePar = 72;
   }

   /**
   Gets the handicap of a regular member.
   @return the calculated value of the handicap of the regular member in the 
   * array and 0 if it is less than handicap 0.
   */
   @Override
   public int handicap()
   {
      int sum = 0;
      int divisor = 4;
      float average = 0.0f;
      int index = indexOfMax();
      for(int i = 0; i < NUM_STORED_SCORES; i++) 
      {
         sum += scores[i];
      }  
      sum -= scores[index];
      average = ((float)sum / divisor);
      float result = average - coursePar;
      int value = (int)(result * HANDICAP_PERCENT);

      if(value < 0)
         return 0;
      else
         return value;

   }

   /**
    * A string method to display the output for regular member
    * @return the desired string for the program.
   */
   @Override
   public String toString()
   {
      return "Regular Member " + super.toString();
   }
}
