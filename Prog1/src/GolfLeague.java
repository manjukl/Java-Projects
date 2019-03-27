/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manjukl
 */
public class GolfLeague 
{  
   private final int MAX_SIZE = 10;
   private GolfLeagueMember members[] = new GolfLeagueMember[MAX_SIZE];
   private int numOfMembers = 0;

   //default constructor
   public GolfLeague()
   {
   }

   /**
   Adds a member to members[].
   @param member to add 
   @return true if the member was added
           false otherwise (array was full)
   */
   public boolean add( GolfLeagueMember member )
   {
      if(numOfMembers < MAX_SIZE)
      {
         members[numOfMembers++] = member;
         return true;
      }
      else
         return false;
   }
   
   /**
   Deletes a member from members[] and moves all array elements 
   after the deleted one up to maintain the order of the array. 
   @param memberName name of the member to be deleted
   @return true if the member was deleted
           false otherwise (no member had the same name)
   */
   public boolean delete( String memberName )
   {
      int index = findByName(memberName);
         if(index != -1)
         {
            numOfMembers--;
            for(int i = index; i < numOfMembers; i++ )
            {
                //if(scores [i] == score)     
                members[i] = members[i + 1];
            }
            return true;
         }
         else
            return false;
   }
   
   
   /**
   Stores score for a member in members[].
   @param memberName name of the member
   @param score to be stored
   @return true if score was stored
           false otherwise (no member had the same name)
   */
   public boolean enterScore ( String memberName, int score )
   { 
      int index = findByName(memberName);
      if(index == -1)
      { 
         return false;
      }
      else
         members[index].storeScore(score);
         return true;
   }
   
   
   /**
   Overrides the toString method from class Object. 
   @return string beginning with a new line character,
   followed by "All members of the League: " and another
   new line character, followed by one line for each member
   in members[]. 
   The line for a member has the string from the toString 
   method of the member, followed by a new line character.
   */
   @Override
   public String toString()
   {
      String total = "\nAll members of the League: \n";
      for(int i = 0; i < numOfMembers; i++)
      {
         total += members[i].toString() + "\n";
      }
      return total;
   }

   
   /**
   Gets the handicap of a member in members[].
   @param memberName name of the member
   @return handicap of the member in the array 
          -1 otherwise (no member had the same name) 
   */
   public int getHandicap( String memberName )
   {
      int index = findByName(memberName);
      if(index != -1)
         return members[index].handicap();
      else
         return -1;
   }
   
   
   /**
   Gets the index of a member in members[].
   @param memberName name of the member
   @return index of the member in members[]
          -1 otherwise (no member had the same name) 
   */
   private int findByName(String memberName)
   {
      for(int i = numOfMembers - 1; i >= 0; i-- )
      {
         if(members[i].getName().equals(memberName))
            return i;
      }
       return -1;
   }
}
