/**
 * Default node of linked list
 * @author Aditya Malik
 */
public class LLNode<T> 
{
  /** Element stored in the node */
  private T element;
  
  /** The next node on the list */
  private LLNode<T> next;
 
  /**
   * A constructor
   * @param element - The element to store in the node
   * @param next - The next node of the list 
   */
  public LLNode(T element, LLNode<T> next) 
  {
    this.element = element;
    this.next = next;
  }
  
  /**
   * returns element stored in the node
   * @return element stored in the node
   */
  public T getElement() 
  {
    return element;
  }
  
  /**
   * returns next node of the list
   * @return next node of the list
   */
  public LLNode<T> getNext() 
  {
    return next;
  }
  
  /**
   * Sets the next node in the list
   * @param next - The next node in the list
   */
  public void setNext(LLNode<T> next) 
  {
    this.next = next;
  }
}
