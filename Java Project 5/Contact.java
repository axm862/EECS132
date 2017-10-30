import java.util.*;
/**
 * This class stores all the names, numbers, and emails of the contacts
 * @author Aditya Malik
 */

public class Contact extends Object implements DatabaseType 
{
  //stores the contact name for the contact
  private String contactName = "";
  //stores the contact phone number for the contact
  private String contactPhoneNumber = "";
  //stores the contact email address for the contact
  private String contactEmail = "";
  
  /**
   * Constructor for the class that takes in the contact's name, phone number, and email address
   * @param contactName is the contact's name that is to be stored
   * @param contactPhoneNumber is the contact's phone number that is to be stored
   * @param contactEmail is the contact's email address that is to be stored
   */ 
  public Contact(String contactName, String contactPhoneNumber, String contactEmail) 
  {
    this.contactName = contactName;
    this.contactPhoneNumber = contactPhoneNumber;
    this.contactEmail = contactEmail;
  }
  
  /**
   * @return the contact name for the contact
   */ 
  public String getName() 
  {
    return contactName;
  }
  
  /**
   * sets the contact name for the contact
   * @param takes in the contact's name
   */ 
  public void setName(String contactName) 
  {
    this.contactName = contactName;
  }
  
  /**
   * @return the contact phone number for the contact
   */ 
  public String getPhoneNumber() 
  {
    return contactPhoneNumber;
  }
  
  /**
   * sets a phone number for the given contact
   * @param takes the contact's phone number that is to be stored
   */ 
  public void setPhoneNumber(String contactPhoneNumber) 
  {
    this.contactPhoneNumber = contactPhoneNumber;
  }
  
  /**
   * @return the contact email address
   */ 
  public String getEmail() 
  {
    return contactEmail;
  }

  /**
   * sets the contact's email address
   * @param takes in the contact's email address that is to be stored
   */ 
  public void setEmail(String contactEmail) 
  {
    this.contactEmail = contactEmail;
  }
  
  /**
   * @return the contact's contact name, contact phone number, and contact email in the form of a string
   */ 
  @Override
  public String toString() 
  {
    return contactName + " " + contactPhoneNumber + " " + contactEmail;
  }
  
  /**
   * This will be comparing an input contact to the instance of the contact and checking if the two are the same
   * @param inputContact is the input contact given by the user
   * @return either true or false depending on if the input contact already exists within the database
   */ 
  public boolean equals(Object inputContact) 
  {
    if(inputContact instanceof Contact) 
    {
      Contact instanceContact = (Contact)inputContact;
      if((instanceContact.getName() == this.getName()) || (instanceContact.getPhoneNumber() == this.getPhoneNumber()) || (instanceContact.getEmail() == this.getEmail())) 
      {
        return true;
      }
    }
    return true;
  }
  
  /**
   * This method creates a comparator that is to be used by other methods later on
   * @param trait is used to determine which trait in the contact should be compared, and its in the form of a string 
   * @return returns the comparator used  
   */ 
  @Override
  public Comparator<Contact> getComparatorByTrait(String trait) 
  {
    if (trait.equals("contactName"))
    {
      return new Comparator<Contact>() 
      {
        public int compare(Contact firstContact, Contact secondContact)
        {
          return firstContact.getName().compareTo(secondContact.getName());
        }
      };
    }
    else if (trait.equals("contactPhone"))
    {
      return new Comparator<Contact>() 
      {
        public int compare(Contact firstContact, Contact secondContact)
        {
          return firstContact.getPhoneNumber().compareTo(secondContact.getPhoneNumber());
        }
      };
    }
    else if (trait.equals("contactEmail"))
    {
      return new Comparator<Contact>() 
      {
        public int compare(Contact firstContact, Contact secondContact)
        {
          return firstContact.getEmail().compareTo(secondContact.getEmail());
        }
      };
    }
    return null;
  }
}