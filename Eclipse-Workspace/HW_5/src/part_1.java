
public class part_1 
{
	
	public static void main(String[] args) 
	{
		task1();
		task2();
		task3();
		task4();
		task5();
	}
	
	public static void task1()
	{
		for(char i = 'A'; i <= 'Z'; i++)
		{
			System.out.print(i);
		}
	}
	
	public static void task2()
	{
		System.out.println();
		for(char i = 'z'; i >= 'a'; i--)
		{
			System.out.print(i);
		}
	}
	
	public static void task3()
	{
		System.out.println();
		for(char i = 'à'; i <= 'ÿ'; i++)
		{
			System.out.print(i);
		}
	}
	
	public static void task4()
	{
		System.out.println();
		for(int i = 0; i <= 9; i++)
		{
			System.out.print(i);
		}
	}

	
	public static void task5()
	{
		System.out.println();
		for(int i = 32; i <= 255; i++)
		{
			System.out.print((char)i);
		}
	}
}
