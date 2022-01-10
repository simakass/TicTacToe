/* Craig Persiko
   TicTacBoard.java
   Starter code for Assignment 11 in CS 111B

   A class representing a Tic Tac Toe board -
   both its user interface and its logical functionality.

   YOUR JOB IS TO WRITE THE BODY OF THE checkWinner METHOD BELOW
   SO THAT THE GAME STOPS WHEN SOMEONE WINS, OR WHEN THE BOARD IS FULL.
   LIKE SHOWN IN THE SAMPLE OUTPUT AT BOTTOM.
*/
// Seraphima Kassianik

import java.util.Scanner;

public class TicTacBoard
{
  private char[][] board;  // 2-D array of characters
  private char curPlayer; // the player whose turn it is (X or O)

  // Constructor: board will be size x size
  public TicTacBoard(int size)
  {
    board = new char[size][size];

    // initialize the board with all spaces:
    for(int row=0; row < board.length; row++)
      for(int col=0; col < board[row].length; col++)
        board[row][col] = ' ';

    curPlayer = 'X';  // X gets the first move
  }

  public void playGame()
  {
    display();
    do
    {
      takeTurn();
      display();
    }while(!checkWinner());
  }

  ///////  display  ////////
  // Display the current status of the board on the
  // screen, using hyphens (-) for horizontal lines
  // and pipes (|) for vertical lines.
  public void display()
  {
    System.out.println();
    dispRow(0);
    System.out.println("-----");
    dispRow(1);
    System.out.println("-----");
    dispRow(2);
    System.out.println();
  }

  // Display the current status of row r of the board
  // on the screen, using hyphens (-) for horizontal
  // lines and pipes (|) for vertical lines.
  private void dispRow(int r)
  {
    System.out.println(board[r][0] + "|" + board[r][1]
                       + "|" + board[r][2]);
  }

  ///////  takeTurn  ////////
  // Allow the curPlayer to take a turn.
  // Send output to screen saying whose turn
  // it is and specifying the format for input.
  // Read user's input and verify that it is a
  // valid move.  If it's invalid, make them
  // re-enter it.  When a valid move is entered,
  // put it on the board.
  public void takeTurn()
  {
    Scanner scan = new Scanner(System.in);
    int row, col;
    boolean invalid;

    do{
      invalid = false; // assume correct entry
      System.out.println("It is now " + curPlayer + "'s turn.");
      System.out.println("Please enter your move in the form row column.");
      System.out.println("So 0 0 would be the top left, and 0 2 would be the top right.");
      row = scan.nextInt();
      col = scan.nextInt();

      if(row < 0 || col < 0 || row > 2 || col > 2)
      {
        System.out.println("Invalid entry: row and column must both be between 0 and 2 (inclusive).");
        System.out.println("Please try again.");
        invalid = true;
      }
      else if(board[row][col] != ' ')
      {
        System.out.println("Invalid entry: Row " + row + " at Column " + col
                           + " already contains: " + board[row][col]);
        System.out.println("Please try again.");
        invalid = true;
      }
    }while(invalid);

    board[row][col] = curPlayer;

    if(curPlayer == 'X')
      curPlayer = 'O';
    else
      curPlayer = 'X';
  }

  // If the game is over, print who won (if anyone),
  // and return true.  If the game is not over, return false.
 
    // YOUR CODE GOES HERE
  
