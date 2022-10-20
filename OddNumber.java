import java.util.Scanner;

public class OddNumber {
	private static Scanner sc;
	public static void main(String[] args) 
	{
		int number, i;
		sc = new Scanner(System.in);
		
		System.out.print(" Please Enter any Number : ");
		number = sc.nextInt();	
		
		for(i = 1; i <= number; i++)
		{
			if(i % 2 != 0)
			{
				System.out.print(i +"\t"); 
			}
		}	
	}
}
