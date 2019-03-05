
public class part_4_functions 
{
	
	public final static String[] massOne = { 	"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять" };
	public final static String[] massDec = { "", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто" };
	public final static String[] massHundreds = { "", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот" };
	public final static String[] massNacat = { "десять", "одинадцать", "двенадцать", "тринадцать", "четырнадцать", "пятьнадцать", "шестьнадцать", "семьнадцать", "восемьнадцать", "девятьнадцать" };

	public static void main(String[] args) 
	{
		int[] x = {10, 12}, y = {27, 21};
		System.out.println(task_1_getDay(5));
		System.out.println(task_2_getString(27));
		System.out.println(task_3_getNumber("восемьдесят два"));
		System.out.println(task_4_getDist(x, y));
	}
	
	public static String task_1_getDay(int numDay)
	{
		if (numDay <= 0 || numDay >= 8)
		{
			throw new IllegalArgumentException();
		}
		String[] days = {null, "Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"};
		return days[numDay];
	}
	public static String task_2_getString(int num)
	{
		if (num == 0)
		{
			return "ноль";
		}
		int divider = 10;
		int remain = 0;
		String string = "";
		int temp = num % 10;
		for (int i = 1; i <= 3; i++)
		{
			remain = num % divider;
			num /= 10;
			if (remain != 0)
			{
				if (i == 1)
				{
					string = massOne[remain];
				}
				if (i == 2)
				{
					if (remain == 1)
					{
						string = massNacat[temp];
					} 
					else
					{
						if (temp == 0)
						{
							string = "";
						}
						string = massDec[remain] + " ".concat(string);
					}
				}
				if (i == 3)
				{
					string = massHundreds[remain] + " ".concat(string);
				}
			}
			if (string.endsWith(" "))
			{
				string = string.substring(0, string.length() - 1);
			}
		}
		return string;
	}
	public static int task_3_getNumber(String string)
	{
		int count = 0;
		String[] stringsMass = string.split(" ");
		for (int i = stringsMass.length - 1, j = 1; i >= 0; i--, j++)
		{
			int dig = serchDig(stringsMass[i], j);
			if (dig == -1)
			{
				throw new IllegalArgumentException();
			}
			count += dig;
		}
		return count;
	}
	public static double task_4_getDist(int[] x, int[] y)
	{
		if (x == null || x.length < 2 || y == null || y.length < 2)
		{
			throw new IllegalArgumentException();
		}
		return Math.sqrt(Math.pow((x[0] - y[0]), 2) + Math.pow((x[1] - y[1]), 2));
	}

	public static int serchDig(String string, int position)
	{
		int dig = 0;
		int i = 0;
		do
		{
			if (string.equals(massOne[i]))
			{
				dig = i;
				return dig;
			}
			i++;
		} while (i < massOne.length);
		i = 0;
		do
		{
			if (string.equals(massDec[i]))
			{
				dig = i * 10;
				return dig;
			}
			i++;
		} while (i < massDec.length);
		i = 0;
		do
		{
			if (string.equals(massHundreds[i]))
			{
				dig = i * 100;
				return dig;
			}
			i++;
		} while (i < massDec.length);
		i = 0;
		do
		{
			if (string.equals(massNacat[i]))
			{
				dig = i + 10;
				return dig;
			}
			i++;
		} while (i < massDec.length);

		return -1;
	}
}
