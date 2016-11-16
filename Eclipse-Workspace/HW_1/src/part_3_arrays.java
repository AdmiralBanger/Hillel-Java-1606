
public class part_3_arrays 
{

	public static void main(String[] args) 
	{
		int[] arr = {3, 6, 2, 3, 7, 1, 9, 5, 6};
		
		System.out.println(task_1_getMin(arr));
		System.out.println(task_2_getMax(arr));
		System.out.println(task_3_getMinInd(arr));
		System.out.println(task_4_getMaxInd(arr));
		System.out.println(task_5_getSummEven(arr));
		
		task_6_reversArr(arr);
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + ' ');
		}
		System.out.println();
		
		System.out.println(task_7_countEven(arr));
		
		task_8_switchHalfArr(arr);
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + ' ');
		}
		System.out.println();
		
		task_9_sortBubble(arr);
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + ' ');
		}
	}
	
	public static int task_1_getMin(int[] arr)
	{
		if (arr == null || arr.length == 0)
		{
			throw new NullPointerException();
		}
		int chMax = arr[0];
		for (int i : arr)
		{
			if (i < chMax)
			{
				chMax = i;
			}
		}
		return chMax;
	}
	public static int task_2_getMax(int[] arr)
	{
		if (arr == null || arr.length == 0)
		{
			throw new NullPointerException();
		}
		int chMax = arr[0];
		for (int i : arr)
		{
			if (i > chMax)
			{
				chMax = i;
			}
		}
		return chMax;
	}
	public static int task_3_getMinInd(int[] arr)
	{
		if (arr == null || arr.length == 0)
		{
			throw new NullPointerException();
		}
		int index = 0;
		int chMin = arr[0];
		for (int i = 1; i < arr.length; i++)
		{
			if (arr[i] < chMin)
			{
				index = i;
				chMin = arr[i];
			}
		}
		return index;
	}
	public static int task_4_getMaxInd(int[] arr)
	{
		if (arr == null || arr.length == 0)
		{
			throw new NullPointerException();
		}
		int index = 0;
		int chMax = arr[0];
		for (int i = 1; i < arr.length; i++)
		{
			if (arr[i] > chMax)
			{
				chMax = arr[i];
				index = i;
			}
		}
		return index;
	}
	
	public static int task_5_getSummEven(int[] arr)
	{
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
		{
			if (i % 2 != 0)
			{
				sum += arr[i];
			}
		}
		return sum;
	}
	public static int[] task_6_reversArr(int[] arr)
	{
		if (arr == null || arr.length == 0)
		{
			return new int[0];
		}
		int[] resArr = new int[arr.length];
		int j = 0;
		for (int i = arr.length - 1; i >= 0; i--)
		{
			resArr[j] = arr[i];
			j++;
		}
		return resArr;
	}
	public static int task_7_countEven(int[] arr)
	{
		int count = 0;
		if (arr != null)
		{
			for (int i = 0; i < arr.length; i++)
			{
				if (arr[i] % 2 != 0)
				{
					count++;
				}
			}
		}
		return count;
	}
	public static int[] task_8_switchHalfArr(int[] arr)
	{
		int[] res = {};
		if (arr != null)
		{
			res = new int[arr.length];
			int midle;
			if (arr.length % 2 == 0)
			{
				midle = arr.length / 2;
			} else
			{
				midle = arr.length / 2 + 1;
				res[midle - 1] = arr[midle - 1];
			}
			for (int i = 0, j = midle; j < arr.length; i++, j++)
			{

				res[j] = arr[i];
				res[i] = arr[j];
			}
		}
		return res;
	}
	public static int[] task_9_sortBubble(int[] arr)
	{
		if (arr == null || arr.length == 0)
		{
			throw new NullPointerException();
		}
		for (int i = arr.length - 1; i >= 1; i--)
		{
			boolean sorted = true;
			for (int j = 0; j < i; j++)
			{
				if (arr[j] > arr[j + 1])
				{
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					sorted = false;
				}
			}
			if (sorted)
			{
				break;
			}
		}
		return arr;
	}
}