  public static void Xwon()
  {
    System.out.println("Player X wins!");
  }
  public static void Owon()
  {
    System.out.println("Playe O wins!");
  }
  public static void noWon()
  {
    System.out.println("Nobody can win now. Game ends in a draw.");
  }
  public boolean checkWinner()
  {
    if (Win('X') == true)
    {
      Xwon();
      return true;
    } // The game never ends. CHANGE THIS
    if (Win('O') == true)
    {
      Owon();
      return true;
    }
    if (noWinner('X') == true)
    {
      noWon();
      return true;
    }
    return false;
  }
  public boolean Win(char c)
  {
    // horizontal win
    // char c;
    // Win(char c)
    //c = ' ';

    int b=0;
    for (int a = 0; a<3; a++)
    {
      if ((board[a][b] == c) && (board[a][b+1] == c) && (board[a][b+2] == c))
      {
        return true;
      }
    }
    // vertical win
    int a = 0;
    for (b=0; b<3; b++)
    {
      if ((board[a][b] == c) && (board[a+1][b] == c) && (board[a+2][b] == c))
      {
        return true;
      }
    }
    // diagonal win
    if ((board[0][0] == c) && (board[1][1] == c) && (board[2][2] == c))
    {
      return true;
    }
    if ((board[0][2] == c) && (board[1][1] == c) && (board[2][0] == c))
    {
      return true;
    }
    return false;
  }
  public boolean vertical1(char c)
  {
    int a, b;
    for (a=0; a<3; a++)
    {
      for (b=0; b<3; b++)
      {
        if (board[a][0] == c)
        {
          return true;
        }
      }
    }
    return false;
  }
  public boolean vertical2(char c)
  {
    int a, b;
    for (a=0; a<3; a++)
    {
      for (b=0; b<3; b++)
      {
        if (board[a][1] == c)
        {
          return true;
        }
      }
    }
    return false;
  }
  public boolean vertical3(char c)
  {
    int a, b;
    for (a=0; a<3; a++)
    {
      for (b=0; b<3; b++)
      {
        if (board[a][2] == c)
        {
          return true;
        }
      }
    }
    return false;
  }
  public boolean horizontal1(char c)
  {
    int a, b;
    for (a=0; a<3; a++)
    {
      for (b=0; b<3; b++)
      {
        if (board[0][b] == c)
        {
          return true;
        }
      }
    }
    return false;
  }
  public boolean horizontal2(char c)
  {
    int a, b;
    for (a=0; a<3; a++)
    {
      for (b=0; b<3; b++)
      {
        if (board[1][b] == c)
        {
          return true;
        }
      }
    }
    return false;
  }
  public boolean horizontal3(char c)
  {
    int a, b;
    for (a=0; a<3; a++)
    {
      for (b=0; b<3; b++)
      {
        if (board[2][b] == c)
        {
          return true;
        }
      }
    }
    return false;
  }
  public boolean diagonal1_1(char c)
  {
    int a, b;
    for (a=0; a<3; a++)
    {
      for (b=0; b<3; b++)
      {
        if (board[2][0] == c)
        {
          return true;
        }
      }
    }
    return false;
  }
  public boolean diagonal1_2(char c)
  {
    int a, b;
    for (a=0; a<3; a++)
    {
      for (b=0; b<3; b++)
      {
        if (board[1][1] == c)
        {
          return true;
        }
      }
    }
    return false;
  }
  public boolean diagonal1_3(char c)
  {
    int a, b;
    for (a=0; a<3; a++)
    {
      for (b=0; b<3; b++)
      {
        if (board[0][2] == c)
        {
          return true;
        }
      }
    }
    return false;
  }
  public boolean diagonal2_1(char c)
  {
    int a, b;
    for (a=0; a<3; a++)
    {
      for (b=0; b<3; b++)
      {
        if (board[0][0] == c)
        {
          return true;
        }
      }
    }
    return false;
  }
  public boolean diagonal2_2(char c)
  {
    int a, b;
    for (a=0; a<3; a++)
    {
      for (b=0; b<3; b++)
      {
        if (board[1][1] == c)
        {
          return true;
        }
      }
    }
    return false;
  }
  public boolean diagonal2_3(char c)
  {
    int a, b;
    for (a=0; a<3; a++)
    {
      for (b=0; b<3; b++)
      {
        if (board[2][2] == c)
        {
          return true;
        }
      }
    }
    return false;
  }
  public boolean noWinner(char c)
  {
    int spaces;
    boolean noWin = false;
    spaces = 0;
    int a, b;
    for (a=0; a<3; a++)
    {
      for (b=0; b<3; b++)
      {
        if (board[a][b] == ' ')
        {
          spaces += 1;
        }
      }
    }
    
    if ((curPlayer == c) && (spaces < 2))
    {
      for (a=0; a<3; a++)
      {
        for (b=0; b<3; b++)
        {
          if (board[a][b] == ' ')
          {
            // checks vertical 
            {
              if ((vertical1(c) && vertical2(c)) || (vertical1(c) && vertical3(c)) || (vertical2(c) && vertical3(c)))
              {
                noWin = true;
              }
            }
            // checks horizontal 
            {
              if ((horizontal1(c) && horizontal2(c)) || (horizontal1(c) && horizontal3(c)) || (horizontal2(c) && horizontal3(c)))
              {
                noWin = true;
              }
            }
            // checks diagonal
            {
              if ((diagonal1_1(c) && diagonal1_2(c)) || (diagonal1_1(c) && diagonal1_3(c)) || (diagonal1_2(c) && diagonal1_3(c)))
              noWin = true;
            }
            {
              if ((diagonal2_1(c) && diagonal2_2(c)) || (diagonal2_1(c) && diagonal2_3(c)) || (diagonal2_2(c) && diagonal2_3(c)))
              noWin = true;
            }
        
          }
          
        }
      }
    }
    return noWin;
  }
}
  


