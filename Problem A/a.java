import java.util.Scanner;
import java.util.Arrays;
import java.util.NoSuchElementException;
 
public class a {
 
    public static String solve(Scanner input)
    {
        char[][] board = new char[4][4];
 
        for (int i = 0; i < 4; i++)
        {
            String row = input.nextLine();
            for (int j = 0; j < 4; j++)
            {
                board[i][j] = row.charAt(j);
            }
        }
 
        char result = checkWinner(board);
    
        if (result == 'X')
            return "X won";
        if (result == 'O')
            return "O won";
        if (result == 'D')
            return "Draw";
        if (result == 'N')
            return "Game has not completed";

        return "Draw";
    }
 
    public static char checkWinner(char[][] board)
    {
        char result;
        char[] work = new char[4];
        // Check Row
        for(int i = 0; i < 4; i++)
        {
            System.arraycopy(board[i], 0, work, 0, board[i].length);
            char res = checkLine(work);
            if (res == 'X' || res == 'O')
                return res;
        }

        //Check Column
        for(int i = 0; i < 4; i++)
        {
            work = new char[4];
            for (int j = 0; j < 4; j++)
            {
                work[j] = board[j][i];
            }
            char res = checkLine(work);
            if (res == 'X' || res == 'O')
                return res;
        }

        //Check first diagonal
        work = new char[4];
        for(int i = 0; i < 4; i++)
        {
            work[i] = board[i][i];
        }
        char res = checkLine(work);
        if (res == 'X' || res == 'O')
            return res;

        //Check second diagonal
        work = new char[4];
        int counter = 0;
        for(int i = 3; i >= 0; i--)
        {
            work[i] = board[counter][i];
            counter++;
        }
        res = checkLine(work);
        if (res == 'X' || res == 'O')
            return res;

        for (int i = 0; i < 4; i++)
        {
            if (board[i][0] == '.')
                return 'N';
        }
 
        return 'D';
    }
 
    public static char checkLine(char[] line)
    {
        char result = 'D';
        final char[] X_WIN_1 = {'T','X','X','X'};
        final char[] X_WIN_2 = {'X','X','X','X'};
        final char[] O_WIN_1 = {'O','O','O','T'};
        final char[] O_WIN_2 = {'O','O','O','O'};

        Arrays.sort(line);

        if (Arrays.equals(X_WIN_1, line) || Arrays.equals(X_WIN_2, line))
            result = 'X';

        if (Arrays.equals(O_WIN_1, line) || Arrays.equals(O_WIN_2, line))
            result = 'O';

        return result;

    }
 
    public static void main(String args[])
   {
        Scanner in = new Scanner(System.in);
 
        int numberGames =  Integer.parseInt(in.nextLine());
        for (int i = 0; i < numberGames; i++)
        {
            System.out.println("Case #" + (i+1) + ": " + solve(in));
            try
            {
                in.nextLine();
            }
            catch(NoSuchElementException e)
            {
                System.out.print("");
            }
        }

 
    }
}