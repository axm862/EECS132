/**
 * @author Aditya Malik
 * value - Takes in a state and returns an int; for each variable it updates the state with
 * that variable
 * toString - Returns the string representation of each of the arguments of the function call 
 * in a neat and organized manner
 **/
public class FunctionCall implements ExpressionClass
{
  /**
   * The private fields as required by the class
   **/
  private Function function = null;
  private ExpressionClass[] expression = null;
  /**
   * Constructor to replace the default constructor that takes in a function and expression
   * @param function - the given function as by the user
   * @param expression - the array of expressions given by the users input
   **/
  public FunctionCall(Function function, ExpressionClass[] expression)
  {
    this.function = function;
    this.expression = expression;
  }
  /**
   * This method takes in the inputState and returns as int that it updates the state with each
   * variable
   * @param inputState - the state of the input as given by the user
   * @return int - The integer representation of the newly formed state
   **/
  public int value(State inputState)
  {
    State newState = new State();
    /**
     * Runs through the length of the input expression
     **/
    for(int i = 0; i < expression.length; i++)
    {
      newState.update(function.getVariable()[i].toString(), expression[i].value(inputState));
    }
    function.getStatement().execute(newState);
    return newState.lookup("return");
  }
  /**
   * Returns the string representation of each of the arguments of the function call in an 
   * organized fashion
   * @return String - The output string after the arguments have been added
   **/
  public String toString()
  {
    StringBuilder b = new StringBuilder();
    b.append(function.getName() + "(");
    /**
     * Runs through the length of the input expession
     **/
    for(int i = 0; i < expression.length - 1; i++)
    {
      b.append(expression[i].toString() + ", ");
    }
    b.append(expression[expression.length - 1].toString() + ")");
    return b.toString();
  }
}