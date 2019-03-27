/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manjukl
 */
public abstract class Person 
{
    private int id;
    private String name;
   
   
   public Person(String name, int id)
   {
       this.name = name;
       this.id = id;
   } 
       
   public String getName()
   {
       return name;
   }
   
   public int getID()
   {
       return id;
   }
   public abstract void register (Course crs);
  
    
}
