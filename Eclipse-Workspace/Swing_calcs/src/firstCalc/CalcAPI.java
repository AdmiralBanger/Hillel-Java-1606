package firstCalc;

public class CalcAPI 
{
	public static int FCalc(int a, int b, char op)
	{
		if (op == '/' && b == 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			int result = 0;
			switch (op)
			{
				case '+': result = a + b; break;
				case '-': result = a - b; break;
				case '*': result = a * b; break;
				case '/': result = a / b; break;
			}
			return result;
		}
	}
}
