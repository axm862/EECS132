import org.junit.*;
import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.*;
public class JUnitTestProject5
{
 /**
  * The JUnit testing for the Contact Class
  * @author Aditya Malik
  **/  
  @Test
  public void testContactClass() 
  {
    Contact contact1 = new Contact("Aditya","000","axm@case");
    Contact contact2 = new Contact("Jason","235","jay@case");
    Contact contact3 = new Contact("Malik", "548", "mal@case");
    assertEquals("getName", "Jason", contact2.getName());
    assertEquals("getNumber", "235", contact2.getPhoneNumber());
    assertEquals("getEmail", "jay@case", contact2.getEmail());
    contact1.setName("Aditya");
    contact1.setPhoneNumber("000");
    contact1.setEmail("axm@case");
    System.out.println(contact3.toString());
    System.out.println(contact2.toString());
    assertEquals("setName", "Malik", contact3.getName());
    assertEquals("setNumber", "548", contact3.getPhoneNumber());
    assertEquals("setEmail", "mal@case", contact3.getEmail());
    assertEquals("toString", "Malik 548 mal@case", contact3.toString());
    assertEquals("equals", false, contact1.equals(contact2));
    assertEquals("equals", true, contact1.equals(contact3));
  }
  
  /**
   * The JUnit testing for the ContactDatabase Class
   **/
  @Test
  public void testContactDatabase() 
  {
    LinkedList<Contact> aLinkedList = new LinkedList<Contact>();
    Contact testContact = new Contact("Aditya","159","axm@case");
    aLinkedList.add(testContact);
    assertEquals("printList", "Aditya 159 axm@case", anArrayList.printList(aLinkedList));
    anArrayList.printList(aLinkedList);
  }
  
  /**
   * The JUnit testing for the Database Class
   **/
  @Test
  public void testDatabase() 
  {
    DatabaseTest test = new DatabaseTest();
    Contact testContact = new Contact("Aditya","159","axm@case");
    assertEquals("add", "Aditya 159 axm@case", test.add(testContact));
    assertEquals("delete", "Aditya 159 axm@case", test.delete(testContact));
  }
}