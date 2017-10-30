/**
 * @author Aditya Malik
 * value - takes a state as input and returns the boolean value that is the result of applying the
 * operator after applying each of the conditions
 * toString - returns the string representation of the result of value
 **/
public class BooleanOperation implements BooleanExpressionClass
{
  /**
   * creates the required fields by the class
   **/
  private Operator operator = null;
  private Comparison expressionOne = null;
  private Comparison expressionTwo = null;
  private boolean storedValue = false;
  public enum Operator { And, Or;}
  /**
   * Constructor to replace the default constructor
   * @param operator - the operator that is used to compare the expressions
   * @param expressionOne - the left hand of the expression 
   * @param expressionTwo - the right hand of the expression
   **/
  public BooleanOperation(Operator operator, Comparison expressionOne, Comparison expressionTwo)
  {
    this.operator = operator;
    this.expressionOne = expressionOne;
    this.expressionTwo = expressionTwo;
  }
   /**
   * This method is to return the boolean value once the operator is applied 
   * @param inputState - the state of the input given by the user
   * @return boolean - returns true or false if the operation holds true or false
   **/
  public boolean value(State inputState)
  {
    /**
     * Use of switch statement to quickly find which case we are dealing with 
     **/
    switch(operator)
    {
      case And:
        storedValue = (expressionOne.value(inputState) && expressionTwo.value(inputState));
        break;
      case Or:
        storedValue = (expressionOne.value(inputState) || expressionTwo.value(inputState));
        break;
    }
    return storedValue;
  }
   /**
   * Returns the string representation of the value method
   * @return String - The string represntation of the value method, given by the left hand expression, operation, and right hand expression
   **/
  public String toString()
  {
    /**
     * Use of switch statement to quickly find which operator we are using
     **/
    switch(operator)
    {
      case And:
        return (expressionOne.toString() + " && " + expressionTwo.toString());
      case Or:
        return (expressionOne.toString() + " || " + expressionTwo.toString());
      default:
        return "";
    }
  }
}
  