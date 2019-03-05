
public class part_2_cycles 
{
	
	public static void main(String[] args) 
	{
		System.out.println(task_1_summOdd());
		System.out.println(task_2_checkPrime(17));
		System.out.println(task_3_sqrt(25));
		System.out.println(task_4_fact(10));
		System.out.println(task_5_numSum(824));
		System.out.println(task_6_reverse(893275));
	}
	
	public static int task_1_summOdd()
	{
		int summ = 0;
		
		for (int i = 1; i <= 99; i++)
		{
			if(i % 2 == 0)
			{
				summ += i;
			}
		}
		
		return summ;
	}
	public static boolean task_2_checkPrime(int num)
	{
		boolean result = true;
		
		if (num < 2)
		{
			return false;
		}
		for (int i = 2; i * i <= num; i++)
		{
			if (num % i == 0)
			{
				result = false;
			}
		}
		
		return result;
	}
	public static int task_3_sqrt(int number)
	{
		int i = 1;
		
		while((i*i)<=(number))
		{
			i++;
		}
		
		return (i-1);
	}
	public static int task_4_fact(int num)
	{
		int res = 1;
		
		for(int i = 1; i <= num; i++)
		{
			res = res * i;
		}
		
		return res;
	}
	public static int task_5_numSum(int num)
	{
		int sum = 0;
		
		while (num != 0)
		{
			sum += num % 10;
			num /= 10;
		}
		
		return Math.abs(sum);
	}
	public static int task_6_reverse(int num)
	{
		int result = 0;
		
		while (num != 0)
		{
			result = result * 10 + num % 10;
			num /= 10;
		}
		
		return Math.abs(result);
	}
}
