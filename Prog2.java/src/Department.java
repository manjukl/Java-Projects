
import java.util.InputMismatchException;
import java.util.Scanner;

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
public class Department
{
   private final int MAX_OF_PEOPLE = 100;
   private final int MAX_OF_COURSES = 10;
   private Person [] peopleList = new Person [MAX_OF_PEOPLE];
   private int numPeople = 0;
   private int numProfs = 0;
   private int courseList = 0;
   private int profList = 0;
   private Course [] crsList = new Course [MAX_OF_COURSES];
   private String nameDepartment;
   private Scanner stdin = DepartmentManagement.getInputStream();
   private final float NICE_SALARY = 1000;
   private int num =0;
  
            
    public int findPerson (int personId)
    {
       for (int i = 0; i < numPeople; i++)
       {
           if(peopleList[i].getID() == personId )
            return i;
       }
       return -1;
    }
  
      
    private int findCourse (String courseId)
    {
       for (int i = 0; i < courseList; i++)
       {
           if(crsList[i].getcrsId().equals(courseId))
               return i;
       }
       return -1;
    }
    
    Person getPerson (int personId)
    {
        int index = findPerson(personId);
            if (index < 0)
                return null;
            return peopleList[index];
    }
    
    Course getCourse (String courseId)
    {
        int index = findCourse(courseId);
            if (index < 0)
                return null;
            return crsList[index];
    }
    
   
  //loop through the array and find person
    // loop through the array and find the course
  
   public Department (String nameDepartment)
   {
       this.nameDepartment = nameDepartment;
   }
   
   public void courseList()
   {
       
       if (courseList == 0)
       {
           System.out.println("No course in the list. Add a course first.");
       }
       else
       {
           for (int i = 0; i < courseList; i++)
            {
               
               
               System.out.println(crsList[i]);
                crsList[i].printProfessor();
                crsList[i].printStudents();
            }
            
        }
   }
   
   public void addCourse()
   {
        System.out.println("Please enter course id:");
        String crsId = stdin.nextLine();
        System.out.println("Please enter course title:");
        String crsTitle = stdin.nextLine();
        Course newCourse = new Course(crsId, crsTitle); 
  
   
        if ( findCourse(crsId) >= 0)
        {
            // System.out.println("")
        }
   
        else 
        {
            System.out.print("The course was added: ");
            crsList[courseList] = newCourse;
            System.out.println(crsList[courseList].getcrsId() + ", " +
                crsList[courseList].getcrsTitle());
            courseList++;
        }
   
   }
   
  
 
  
 
 
 public void avgSalOfProfessors()
 {  
    float sum = 0;
    for (int i = 0; i < numProfs; i++)
    {
       {
            if (peopleList[i] instanceof Professor)
            sum += ((Professor)peopleList[i]).getSalary();
       }
        float avg;
        if ( numProfs == 0)
        {
            avg = 0;
        }
        else
        {
            avg = sum / (float)numProfs;
        }
        System.out.println("The average salary in " + nameDepartment + " department "
           + "is " + avg);
    }
 }
 
 public String getName()
 {
     return nameDepartment;
 }
 
 private int findProfessor(int id)
 {
     for(int i = 0; i < numProfs; i++)
     {
         if(peopleList[i].getID() == id)
            return i;
     }
     return -1;
 }

 void listPeople() 
 {
       if (numPeople == 0)
       {
            System.out.println("No people in the list. Add a student or"
             + " professor first." );
       }  
       
        else
        {
          for(int i = 0; i < numPeople; i++)
       
           System.out.println(peopleList[i]);
        }
 }
     void AddPerson( Person newPerson)
     {
     peopleList[numPeople++] = newPerson;
     }
    boolean checkId(String id)
    {
        try
        {
            if (id.length()!= 5)
             {
                throw new InputMismatchException("the length of id has "
                        + "to be 5.");
             }
            
            for (int i = 0; i < id.length() ; i++)
            {   
                if (!Character.isDigit(id.charAt(i)) )
                {
                    throw new InputMismatchException("wrong character.");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Invalid Id: " + e.toString());
            return false;
        }
        return true;
    }
    
    
    
    boolean hasPeople()
    {
        return numPeople > 0;
    }
    
    boolean hasCourses()
    {
         return courseList > 0; 
    }
    
    void deletePeople() 
    {
        if(numPeople == 0)
        {
            // output error
            System.out.println("The people list is empty.");
            // return
            return;             
        }
        
            System.out.println("Please enter the person's id:"); 
           
            String id = stdin.nextLine(); 
     
        while (!checkId(id))
        {
            System.out.println("Please enter valid id:");
            id = stdin.nextLine(); 
        }
        
            int i = findPerson(Integer.parseInt (id));
        if (i != -1)
        {
             peopleList[i] = peopleList[numPeople-1];
             numPeople--;
             System.out.println("The person with id = " + id + " was deleted.");
        }
        else
            System.out.println("There is no person with id = " + id + "in "
                    + "this department. Please try again.");
    }
 
 }
