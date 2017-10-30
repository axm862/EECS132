/**
 * @author Aditya Malik
 * This interface contains the required method stubs required by the other classes in order to run
 * their methods and connect them in the hierarchy
 * execute - takes in a state and checks to see if a value is true during that state and this
 * is used to execute the body statement
 * toString - the string representation of what is happening in the execute method
 * toStringTabbed - takes in an input integer that decides the number of tabs that is to be placed
 * in the new tabbed string, which is similar to toString but with tabs
 **/
public interface StatementClass
{
  public abstract void execute(State inputState);
  
  public abstract String toString();
  
  public abstract String toStringTabbed(int inputInt);
}
