


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manjukl
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class DepartmentManagement 
{
    
    private static Scanner stdin = new Scanner(System.in);
    private final int MAX_DEPT_SIZE = 100;
    private Department[] DeptList = new Department [MAX_DEPT_SIZE];
    private Department currentDept = null;
    
    private int numDept = 0;
    public static Scanner getInputStream()
    {
        return stdin;
    }
    
    public void run()
    {
        System.out.println("Department Management System is running...!");
        System.out.println("Mainmenu: please enter a department name or "
            + "enter Q to quit:");
            
        String cmd = stdin.nextLine();
            while( !cmd.equalsIgnoreCase("q") )
            {   
                int index = findDept(cmd);
                if(index >= 0)
                {
                    currentDept = DeptList[index];
                    DepartmentName();
                }

                else
                {
                    Department Dept = new Department(cmd);
                    DeptList[numDept] = Dept;
                    numDept++;
                    currentDept = Dept;
                    DepartmentName();
                    // Make a new department and add it to the list
                    // Run the new department
                }
                System.out.println("Mainmenu: please enter a department name "
                        + "or enter Q to quit:" );
                cmd = stdin.nextLine();
            }              
            System.out.println("Thanks for using Department "
                       + "Management System!");
    }
    
    public void register ()
    {
        if ( !currentDept.hasPeople())
        {
            System.out.println("There is no student or professor in "
                    + "the department. Add a person first.");
                    return;
        }
        
        if ( !currentDept.hasCourses ())
        {
            System.out.println("There is no course in the department. "
                    + "Add a course first.");
            return;
        }
        
        String personId;
        String courseId;
        Person person = null;
        System.out.println("Please enter an id of a student or a professor:");
        //personId = getInputStream().next();
    
        while (person == null)
        { 
            personId = getInputStream().nextLine();
            while (!currentDept.checkId(personId))
            {
                System.out.println("Please enter valid id:");
                personId = getInputStream().nextLine();
            }
            person = currentDept.getPerson(Integer.parseInt(personId));
         
            if (person == null)
            {
                System.out.println("There is no person with id "
                        + "= " + personId + ". Please try again." );
            }   
        }
   
        System.out.println("Please enter course id:");
    
        Course course = null;
        while (course == null)
        {
            courseId = getInputStream().nextLine();    
            course = currentDept.getCourse(courseId);
            if (course == null)
            {
                System.out.println("There is no course with id = " + courseId + ". "
               + "Please try again.");
            }
        }
    
        person.register(course);
        System.out.println("Registration was successful.");
       
        System.out.println(course);
        course.printProfessor();
        course.printStudents();
    }     
    
    
    public void DepartmentName()
    {
        System.out.println();
        System.out.println ("Please enter");
        System.out.println ("MP to manage people,");
        System.out.println ("MC to manage course");
        System.out.println ("RC to register a course for a person");
        System.out.println ("RM to return to upper menu");
     
        String cmd = stdin.nextLine();
        while (!cmd.equalsIgnoreCase("rm")  )
        {
            if(cmd.equalsIgnoreCase("mp"))
             ManagePeople();
            else if(cmd.equalsIgnoreCase("mc"))
            ManageCourse ();
            else if(cmd.equalsIgnoreCase("rc"))
             register();
            else if(cmd.equalsIgnoreCase("rm"))
               return;
         System.out.println();
         System.out.println ("Please enter");
         System.out.println ("MP to manage people,");
         System.out.println ("MC to manage course");
         System.out.println ("RC to register a course for a person");
         System.out.println ("RM to return to upper menu");
    
         cmd = stdin.nextLine();
    }
    }
    
     public void ManageDept()
  {
    System.out.println();
    System.out.println ("Please enter");
    System.out.println ("LP to list all professors,");
    System.out.println ("AP to add a professor,");
    System.out.println ("DP to delete a professor,");
    System.out.println ("AVG to get the average salary of all "
                 + "professors,");
    System.out.println ("RM to return to upper menu");
         
    String cmd = stdin.nextLine();
    while (!cmd.equalsIgnoreCase("rm")  )
        {
            if(cmd.equalsIgnoreCase("lp"))
             currentDept.listPeople();
            else if(cmd.equalsIgnoreCase("ap"))
             addPeople();
            else if(cmd.equalsIgnoreCase("dp"))
             currentDept.deletePeople();
            else if(cmd.equalsIgnoreCase("avg"))
             currentDept.avgSalOfProfessors();
            else if(cmd.equalsIgnoreCase("rm"))
             return;
         
         System.out.println();
         System.out.println ("Please enter");
         System.out.println ("LP to list all professors,");
         System.out.println ("AP to add a professor,");
         System.out.println ("DP to delete a professor,");
         System.out.println ("AVG to get the average salary of all "
                 + "professors,");
         System.out.println ("RM to return to upper menu");
         
         cmd = stdin.nextLine();
      }
  } 
   public void ManagePeople()
   {
        System.out.println();
        System.out.println("Please enter");
        System.out.println("LP to list all people,");
        System.out.println("AP to add a person,");
        System.out.println("DP to delete a person");
        System.out.println("RM to return to upper menu");
    
        String cmd = stdin.nextLine();
    
        while (!cmd.equalsIgnoreCase ("rm"))
        {
            if(cmd.equalsIgnoreCase("lp"))
             currentDept.listPeople();
            else if(cmd.equalsIgnoreCase("ap"))
             addPeople();
            else if(cmd.equalsIgnoreCase("dp"))
             currentDept.deletePeople();
            else if(cmd.equalsIgnoreCase("rm"))
             return;
  
            System.out.println();
            System.out.println("Please enter");
            System.out.println("LP to list all people,");
            System.out.println("AP to add a person,");
            System.out.println("DP to delete a person");
            System.out.println("RM to return to upper menu");
   
            cmd = stdin.nextLine();
        }
   }
            
     public void ManageCourse()
     {
        System.out.println();
        System.out.println("Please enter");
        System.out.println("LC to list all courses,");
        System.out.println("AC to add a course,");
        System.out.println("RM to return to upper menu");
     
        String cmd = stdin.nextLine();
     
        while (!cmd.equalsIgnoreCase ("rm"))
        {
            if(cmd.equalsIgnoreCase("lc"))
                currentDept.courseList();
            else if(cmd.equalsIgnoreCase("ac"))
                currentDept.addCourse();
      
            System.out.println();
            System.out.println("Please enter");
            System.out.println("LC to list all courses,");
            System.out.println("AC to add a course,");
            System.out.println("RM to return to upper menu");
          
            cmd = stdin.nextLine();
        }  
     
     }
      
     
    public int findDept(String name)
    {
        //int Find( Department [] DeptList, num, name);
        for ( int i = 0; i < numDept; i++ )
        {
            if(DeptList[i].getName().equals(name))
                return i;
        }
        return -1;
    }
    void addPeople() 
    {
        Person newPerson = null;
        System.out.println("Please enter name:");
        String name = stdin.next();
        System.out.println("Please enter id:");
        String id = stdin.next(); 
     
        boolean personExists = true;
        while ( personExists)
        {
            while (!checkId(id))
            {
            System.out.println("Please enter valid id:");
            id = stdin.next(); 
            }
               // personExists = findPerson(Integer.parseInt (id)) != -1;
               personExists = false;
            for ( int i = 0; i < numDept; i++)
                if (DeptList[i].findPerson(Integer.parseInt (id)) != -1)
                    personExists = true;
            if (personExists)
            {
                System.out.println("A person with the same id already exists. "
                        + "Please try a different id.");
                        id = stdin.next();
             }
                
        }
        
     
        System.out.println("Please select the role of the person by entering 1 "
              + "or 2: 1.Student, 2.Professor"); 
        int role = 0; 
      
        while (role != 1 && role != 2)
        { 
            try
            {
                role = Integer.parseInt(stdin.next());
                stdin.nextLine();
                if(role != 1 && role != 2)
                System.out.println("Invalid role. Please select again");
             }
         catch (Exception e)
         {
        System.out.println("Invalid Input. " + e.toString() + " Please try again");
         }
        }
        
        if (role == 1)
            newPerson = new Student(name, Integer.parseInt (id));
       
        else if (role == 2)
            newPerson = new Professor(name, Integer.parseInt (id), 0); 
        currentDept.AddPerson(newPerson);
        System.out.println("The person you just added: " + newPerson.toString() );
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
    
}
