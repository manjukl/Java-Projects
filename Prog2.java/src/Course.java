/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manjukl
 */
public class Course {
    
     private String studentName;
     private String courseId;
     private String courseTitle;
     private Professor professor;
     private final int MAX_STUDENT_SIZE = 100;
     private Student [] StudentList = new Student [MAX_STUDENT_SIZE];
     private int StudentCount = 0;
     
     
     public Course(String courseId, String courseTitle)
     {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
     }
     @Override
        public String toString()
        { 
            //Course information: cs2430, oops1
           return "Course information: " + courseId + ", " + courseTitle;
          
        }
        
        public void printProfessor()
        {
            if (professor != null)
                System.out.println(professor);
        }
        public void printStudents()
        {
            for (int i = 0; i < StudentCount; i++)
                System.out.println(StudentList[i]);
        }
      
     public String getcrsId()
     {
        return courseId;
     }
     
     public String getcrsTitle()
     {
        return courseTitle;
     }
     
     public void registerProfesor (Professor newProfessor)
     {
        this.professor = newProfessor;
     }
     
     public void registerStudent (Student newStudent)
     { 
         StudentList [StudentCount] = newStudent;
         StudentCount++;
     }
}
