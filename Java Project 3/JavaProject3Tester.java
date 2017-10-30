import org.junit.*;
import static org.junit.Assert.*;
/**
 * Test class JavaProject3
 */
public class JavaProject3Tester 
{  
  private void equals2Darrays(int[][] expected, int[][] received) 
  {
    assertEquals(expected.length, received.length);
    for (int i = 0; i < expected.length; i++) 
    {
      assertArrayEquals(expected[i], received[i]);
    }
  }
  /**
   * Test the contains method.
   */
  @Test
  public void testSlideLeft() 
  {
    int[][] array1 = {{},{5},{2,0,6},{1,1,0,0},{0,1,0,2},{0,1,1,2,0},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out1 = {{},{5},{2,0,6},{1,1,0,0},{0,1,0,2},{0,1,1,2,0},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out2 = {{},{5},{2,0,6},{1,1,0,0},{0,1,0,2},{0,1,1,2,0},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out3 = {{},{5},{2,6,0},{1,1,0,0},{0,1,0,2},{0,1,1,2,0},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out4 = {{},{5},{2,6,0},{2,0,0,0},{0,1,0,2},{0,1,1,2,0},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out5 = {{},{5},{2,6,0},{2,0,0,0},{1,2,0,0},{0,1,1,2,0},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out6 = {{},{5},{2,6,0},{2,0,0,0},{1,2,0,0},{4,0,0,0,0},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out7 = {{},{5},{2,6,0},{2,0,0,0},{1,2,0,0},{4,0,0,0,0},{2,2,0,0,0},{1,1,1,1,1}};
    int[][] out8 = {{},{5},{2,6,0},{2,0,0,0},{1,2,0,0},{4,0,0,0,0},{2,2,0,0,0},{2,2,1,0,0}};
    equals2Darrays(out1, JavaProject3IntTest.slideLeft(array1, 0));
    equals2Darrays(out2, JavaProject3IntTest.slideLeft(array1, 1));
    equals2Darrays(out3, JavaProject3IntTest.slideLeft(array1, 2));
    equals2Darrays(out4, JavaProject3IntTest.slideLeft(array1, 3));
    equals2Darrays(out5, JavaProject3IntTest.slideLeft(array1, 4));
    equals2Darrays(out6, JavaProject3IntTest.slideLeft(array1, 5));
    equals2Darrays(out7, JavaProject3IntTest.slideLeft(array1, 6));
    equals2Darrays(out8, JavaProject3IntTest.slideLeft(array1, 7));
  }
  
  @Test
  public void testSlideRight() 
  {
    int[][] array1 = {{},{5},{2,0,6},{1,1,0,0},{0,1,0,2},{0,1,1,2,0},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out1 = {{},{5},{2,0,6},{1,1,0,0},{0,1,0,2},{0,1,1,2,0},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out2 = {{},{5},{2,0,6},{1,1,0,0},{0,1,0,2},{0,1,1,2,0},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out3 = {{},{5},{0,2,6},{1,1,0,0},{0,1,0,2},{0,1,1,2,0},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out4 = {{},{5},{0,2,6},{0,0,0,2},{0,1,0,2},{0,1,1,2,0},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out5 = {{},{5},{0,2,6},{0,0,0,2},{0,0,1,2},{0,1,1,2,0},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out6 = {{},{5},{0,2,6},{0,0,0,2},{0,0,1,2},{0,0,0,2,2},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out7 = {{},{5},{0,2,6},{0,0,0,2},{0,0,1,2},{0,0,0,2,2},{0,0,0,2,2},{1,1,1,1,1}};
    int[][] out8 = {{},{5},{0,2,6},{0,0,0,2},{0,0,1,2},{0,0,0,2,2},{0,0,0,2,2},{0,0,1,2,2}};
    equals2Darrays(out1, JavaProject3IntTest.slideRight(array1, 0));
    equals2Darrays(out2, JavaProject3IntTest.slideRight(array1, 1));
    equals2Darrays(out3, JavaProject3IntTest.slideRight(array1, 2));
    equals2Darrays(out4, JavaProject3IntTest.slideRight(array1, 3));
    equals2Darrays(out5, JavaProject3IntTest.slideRight(array1, 4));
    equals2Darrays(out6, JavaProject3IntTest.slideRight(array1, 5));
    equals2Darrays(out7, JavaProject3IntTest.slideRight(array1, 6));
    equals2Darrays(out8, JavaProject3IntTest.slideRight(array1, 7));
  }
  
  @Test
  public void testSlideUp()
  {
    int[][] array1 = {{},{5},{2,0,6},{1,1,0,0},{0,1,0,2},{0,1,1,2,0},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out1 = {{},{5},{2,0,6},{1,1,0,0},{0,1,0,2},{0,1,1,2,0},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out2 = {{},{5},{2,0,6},{1,1,0,0},{0,1,0,2},{0,1,1,2,0},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out3 = {{},{5},{2,0,6},{1,1,0,0},{0,1,0,2},{0,1,1,2,0},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out4 = {{},{5},{2,0,6},{1,1,0,0},{0,1,0,2},{0,1,1,2,0},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out5 = {{},{5},{2,0,6},{1,1,0,0},{0,1,0,2},{0,1,1,2,0},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out6 = {{},{5},{2,0,6},{1,1,0,0},{0,1,0,2},{0,1,1,2,0},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out7 = {{},{5},{2,0,6},{1,1,0,0},{0,1,0,2},{0,1,1,2,0},{0,1,1,1,1},{1,1,1,1,1}};
    int[][] out8 = {{},{5},{2,0,6},{1,1,0,0},{0,1,0,2},{0,1,1,2,0},{0,1,1,1,1},{1,1,1,1,1}};
    equals2Darrays(out1, JavaProject3IntTest.slideUp(array1, 0));
    equals2Darrays(out2, JavaProject3IntTest.slideUp(array1, 1));
    equals2Darrays(out3, JavaProject3IntTest.slideUp(array1, 2));
    equals2Darrays(out4, JavaProject3IntTest.slideUp(array1, 3));
    equals2Darrays(out5, JavaProject3IntTest.slideUp(array1, 4));
    equals2Darrays(out6, JavaProject3IntTest.slideUp(array1, 5));
    equals2Darrays(out7, JavaProject3IntTest.slideUp(array1, 6));
    equals2Darrays(out8, JavaProject3IntTest.slideUp(array1, 7));
  }
  
  @Test
  public void testSlideDown()
  {
    int[][] array1 = {{0,1,0,1},{1,2,0,1},{1,1,1,1},{0,0,0,2}};
    int[][] out1 = {{0,1,0,1},{0,2,0,1},{0,1,1,1},{2,0,0,2}};
    int[][] out2 = {{0,0,0,1},{1,1,0,1},{1,2,1,1},{0,1,0,2}};
    int[][] out3 = {{0,1,0,1},{1,2,0,1},{1,1,0,1},{0,0,1,2}};
    int[][] out4 = {{0,1,0,0},{1,2,0,1},{1,1,1,2},{0,0,0,2}};
    equals2Darrays(out1, JavaProject3IntTest.slideDown(array1, 0));
    equals2Darrays(out2, JavaProject3IntTest.slideDown(array1, 1));
    equals2Darrays(out3, JavaProject3IntTest.slideDown(array1, 2));
    equals2Darrays(out4, JavaProject3IntTest.slideDown(array1, 3));
  }
  
  @Test
  public void testSlideUpLeft()
  {
    int[][] array1 = {{0,1,0,1},{1,2,0,1},{1,1,1,1},{0,0,0,2}};
    //int[][] array2 = {{},{2}};
    int[][] out1 = {{2,1,0,1},{1,1,0,1},{1,1,2,1},{0,0,0,0}};
    int[][] out2 = {{0,1,0,1},{2,2,0,1},{1,0,1,1},{0,0,0,2}};
    int[][] out3 = {{0,2,0,1},{1,2,0,1},{1,1,1,0},{0,0,0,2}};
    int[][] out4 = {{0,1,1,1},{1,2,0,0},{1,1,1,1},{0,0,0,2}};
    //int[][] out5 = {{},{2}};
    //int[][] out6 = {{},{2}};
    equals2Darrays(out1, JavaProject3IntTest.slideUpLeft(array1,0,0));
    equals2Darrays(out2, JavaProject3IntTest.slideUpLeft(array1,1,0));
    equals2Darrays(out3, JavaProject3IntTest.slideUpLeft(array1,0,1));
    equals2Darrays(out4, JavaProject3IntTest.slideUpLeft(array1,1,3));
    //equals2Darrays(out5, JavaProject3IntTest.slideUpLeft(array2,0,0));
    //equals2Darrays(out6, JavaProject3IntTest.slideUpLeft(array2,0,1));
  }
  
  @Test
  public void testSlideDownRight()
  {
    int[][] array1 = {{0,1,0,1},{1,2,0,1},{1,1,1,1},{0,0,0,2}};
    //int[][] array2 = {{},{2}};
    int[][] out1 = {{0,1,0,1},{1,2,0,1},{1,1,1,1},{0,0,0,2}};
    int[][] out2 = {{0,1,0,1},{0,2,0,1},{1,0,1,1},{0,0,2,2}};
    int[][] out3 = {{0,0,0,1},{1,2,0,1},{1,1,1,2},{0,0,0,2}};
    int[][] out4 = {{0,1,0,1},{1,2,0,1},{1,1,1,1},{0,0,0,2}};
    //int[][] out5 = 
    //int[][] out6 = 
    equals2Darrays(out1, JavaProject3IntTest.slideDownRight(array1,0,0));
    equals2Darrays(out2, JavaProject3IntTest.slideDownRight(array1,1,0));
    equals2Darrays(out3, JavaProject3IntTest.slideDownRight(array1,0,1));
    equals2Darrays(out4, JavaProject3IntTest.slideDownRight(array1,1,3));
    //equals2Darrays(out5, JavaProject3IntTest.slideDownRight(array2,0,0));
    //equals2Darrays(out6, JavaProject3IntTest.slideDownRight(array2,0,1));   
  }
  
  @Test
  public void testSlideUpRight()
  {
    int[][] array1 = {{0,1,0,1},{1,2,0,1},{1,1,1,1},{0,0,0,2}};
    int[][] out1 = {{0,1,0,1},{1,2,0,1},{1,1,1,1},{0,0,0,2}};
    int[][] out2 = {{0,2,0,1},{0,2,0,1},{1,1,1,1},{0,0,0,2}};
    int[][] out3 = {{0,2,0,1},{0,2,0,1},{1,1,1,1},{0,0,0,2}};
    int[][] out4 = {{0,1,0,1},{1,2,0,2},{1,1,0,1},{0,0,0,2}};
    equals2Darrays(out1, JavaProject3IntTest.slideUpRight(array1,0,0));
    equals2Darrays(out2, JavaProject3IntTest.slideUpRight(array1,1,0));
    equals2Darrays(out3, JavaProject3IntTest.slideUpRight(array1,0,1));
    equals2Darrays(out4, JavaProject3IntTest.slideUpRight(array1,1,3));
  }
  
  @Test
  public void slideDownLeft()
  {
    int[][] array1 = {{0,1,0,1},{1,2,0,1},{1,1,1,1},{0,0,0,2}};
    int[][] out1 = {{0,1,0,1},{1,2,0,1},{1,1,1,1},{0,0,0,2}};
    int[][] out2 = {{0,0,0,1},{2,2,0,1},{1,1,1,1},{0,0,0,2}};
    int[][] out3 = {{0,0,0,1},{2,2,0,1},{1,1,1,1},{0,0,0,2}};
    int[][] out4 = {{0,1,0,1},{1,2,0,0},{1,1,0,1},{0,2,0,2}};
    equals2Darrays(out1, JavaProject3IntTest.slideDownLeft(array1,0,0));
    equals2Darrays(out2, JavaProject3IntTest.slideDownLeft(array1,1,0));
    equals2Darrays(out3, JavaProject3IntTest.slideDownLeft(array1,0,1));
    equals2Darrays(out4, JavaProject3IntTest.slideDownLeft(array1,1,3));
  }
}