package Lists;

public class List1 implements ListInterface
{
	private int[] arr = new int[10];
	private int index = 0;
	
	@Override
	public void init(int[] mas) 
	{
		if (arr == null)
		{
			mas = new int[0];
		}
		
		for (int i = 0; i < mas.length; i++)
		{
			arr[i] = mas[i];
		}
		
		index = mas.length;
	}
	@Override
	public void print() 
	{
		for (int i = 0; i < index; i++) 
		{
			System.out.print(arr[i] + ", ");
		}
	}
	@Override
	public void clear() 
	{
		index = 0;
	}
	@Override
	public String toString()
	{
		String str = "";
		
		for (int i = 0; i < index; i++)
		{
			str += Integer.toString(arr[i]);
		}
		
		return str;
	}
	@Override
	public int[] toArray() 
	{
		int[] temp = new int[index];
		
		for (int i = 0; i < index; i++)
		{
			temp[i] = arr[i];
		}
		
		return temp;
	}
	@Override
	public int size() 
	{
		return index;
	}
	@Override
	public void addStart(int num) 
	{
		index++;
		int[] tmp = new int[arr.length];
		
		for (int i = 1; i < size(); i++)
		{
			tmp[i] = arr[i - 1];
		}
		tmp[0] = num;
		
		arr = tmp;
	}
	@Override
	public void addEnd(int num) 
	{
		arr[index++] = num;
	}
	@Override
	public void addPos(int pos, int num) 
	{
		if (pos > size()+1 || pos < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		index++;
		int[] temp = new int[arr.length];
		
		for (int i = 0; i < size(); i++)
		{
			if (i < pos)
			{
				temp[i] = arr[i];
			} 
			else if (i == pos)
			{
				temp[pos] = num;
			} 
			else
			{
				temp[i] = arr[i - 1];
			}
		}
		
		arr = temp;
	}
	@Override
	public int delStart() 
	{
		if (index == 0)
		{
			throw new NullPointerException();
		}
		
		int[] tmp = new int[arr.length];
		int value = arr[0];
		index--;
		
		for (int i = 0; i < size(); i++)
		{
			tmp[i] = arr[i + 1];
		}
		arr = tmp;
		
		return value;
	}
	@Override
	public int delEnd() 
	{
		if (index == 0)
		{
			throw new NullPointerException();
		}
		index--;
		return arr[index];
	}
	@Override
	public int delPos(int pos) 
	{
		if (pos > index || pos < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		if (index == 0)
		{
			throw new NullPointerException();
		}
		
		int value = arr[pos];
		
		for (int i = pos; i < index; i++)
		{
			arr[i] = arr[i + 1];
		}
		index--;
		
		return value;
	}
	@Override
	public int get(int pos) 
	{
		if (pos >= index || pos < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		return arr[pos];
	}
	@Override
	public void set(int pos, int num) 
	{
		if (pos >= index)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		arr[pos] = num;
	}
	@Override
	public int min() 
	{
		if (index == 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		int min = arr[0];
		
		for (int i = 0; i < index; i++)
		{
			if (arr[i] < min)
			{
				min = arr[i];
			}
		}
		
		return min;
	}
	@Override
	public int max() 
	{
		if (index == 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		int max = arr[0];
		
		for (int i = 0; i < index; i++)
		{
			if (arr[i] > max)
			{
				max = arr[i];
			}
		}
		
		return max;
	}
	@Override
	public int minIndex() 
	{
		if (index == 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		int min = arr[0];
		int ind = 0;
		for (int i = 1; i < index; i++)
		{
			if (arr[i] < min)
			{
				ind = i;
				min = arr[i];
			}
		}
		return ind;
	}
	@Override
	public int maxIndex() 
	{
		if (index == 0)
		{
			throw new IndexOutOfBoundsException();
		}

		int max = arr[0];
		int ind = 0;
		
		for (int i = 1; i < index; i++)
		{
			if (arr[i] > max)
			{
				max = arr[i];
				ind = i;
			}
		}
		
		return ind;
	}
	@Override
	public void reverse() 
	{
		int[] res = new int[arr.length];
		int j = 0;
		
		for (int i = index - 1; i >= 0; i--)
		{
			res[j] = arr[i];
			j++;
		}
		
		arr = res;
	}
	@Override
	public void sort() 
	{
		for (int i = index - 1; i >= 1; i--)
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
	public void halfReverse()
	{
		if (size() < 1)
		{
			throw new NegativeArraySizeException();
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
