/**
This class handles all necessary operations that the vectors have 
to be able to carry out 
@author manjukl
*/
public class TVector 
{
   private final int N = 4;             // Dimension of vectors
   private long [] vect = new long[N];

   /**
   This is a TVector constructor where the array to read the string is 
   declared and initialized
   @param v is the passed string 
   */
   public TVector ( String v )
   {
      // Use split to parse v
      String toks [];
      toks = v.split("[(,)]");
      for(int i = 0; i < N; i++)
      {
         vect[i] = Long.parseLong(toks[i + 1]);
      }
   }

   /**
   This is a TVector constructor where the all the elements in the array are
   initialized.
   @param a is the assigned first element of the array
   @param b is the assigned second element of the array
   @param c is the assigned third element of the array
   @param d is the assigned fourth element of the array
   */
   public TVector(long a, long b, long c, long d) //long
   {
      vect[0] = a;
      vect[1] = b;
      vect[2] = c;
      vect[3] = d;
   }
    
   /**
   This is a TVector copy constructor
   @param tvec is the new TVector created
   */
   public TVector(TVector tvec)
   {
      for (int i = 0; i < N; i++)
      {
         vect[i] = tvec.vect[i];
      }
   }
    
   /**
   This is a toString method that prints out the desired output.
   */
   @Override
   public String toString()
   {
      return "(" + vect[0] + "," + vect[1] + "," + vect[2] + "," + vect[3]
         + ")";
   }
   
   /**
   This is an equals method that checks if two vectors are equal
   @param obj is used to make an instance of TVecotr
   @return true if the vectors are equal
   */
   @Override
   public boolean equals(Object obj)
   {
      if(obj instanceof TVector)
      {
         TVector temp = (TVector) obj;
         for(int i = 0; i < N; i++)
         {
            if(this.vect[i] != temp.vect[i])
               return false;
         }
         return true;
      }
      return false; 
   }
   
   /**
   This method creates a new vector and adds it to the passed vector
   @param vec is the passed vector
   */
   public TVector sum(TVector vec)
   {
      TVector tvec = new TVector(this);
      for(int i = 0; i < N; i++)
         tvec.vect[i] += vec.vect[i];
      return tvec;
   }
    
   /**
   This method creates a new vector and subtracts a passed vector from it
   @param vec is the passed vector
   */
   public TVector subtract(TVector vec)
   {
      TVector tvec = new TVector(this);
      for(int i = 0; i < N; i++)
         tvec.vect[i] -= vec.vect[i];
      return tvec;
   }
   
   /**
   This method creates a new vector and multiplies it to the passed vector
   @param vec is the passed vector
   */
   public TVector multiply(TVector vec)
   {
      TVector tvec = new TVector(this);
      for(int i = 0; i < N; i++)
         tvec.vect[i] *= vec.vect[i];
      return tvec;
   }
   
