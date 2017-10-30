import java.util.*;
import java.util.LinkedList;
/*
 * This class shows a database the contains the different DatabaseTypes
 * @author Aditya Malik
 */ 

public class Database<E extends DatabaseType> 
{
  //Creatse the head for the lined list
  private LLNode<E> nodeFront;
  //Creates the hashtable to store the data of the database
  private Hashtable<String, ArrayList<E>> table = new Hashtable<String, ArrayList<E>>();

  /**
   * Adds the element to the database
   * @param element - the element to be added to the database
   */ 
  public void add(E element) 
  {
    this.nodeFront = new LLNode<E>(element, nodeFront);
    this.table.clear();
  }
  
  /**
   * Deletes the element from the database
   * @param element - the element to be removed
   */ 
  public void delete(E element) 
  {
    //A counter used to go through the database
    LLNode<E> count = nodeFront; 
    if(count.getNext() == null && count.getElement().equals(element)) 
    {
      nodeFront = null;
    }
    else if(count.getNext() == null && count.getElement().equals(element))
    {
      nodeFront = count.getNext();
    }
    else if(count.getNext() != null)
    {
      //Cycles through the database and removes values that equal the element
      while(count.getNext() != null)
      {
        if(count.getNext().getNext() != null && count.getNext().equals(element))
        {
          count.setNext(count.getNext().getNext());
        }
        else if(count.getNext().getNext() == null && count.getNext().equals(element))
        {
          count.setNext(null);
        }
        count = count.getNext();
      }
    }
    this.table.clear();
  }

  /**
   * Looks up values on the database and adds them to the linked list
   * @param value - The value checked in the database
   * @param aComparator - The comparator used to compare the two values
   * @return a linked list that contains the values in the database
   */ 
  public LinkedList<E> lookupInList(E value, Comparator aComparator) 
  {
    //Returned linked list
    LinkedList<E> newIndex = new LinkedList<E>();
    //A counter that cycles through the values stored in the loop
    LLNode<E> count = nodeFront;
    //Cycles through the values and stores them in the linked list if they are the same
    while(count.getNext() != null) {
      if(count.getElement().equals(value))
      {
        newIndex.addFirst(value);
      }
    }
    return newIndex;
  }
  
  /**
   * This method returns a linked list that has all the elements matching an input value
   * @param value - The value checked for comparision
   * @param index - The ArrayList in which the value is used to compare each element
   * @param aComparator - The input class used for calling the compare method
   * @return gives a linked list with all the elements that match the value
   */ 
  public LinkedList<E> lookupInIndex(E value, ArrayList<E> index, Comparator<E> aComparator)
  {
    //The index of the desired element
    int elementIndex = Collections.binarySearch(index, value, aComparator);
    //Linked list to store elements similar to printed elements
    LinkedList<E> newList = new LinkedList<E>();
    if(elementIndex >= 0)
    {
      //Counts elements after elementIndex
      int elementAfterIndex = elementIndex + 1;
      //Loops through the elements after elementIndex and searches for similiar ones
      while(aComparator.compare(index.get(elementAfterIndex), value) == 0)
      {
        newList.addFirst(value);
        elementAfterIndex++;
      }
      //Counts elements before the indexElement
      int elementBeforeIndex = elementIndex - 1;
      //Loops through the elements before elementIndex and searches for similiar ones
      while(aComparator.compare(index.get(elementBeforeIndex), value) == 0) 
      {
        newList.addFirst(value);
        elementBeforeIndex--;
      }
      newList.addFirst(value);
    }
    return newList;
  }
  
  /**
   * Creates an ArrayList and copies addresses of elements in the database. It also sorts the ArrayList using comparator and stores the result in the hashtable using a key
   * @param trait - The string used by the arraylist in the hashtable and used to call getComparaotrByTrait method
   */ 
  public void makeIndex(String trait) 
  {
    if(nodeFront != null)
    {
      //The arrayList that stores elements for the database
      ArrayList<E> newList = new ArrayList<E>();
      //A counter used for the elements for the database
      LLNode<E> count = nodeFront;
      //Cycles through the elements in the database and adds them to the ArrayList
      if(nodeFront.getNext() == null) 
      {
        newList.add(count.getElement());
      }
      else if(nodeFront.getNext() != null){
        while(count.getNext() != null)
        {
          newList.add(count.getElement());
          count = count.getNext();
        }
      }
      //Places it in the hashtable and then calls comparator to sort the ArrayList
      table.put(trait, newList);
      Comparator<E> aComparator = nodeFront.getElement().getComparatorByTrait(trait);
      Collections.sort(newList, aComparator);
    }
  }
  
  /**
   * This method searches for a key that matches the input trait. It then calls the loopupInIndex method to see if there is the given element and comparator using the trait
   * @param trait - The string that is the key for the hashtable
   * @param element - The value that is searched through the given linked list
   * @return The linked list
   */ 
  public LinkedList lookup(String trait, E element)
  {
    if(table.containsKey(trait))
    {
      //Compares the elements and calls the lookupInIndex method
      Comparator aComparator = element.getComparatorByTrait(trait);
      return lookupInIndex(element, table.get(trait), aComparator);
    }
    else if(nodeFront != null)
    {
      //Compares the elements and calls the lookupInIndex method
      Comparator aComparator = element.getComparatorByTrait(trait);
      return lookupInList(element, aComparator);
    }
    return new LinkedList<E>();
  }
  
  /**
   * Chekcs to see if the given ArrayList from the hashtable is the same ArrayList that contains the key. If it isn't, it calls the makeIndex method which then creates a new index and returns it
   * @param trait - The string used to look up the hashtable as the key
   * @return The arraylist which contains the key trait
   */ 
  public ArrayList<E> getList(String trait)
  {
    if(!table.containsKey(trait)) 
    {
      makeIndex(trait);
    }
    else
    {
      return table.get(trait);
    }
    return table.get(trait);
  }
}