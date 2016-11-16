
public class part_1_oper 
{
	
	public static void main(String[] args) 
	{
		System.out.println(task_1_summOrMult(4, 7));
		System.out.println(task_2_chetv(0,0));
		System.out.println(task_3_summ(-3, 2, 8));
		System.out.println(task_4_max(3, 5, 1));
		System.out.println(task_5_getMark(73));
	}
	
	public static int task_1_summOrMult(int a, int b)
	{
		int result = 0;
		
		if(a % 2 == 0)
		{
			result = a * b;
		}
		else
		{
			result = a + b;
		}
		
		return result;
	}
	public static int task_2_chetv(int x, int y)
	{
		int res = 0;
		
		if (x > 0 && y > 0)
		{
			res = 1;
		} 
		else if (x > 0 && y < 0)
		{
			res = 2;
		} 
		else if (x < 0 && y < 0)
		{
			res = 3;
		} 
		else if (x < 0 && y > 0)
		{
			res = 4;
		} 
		else if (x == 0 && y == 0)
		{
			res = 0;
		}
		else
		{
			throw new IllegalArgumentException();
		}
		
		return res;
	}
	public static int task_3_summ(int a, int b, int c)
	{
		int sum = 0;
		
		if (a >= 0)
		{
			sum += a;
		}
		if (b >= 0)
		{
			sum += b;
		}
		if (c >= 0)
		{
			sum += c;
		}
		
		return sum;
	}
	public static int task_4_max(int a, int b, int c)
	{
		int res = 0;
		
		if ((a * b * c) >= (a + b + c))
		{
			res = (a * b * c) + 3;
		}
		else
		{
			res = a + b + c + 3;
		}
		
		return res;
	}
	public static char task_5_getMark(int num)
	{
		char result = 'Z';
		
		if (num >= 0 && num <= 19)
		{
			result = 'F';
		}
		else if (num >= 20 && num <= 39)
		{
			result = 'E';
		}
		else if (num >= 40 && num <= 59)
		{
			result = 'D';
		}
		else if (num >= 60 && num <= 74)
		{
			result = 'C';
		}
		else if (num >= 75 && num <= 89)
		{
			result = 'B';
		}
		else if (num >= 90 && num <= 100)
		{
			result = 'A';
		}
		else
		{
			throw new IllegalArgumentException();
		}
		return result;
	}
}
