/**
 * @author Aditya Malik
 * execute - takes in a string and consists of a loop that has state execute each of the statements
 * at every iteration of the loop
 * toString - returns a string that contains the following methods in string representation with
 * calling toStringTabbed as well
 * toStringTabbed - returns what is identital to toString except consists of tabs equal to the
 * input int
 **/
public class CompoundStatement implements StatementClass
{
  /**
   * Creates the field required by the class
   **/
  private StatementClass[] statement = null;
  /**
   * The constructor of the class to replace the default constructor with input array of statements
   * @param statement - the array of statements that are inputted by the user
   **/
  public CompoundStatement(StatementClass[] statement)
  {
    this.statement= statement;
  }
   /**
   * Takes in a string and loops through it and at each itertion of the loop the state is used
   * to execute each of the statements in the array
   * @param inputState - the state of the input given by the user
   **/
  public void execute(State inputState)
  {
    /**
     * for loop to run through the length of the array
     **/
    for(int i = 0; i < statement.length; i++)
    {
      statement[i].execute(inputState);
    }
  }
   /**
   * Returns the string representation of what is done in the execute statement and calls toStringTabbed
   * @return String - the string representation of the execute method 
   **/
  public String toString()
  {
    StringBuilder b = new StringBuilder();
    b.append("{\n");
    /**
     * for loop to run through the length of the array
     **/
    for(int i = 0; i < statement.length; i++)
    {
      b.append(statement[i].toStringTabbed(1));
    }
    b.append("}\n");
    return b.toString();
  }
   /**
   * Returns the same thing as the toString except with a set number of tabs based on inputInt
   * @param inputInt - the number of tabs to be inputted into the method
   * @return String - the resulting string of the execute method with the tabs added
   **/
  public String toStringTabbed(int inputInt)
  {
    StringBuilder b = new StringBuilder();
    b.append("{\n");
    /**
     * for loop to run through and add tabs to the sections needed
     **/
    for(int i = inputInt - 1; i > 0; i--)
    {
      b.append("\t");
    }
    /**
     * for loop to run through the string and add the correct statements to that area
     **/
    for(int i = 0; i < statement.length; i++)
    {
      b.append(statement[i].toStringTabbed(inputInt));
    }
     /**
     * for loop to run through and add tabs to the sections needed
     **/
    for(int i = inputInt - 1; i > 0; i--)
    {
      b.append("\t");
    }
    b.append("}\n");
    return b.toString();
  }
}