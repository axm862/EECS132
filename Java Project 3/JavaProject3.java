/**
 * @author Aditya Malik
 * slideLeft - Each non-zero element starting from the left is slid to the furthest left of the 2D array, and 
 * if the elements are similar, they are merged together.
 * slideRight - Each non-zero element starting from the right is slid to the furthest right of the 2D array, and 
 * if the elements are similar, they are merged together.
 * slideUp - Each non-zero element starting from the topmost is slid to the top of the 2D array, and if the elements
 * are similar, they are merged together.
 * slideDown - Each non-zezro element starting from the bottom-most is slid to the botton of the 2D array, and if the
 * elements are similar, they are merged together.
 * slideUpLeft - Each non-zero element is slid along the diagonal to the top-left of the 2D array, and if the elements
 * are similar, they are merged together.
 * slideDownRight - Each non-zero element is slid along the diagonal to the bottom-right of the 2D array, and if the elements
 * are similar, they are merged together.
 * slideUpRight - Each non-zero element is slid along the diagonal to the top-right of the 2D array, and if the elements are
 * similar, they are merged together.
 * slideDownLeft - Each non-zezro element is slid along the diagonal to the bottom-left of the 2D array, and if the elemnts are
 * similar, they are merged together.
 * */

public class JavaProject3
{
  /**
   * Each non-zero element starting from the left is slid to the furthest left of the 2D array, and if the elements are similar, they are merged together.
   * @param array - takes in a 2D array
   * @param row - the given row that we want to modify
   * @return check - the check returns either true or false if the numbers have slid
   **/
  public static boolean slideLeft(int[][] array, int row) 
  {
    // counter to keep track of where we are moving a non-zero entry
    int ctr = 0;
    // keeps track of if the shift happened or not
    boolean check = false;
    // go through each number in the array
    for (int i = 0; i < array[row].length; i++) 
    {
      // look for a value that isn't zero
      if (array[row][i] != 0) 
      {
        // we found a non-zero entry so we have to move it
        // look to the left to see if the one on the left is the same.
        if (ctr > 0 && array[row][i] == array[row][ctr - 1]) 
        {
          // they are the same so we should combine the two
          array[row][ctr - 1] *= 2;
          // we do not increment the counter and set the check to true
          check = true;
        } 
        else 
        {
          // they are not the same, move them next to each other
          array[row][ctr] = array[row][i];
          // increment the counter so that the next non-zero is moved
          // to the correct position
          ctr++;
        }
      }
    }
    // fill the rest with zeros
    for (int i = ctr; i < array[row].length; i++) 
    {
      array[row][i] = 0;
      // set check to true to show values have slided left
      check = true;
    }
    // return boolean check
    return check;
  }
  
  /**
   * Each non-zero element starting from the right is slid to the furthest right of the 2D array, and if the elements are similar, they are merged together.
   * @param array - takes in a 2D array to be modified
   * @param row - the row that needs to be modified
   * @return check - returns true or false to indicate if numbers slid or not
   * */
  public static boolean slideRight(int[][] array, int row)
  {
    //counter keeps track of where you are in the array
    int ctr = array[row].length-1;
    //check used to see if elements slided or not
    boolean check = false;
    //go through each number in the array starting from the furthest right
    for(int i = array[row].length-1; i >= 0; i--)
    {
      //look for a value that isn't zero
      if(array[row][i] != 0)
      {
        // checks to see if the numbers next to target value are similar 
        if(array[row].length - 1 > ctr && array[row][i] == array[row][ctr+1])
        {
          //combine the two
          array[row][ctr+1] *= 2;
          //set check to true and don't increment counter 
          check = true;
        }
        else
        {
          //if they are not the same then move them next to each other
          array[row][ctr] = array[row][i];
          ctr--;
        }
      }
    }
    //replaces the rest with zeros 
    for(int i = ctr; i >= 0; i--)
    {
      array[row][i] = 0;
      //set check to true to show it slid
      check = true;
    }
    //return boolean check
    return check;
  }
  
  /**
   *  Each non-zero element starting from the topmost is slid to the top of the 2D array, and if the elements are similar, they are merged together.
   * @param array - the 2D input array to be modified
   * @param col - the column we want to modify 
   * @return check - returns true or false to indicate if numbers slid or not
   * */
  public static boolean slideUp(int[][] array, int col)
  {
    //counter to keep track of where you are in the array
    int ctr = 0;
    //boolean statement to show if the element slid or not
    boolean check = false;
    //loop to go through numbers in array
    for(int i = 0; i < array.length; i++)
    {
      //looking for non-zero number
      if(array[i][col] != 0)
      {
        //if the numbers are the same, add them together
        if(ctr > 0 && array[i][col] == array[ctr - 1][col])
        {
          array[ctr - 1][col] *= 2;
          //make boolean into true since numbers were slid, do not increment counter
          check = true;
        }
        else
        {
          //if they arent the same, place them next to each other and increment counter
          array[ctr][col] = array[i][col];
          ctr++;
        }
      }
    }
    //replaces the spots with zeros for what was moved
    for(int i = ctr; i < array.length; i++)
    {
      array[i][col] = 0;
      //sets boolean to true to show numbers slid
      check = true;
    }
    //return boolean statement
    return check;
  }
  
