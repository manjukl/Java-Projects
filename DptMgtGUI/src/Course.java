/**
 @author mattk and manjukl
 */
public class Course
{
   private String cId;
   private String title;
   private final int MAX_NUM = 100;
   private Bag studBag = new Bag();
   private Professor cProf = null;
   private int sCount;
   private boolean isProf = false;
/**
   Displays all course information including professor, and students enrolled.
   @return the course information, professor of the course, and students in 
   the course.
   */   
   @Override
   public String toString()
   {
      // if(obj instanceof Professor)
       
      String output = cId + ", " + title;
      String profOut = "";
      if (cProf != null)
      {
          profOut = "\n" + cProf.toString();
      }
      
      String studOut = studBag.toString();
      
      return output + profOut + studOut;   
   }
/**
   Constructor. Used in setting data in the department class.
   @param title
   @param cId 
   */   
   public Course(String title, String cId)
   {
      this.cId = cId;
      this.title = title;
   }
/**
   Adds a professor as the current professor to the course selected.
   use in 
   @param prof 
   */   
   public void addProfessor(Professor prof)
   {
      cProf = prof; 
   }
/**
   Adds a student to the course, and increments the amount of students in the
   course by one.
   @param stud 
   */   
   public void addStudent(Student stud)
   {//add the student into the array cStud
       studBag.add(stud);
               
       sCount++;
   }
/**
   Used to give other classes the permission to use the cId variable.
   @return the course id
   */   
   public String getCId()
   {
      return this.cId;
   }
   
   @Override
   public boolean equals(Object obj)
   {
      if (obj instanceof Course)
      {
        Course cors = (Course) obj;
        return this.cId.equals(cors.cId);
      }
      return false;
   }
}
