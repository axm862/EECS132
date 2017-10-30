/**
 *@author Aditya Malik
 * value - takes a state input and returns the int value depending on which operator is chosen
 * toString - return a string that contains the left hand operand, the operator assignment, and then
 * the left hand operand
 **/
public class ArithmeticOperation implements ExpressionClass
{
  /**
   * Creates the private fields required by the class
   **/
  private Operator operator = null;
  private ExpressionClass expressionOne = null;
  private ExpressionClass expressionTwo = null;
  private int storedValue = 0;
  /**Creates the enum Operator
    **/
  public enum Operator {Add, Sub, Mult, Div, Rem; }
  /**Constructor for the class to override default constructor
    * @param operator - the operator that compares the expressions 
    * @param expressionOne - the left hand of the expression
    * @param expressionTwo - the right hand of the expression
    **/
  public ArithmeticOperation(Operator operator, ExpressionClass expressionOne, ExpressionClass expressionTwo)
  {
    this.operator = operator;
    this.expressionOne = expressionOne;
    this.expressionTwo = expressionTwo;
  }
  /**
   * Takes in and input state and returns the int value thats the result of applying the operation
   * @param inputState - the state of the input given
   * @return storedValue - the int value representation of applying the operation
   **/
  public int value(State inputState)
  {
    /**
     * created a switch statement to quickly figure out which operator was chosen
     **/
    switch (operator) 
    {
      case Add:
        storedValue = expressionOne.value(inputState) + expressionTwo.value(inputState);
        break;
      case Sub:
        storedValue = expressionOne.value(inputState) - expressionTwo.value(inputState);
        break;
      case Mult:
        storedValue = expressionOne.value(inputState) * expressionTwo.value(inputState);
        break;
      case Div:
        storedValue = expressionOne.value(inputState) / expressionTwo.value(inputState);
        break;
      case Rem:
        storedValue = expressionOne.value(inputState) % expressionTwo.value(inputState);
        break;
    }
    return storedValue;
  }
  /**
   * returns a string that contains the left hand expression, operation, and right hand expression
   * @return String - returns a string representation of the expressions and operation
   **/
  public String toString()
  {
    /**
     * created a switch statement to quickly figure out which operator is called
     **/
    switch(operator)
    {
      case Add:
        return (expressionOne.toString() + " + " + expressionTwo.toString());
      case Sub:
        return (expressionOne.toString() + " - " + expressionTwo.toString());
      case Mult:
        return (expressionOne.toString() + " * " + expressionTwo.toString());
      case Div:
        return (expressionOne.toString() + " / " + expressionTwo.toString());
      case Rem:
        return (expressionOne.toString() + " % " + expressionTwo.toString());
      default:
        return "";
    }
  }
}
        