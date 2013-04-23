import java.util.Scanner;

public class b {
	
	public static String solve(Scanner in)
	{
		int x = in.nextInt();
		int y = in.nextInt();

		int[][] lawn = new int[x][y];

		for (int i = 0; i < x; i++)
		{
			for (int j = 0; j < y; j++)
			{
				lawn[i][j] = in.nextInt();
			}
		}


		if (checkLawn(lawn))
			return "YES";
		else
			return "NO";
		
	}

	public static boolean checkLawn(int[][] lawn)
	{
		for (int i = 0; i < lawn.length; i++)
		{
			for (int j = 0; j < lawn[i].length; j++)
			{
				if (!checkLine(getRow(lawn, i), lawn[i][j]) && !checkLine(getCol(lawn, j), lawn[i][j]))
				{
					return false;
				}
			}
		}

		return true;
	}

	public static boolean checkLine(int[] line, int num)
	{
		for (int i = 0; i < line.length; i++)
		{
			if (line[i] > num)
			{
				return false;
			}
		}
		return true;
	}

	public static int[] getRow(int[][] lawn, int row)
	{
		return lawn[row];	
	}

	public static int[] getCol(int[][] lawn, int col)
	{
		int[] work = new int[lawn.length];

		for (int j = 0; j < lawn.length; j++)
		{
				work[j] = lawn[j][col];
		}	

		return work;
	}

	public static void print(int[][] lawn)
	{
		for (int i = 0; i < lawn.length; i++)
		{
			for (int j = 0; j < lawn[i].length; j++)
			{
				System.out.print(lawn[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);

		int numberGames = Integer.parseInt(in.nextLine());

		for (int i = 0; i < numberGames; i++)
		{
			System.out.println("Case #" + (i+1) + ": " + solve(in));
		}	

	}
}