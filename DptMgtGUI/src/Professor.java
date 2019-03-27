/**
This class is used for the sole purpose of adding a professor to the array
of people in the People class. It also overrides the toString method, but in
a different way which is unique to professors.
 @author mattk and manjukl
 */
public class Professor extends Person
{
/**
   Constructor. Used for setting data in the department class.
   @param name
   @param id 
   */
   public Professor (String name, String id)
   {
      super(name, id);
   }
/**
   Overridden method from Person class. When adding a professor into a course
    from department class, this takes the information and places it into the
    course array at the specific index.
   @param crs
   */   
   @Override
   public void register(Course crs)
   {
      crs.addProfessor(this);
   }
/**
   Prints out a certain string.
   @return string of both the name and id of the professor.
   */  
   @Override
   public String toString()
   {
      return "Professor: name: " + name + " and id: " + id;
   }
}
