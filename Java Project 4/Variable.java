/**
 * @author Aditya Malik
 * value - takes a state as input and returns the int value of that number
 * toString - returns the string representation of the numeric value of the number
 **/
public class Variable implements ExpressionClass
{  
  /**
   * The private field as required by the class
   **/
  private String inputString = null;
  /**
   * The constuctor for the class to replace the default constructor; takes in an inputString
   * @param inputString - the input string as given by the user to run through the methods
   **/
  public Variable(String inputString) 
  {
    this.inputString = inputString;
  } 
  /**
   * This method takes a state as input and returns the int value associated with the number
   * @param inputState - the state of the input as given by the user
   * @return int - the returned int value associated with the number of the input state
   **/
  public int value(State inputState) 
  {
    return inputState.lookup(inputString);
  } 
  /**
   * This method returns the string representation of the numeric value of the number
   * @return String - the returned string that represents the numeric value of the number
   **/
  public String toString() 
  {
    return inputString;
  }
}