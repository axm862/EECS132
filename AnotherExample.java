public class AnotherExample extends Example
{
  private int numThree = 0;
  
  public AnotherExample(int numOne, int numTwo, int numThree)
  {
    super(numOne, numTwo);
    this.numThree = numThree;
  }
  public void setNumThree(int numThree)
  {
    this.numThree = numThree;
  }
  public int getNumThree()
  {
    return numThree;
  }
  public int addNumbers()
  {
    return (this.getNumOne() + this.getNumTwo() + this.getNumThree());
  }
  public String toString()
  {
    StringBuilder b = new StringBuilder();
    b.append("\nNumber one:" + this.getNumOne() + "\nNumber two:" + this.getNumTwo() + 
             "\nNumber three:" + this.getNumThree());
    return b.toString();
  }
  public boolean equals()
  {
    boolean result = false;
    if((this.getNumOne() == this.getNumTwo()) && (this.getNumOne() == this.getNumThree()) && 
       this.getNumTwo() == this.getNumThree())
    {
      result = true;
    }
    return result;
  }
  public static void main (String [] args)
  {
    AnotherExample a = new AnotherExample(5,10,15);
    a.toString();
    a.equals();
  }
}