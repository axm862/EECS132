/**
 * @author Aditya Malik
 * execute - takes a state and updates the state to the set value of the variable
 * toString - returns a string that contains the variables string value
 * toStringTabbed - returns a string that is identitcal to what is returned by toString except with a fixed number of tabs chosen by an input int
 **/
public class Assignment implements StatementClass
{
  /**
   * Private fields required by the class
   **/
  private Variable variable = null;
  private ExpressionClass expression = null;
  /**
   * Constructor to replace the default constructor
   * @param variable - the variable input number
   * @param expression - the expression taken in by the user
   **/
  public Assignment(Variable variable, ExpressionClass expression)
  {
    this.variable = variable;
    this.expression = expression;
  }
  /**
   * Takes a state and updates the state to set the value of the variable to be ethe value of the expression
   * @param inputState - the state of the input that is given by the user
   * @return void
   **/
  public void execute(State inputState)
  {
    inputState.update(variable.toString(), expression.value(inputState));
  }
  /**
   * Returns a string that contains the variables string value in representation
   * @return String - the string returned is the string representation of the state values
   **/
  public String toString()
  {
    return (variable.toString() + " := " +expression.toString() + ";\n");
  }
   /**
   * Returns a string that is identical to toString except has a fixed number of tabs determined by inputInt
   * @param inputInt - the number of tabs to be determined
   * @return String - the resulting string of the state values with operand and fixed tabs
   **/
  public String toStringTabbed(int inputInt)
  {
    StringBuilder b = new StringBuilder();
    /**
     * Running a while loop to add the tabs
     **/
    while(inputInt > 0)
    {
      b.append("\t");
      inputInt --;
    }
    b.append(variable.toString() + " := " + expression.toString() + ";\n");
    return b.toString();
  }
}