/* Sample Output:

 | | 
-----
 | | 
-----
 | | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 0

X| | 
-----
 | | 
-----
 | | 

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 0

X| | 
-----
 | | 
-----
O| | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 1

X| | 
-----
 |X| 
-----
O| | 

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 1

X| | 
-----
 |X| 
-----
O|O| 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 2

X| | 
-----
 |X| 
-----
O|O|X

Player X wins!

************************************************
*********** Running the program again **********
************************************************

 | | 
-----
 | | 
-----
 | | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
-1 1
Invalid entry: row and column must both be between 0 and 2 (inclusive).
Please try again.
It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 3
Invalid entry: row and column must both be between 0 and 2 (inclusive).
Please try again.
It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 1

 | | 
-----
 |X| 
-----
 | | 

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 1
Invalid entry: Row 1 at Column 1 already contains: X
Please try again.
It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 0

 | | 
-----
 |X| 
-----
O| | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 0

X| | 
-----
 |X| 
-----
O| | 

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 2

X| | 
-----
 |X| 
-----
O| |O

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 2

X| |X
-----
 |X| 
-----
O| |O

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 1

X| |X
-----
 |X| 
-----
O|O|O

Player O wins!

************************************************
*********** Running the program again **********
************************************************

 | | 
-----
 | | 
-----
 | | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 2

 | | 
-----
 | | 
-----
 | |X

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 0

O| | 
-----
 | | 
-----
 | |X

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 2

O| |X
-----
 | | 
-----
 | |X

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 1

O| |X
-----
 |O| 
-----
 | |X

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 2

O| |X
-----
 |O|X
-----
 | |X

Player X wins!

************************************************
*********** Running the program again **********
******************************************************
* Following is Extra Credit: determine if unwinnable *
******************************************************

 | | 
-----
 | | 
-----
 | | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 0

X| | 
-----
 | | 
-----
 | | 

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 0

X| | 
-----
 | | 
-----
O| | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 2

X| |X
-----
 | | 
-----
O| | 

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 1

X|O|X
-----
 | | 
-----
O| | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 2

X|O|X
-----
 | | 
-----
O| |X

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 1

X|O|X
-----
 |O| 
-----
O| |X

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 1

X|O|X
-----
 |O| 
-----
O|X|X

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 2

X|O|X
-----
 |O|O
-----
O|X|X

Nobody can win now. Game ends in a draw.
************************************************
*********** Running the program again **********
******************************************************
* Following is Extra Credit: determine if unwinnable *
******************************************************

 | | 
-----
 | | 
-----
 | | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 1

 | | 
-----
 |X| 
-----
 | | 

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 0

O| | 
-----
 |X| 
-----
 | | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 2

O| |X
-----
 |X| 
-----
 | | 

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 0

O| |X
-----
 |X| 
-----
O| | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 2

O| |X
-----
 |X| 
-----
O| |X

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 2

O| |X
-----
 |X|O
-----
O| |X

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 0

O| |X
-----
X|X|O
-----
O| |X

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 1

O|O|X
-----
X|X|O
-----
O| |X

Nobody can win now. Game ends in a draw.
 

*/