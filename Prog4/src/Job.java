/**
Class Job holds data for a job. It has internal variables to hold the arrival
time of the job and the job number. Contains methods to convert the job data
to a string for printing, get the arrival time of a given job and reset the 
job count.
@author Thomas Leuenberger, Lizkebe Manjuk
*/

public class Job 
{
   private static int jobCount = 0;    // Total count of jobs created   
   private int jobNumber;              // Set to incremented jobCount
   private int arrivalTime;
   
   /**
   Constructor to create a new job object with the given arrival time
   @param arriveTime integer of the time at which the job arrives
   */
   public Job(int arriveTime)
   {
      this.arrivalTime = arriveTime;
      this.jobCount++;
      this.jobNumber = this.jobCount;
   }
   
   /**
   Converts the job object's data to a string for printing.
   @return String containing the job object's data in the desired format
   */
   @Override
   public String toString()
   {
      String temp;
      temp = "J:" + this.jobNumber + "/T:" + this.arrivalTime;
      return temp;
   }
   
   /**
   Gets the arrival time of the job.
   @return integer of the arrival time
   */
   public int getArrival()
   {
      return this.arrivalTime;
   }
   
   /**
   Resets the job count.
   */
   public static void resetJobCount()
   {
      jobCount = 0;
   }   
}