  /**
   * Each non-zezro element starting from the bottom-most is slid to the botton of the 2D array, and if the elements are similar, they are merged together.
   * @param array - the 2D input array to be modified
   * @param col - the column to be checked to slide everything down
   * @return check - returns true or false to indicate if numbers slid or not
   **/
  public static boolean slideDown(int[][] array, int col)
  {
    //counter to keep track of where you are in the array
    int ctr = array.length - 1;
    //boolean check to show if numbers slid or not
    boolean check = false;
    //goes through the length of the array starting from the end
    for(int i = array.length - 1; i >= 0; i--)
    {
      //looking for non-zero number
      if(array[i][col] != 0)
      {
        //if they are similiar, add them together
        if(array.length - 1 > ctr && array[i][col] == array[ctr + 1][col])
        {
          array[ctr + 1][col] *= 2;
          //turns boolean into true to show numbers slid
          check = true;
        }
        else
        {
          //puts the numbers next to each other and decreases counter
          array[ctr][col] = array[i][col];
          ctr--;
        }
      }
    }
    //replaces the rest of the moved spots with zeros
    for(int i = ctr; i >= 0; i--)
    {
      array[i][col] = 0;
      //turns boolean into true to show numbers slid
      check = true;
    }
    //returns boolean check
    return check;
  }
  
  /**
   * Each non-zero element is slid along the diagonal to the top-left of the 2D array, and if the elements are similar, they are merged together.
   * @param array - the 2D input array to be modified
   * @param row - the row location of the element which wants to be modified 
   * @param col - the column location of the element that needs to be slid up-left
   * @return check - returns true or false to indicate if numbers slid or not
   **/
  public static boolean slideUpLeft(int[][] array, int row, int col)
  {
    //boolean check to show if it slid or not
    boolean check = false;
    //decrements the values of row and col
    while(row > 0 && col > 0)
    {
      row--;
      col--;
    }
    //makes counters of row and col, as well as where it starts
    //row counter
    int rowCtr = row;
    //column counter
    int colCtr = col;
    //row starting pos
    int rowStart = row;
    //col starting pos
    int colStart = col;
    //goes through the whole array
    while(array.length > row && array[0].length > col)
    {
      //looks for non-zero number
      if(array[row][col] != 0)
      {
        //if the two numbers are similar, it adds them together
        if(colCtr > colStart && rowCtr > rowStart && array[row][col] == array[rowCtr - 1][colCtr - 1])
        {
          array[rowCtr - 1][colCtr - 1] *= 2;
          //turns boolean into true to show numbers slid
          check = true;
        }
        //if not equal it moves them next to each other diagonally and increments counters
        else
        {
          array[rowCtr][colCtr] = array[row][col];
          rowCtr++;
          colCtr++;
        }
      }
      //while condition
      row++;
      col++;
    }
    //replaces the moved spots left empty with zeros 
    while(array.length > rowCtr && array[0].length > colCtr)
    {
      array[rowCtr][colCtr] = 0;
      //turns check into true to show numbers slid
      check = true;
      //while condition
      rowCtr++;
      colCtr++;
    }
    //returns the boolean check
    return check;
  }
  
  /**
   * Each non-zero element is slid along the diagonal to the bottom-right of the 2D array, and if the elements are similar, they are merged together.
   * @param array - 2D array that needs to be modified
   * @param row - the row location of the element that needs to be modified and slid down-right
   * @param col - the column location of the element that needs to be modified and slid down-right
   * @return check - returns true or false to indicate if numbers slid or not
   **/
  public static boolean slideDownRight(int[][] array, int row, int col)
  { 
    //boolean check to see if the numbers slid or not
    boolean check = false;
    //increases the values of row and col for the array
    while(array.length - 1 > row && array[0].length - 1 > col)
    {
      row++;
      col++;
    }
    //makes row and column counters as well as starting placements of them
    //row counter
    int rowCtr = row;
    //column counter
    int colCtr = col;
    //starting row pos
    int rowStart = row;
    //starting col pos
    int colStart = col;  
    //runs through the array
    while(row >= 0 && col>= 0)
    {
      //looks for a non-zero number
      if(array[row][col] != 0)
      {
        //if the numbers are equal, adds them together
        if(colStart > colCtr && rowStart > rowCtr && array[row][col] == array[rowCtr + 1][colCtr + 1])
        {
          array[rowCtr + 1][colCtr + 1] *= 2;
          //turns boolean check into true to show numbers slid
          check = true;
        }
        //if they arent equal, sets them next to each other and decrements the counter
        else
        {
          array[rowCtr][colCtr] = array[row][col];
          rowCtr--;
          colCtr--;
        }
      }
      //while condition
      row--;
      col--;
    }
    //fills the rest of the spots with zeros
    while(rowCtr >= 0 && colCtr >= 0)
    {
      array[rowCtr][colCtr] = 0;
      //turns boolean check to true to show numbers have slid
      check = true;
      //while loop condition
      rowCtr--;
      colCtr--;
    }
    //returns boolean check
    return check;
  }
  
