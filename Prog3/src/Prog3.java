/*
This class controls the printed information(output) to the user.
It also hepls to regulate user input by contacting the RpnEvaluator class
to find out if an input is valid or not.
@author manjukl
*/

import java.util.Scanner;
import java.io.File;
import java.util.Vector;
public class Prog3 
{
   private static final int SIZE = 50;
   private static Vector <TVector> goodList = new Vector<TVector>(SIZE);
   private static Scanner sc = new Scanner(System.in);
   private static int count = 0;
   
   /**
   This main method is the testbed main for class Prog3. It also 
   tests the RpnEvaluation class.
   @param args is the input
   */
   public static void main(String [] args)
   {
      sc = new Scanner(System.in);
      try
      {
         //sc = new Scanner( new File("J:/Fall 2017/CS2430/Programs/"
         //+ "Prog3/src/Prog3_1.in"));
      }
      catch(Exception e)
      {
         System.out.println(e.toString());
      }
      while(sc.hasNext())
      {
         RpnEvaluator rp = new RpnEvaluator();
         String input = sc.nextLine();
         if(rp.evalution(input))
            validOutput(rp);
         else
            invalidOutput(rp);
      }
      System.out.println("The list of good answers is:");
      for(int i = 0; i < goodList.size(); i++)
      {
         System.out.println(goodList.get(i).toString());
      }
   }
   
   /**
   This method prints out the output when the evaluation is successful
   @param rp is the object of RpnEvaluation created
   */
   public static void validOutput(RpnEvaluator rp)
   {
      System.out.println("Expression " + ++count + " is: "
         + rp.getExpress());
      System.out.println("The value is: " + rp.getResult().toString());
      goodList.add(rp.getResult());
   }
   
   /**
   This method prints out the output when the evaluation is not successful
   @param rp is the object of RpnEvaluation created
   */
   public static void invalidOutput(RpnEvaluator rp)
   {
      System.out.println("Expression " + ++count + " is: " 
         + rp.getExpress());
      System.out.println("Invalid Expression");
   }
}
