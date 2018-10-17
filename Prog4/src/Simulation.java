/**

 @author leuenbergert
 */
import java.util.*;

public class Simulation
{
   private int numArrivals, numWaiting, numServIm, maxWait, arr_min, arr_max,
      sc_min, sc_max, stopTime, currTime, arrivalTime, 
      nextEventTime, serviceCompletionTime, nextArrival, nextCompletion,
      currentMax, arrivT;
private Queue Q;
   // current job being processed, null if none
   private Job curProcessed = null;
   private Job job2;
   private int numArriv = 0, numComp = 0;
   private int [] compList = new int[10];
   private int [] arrivList = new int[10];
   private Random arrivalRandNumGen = new Random(2345);
   private Random completionRandNumGen = new Random(5432);
   private int numComp2 = 0;
   
   public Simulation(int ar_min, int ar_max, int sc_min, int sc_max, 
           int stop_time)
   {
      numArrivals = numWaiting = numServIm = maxWait = currTime = 
         nextEventTime = nextArrival = nextCompletion = currentMax = 
         arrivalTime = serviceCompletionTime = 0; 
      this.arr_max = ar_max;
      this.arr_min = ar_min;
      this.sc_min = sc_min;
      this.sc_max = sc_max;
      this.stopTime = stop_time;
      Q = new Queue<Job>(stopTime); 
   }   
   
   private int schedualArrival()
   {
      arrivalTime = arr_min 
              + arrivalRandNumGen.nextInt(arr_max - arr_min + 1);      
      arrivalTime = currTime + arrivalTime;
      arrivList[numArriv] = arrivalTime;
      numArriv = (numArriv + 1) % arrivList.length;
      return arrivalTime;
   }
   private void schedualCompletion()
   {
      serviceCompletionTime = sc_min 
         + completionRandNumGen.nextInt(sc_max - sc_min + 1);
      serviceCompletionTime = currTime + serviceCompletionTime;
      compList[numComp] = serviceCompletionTime;
      numComp = (numComp + 1) % compList.length;
   }
   
   private void initilaizeLists()
   {
      compList = new int[10];
      arrivList = new int[10];
      numArriv = numComp = numComp2 = nextEventTime = arrivT = 0;
   }
   
   public void runSimulation()
   {
      int arrival = 0 , completion = 0;
      initilaizeLists();   
      boolean first = true;
      arrivT = schedualArrival();
      while(!(currTime >= stopTime))
      {           
         if(numArriv == 0)
            arrival = arrivList[arrivList.length - 1];
         else
            arrival = arrivList[numArriv - 1];
         completion = compList[numComp2];
         if(arrival < completion)
            nextEventTime = arrival;
         else 
            nextEventTime = completion;
         checkTime(arrival, completion);
         doWork(arrival, completion);
      }     
      job2.resetJobCount();
   }
   
   private void checkTime(int arrival, int completion)
   {
      if(completion < arrival && completion > 1 && curProcessed != null 
                 && completion <= stopTime)
      {
         currTime = completion;
      }
      else if (completion > arrival || currTime == 0 
              || serviceCompletionTime == 0 || curProcessed == null 
              && arrival < stopTime)
      {
         currTime = arrival;
         job2 = new Job(arrivT);
         arrivT = schedualArrival();
      }         
      else
      {
         currTime = arrival;
         if (completion >= stopTime && arrival >= stopTime)
            currTime = stopTime;
         if(arrival <= stopTime)
         {            
            job2 = new Job(arrivT);
            arrivT = schedualArrival();
         }
      }
   }
   
   private void doWork(int arrival, int completion)
   {
      if(currTime == completion)
      {              
         doCompletion();
      }     
      if(currTime == arrival)
      {
         doArrival(job2);
         numArrivals++;
      }   
   }
   
   @Override
   public String toString()
   {
      String temp;
      if(curProcessed == null)
      {
         temp = "Current Job: " + "None" + "\nNum Arrived: " + numArrivals 
                 + "\nNum Waiting: " + numWaiting + "\nNum Served Immed: "
                 + numServIm + "\nMax Waiting Time: " + currentMax;
      }
      else
         temp = "Current Job: " + curProcessed + "\nNum Arrived: "
                 + numArrivals + "\nNum Waiting: " + numWaiting 
                 + "\nNum Served Immed: " + numServIm 
                 + "\nMax Waiting Time: " + currentMax;
      return temp;
   }
   
   private void doCompletion()
   {
      numComp2 = (numComp2 + 1) % compList.length;
      if(Q.isEmpty())
      {
         curProcessed = null;
         numWaiting = 0;
      }
      else
      {
         try
         {
            curProcessed = (Job)Q.remove();
            numWaiting--; 
            schedualCompletion();
            checkZero();

         }
         catch (Exception e)
         {
            System.out.println(e.toString());
         }
      }
   }
   
   private void checkZero()
   {
      if(numComp2 == 0)
      {
         if(compList[compList.length-1] - 
                 curProcessed.getArrival() > currentMax)
         currentMax = compList[compList.length-1] - 
                 curProcessed.getArrival();
      }
      else
      {
         if(compList[numComp2-1] - 
                 curProcessed.getArrival() > currentMax)
         currentMax = compList[numComp2-1] - curProcessed.getArrival();
      }
   }
   
   private void doArrival(Job curJob)
   {
      if(curProcessed == null)
      {
         schedualCompletion();
         curProcessed = curJob;
         numServIm++;
      }
      else
      {
         try
         {
            Q.add(curJob);
            numWaiting++;
         }
         catch (Exception e)
         {
            System.out.println(e.toString());
         }               
      }
   }
}
