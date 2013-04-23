import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.lang.Math;

public class c {
	
	// Check if an int is a palindrome
	public static boolean check(int foo)
	{
		String bar = String.valueOf(foo);
		String reversed = new StringBuilder(bar).reverse().toString();

		if (bar.equals(reversed))
			return true;
		else
			return false;
	}

	public static int solve(Scanner in)
	{
		int counter = 0;
		int first = in.nextInt();
		int first_down = (int)Math.ceil(Math.sqrt(first));
		int second = in.nextInt();
		int second_down = (int)Math.floor(Math.sqrt(second));
		for (int i = first_down; i <= second_down; i++)
		{
			if (check(i) && check((int)Math.pow(i,2)))
			{
				counter++;
			}
		}
		in.nextLine();
		return counter;
	}


	public static void main(String args[])
	{
		
		Scanner in = new Scanner(System.in);

		int numberProblems = Integer.parseInt(in.nextLine());
		for (int i = 0; i < numberProblems; i++)
			System.out.println("Case #" + (i+1) + ": " + solve(in));


	}
	
}