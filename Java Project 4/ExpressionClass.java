/**
 * @author Aditya Malik
 * This interface contains the required method stubs required by other classes that call the
 * stubs
 * value - takes an input of the inputState and returns some sort of associated value
 * toString - returns the string representation of some value
 **/
public interface ExpressionClass
{
  public abstract int value(State inputState);
  
  public abstract String toString();
}