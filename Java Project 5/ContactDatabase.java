import java.util.Scanner;
import java.util.*;
import java.util.LinkedList;
/**
 * The database that stores all the contacts
 * @author Aditya Malik
 */ 

public class ContactDatabase<E extends DatabaseType> extends Database 
{
   /**
   * This method prints all the contacts in a list that are stored in the iterable
   * @param contact - takes input of an iterable that contains various contacts
   * @return prints a lost of all the contacts that are stored 
   */ 
  public void printList(Iterable<Contact> contact) 
  {
    int i = 1;
    //goes through the iterable searching for contacts and printing them out
    for(Contact aContact : contact) 
    {
      System.out.println("" + i + aContact.toString());
      i++;
    }
  }
  
  /**
   * The main method will create the ContactDatabase by taking inputs which determines both what data to store and what methods to call 
   */ 
  public static void  main(String[] args)  
  {
    //creating a new contactDatabase 
    ContactDatabase contactDatabase = new ContactDatabase();
    //stores users input string
    Scanner scanner = new Scanner (System.in);
    //tests to see if the find was the last to be called
    boolean booleanTest = false;
    //A sring that will store data and be used to compare and add parts of a method to 
    String command = "";
    //A arraylist used in the code 
    ArrayList anArrayList = null;
    //A linked list used in the code 
    LinkedList aLinkedList = null;
    System.out.print("Enter a command: ");
    command = scanner.next();
    //Will test to see what the user has inputted and will run commands accordingly
    while(!command.equalsIgnoreCase("quit")) 
    {
      String[] arrayOfString = new String[3];
      if(command.startsWith("add")) 
      {
        arrayOfString = new String[3];
        //Cycles through the array and stores the input by the user
        for(int i = 0; i < 3; i++) 
        {
          arrayOfString[i] = scanner.next();
        }
        command = scanner.next();
        //Creates a new contact based on user input and adds it to the database
        Contact contact = new Contact(arrayOfString[0], arrayOfString[1], arrayOfString[2]);
        contactDatabase.add(contact);
      }
      else if(command.startsWith("listby")) 
      {
        command = scanner.next();
        anArrayList = contactDatabase.getList(command);
        contactDatabase.printList(anArrayList);
        command = scanner.next();
        //sets the test to false
        booleanTest = false;
      }
      else if(command.equals("find")) 
      {
        Contact contact2 = null;
        command = scanner.next();
        //adds new contact by the input name
        if(command.equals("name")) 
        {
          contact2 = new Contact(scanner.next(), null, null);
        }
        //adds new contact by the phone number
        else if(command.equals("phonenumber")) 
        {
          contact2 = new Contact(null, scanner.next(), null);
        }
        //adds new contact by the email address
        else if(command.equals("email")) 
        {
          contact2 = new Contact(null, null, scanner.next());
        }
        aLinkedList = contactDatabase.lookup(command, contact2);
        contactDatabase.printList(aLinkedList);
        command = scanner.next();
        //sets the test to true
        booleanTest = true;
      }
      else if(command.equals("delete")) 
      {
        command = scanner.next();
        //removes the parts from the linkedLists
        if(booleanTest && aLinkedList != null) 
        {
          aLinkedList.remove(Integer.parseInt(command));
        }
        else if(!booleanTest && anArrayList != null)
        {
          aLinkedList.remove(Integer.parseInt(command));
        }
        else 
        {
          System.out.println("Nothing found");
        }
        command = scanner.next();
      }
      //makes the index
      else if(command.equals("makeindex")) 
      {
        command = scanner.next();
        contactDatabase.makeIndex(command);
        command = scanner.next();
      }
      else
      {
        System.out.println("Not a valid command");
        command = scanner.next();
      }
    }
    //if the user quits the database
    if(command.equals("quit")) 
    {
     scanner.close();
    }    
  } 
}