  /**
   * Each non-zero element is slid along the diagonal to the top-right of the 2D array, and if the elements are similar, they are merged together.
   * @param array - the 2D input array that needs to be modified
   * @param row - the row location of the element that needs to be slid up-right
   * @param col - the column location of the element that needs to be slid up-right
   * @return check - returns true or false to indicate if numbers slid or not
   **/
  public static boolean slideUpRight(int[][] array, int row, int col)
  {  
    //boolean check to see if the numbers slide or not
    boolean check = false;
    //increments row and decrements columns since going up-right
    while(row > 0 && array[0].length - 1 > col)
    {
      row--;
      col++;
    }    
    //creates row and column counters, as well as row and column start indicators
    //row counter
    int rowCtr = row;
    //column counter
    int colCtr = col;
    //starting row position
    int rowStart = row;
    //starting column position
    int colStart = col;    
    //loop to run through the array
    while(array.length > row && col >= 0)
    {
      //looking for a non-zero number
      if(array[row][col] != 0)
      {
        //if the two numbers are equal to each other it adds them together
        if(colCtr < colStart && rowStart < rowCtr && array[row][col] == array[rowCtr - 1][colCtr + 1])
        {
          array[rowCtr - 1][colCtr + 1] *= 2;
          //turns boolean into true to show numbers slid
          check = true;
        }
        //if not equal it sets them next to each other and increments row counter and decrements column counter
        else
        {
          array[rowCtr][colCtr] = array[row][col];
          rowCtr++;
          colCtr--;
        }
      }
      //while loop condition
      row++;
      col--;
    }   
    //replaces the rest of the spots with zeros
    while(array.length > rowCtr && colCtr >= 0)
    {
      array[rowCtr][colCtr] = 0;
      //turns boolean check to true to show numbers slid
      check = true;
      //while loop condition
      rowCtr++;
      colCtr--;
    }
    //returns boolean check
    return check;
  }
  
  /**
   * Each non-zezro element is slid along the diagonal to the bottom-left of the 2D array, and if the elemnts are similar, they are merged together.
   * @param array - the 2D array that needs to be modified and numbers that need to be slid
   * @param row - the row location of the element that needs to be slid to the down-left
   * @param col - the column location of the element that needs to be slid to the bottom-left
   * @return check - returns true or false to indicate if numbers slid or not

   **/
  public static boolean slideDownLeft(int[][] array, int row, int col)
  {
    //creates boolean check to see if numbers moved
    boolean check = false;
    //increments row and decrements column since going down and left
    while(array.length - 1 > row && col > 0)
    {
      row++;
      col--;
    }
    //creates row and column counters, as well as start position indicators
    //row counter
    int rowCtr = row;
    //column counter
    int colCtr = col;
    //starting row position
    int rowStart = row;
    //starting column position
    int colStart = col;
    //runs through the length of the array
    while(row >= 0 && array[0].length > col)
    {
      //looking for a non-zero number
      if(array[row][col] != 0)
      {
        //if the two numbers in the diagonal are equal, it adds them together
        if(colCtr > colStart && rowStart > rowCtr && array[row][col] == array[rowCtr + 1][colCtr - 1])
        {
          array[rowCtr + 1][colCtr - 1] *= 2;
          //returns check to true to show numbers slid
          check = true;
        }
        //if the numbers are not the same, it places them next to each other and decreases the row counter but increases the column counter
        else
        {
          array[rowCtr][colCtr] = array[row][col];
          rowCtr--;
          colCtr++;
        }
      }
      //while loop condition
      row--;
      col++;
    }
    //replaces the remaining spots with zeros 
    while(rowCtr >= 0 && array[0].length > colCtr)
    {
      array[rowCtr][colCtr] = 0;
      //turns boolean to true to show numbers slid
      check = true;
      //while loop condition
      rowCtr--;
      colCtr++;
    }
    //returns boolean check
    return check;
  }
}