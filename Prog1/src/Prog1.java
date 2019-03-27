/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manjukl
 */
import java.util.Scanner;
import java.io.File;
public class Prog1 
{
    private static GolfLeague league = new GolfLeague();
    private static Scanner sc = new Scanner (System.in );

   /**
   Adds an instance of GolfLeagueMember to league.
   The method reads in two strings for name and group
   and an integer for score, invokes the add method 
   on league, and displays a message according to the
   return result of the add method.
   */
   private static void addMember()
   {
      String name = sc.next();
      String group = sc.next();
      int score = sc.nextInt();
      GolfLeagueMember member;
      if(group.equals("Regular"))
         member = new RegularMember(name, score);
      else if (group.equals("Senior"))
         member = new SeniorMember(name, score);
      else
         member = new YouthMember(name, score); 


      boolean add = league.add(member);
            if(add == true)
               System.out.println(group + " Member "+ name + " is added");
            else 
               System.out.println(name + " is not added");
   }

   /**
   Deletes a member from league.
   The method reads in a string for name, invokes method
   delete on league, and displays a message according to 
   the return result of the delete method.
   */
   private static void deleteMember()  
   {
      String name = sc.next();

      GolfLeagueMember member;
      if(league.delete(name))
         System.out.println(name + " is deleted");
      else 
         System.out.println(name + "is not deleted");

   }
      
   /**
   Adds a score for a member in league.
   The method reads in a string for name and an integer 
   for score, invokes method enterScore on league, and 
   displays a message according to the return result of 
   the enterScore method.
   */
   private static void addScore()
   {
      String name = sc.next();
      int score = sc.nextInt();
      league.enterScore(name, score);
      System.out.println("Score of " + score + " is stored for " + name );
   }

   /**
   Displays the handicap for a member in league.
   The method reads in a string for name, invokes method 
   getHandicap on league, and displays a message according 
   to the return result of the getHandicap method.
   */
   private static void displayHandicap()
   {
      String name = sc.next();
      System.out.println(name + " has a handicap of " + 
              league.getHandicap(name));
   }
   
   public static void main(String [] args)
   {
       
      try
      {
         //sc = new Scanner( new File("J:/Fall 2017/CS2430/Programs
         //Prog1/src/Prog1_1.in"));
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      while(sc.hasNext()) 
      {
         String command = sc.next().toLowerCase();
         if( command.equals("add"))
            addMember();
         else if( command.equals("delete"))
            deleteMember();
         else if ( command.equals("score"))
            addScore();
         else if(command.equals("handicap"))
            displayHandicap();
         else
            System.out.println(league);
      }
   }

}
