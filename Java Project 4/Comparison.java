/**
 * @author Aditya Malik
 * value - takes a state as input and returns the boolean value that is the result of applying the 
 * operations to the expressions
 * toString - returns the string representation of what is done in value
 **/
public class Comparison implements BooleanExpressionClass
{
  /**
   * Creates the required fields for the class
   **/
  private Operator operator = null;
  private ExpressionClass expressionOne = null;
  private ExpressionClass expressionTwo = null;
  private boolean storedValue = false;
  public enum Operator { LT, LTE, GT, GTE, EQ, NEQ; }
  /**
   * Creates a constructor to replace the default constructor 
   * @param operator - the operator that we are dealing with
   * @param expressionOne - the left hand expression 
   * @param expressionTwo - the right hand expression 
   **/
  public Comparison(Operator operator, ExpressionClass expressionOne, ExpressionClass expressionTwo)
  {
    this.operator = operator;
    this.expressionOne = expressionOne;
    this.expressionTwo = expressionTwo;
  }
  /**
   * Takes a state as input and returns the boolean value that is the result of applying the operation to the left 
   * hand and right hand expressions
   * @param inputState - the state of the input given by the user
   * @return boolean - returns true or false depending on which operation is chosen 
   **/
  public boolean value(State inputState)
  {
    /**
     * Switch statement used to quickly find which operator we are dealing with
     **/
    switch(operator)
    {
      case LT:
        storedValue = (expressionOne.value(inputState) < expressionTwo.value(inputState));
        break;
      case LTE: 
        storedValue = (expressionOne.value(inputState) <= expressionTwo.value(inputState));
        break;
      case GT: 
        storedValue = (expressionOne.value(inputState) > expressionTwo.value(inputState));
        break;
      case GTE:
        storedValue = (expressionOne.value(inputState) >= expressionTwo.value(inputState));
        break;
      case EQ:
        storedValue = (expressionOne.value(inputState) == expressionTwo.value(inputState));
        break;
      case NEQ:
        storedValue = (expressionOne.value(inputState) != expressionTwo.value(inputState));
        break;
    }
    return storedValue;
  }
   /**
   * Returns the string representation of what is done in the value method
   * @return String - the string represnetation of the left hand expression, operand, and right
   * hand expression
   **/
  public String toString()
  {
    /**
     * Switch statement used to find which operator we are dealing with
     **/
    switch(operator)
    {
      case LT:
        return (expressionOne.toString() + " < " + expressionTwo.toString());
      case LTE:
        return (expressionOne.toString() + " <= " + expressionTwo.toString());
      case GT:
        return (expressionOne.toString() + " > " + expressionTwo.toString());
      case GTE:
        return (expressionOne.toString() + " >= " + expressionTwo.toString());
      case EQ:
        return (expressionOne.toString() + " == " + expressionTwo.toString());
      case NEQ: 
        return (expressionOne.toString() + " != " + expressionTwo.toString());
      default:
        return "";
    }
  }
}