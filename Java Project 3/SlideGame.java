/**
 * @author Aditya Malik
 * setButtonValues - This method sets number values onto the buttons located within the game frame. This is what allows us to see what number is associated with which panel.
 * randomValues - This method will place a random integer onto one of the empty buttons located within the game board.
 * actionPerformed - This method is what determines where the user clicks on the gameboard and depending on where the user clicks, a specific method will run from the JavaProject3 class
 * main - This is the default method that is executed when the file is simply called from the interactions page
 **/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SlideGame extends JFrame implements ActionListener
{
  //initial number of rows
  private int row = 0;
  //initial number of columns
  private int col = 0;
  //new JFrame for the game
  private JFrame actualGame = null;
  //2D input array
  private int[][] array = null;
  //new buttons to be put into the JFrame game
  private JButton[][] button = null;
  //constructor that takes in rows and columns to set the size of the game
  public SlideGame(int row, int col)
  {
    this.row = row;
    this.col = col;
    JPanel board = new JPanel(new GridLayout(row,col));
    actualGame = new JFrame();
    actualGame.setSize(row*100,col*100);
    button = new JButton[row][col];
  
    this.actualGame.getContentPane().add(board, "Center");
    this.array = new int[row][col];
    //runs through the rows and columns in the array and places buttons in each (row,column) location
    for(int i = 0; i < array.length; i++)
    {
      for(int j = 0; j < array[0].length; j++)
      {
        button[i][j] = new JButton();
        button[i][j].addActionListener(this);
        array[i][j] = 0;
        board.add(button[i][j]);
        button[i][j].setBackground(Color.RED);

      }
      actualGame.setVisible(true);
    }
  }
  
  /**
   * This method sets number values onto the buttons located within the game frame. This is what allows us to see what number is associated with which panel.
   * No param or return
   **/
  public void setButtonValues()
  {
    //both for loops run through each row and column in the array
    for(int i = 0; i < array.length; i++)
    {
      for(int j = 0; j < array[0].length; j++)
      {
        //if its not a zero in that location, then show the value of the element that is placed there
        if(array[i][j] != 0)
        {
          button[i][j].setText(Integer.toString(array[i][j]));
        }
        //if the element is equal to zero, display nothing
        if(array[i][j] == 0)
        {
          button[i][j].setText(null);
        }
      }
    }
  }
  
  /**
   * This method will place a random integer onto one of the empty buttons located within the game board.
   * No param or return
   **/
  public void randomValues()
  {
    //counter keeps track of where you are, while rowCtr and colCtr make the random number of position in (row,col)
    int ctr = 0;
    int rowCtr = (int)(Math.random() * array.length);
    int colCtr = (int)(Math.random() * array[0].length);
    //both for loops run through the elements in the array
    for(int i = 0; i < array.length; i++)
    {
      for(int j = 0; j < array[i].length; j++)
      {
        //if its a non-zero number, add to the counter
        if(array[i][j] != 0)
        {
          ctr++;
        }
      }
    }
    //
    if(ctr != row * col)
    {
      if(array[rowCtr][colCtr] == 0)
      {
        array[rowCtr][colCtr] = 1;
        button[rowCtr][colCtr].setText(Integer.toString(array[rowCtr][colCtr]));
      }
      else
      {
        randomValues();
      }
    }
    //no more possible moves
    else
    {
      System.out.println("The game has ended");
    }
  }
  
  /**
   * This method is what determines where the user clicks on the gameboard and depending on where the user clicks, a specific method will run from the JavaProject3 class
   * @param e - Determines the button which is pressed and uses this to run through the loops
   **/
   public void actionPerformed(ActionEvent e)
  {
    JButton aButton = (JButton) e.getSource();
    //the two for-loops run through the rows and columns of the array to find a specific (row,col)
    //runs through the rows
    for(int i = 0; i < button.length; i++)
    {
      //runs through the columns
      for(int j = 0; j < button[0].length; j++)
      {
        //tests to see if the button pressed is the same as the button we are looking for in the array of buttons
       if(aButton == button[i][j])
       {
         //The following series of if statements are to test where the button is located, and depending on its location, it will execute one of the 8 methods created in JavaProject3 class
         if(i != 0 && i != array.length - 1)
         {
           //if the column location equals zero
           if(j == 0)
           {
             //Slides all the rows to the left
             for(int x = 0; x < array.length; x++)
             {
               JavaProject3.slideLeft(array,x);
             }
             //calls the methods to show the numbers and place a new random integer value 
             setButtonValues();
             randomValues();
           }
           //if its the last column location
           if(j == array[0].length - 1)
           {
             //Slides all the rows to the right
             for(int x = 0; x < array.length; x++)
             {
               JavaProject3.slideRight(array,x);
             }
             //calls the methods to show the numbers and place a new random integer value
             setButtonValues();
             randomValues();
           }
         }
         //if the column is not equal to zero or the last columns in the length of the array(location-wise)
         if(j != 0 && j != array.length - 1)
         {
           //if row location equals zero
           if(i == 0)
           {
             //moves all the columns in the row up
             for(int x = 0; x < array[i].length; x++)
             {
               JavaProject3.slideUp(array,x);
             }
             //calls the methods to show the numbers and place a new random integer value
             setButtonValues();
             randomValues();
           }
           //if the row location is the last row in the length
           if(i == array.length - 1)
           {
             //moves all the columns in the row down
             for(int x = 0; x < array[i].length; x++)
             {
               JavaProject3.slideDown(array,x);
             }
             //calls the methods to show the numbers and place a new random integer value
             setButtonValues();
             randomValues();
           }
         }
         //if the row location equals zero
         if(i == 0)
         {
           //if the column location equals zero
           if(j == 0)
           {
             //Does the upper part of the array to calculate if it slides top-left
             for(int x = 0; x < array.length; x++)
             {
               JavaProject3.slideUpLeft(array,x,j);
             }
             //Does the lower part of the array to calculate if it slides top-left
             for(int z = array[i].length - 1; z > 0; z--)
             {
               JavaProject3.slideUpLeft(array,i,z);
             }
             //calls the method to show the numbers and place a new random integer value
             setButtonValues();
             randomValues();
           }
           //if the column location is equal to the length of the column
           if(j == array[i].length - 1)
           {
             //Does the upper part of the array to calculate if it slides top-right
             for(int x = 0; x < array.length; x++)
             {
               JavaProject3.slideUpRight(array,x,0);
             }
             //Does the lower part of the array to calculate if it slides top-right
             for(int z = array[i].length - 1; z > 0; z--)
             {
               JavaProject3.slideUpRight(array, array.length - 1, z);
             }
             //calls the method to show the numbers and place a new random integer value
             setButtonValues();
             randomValues();
           }
         }
         //if the row location is equal to the length of the row
         if(i == array.length - 1)
         {
           //if the column location is equal to zero
           if(j == 0)
           {
             //Runs through the upper part of the array to calculate if it slides bottom-left
             for(int x = 0; x < array.length; x++)
             {
               JavaProject3.slideDownLeft(array,x,j);
             }
             //Runs through the bottom part of the array to calculate if it slides bottom-left
             for(int z = array[i].length - 1; z > 0; z--)
             {
               JavaProject3.slideDownLeft(array,i,z);
             }
             //calls the method to show the numbers and place a new random integer value
             setButtonValues();
             randomValues();
           }
           //if the column location is equal to the column length 
           if(j == array[i].length - 1)
           {
             //Runs through the upper part of the array to calculate if it slides bottom-right
             for(int x = 0; x < array.length; x++)
             {
               JavaProject3.slideDownRight(array,x,j);
             }
             //Runs through the bottom part of the array to calculate if it slides bottom-right
             for(int z = 0; z < array.length - 1; z++)
             {
               JavaProject3.slideDownRight(array,i,z);
             }
             //calls the method to show the numbers and place a new random integer value
             setButtonValues();
             randomValues(); 
           }
         }
       }
      }
    }
    //this method will place objects on the board
    this.pack();
 }
  
  /**
   * This is the default method that is executed when the file is simply called from the interactions page
   * @param args - The input strings that is given by the user
   * No return type
   **/
  public static void main(String [] args)
  {
    //default length is given
    if(args.length == 0)
    {
      new SlideGame(4,4).setButtonValues();
    }
    //sets the parameters of the size of the grid for max and min size
    else if(args.length == 2 && Integer.parseInt(args[0]) > 3 && Integer.parseInt(args[0]) < 12 && Integer.parseInt(args[1]) > 3 && Integer.parseInt(args[1]) < 12)
    {
      new SlideGame(Integer.parseInt(args[0]),Integer.parseInt(args[1])).setButtonValues();
    }
    //if something else that doesn't fit the given values above, an error message is printed
    else
    {
      JFrame errorMessage = new JFrame();
      TextArea text = new TextArea("Please enter applicable parameters!");
      errorMessage.add(text);
      errorMessage.setSize(400,200);
      errorMessage.setVisible(true);
    }
  }
}
  