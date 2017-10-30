/**
 * @author Aditya Malik
 * execute - takes in a state and using the state it gets the value of the condition. If the 
 * conditions value is true the state runs the then statement, else it runs the else statement
 * toString - returns the string representation of what is done in the execute method
 * toStringTabbed - returns the same thing as the toString but adds a certain number of tabs
 * given by the input int
 **/
public class ConditionalStatement implements StatementClass
{
   /**
    * The required private fields by the class
   **/
  private BooleanExpressionClass booleanExpression = null;
  private StatementClass thenStatement = null;
  private StatementClass elseStatement = null;
  /**
   * Constructor created to replace the default constructor
   * @param booleanExpression - the expression that is given
   * @param thenStatement - the "then" end of the statement for the expressions
   * @param elseStatement - the "else" end of the statement for the expressions
   **/
  public ConditionalStatement(BooleanExpressionClass booleanExpression, StatementClass thenStatement, StatementClass elseStatement)
  {
    this.booleanExpression = booleanExpression;
    this.thenStatement = thenStatement;
    this.elseStatement = elseStatement;
  }
   /**
   * This method takes in a state and using that, it decides which statement to run, either then
   * or else statements
   * @param inputState - the state of the input given by the user
   **/
  public void execute(State inputState)
  {
    if(booleanExpression.value(inputState) == true)
    {
      thenStatement.execute(inputState);
    }
    else
    {
      elseStatement.execute(inputState);
    }
  }
   /**
   * Returns the string representation of the execute method
   * @return String - the actual string of the method given and calls toStringTabbed as well
   **/
  public String toString()
  {
    return ("if (" + booleanExpression.toString() + ")\n" + 
            thenStatement.toStringTabbed(1) + "else\n" + elseStatement.toStringTabbed(1));
  }
   /**
   * This method returns the same thing as the toString except with a set number of tabs given
   * by the int inputInt
   * @param inputInt - the number of tabs to be placed into the string
   * @return String - the string representation with the given tabs of the execute method
   **/
  public String toStringTabbed(int inputInt)
  {
    StringBuilder b = new StringBuilder();
     /**
     * for loop to run through and add tabs to the sections needed
     **/
    for(int i = inputInt; i > 0; i--)
    {
      b.append("\t");
    }
    b.append("if (" + booleanExpression.toString() + ")\n" + thenStatement.toStringTabbed(inputInt + 1));
     /**
     * for loop to run through and add tabs to the sections needed
     **/
    for(int j = inputInt; j > 0; j--)
    {
      b.append("\t");
    }
    b.append("else\n" + elseStatement.toStringTabbed(inputInt + 1));
    return b.toString();
  }
}