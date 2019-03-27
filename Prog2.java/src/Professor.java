/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manjukl
 */

public class Professor extends Person
 {
   private float salary;

    public Professor(String name, int id, float salary) 
    {
        super(name, id);
        this.salary = salary;
    }
 
   public float getSalary()
   {
       return salary;
   }
   
    public void register (Course crs)
    {
        crs.registerProfesor(this);
    }
    public String toString()
   {
       return "Professor: name=" + this.getName() + " and id=" + this.getID();
   }
}
