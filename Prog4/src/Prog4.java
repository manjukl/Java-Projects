/**

 @author leuenbergert
 */

import java.io.*;
import java.util.Scanner;


public class Prog4 
{
   private static int arrivalMin, arrivalMax,scMin, scMax, stopTime;
   private static String jobList [] = new String[50];
   private static int num = 0;
   
   /**
   main test bed
   @param args not used in this project
   @throws IOException catches input/output exceptions
   */
    public static void main( String args[] ) throws IOException
   {
      Scanner stdin = new Scanner(System.in);
      Simulation sim;
      
      try
      {
         stdin = new Scanner( new File("Prog4_1.in") );
      }
      catch (Exception ex)
      {
         System.out.println(ex.toString());
      }     
      
      while(true)
      {
         try
         {
            arrivalMin = stdin.nextInt();
            arrivalMax = stdin.nextInt();
            scMin = stdin.nextInt();
            scMax = stdin.nextInt();
            stopTime = stdin.nextInt();
            sim = new Simulation(arrivalMin, arrivalMax,
              scMin, scMax, stopTime);
         }
         catch (Exception ex)
         {
            for(int i = 0; i < num; i++)
            {
               System.out.println(jobList[i] + "\n");
            }
            System.out.println("Normal Termination!");
            break;
         }     
         sim.runSimulation();
         String temp = sim.toString();
         jobList[num++] = temp;         
      }
   }
}
