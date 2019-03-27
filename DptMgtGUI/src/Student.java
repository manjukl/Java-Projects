
/**
 This class is used for the sole purpose of adding a student to the array
 of people in the People class. It also overrides the toString method, but in
 a different way which is unique to students.

 @author mattk and manjukl
 */
public class Student extends Person
{

   /**
    Constructor. Used in setting data in the department class.

    @param name
    @param id
    */
   public Student(String name, String id)
   {
      super(name, id);
   }

   /**
    Overridden method from Person class. When adding a student into a course
    from department class, this takes the information and places it into the
    course array at the specific index.

    @param crs
    */
   @Override
   public void register(Course crs)
   {
      crs.addStudent(this);
   }

   /**
    Overridden method from Person class. Prints out a specific string for
    students.

    @return string of both id and name of student
    */
   @Override
   public String toString()
   {
      return "Student: name: " + name + " and id: " + id;
   }
}