   public static void main (String args[])
   {
      System.out.println("Declar three variables v1, v2 and v3 of class "
              + "TVector.");
         TVector v1;
         TVector v2;
         TVector v3;

      System.out.println("Declare variable obj of class Object.");
         Object obj;

      System.out.println("Create a TVector with (45,3,325,3) and assign it "
              + "to v1.");
         v1 = new TVector(45,3,325,3);

      System.out.println("Create a TVector with (-4,6,12,9) and assign it "
              + "to v2.");
         v2 = new TVector(-4,6,12,9);

      System.out.println("Display v1 as string");
      System.out.println(v1.toString());

      System.out.println("Display v2 as string");
      System.out.println(v2.toString());

      System.out.println("Assign v1 to obj.");
         obj = v1;

      System.out.println("Copy v1 to v3.");
         v3 = new TVector(v1);

      System.out.println("Display obj as string.");
         System.out.println(obj.toString());

      System.out.println("Display v3 as string.");
         System.out.println(v3.toString());

      // Complete the if condition
      if (obj == v1 )
         System.out.println("obj and v1 point to the same object");
      else
         System.out.println("obj and v1 point to different objects");

      // Complete the if condition
      if ( obj == v3)
         System.out.println("obj and v3 point to the same object");
      else
         System.out.println("obj and v3 point to different objects");

      // Complete the if condition
      if (obj.equals(v1))
         System.out.println("obj equals v1");
      else
         System.out.println("obj does not equal v1");

      // Complete the if condition
      if (obj.equals(v3))
         System.out.println("obj equals v3");
      else
         System.out.println("obj does not equal v3");

      System.out.println("Add v1 and v2 and assign the sum to obj");
         obj = v1.sum(v2);

      System.out.println("Display obj as string.");
       System.out.println(obj.toString());

      System.out.println("Subtract v2 from v1 and assign the difference "
              + "to v3.");
      v3 = v1.subtract(v2);

      System.out.println("Display v3 as string.");
      System.out.println(v3.toString());

      System.out.println("Multiple v1 and v2 and assign the product to v3.");
      v3 = v1.multiply(v2);

      System.out.println("Display v3 as string.");
      System.out.println(v3.toString());

      System.out.println("Assign obj an object of Stack of size 3.");
      obj = new Stack(3);
      

      // Complete the if condition
      if (obj == v1 )
         System.out.println("obj and v1 point to the same object");
      else
         System.out.println("obj and v1 point to different objects");

      // Complete the if condition
      if (obj.equals(v1))
         System.out.println("obj equals v1");
      else
         System.out.println("obj does not equal v1");

      System.out.println("Declare a variable myStack of class Stack and "
              + "assign stack obj to it");
      Stack myStack = (Stack)obj;

      // Complete the if condition
      if (myStack.isEmpty() )
         System.out.println("myStack is empty");
      else
         System.out.println("myStack is not empty");

      // Complete the if condition
      if (myStack.isFull())
         System.out.println("myStack is full");
      else
         System.out.println("myStack is not full");

      System.out.println("Push v1 to myStack.");
      myStack.push(v1);

      System.out.println("Push v2 to myStack.");
      myStack.push(v2);

      System.out.println("Push v3 to myStack.");
      myStack.push(v3);

      // Complete the if condition
      if (myStack.isEmpty())
         System.out.println("myStack is empty");
      else
         System.out.println("myStack is not empty");

      // Complete the if condition
      if (myStack.isFull())
         System.out.println("myStack is full");
      else
         System.out.println("myStack is not full");

      System.out.println("Pop an object from myStack and assign it to obj");
      obj = myStack.pop();

      System.out.println("Add obj to v1");
      v1 = v1.sum((TVector)obj);

      System.out.println("push v1 into myStack");
      myStack.push(v1);

      System.out.println("Pop an object from myStack and assign it to v1");
      v1 = (TVector)myStack.pop();

      System.out.println("Pop an object from myStack and assign it to obj");
      obj = myStack.pop();

      System.out.println("Display v1 as string");
      System.out.println(v1.toString());

      System.out.println("Display obj as string");
      System.out.println(obj.toString());

      System.out.println("Assign the product of v1 and obj to v3");
      v3 = v1.multiply((TVector)obj);

      System.out.println("Assign the different of v1 and obj to v2");
      v2 = v1.subtract((TVector)obj);

      System.out.println("Assign the sum of v1 and obj to v1");
      v1 = v1.sum((TVector)obj);

      System.out.println("Display v1 as string");
      System.out.println(v1.toString());

      System.out.println("Display v2 as string");
      System.out.println(v2.toString());

      System.out.println("Display v3 as string");
      System.out.println(v3.toString());

      System.out.println("Pop on object from myStack and assign it to obj");
      obj = myStack.pop();

      System.out.println("Display obj as string");
      System.out.println(obj.toString());
     
      System.out.println("Assign the product of v1 and obj to v3");
      v3 = v1.multiply((TVector)obj);

      System.out.println("Assign the different of v1 and obj to v2");
      v2 = v1.subtract((TVector)obj);

      System.out.println("Assign the sum of v1 and obj to v1");
      v1 = v1.sum((TVector)obj);

      System.out.println("Display v1 as string");
      System.out.println(v1.toString());
      
      System.out.println("Display v2 as string");
      System.out.println(v2.toString());
     
      System.out.println("Display v3 as string");
      System.out.println(v3.toString());
      
      // Complete the if condition
      if (myStack.isEmpty())
         System.out.println("myStack is empty");
      else
         System.out.println("myStack is not empty");

      // Complete the if condition
      if (myStack.isFull())
         System.out.println("myStack is full");
      else
         System.out.println("myStack is not full");
   }
   
}
