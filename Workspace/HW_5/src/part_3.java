
public class part_3 
{

	public static void main(String[] args) 
	{
		String str = " аждый охотник желает знать,где сидит фазан.";
		String[] strArr = {" аждый", "охотник", "желает", "знать", "где", "сидит", "фазан"};
		System.out.println(task_1_findMinWord(str));
		task_2_change3LastSimbol(strArr, 5);
		for (int i = 0; i < strArr.length; i++)
		{
			System.out.print(strArr[i] + " ");
		}
		System.out.println();
		System.out.println(task_3_addSpace(str));
		System.out.println(task_4_oneSimbol(str));
		System.out.println(task_5_countNumWord(str));
		System.out.println(task_6_removePartString(str, 10, 10));
		System.out.println(task_7_reversString(str));
		System.out.println(task_8_removeLastWord(str));
	}
	
	public static int task_1_findMinWord(String string) 
	{
		if (string == null) 
		{
			throw new NullPointerException();
		}
		
		int shortWord = 0;
		string = string.trim();
		String[] stringArr = string.split("(\\,\\s|\\s)");
		shortWord = stringArr[0].length();
		for (int i = 1; i < stringArr.length; i++) 
		{
			if (stringArr[i].length() < shortWord) 
			{
				shortWord = stringArr[i].length();
			}
		}
		return shortWord;
	}
	public static String[] task_2_change3LastSimbol(String[] massString, int length) 
	{
		if (massString == null) 
		{
			throw new NullPointerException();
		}
		for (int i = 0; i < massString.length; i++) 
		{
			if (massString[i].length() == length)
			{
				massString[i] = massString[i].replaceAll("...$", "\\$");
			}
		}
		return massString;
	}
	public static String task_3_addSpace(String string) 
	{
		return string.replaceAll(",(?!\\s)", ", ");
	}
	public static String task_4_oneSimbol(String string) 
	{
		if (string == null) 
		{
			throw new NullPointerException();
		}
		String ret = null;
		StringBuffer sb = new StringBuffer();
		char ch = ' ';
		while (!string.isEmpty()) 
		{
			ch = string.charAt(0);
			sb.append(ch);
			string = string.replaceAll(ch + "+", "");
		}
		ret = sb.toString();
		return ret;
	}
	public static int task_5_countNumWord(String string) 
	{
		String[] massStrings = null;
		if (string == null) 
		{
			throw new NullPointerException();
		} 
		else if (string.length() == 0) 
		{
			return 0;
		} 
		else 
		{
			massStrings = string.split("\\s|\\,\\s|\\,");
		}
		return massStrings.length;
	}
	public static String task_6_removePartString(String string, int index, int length) 
	{
		StringBuffer strBuff = new StringBuffer();
		if (string == null) 
		{
			throw new NullPointerException();
		} 
		else if ((index + length) > string.length()) 
		{
			throw new IllegalArgumentException();
		} 
		else 
		{
			strBuff = new StringBuffer();
			strBuff = strBuff.append(string);
			strBuff.delete(index, index + length);
		}
		return strBuff.toString();
	}
	public static String task_7_reversString(String string) 
	{
		StringBuffer strBuff = new StringBuffer();
		if (string == null) 
		{
			throw new NullPointerException();
		}
		strBuff = strBuff.append(string);
		strBuff.reverse();
		return strBuff.toString();
	}
	public static String task_8_removeLastWord(String string) 
	{
		string = string.replaceAll("\\s[а-€]*$", "");
		return string.trim();
	}
}
