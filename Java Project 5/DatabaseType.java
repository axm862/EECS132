import java.util.*;
/**
 * An interface that contains method stub getComparatorByTrait
 * @author Aditya Malik
 */ 
public interface DatabaseType<F> 
{
  /**
   * Method stub for getComparatorByTrait
   * @param trait - The input string
   * @return a Comparator
   */ 
  public Comparator getComparatorByTrait(String trait);
}