/**
 This class is essentially the brain of the package. It runs the main menu
 which calls in the command menu from the Department class. It also includes
 the static Scanner which is used in Department.

 @author mattk
 */
public class DepartmentManagement
{
   public static Bag deptBag = new Bag();
   public static int deptCount = 0;

   public Object readIn(String deptName)
   {
      Department currentDept = new Department(deptName);
      if (deptBag.contains(currentDept) == null)
      {
         deptBag.add(currentDept);
         deptCount++;
      }
      return deptBag.contains(currentDept);
   }
}