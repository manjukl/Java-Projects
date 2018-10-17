/**
Queue class implements the Queue data type. It contains methods to add, 
remove, check if the queue is full and check if the queue is empty. The 
queue has the functionality to be defined to contain any data type.
@author Thomas Leuenberger, Lizkebe Manjuk
*/

public class Queue<E>
{
   private E[] elements;
   private int count, front, rear;
   
   /**
   Constructor creates a new Queue of the given size.
   @param size integer of the size of Queue.
   */
   public Queue(int size)
   {
      elements = (E[]) new Object[size];
      front = rear = count = 0;
   }
   
   /**
   Adds an object to the queue.
   @param x object to be added, must match the data type of queue.
   @throws Exception if queue if full
   */
   public void add(E x) throws Exception
   {
      if(isFull())
         throw new Exception("Queue is Full");
      elements[rear] = x;
      rear = (rear + 1) % elements.length;
      count ++;
   }
   
   /**
   Removes the first object from the queue.
   @return The removed object that matches the queue's data type
   @throws Exception if queue is empty
   */
   public E remove() throws Exception
   {
      if(isEmpty())
         throw new Exception("Queue is empty");
      E x = elements[front];
      front = (front + 1) % elements.length;
      count --;
      return x;
   }
   
   /**
   Checks if the queue is full.
   @return true if the queue is full, false otherwise.
   */
   public boolean isFull()
   {
      return elements.length == count;
   }
   
   /**
   Checks if the queue is empty.
   @return true if the queue is empty, false otherwise
   */
   public boolean isEmpty()
   {
      return count == 0;
   }
   
