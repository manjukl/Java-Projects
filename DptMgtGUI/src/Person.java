
/**
 This class is used for storing all of the people ever created in the system
 into one single array. It stores both their id's and names into a list,
 and assigns them all a specific index which may be called later for reference
 in the Department class.

 @author mattk and manjukl
 */
public abstract class Person
{

   protected String id;
   protected String name;
   
   @Override
   public boolean equals(Object obj)
   {
      if (obj instanceof Person)
      {
        Person pers = (Person) obj;
        return this.id.equals(pers.id);
      }
      return false;
   }
   /**
    Constructor. Used in both Student and Professor as a superclass. Takes in
    both name and id of entered person.

    @param name
    @param id
    */
   public Person(String name, String id)
   {
      this.id = id;
      this.name = name;
   }

   /**
    Used to give other classes within the package access to the variable id.

    @return id of person
    */
   public String getId()
   {
      return this.id;
   }

   /**
    Abstract method to give both Student and Professor classes access to
    override for class specific tasks.
    */
   public abstract void register(Course crs);
}
