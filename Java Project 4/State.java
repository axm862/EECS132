/**
 * @author Aditya Malik
 * update - Takes in a variable name and variable value and adds this to the hashtable
 * lookup - Takes in a variable name and returns the int value associated with where the
 * name is stored in the hashtable
 **/
import java.util.*;
public class State
{
  /**
   * Creating the private field hashtable as required by the class
   **/
  private Hashtable<String,Integer> table = new Hashtable<String, Integer>();
  /**
   * This method takes in a variable name and value and adds it to the hashtable
   * @param variableName - the variable name to be placed into the hashtable
   * @param variableValue - the int value to be placed into the hashtable associated with the
   * variableName
   **/
  public void update(String variableName, Integer variableValue)
  {
    table.put(variableName,variableValue);
  }
  /**
   * This method takes in a variable name and returns the associated int value with that variable
   * in the hashtable
   * @param variableName - the name of the variable stored in the hashtable and the int we want to
   * find that is associated with that variable
   * @return int - the integer value of the variableName input
   **/
  public int lookup(String variableName)
  {
    /**
     * While the values of the hashtable are not empty it will get the value from the name
     **/
    if(table.get(variableName) != null)
    {
      Integer variableValue = table.get(variableName);
      return variableValue;
    }
    return 0;
  }
}
  