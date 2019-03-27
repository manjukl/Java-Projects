import java.util.*;
import javax.swing.JOptionPane;

/**
 This class is essentially the power-house of the package. It works with all
 of the methods from listing people to registering them to courses. It also
 prints out the different menus that a user might see when typing in certain
 commands.

 @author mattk and manjukl
 */
public class Department
{

   public static int count = 0; // Amount of people created
   public static int cCount = 0;
   public Bag persBag = new Bag();
   public Bag corsBag = new Bag();
   private String deptName;

   @Override
   public boolean equals(Object obj)
   {
      if (obj instanceof Department)
      {
         Department dept = (Department) obj;
         return this.deptName.equals(deptName);
      }
      return false;
   }
   /**
    Scans through each character given by the user to check if the id given is
    an integer, and throws an exception if it isn't.

    @param id entered in addPerson, deletePerson, and registerCourse
    @return true of no exception is thrown
    @throws InputMismatchException
    */
   public boolean isIdValid(String id) throws InputMismatchException
   {
      if (id.length() < 5 || id.length() > 5)
      {
         throw (new InputMismatchException(": The length of id has to be 5!"
               + "\nPlease enter valid id!"));
      }

      for (int i = 0; i < id.length(); i++)
      {
         char tChar = id.charAt(i);
         if (Character.isLetter(tChar) || id.contains("."))
         {
            throw (new InputMismatchException(": Wrong character!"
                  + "\nPlease enter valid id!"));
         }
      }
      
      for (int i = 0; i < DepartmentManagement.deptCount; i++)
        {
            Object a = DepartmentManagement.deptBag.get(i);
            Department b = (Department) a;
            for (int k = 0; k < b.count; k++)
            {
               Object c = b.persBag.get(k);
               Person d = (Person) c;
               if (d.getId().equals(id))
               {
                   throw (new InputMismatchException(": This ID is already taken!"));
               }
            }
         }
      //return true when no exception is thrown
      return true;
   }

     public boolean isIdValidRemove(String id) throws InputMismatchException
   {
      if (id.length() < 5 || id.length() > 5)
      {
         throw (new InputMismatchException(": The length of id has to be 5!"
               + "\nPlease enter valid id!"));
      }

      for (int i = 0; i < id.length(); i++)
      {
         char tChar = id.charAt(i);
         if (Character.isLetter(tChar) || id.contains("."))
         {
            throw (new InputMismatchException(": Wrong character!"
                  + "\nPlease enter valid id!"));
         }
      }
      
      for (int i = 0; i < DepartmentManagement.deptCount; i++)
        {
            Object a = DepartmentManagement.deptBag.get(i);
            Department b = (Department) a;
            for (int k = 0; k < b.count; k++)
            {
               Object c = b.persBag.get(k);
               Person d = (Person) c;
               if (d.getId().equals(id))
               {
                   b.persBag.remove(d);
               }
               else
                    JOptionPane.showMessageDialog(null,"There is no person with id: " + id
                        + "in this department. Please try again.");
            }
         }
      //return true when no exception is thrown
      return true;
   }
     
     public boolean isIdValidRegister(String cId, String id) throws InputMismatchException
     {
         if (id.length() < 5 || id.length() > 5)
        {
             throw (new InputMismatchException(": The length of id has to be 5!"
                + "\nPlease enter valid id!"));
        }

        for (int i = 0; i < id.length(); i++)
        { 
            char tChar = id.charAt(i);
            if (Character.isLetter(tChar) || id.contains("."))
            {
                throw (new InputMismatchException(": Wrong character!"
                    + "\nPlease enter valid id!"));
            }
        }
        Student std = new Student(null, id);
        int index = this.persBag.find(std);
        if (index != -1)
        {
            Course crs = new Course (null, cId);
            int cIndex = this.corsBag.find(crs);
            if (cIndex != -1)
            {
                ((Person)this.persBag.get(index)).register((Course) corsBag.get(index));
                return true;
            }
            else 
                return false;
        }
        else 
            return false;
       
     }
   /**
    Sets department name to a cross-class type
    */
   public Department(String deptName)
   {
      this.deptName = deptName;
   }

   /**
    Adds a person to the the array and asks for name and id. If id entered is
    invalid or matches with another id in the list, it prompts the user for a
    new id.
    */
    public void addPerson(String id, String name, String role)
    {
        boolean isValid = false;
        try
        {
            isValid = isIdValid(id);
            if (role.equals("Student"))
            {
                Student currentPers = new Student(name, id);
                persBag.add(currentPers);
                count++;
            }
               
            if (role.equals("Professor"))
            {
                Professor currentPers = new Professor(name, id);
                persBag.add(currentPers);
                count++;
            }
        }
        catch (Exception e)
        {
           System.out.println("Invalid Id: " + e);
        }
    }
    
    public void addCourse(String title, String cId)
    {
        Course currentCors = new Course(title, cId);
        corsBag.add(currentCors);
        cCount++;
    }
   /**
    Adds a person to a specific course selected. Scans through all inputs to
    detect errors and only ever stops when both a legitimate id, and course id
    is entered. If there are no courses or people in the list, this method
    does nothing.
    */

   public void registerCourse(String id, String cId)
   {
      boolean isValid;
      boolean courseValid = false;
      Person personToRegister = null;
      if (count != 0 && cCount != 0)
      {
         while (personToRegister == null)
         {
            isValid = false;
            while (!isValid)
            {
               try
               {
                  isValid = isIdValidRegister(id, cId);
               }
               catch (Exception e)
               {
                  System.out.println("Invalid Id: " + e);
               }
            }
         }
      }
   }
}

//            for (int i = 0; i < DepartmentManagement.deptCount; i++)
//            {
//               for (int k = 0; k < DepartmentManagement.deptList[i].count; k++)
//               {
//                  if (DepartmentManagement.deptList[i].pers[k]
//                        .getId().equals(id))
//                  {
//                     personToRegister
//                           = DepartmentManagement.deptList[i].pers[k];
//                  }
//               }
//            }
//            if (personToRegister == null)
//            {
//               System.out.println("There is no person with id = " + id
//                     + ". Please try again.");
//            }
//         }

//         while (!courseValid)
//         {
//            String cId = DepartmentManagement.stdin.nextLine();
//            for (int j = 0; j < cCount; j++)
//            {
//               if (cors[j].getCId().equals(cId))
//               {
//                  courseValid = true;
//                  personToRegister.register(cors[j]);
//                  System.out.println("Registration was successful.");
//                  System.out.println("Course information: "
//                        + cors[j].toString());
//               }
//            }
//            if (courseValid == true)
//            {
//               return;
//            }
//
//            else
//            {
//               System.out.println("There is no course with id = " + cId
//                     + ". Please try again.");
//            }
//         }
//      }
//      if (count == 0)
//      {
//         System.out.println("There is no student or professor "
//               + "in the department. Add a person first.");
//      }
//      else
//      {
//         System.out.println("There is no course in the department. "
//               + "Add a course first.");
//      }
//   }

      