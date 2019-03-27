/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manjukl
 */
public class Student extends Person
{

    public Student(String name, int id) 
    {
        super(name, id);
    }
    
    public void register (Course crs)
    {
        crs.registerStudent(this);
    }
    
   public String toString()
   {
       return "Student: name=" + this.getName() + " and id=" + this.getID();
   }
}