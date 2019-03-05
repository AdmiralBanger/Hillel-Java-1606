import java.util.Random;

public class random 
{
	
	public static void main(String[] args) 
	{
		task_1_oneNum();
		task_2_tenNum();
		task_3_tenNum_0to10();
		task_4_tenNum_20to50();
		task_5_tenNum_Min10to10();
		task_6_tenNumLast();
	}
	
	public static void task_1_oneNum()
	{
		Random rd = new Random();
		int random = rd.nextInt();
		System.out.println(random);
	}
	public static void task_2_tenNum()
	{
		Random rd = new Random();
		for (int i = 1; i <= 10; i++)
		{
			System.out.print(rd.nextInt() + "\t");
		}
		System.out.println();
	}
	public static void task_3_tenNum_0to10()
	{
		Random rd = new Random();
		for (int i = 1; i <= 10; i++)
		{
			System.out.print(rd.nextInt(10) + "\t");
		}
		System.out.println();
	}
	public static void task_4_tenNum_20to50()
	{
		Random rd = new Random();
		for (int i = 1; i <= 10; i++)
		{
			System.out.print(rd.nextInt(30) + 20 + "\t");
		}
		System.out.println();
	}
	public static void task_5_tenNum_Min10to10()
	{
		Random rd = new Random();
		for (int i = 1; i <= 10; i++)
		{
			System.out.print(rd.nextInt(20) - 10 + "\t");
		}
		System.out.println();
	}
	public static void task_6_tenNumLast()
	{
		Random rd = new Random();
		for (int i = 1; i <= rd.nextInt(12) + 3; i++)
		{
			System.out.print(rd.nextInt(45) - 10 + "\t");
		}
		System.out.println();
	}
}
