/**
 * @author Aditya Malik
 * This interface contains the required method stubs required by other classes
 * value - takes an input of inputState and returns some sort of associated value
 * toString - to return the string representation of some value
 **/
public interface BooleanExpressionClass
{
  public abstract boolean value(State inputState);
 
  public abstract String toString();
}