   /**
   Course: CS 2430
   Lab9 is part of Prog 4
   The test bed main for class Queue. It also test the Job class.
   Due Wednesday, November 15, 11:00 p.m.
   */
   public static void main(String [] args) throws Exception 
   {
      System.out.println ( "Declare j1, j2 and j3 as Job" );
      Job j1, j2, j3;
      String temp;
      
      
      System.out.println ( "Declare obj as Object" );
      Object obj;
      
      System.out.println ( "Declare jobQ as Queue of class Job with size 5" );
      Queue jobQ = new Queue<Job>(5);
      
      // Determine if jobQ is empty and display a message
      // Do not use if statement
      System.out.println ( "jobQ is empty, since jobQ.isEmpty() is " 
              + jobQ.isEmpty());

      // Determine if jobQ is full and display a message
      // Do not use if statement
      System.out.println ( "jobQ is not full, since jobQ.isFull() is " 
              + jobQ.isFull());

      System.out.println ( "Create a job with arrival time being 5 and "
              + "assign it to j1");
      j1 = new Job(5);
      
      System.out.println ( "Add j1 to jobQ");
      jobQ.add(j1);
      
      
      // Determine if jobQ is empty and display a message
      // Do not use if statement
      temp = jobQ.isEmpty() ?  "jobQ is empty, since jobQ.isEmpty() is true" 
              :  "jobQ is not empty, since jobQ.isEmpty() is false";
      System.out.println(temp);


      // Determine if jobQ is full and display a message
      // Do not use if statement
      temp = jobQ.isFull() ?  "jobQ is full, since jobQ.isFull() is true"
              :  "jobQ is not full, since jobQ.isFull() is false";
      System.out.println(temp);

      System.out.println ( "Create a job with arrival time being 15 and "
              + "assign it to obj");
      obj = new Job(15);

      
      System.out.println ( "Add obj to jobQ");
      jobQ.add(obj);
      
      System.out.println ( "Create a job with arrival time being 50 and "
              + "assign it to j2");
      j2 = new Job(50);

      
      System.out.println ( "Add j2 to jobQ");
      jobQ.add(j2);
      
      System.out.println ( "Create a job with arrival time being 115 and "
              + "assign it to j3");
      j3 = new Job(115);
      
      System.out.println ( "Add j3 to jobQ");
      jobQ.add(j3);
      
      // Determine if jobQ is empty and display a message
      // Do not use if statement
      temp = jobQ.isEmpty() ?  "jobQ is empty, since jobQ.isEmpty() is true" 
              :  "jobQ is not empty, since jobQ.isEmpty() is false";
      System.out.println(temp);


      // Determine if jobQ is full and display a message
      // Do not use if statement
      temp = jobQ.isFull() ?  "jobQ is full, since jobQ.isFull() is true"
              :  "jobQ is not full, since jobQ.isFull() is false";
      System.out.println(temp);


      System.out.println ( "Create a job with arrival time being 215 and "
              + "assign it to obj");
      obj = new Job(215);
      
      System.out.println ( "Add obj to jobQ");
      jobQ.add(obj);
      
      
      // Determine if jobQ is empty and display a message
      // Do not use if statement
      temp = jobQ.isEmpty() ?  "jobQ is empty, since jobQ.isEmpty() is true" 
              :  "jobQ is not empty, since jobQ.isEmpty() is false";
      System.out.println(temp);


      // Determine if jobQ is full and display a message
      // Do not use if statement
      temp = jobQ.isFull() ?  "jobQ is full, since jobQ.isFull() is true"
              :  "jobQ is not full, since jobQ.isFull() is false";
      System.out.println(temp);
      

      System.out.println ( "Remove the first job from jobQ and assign it "
              + "to obj");
      obj = jobQ.remove();
      
      System.out.println ( "Show obj as a string on a line");
      System.out.println(obj.toString());
      
      
      // Determine if jobQ is empty and display a message
      // Do not use if statement
      temp = jobQ.isEmpty() ?  "jobQ is empty, since jobQ.isEmpty() is true" 
              :  "jobQ is not empty, since jobQ.isEmpty() is false";
      System.out.println(temp);


      // Determine if jobQ is full and display a message
      // Do not use if statement
      temp = jobQ.isFull() ?  "jobQ is full, since jobQ.isFull() is true"
              :  "jobQ is not full, since jobQ.isFull() is false";
      System.out.println(temp);
      

      System.out.println ( "Create a job with arrival time being 250 and "
              + "assign it to obj");
      obj = new Job(250);
      
      System.out.println ( "Add obj to jobQ");
      jobQ.add(obj);
      
      
      // Use a while loop to remove every job in jobQ and 
      // display a message for each removed job as follows:
      // Job removed: J:3/T:50
      while(!jobQ.isEmpty())
      {
         System.out.println("Job removed: "  + jobQ.remove().toString());
      }

      
      // Determine if jobQ is empty and display a message
      // Do not use if statement
      temp = jobQ.isEmpty() ?  "jobQ is empty, since jobQ.isEmpty() is true" 
              :  "jobQ is not empty, since jobQ.isEmpty() is false";
      System.out.println(temp);


      // Determine if jobQ is full and display a message
      // Do not use if statement
      temp = jobQ.isFull() ?  "jobQ is full, since jobQ.isFull() is true"
              :  "jobQ is not full, since jobQ.isFull() is false";
      System.out.println(temp);
      

      System.out.println ( "Reset the job count");
      j1.resetJobCount();
      
      System.out.println ( "Create a job with arrival time being 295 and "
              + "assign it to obj");
      obj = new Job(295);
      
      
      System.out.println ( "Add obj to jobQ");
      jobQ.add(obj);

      // Determine if jobQ is empty and display a message
      // Do not use if statement
      temp = jobQ.isEmpty() ?  "jobQ is empty, since jobQ.isEmpty() is true" 
              :  "jobQ is not empty, since jobQ.isEmpty() is false";
      System.out.println(temp);


      // Determine if jobQ is full and display a message
      // Do not use if statement
      temp = jobQ.isFull() ?  "jobQ is full, since jobQ.isFull() is true"
              :  "jobQ is not full, since jobQ.isFull() is false";
      System.out.println(temp);
      

      System.out.println ( "Create a job with arrival time being 305 and "
              + "assign it to obj");
      obj = new Job(305);
      
      
      System.out.println ( "Add obj to jobQ");
      jobQ.add(obj);

      // Use a while loop to remove every job in jobQ and 
      // display a message for each removed job as follows:
      // Job removed: J:3/T:50
      while(!jobQ.isEmpty())
      {
         System.out.println("Job removed: "  + jobQ.remove().toString());
      }

      
      // Determine if jobQ is empty and display a message
      // Do not use if statement
      temp = jobQ.isEmpty() ?  "jobQ is empty, since jobQ.isEmpty() is true" 
              :  "jobQ is not empty, since jobQ.isEmpty() is false";
      System.out.println(temp);


      // Determine if jobQ is full and display a message
      // Do not use if statement
      temp = jobQ.isFull() ?  "jobQ is full, since jobQ.isFull() is true"
              :  "jobQ is not full, since jobQ.isFull() is false";
      System.out.println(temp);
      
   }   
}
