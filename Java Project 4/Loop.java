/**
 * @author Aditya Malik
 * execute - Takes in a state and at each iteration of the loop, state is used to get the 
 * value of the condition and it executes while its true
 * toString - the string representation of what is happening in the execute method
 * toStringTabbed - returns the same thing as toString but with a certain amount of tabs as
 * given by an input int
 **/
public class Loop implements StatementClass
{
  /**
   * The private fields created as required by the class
   **/
  private BooleanExpressionClass booleanExpression = null;
  private StatementClass statement = null;
  /**
   * The constructor to replace the default constructor that takes in a booleanExpression
   * and a statement
   * @param booleanExpression - the given booleanExpression by the user for input
   * @param statement - the given statement by the user for input of the methods
   **/
  public Loop(BooleanExpressionClass booleanExpression, StatementClass statement)
  {
    this.booleanExpression = booleanExpression;
    this.statement = statement;
  }
  /**
   * This method takes in the state and at each iteration of the loop the state is used to get the
   * value of the condition
   * @param inputState - the state of the input as given by the user
   **/
  public void execute(State inputState)
  {
    while(booleanExpression.value(inputState) == true)
    {
      statement.execute(inputState);
    }
  }
  /**
   * The string representation of what is happening in the execute method put into a orderly
   * manner
   * @preturn String - Returns the string of the representation of the execute method
   **/
  public String toString()
  {
    return ("while (" + booleanExpression.toString() + ")\n" + statement.toStringTabbed(1));
  }
  /**
   * This method prints the same thing as the toString except with a certain amount of tabs
   * as given by the input
   * @param inputInt - the number of tabs to be placed into the String
   * @return String - the resulting string of the tabs along with the toString representation
   **/
  public String toStringTabbed(int inputInt)
  {
    StringBuilder b = new StringBuilder();
    /**
     * This for loop runs through the inputInt adding tabs whenever necessary
     **/
    for(int i = inputInt; i > 0; i--)
    {
      b.append("\t");
    }
    b.append("while (" + booleanExpression.toString() + ")\n" + statement.toStringTabbed(inputInt + 1));
    return b.toString();
  }
}
            