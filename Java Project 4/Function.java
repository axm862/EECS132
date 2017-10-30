/**
 * @author Aditya Malik
 * getName - This method simply returns the name of the given input
 * getStatement - This method simply returns the statement of the given input
 * getVariable - This method simply returns the variable of the given input
 * toString - This method simply prints each of the variables of the function in a neat and
 * organized way
 **/
public class Function 
{
  /**
   * Private fields as required by the class
   **/
  private String name = null;
  private StatementClass statement = null;
  private Variable[] variable = null;
  /**
   * Constructor to replace the default constructor by taking in the three parameters
   * @param name - the name of the input
   * @param statement - the given statement by the user
   * @param variable - the array of the given variables by the user
   **/
  public Function(String name, StatementClass statement, Variable[] variable)
  {
    this.name = name;
    this.statement = statement;
    this.variable = variable;
  }
  /**
   * This method simply returns the name of the given input
   * @return String - Returns the name string
   **/
  public String getName()
  {
    return this.name;
  }
  /**
   * This method simply returns the statement of the given input
   * @return StatementClass - Returns the statement StatementClass
   **/  
  public StatementClass getStatement()
  {
    return this.statement;
  }
  /**
   * This method simply returns the variable of the given input
   * @return Variable - Returns the variable value
   **/  
  public Variable[] getVariable()
  {
    return variable;
  }
   /**
   * This method returns the String of each of the variables of the function in a neat and
   * organized manner
   * @return String - Returns the string of each of the variables of the function
   **/
  public String toString()
  {
    StringBuilder b = new StringBuilder();
    b.append("function " + name + "(");
     /**
     * for loop to run through and appends the sections needed for the variable
     **/
    for(int i = 0; i < variable.length - 1; i++)
    {
      b.append(variable[i].toString() + ", ");
    }
    b.append(variable[variable.length - 1].toString() + ")\n" + statement.toStringTabbed(1));
    return b.toString();
  }
}
                    