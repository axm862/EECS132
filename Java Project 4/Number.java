/**
 * @author Aditya Malik
 * value - takes a state as input and returns the int value of the number
 * toString - returns a string representation of the numeric value of the number
 **/
public class Number implements ExpressionClass
{  
  /**
   * The private field as required by the class
   **/
  private int inputNum = 0;
  /**
   * Constructor to replace the default constructor that takes in an input int
   * @param inputNum - the input number as given by the user to run through the methods
   **/
  public Number(int inputNum) 
  {
    this.inputNum = inputNum;
  }
  /**
   * This method will take in a state as an input and return the int value of that number
   * @param inputState - the state of the input as given by the user
   * @return int - the integer value of the number given by the user
   **/
  public int value(State inputState) 
  {
    return inputState.lookup("" + inputNum);
  }
  /**
   * This method returns the string representation of the numeric value of the number
   * @return String - the String representation of the input number
   **/
  public String toString()
  {
    return Integer.toString(inputNum);
  }
}