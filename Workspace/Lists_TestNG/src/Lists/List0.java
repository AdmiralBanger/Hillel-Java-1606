package Lists;

public class List0 implements ListInterface
{
	private int[] arr = {};
	
	@Override
	public void init(int[] a)
	{
		if (a == null)
		{
			throw new NullPointerException();
		} 
		else if (a.length == 0)
		{
			arr = new int[0];
			return;
		}
		int[] tmp = new int[a.length];
		for (int i = 0; i < a.length; i++)
		{
			tmp[i] = a[i];
		}
		arr = tmp;
	}
	@Override
	public void print()
	{
		for (int i = 0; i < arr.length; i++) 
		{
			System.out.print(arr[i] + ", ");
		}
	}
	@Override
	public void clear()
	{
		arr = new int[0];
	}
	@Override
	public String toString()
	{
		String str = "";
		
		for (int i = 0; i < arr.length; i++)
		{
			str += Integer.toString(arr[i]);
		}
		
		return str;
	}
	@Override
	public int[] toArray()
	{
		int[] ret = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++)
		{
			ret[i] = arr[i];
		}
		
		return ret;
	}
	@Override
	public int size()
	{
		return arr.length;
	}
	@Override
	public void addStart(int num)
	{
		if (arr == null)
		{
			throw new NullPointerException();
		}
		
		int[] temp = new int[arr.length + 1];
		for (int i = 1; i < temp.length; i++)
		{
			temp[i] = arr[i - 1];
		}
		temp[0] = num;
		arr = temp;
	}
	@Override
	public void addEnd(int num)
	{
		int[] temp = new int[arr.length + 1];
		
		for (int i = 0; i < arr.length; i++)
		{
			temp[i] = arr[i];
		}
		temp[temp.length - 1] = num;
		arr = temp;
	}
	@Override
	public void addPos(int pos, int num)
	{
		if (pos > arr.length || pos < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		int[] temp = new int[arr.length + 1];
		for (int i = 0; i < pos; i++)
		{
			temp[i] = arr[i];
		}
		temp[pos] = num;
		for (int i = pos + 1; i < temp.length; i++)
		{
			temp[i] = arr[i - 1];
		}
		arr = temp;
	}
	@Override
	public int delStart()
	{
		if (arr.length == 0)
		{
			throw new NullPointerException();
		}
		
		int[] temp = new int[arr.length - 1];
		int del = arr[0];
		for (int i = 0; i < temp.length; i++)
		{
			temp[i] = arr[i + 1];
		}
		arr = temp;
		
		return del;
	}
	@Override
	public int delEnd()
	{
		if (arr.length == 0)
		{
			throw new NullPointerException();
		}
		
		int[] res = new int[arr.length - 1];
		
		int del = arr[arr.length - 1];
		for (int i = 0; i < res.length; i++)
		{
			res[i] = arr[i];
		}
		arr = res;
		
		return del;
	}
	@Override
	public int delPos(int pos)
	{
		if (pos > arr.length)
		{
			throw new IndexOutOfBoundsException();
		}
		if (arr.length == 0)
		{
			throw new NullPointerException();
		}
		
		int[] temp = new int[arr.length - 1];
		int del = arr[pos];
		for (int i = 0; i < pos; i++)
		{
			temp[i] = arr[i];
		}
		for (int i = pos; i < temp.length; i++)
		{
			temp[i] = arr[i + 1];
		}
		arr = temp;
		
		return del;
	}
	@Override
	public int get(int pos)
	{
		return arr[pos];
	}
	@Override
	public void set(int pos, int num)
	{
		arr[pos] = num;
	}
	@Override
	public int min()
	{
		int res = arr[0];
		
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] < res)
			{
				res = arr[i];
			}
		}
		
		return res;
	}
	@Override
	public int max()
	{
		int res = arr[0];
		
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] > res)
			{
				res = arr[i];
			}
		}
		
		return res;
	}
	@Override
	public int minIndex()
	{
		int res = 0;
		
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] < arr[res])
			{
				res = i;
			}
		}
		
		return res;
	}
	@Override
	public int maxIndex()
	{
		int res = 0;
		
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] > arr[res])
			{
				res = i;
			}
		}
		
		return res;
	}
	@Override
	public void reverse()
	{
		int[] temp = new int[arr.length];
		int j = 0;
		for (int i = arr.length - 1; i >= 0; i--)
		{
			temp[j] = arr[i];
			j++;
		}
		arr = temp;
	}
	@Override
	public void sort()
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
	}
	@Override
	public void halfReverse() 
	{
		if (size() < 1)
		{
			throw new NullPointerException();
		}
		int dx = (arr.length%2 == 0) ? 0 : 1;
		for (int i = 0; i < arr.length/2; i++)
		{
			int temp = arr[i];
			arr[i] = arr[arr.length/2 + i + dx];
			arr[arr.length/2 + i + dx] = temp;	
		}
	}
}
