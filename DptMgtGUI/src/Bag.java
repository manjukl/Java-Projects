/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**

 @author koenenm and manjukl
 */
public class Bag
{

   private Object[] items;
   private int numItems = 0;

   public Bag()
   {
      items = new Object[1];
   }
   
   @Override
   public String toString()
   {
       String total = "";
       for (int i = 0; i < numItems; i++)
       {
           total += items[i].toString();
           total += "\n";
       }
       return total;
   }
   
   public Object get(int index)
   {
        return items[index];
   }
           

   public void grow()
   {
      Object[] newItems = new Object[items.length + 1];
      for (int i = 0; i < items.length; i++)
      {
         newItems[i] = items[i];
      }
      items = newItems;
   }

   public void add(Object obj)
   {
      if (numItems == items.length)
      {
         grow();
      }
      items[numItems] = obj;
      numItems++;
   }

   public void remove(Object obj)
   {
      int foundIndex = find(obj);

      if (foundIndex != -1)
      {
         for (int i = foundIndex; i < items.length - 1; i++)
         {
            items[i] = items[i + 1]; //Overwrite
         }
         numItems -= 1;
      }
   }

   public Object contains(Object obj)
   {
      int foundIndex = find(obj);
      if (foundIndex != -1)
      {
         return items[foundIndex];
      }
      return null;
   }

   public int find(Object obj)
   {
      for (int i = 0; i < items.length; i++)
      {
         if (obj.equals(items[i]))
         {
            return i;
         }
      }
      return -1;
   }
}
