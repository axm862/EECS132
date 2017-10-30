/**
 * @author Aditya Malik
 * execute - takes in a state and updates the state to the value of return to have the value
 * of the expression
 * toString - returns a string that represents what is happening in the execute method
 * toStringTabbed - returns a string that is similar to toString except with a certain number
 * of tabs as given by an input int
 **/
public class Return implements StatementClass
{
  /**
   * The private field as required by the class
   **/
  private ExpressionClass expression = null;
  /**
   * A constructor that takes in an expression and replaces the default constructor
   * @param expression - the given input expression by the user to run through the methods
   **/
  public Return(ExpressionClass expression)
  {
    this.expression = expression;
  }
  /**
   * This method updates the state to set the value of a variable return to have the value of
   * the expression
   * @param inputState - the state of the input as given by the user
   **/
  public void execute(State inputState)
  {
    inputState.update("return ", expression.value(inputState));
  }
  /**
   * This method returns a string that is a visual representation of what is happening in the
   * execute method in a nice and orderly manner
   **/
  public String toString()
  {
    return ("return " + expression.toString() + ";\n");
  }
  /**
   * This method returns a string that is similar to toString except with a certain number of
   * tabs as given by the input int
   * @param inputInt - the number of tabs to be placed into the string
   * @return String - the output string which is the same as toString but with included tabs
   **/
  public String toStringTabbed(int inputInt)
  {
    StringBuilder b = new StringBuilder();
    /**
     * While loop used to run through and add tabs whenever required
     **/
    while(inputInt > 0)
    {
      b.append("\t");
      inputInt --;
    }
    b.append("return " + expression.toString() + ";\n");
    return b.toString();
  }
}