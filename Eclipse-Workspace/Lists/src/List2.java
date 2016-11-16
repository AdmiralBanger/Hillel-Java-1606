

public class List2 implements ListInterface
{
	private int[] arr = new int[30];
	private int start = arr.length / 2;
	private int end = start;
	
	@Override
	public void init(int[] a) 
	{
		if (a == null)
		{
			throw new NullPointerException();
		}
		
		start = arr.length / 2;
		end = a.length + start;
		for (int i = 0; i < a.length; i++)
		{
			arr[start + i] = a[i];
		}
	}
	@Override
	public void print() 
	{
		for (int i = 0; i < size(); i++)
		{
			System.out.print("" + arr[start + i]);
		}
	}
	@Override
	public void clear() 
	{
		start = arr.length / 2;
		end = start;
	}
	@Override
	public String toString()
	{
		String temp = "";
		
		for (int i = 0; i < size(); i++)
		{
			temp += arr[start + i] + "";
		}
		
		return temp;
	}
	@Override
	public int[] toArray() 
	{
		int[] temp = new int[size()];
		
		for (int i = 0; i < size(); i++)
		{
			temp[i] = arr[start + i];
		}
		
		return temp;
	}
	@Override
	public int size() 
	{
		return end - start;
	}
	@Override
	public void addStart(int num) 
	{
		start--;
		arr[start] = num;
	}
	@Override
	public void addEnd(int num) 
	{
		arr[end++] = num;
	}
	@Override
	public void addPos(int pos, int num) 
	{
		if (pos < 0 || pos > end)
		{
			throw new IndexOutOfBoundsException();
		}
		end++;
		int i = end;
		while (i > start + pos)
		{
			arr[i] = arr[i - 1];
			i--;
		}
		arr[start + pos] = num;
	}
	@Override
	public int delStart() 
	{
		if (size() == 0)
		{
			throw new NullPointerException();
		}
		int res = arr[start];
		start++;
		return res;
	}
	@Override
	public int delEnd() 
	{
		if (size() == 0)
		{
			throw new NullPointerException();
		}
		int res = arr[end];
		end--;
		return res;
	}
	@Override
	public int delPos(int pos) 
	{
		if (size() == 0)
		{
			throw new NullPointerException();
		}
		if (pos < 0 || pos > size())
		{
			throw new IndexOutOfBoundsException();
		}
		for (int i = pos; i < size(); i++)
		{
			arr[start + i] = arr[start + 1 + i];
		}
		int res = arr[start + pos];
		end--;
		return res;
	}
	@Override
	public int get(int pos) 
	{
		if ((end - start) == 0 || pos < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		return arr[start + pos];
	}
	@Override
	public void set(int pos, int num) 
	{
		if ((end - start) == 0 || pos < 0)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		arr[start + pos] = num;
	}
	@Override
	public int min() 
	{
		if (size() == 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		int min = arr[start];
		
		for (int i = 0; i < size(); i++)
		{
			if (arr[start + i] < min)
			{
				min = arr[start + i];
			}
		}
		
		return min;
	}
	@Override
	public int max() 
	{
		if (size() == 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		int max = arr[start];
		
		for (int i = 0; i < size(); i++)
		{
			if (arr[start + i] > max)
			{
				max = arr[start + i];
			}
		}
		
		return max;
	}
	@Override
	public int minIndex() 
	{
		if (size() == 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		int min = start;
		for (int i = 1; i < size(); i++)
		{
			if (arr[start + i] < arr[min])
			{
				min = start + i;
			}
		}
		return min-start;
	}
	@Override
	public int maxIndex() 
	{
		if (size() == 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		int ind = 0;
		int max = arr[start];
		
		for (int i = 1; i < size(); i++)
		{
			if (arr[start + i] > max)
			{
				max = arr[start + i];
				ind = i;
			}
		}
		
		return ind;
	}
	@Override
	public void reverse() 
	{
		int[] res = new int[size()];
		int j = 0;
		
		for (int i = size() - 1; i >= 0; i--)
		{
			res[j] = arr[start + i];
			j++;
		}
		
		clear();
		init(res);
	}
	@Override
	public void sort() 
	{
		for (int i = size() - 1; i >= 1; i--)
		{
			boolean sorted = true;
			for (int j = 0; j < i; j++)
			{
				if (arr[start + j] > arr[start + j + 1])
				{
					int temp = arr[start + j];
					arr[start + j] = arr[start + j + 1];
					arr[start + j + 1] = temp;
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
		int dx = (size()%2 == 0) ? 0 : 1;
		for (int i = 0; i < size()/2; i++)
		{
			int temp = arr[i+start];
			arr[i+start] = arr[size()/2 + start + i + dx];
			arr[size()/2 + start + i + dx] = temp;	
		}
	}
}
