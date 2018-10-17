/**
This is the stack class that deals with necessary operations that a stack
of objects has to be able to carry out. Such operations include adding
an object to a stack, removing an object from the stack and checking if
the stack is empty or not.
@author manjukl
*/
public class Stack 
{
   private Object [] items;
   private int top;

   /**
   This is a stack constructor that initializes the array and top(keeps
   record of the next available index in the array).
   @param size  of the array
   */
   public Stack(int size)
   {
      items = new Object[size];
      top = 0;
   }

   /**
   This method adds an element(object) to the stack
   @param obj to be added to the array
   */
   public void push(Object obj)
   {
      items[top++] = obj;
   }

   /**
   This method deletes an element(object) from the stack
   @return obj that was deleted from the stack
   */
   public Object pop()
   {
      Object obj = items[--top];
      return obj;
   }

   /**
   This method checks if the stack is full
   @return true if the array is full
   */
   public boolean isFull()
   {
      return top == items.length;
   }

   /**
   This method checks if the stack is empty
   @return true if the top is zero which means the array is empty
   */
   public boolean isEmpty()
   {
      return top == 0;
   }

}
