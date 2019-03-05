package Lists;

public class LList2 implements ListInterface
{

	class Node
	{
		int val;
		Node next = null;
		Node prev = null;
		public Node(int val) 
		{
			this.val = val;
		}
	}
	
	Node root = null;
	
	@Override
	public void init(int[] ini) 
	{
		int[] exp = {};
		if(ini == null)
		{	
			throw new NullPointerException();
		}
		else if (exp == ini)
		{
			addStart(ini[0]);
		}
		clear();
		for (int i = ini.length - 1; i >= 0; i--) 
		{
			addStart(ini[i]);
		}
		
	}
	@Override
	public void print() 
	{
		String ans = "";
		Node p = root;
		while (p != null)
		{
			ans += p.val + ", ";
			p = p.next;
		}	
		System.out.println(ans);
	}
	public String toString()
	{
		String str = "";
		Node p = root;		
		
		while (p != null)
		{
			str += "" + p.val;
			p = p.next;
		}
		
		return str;
	}
	@Override
	public int[] toArray() 
	{
		int[] ret = new int[size()];
		Node p = root;
		if (p == null)
		{
			int[] ret1 = {};
			return ret1;
		}
		int i = 0;
		
		while (p != null)
		{
			ret[i] = p.val;
			p = p.next;
			i++;
		}
		
		return ret;
	}
	@Override
	public int size() 
	{
		int ret = 0;
		Node p = root;
		
		while (p != null)
		{
			ret++;
			p = p.next;
		}
		
		return ret;
	}
	@Override
	public void clear() 
	{
		root = null;
	}
	@Override
	public void addStart(int val) 
	{
		Node p = new Node(val);
		if (size() == 0 || root == null)
		{
			root = p;
			root.prev = root;
		}
		else
		{
			p.next = root;
			p.prev = root.prev;
			root.prev = p;
			root = p;
		}
	}
	@Override
	public void addEnd(int val)
	{
		if (size() == 0)
		{
			addStart(val);
		}
		else
		{
			Node p = new Node(val);
			root.prev.next = p;
			p.prev = root.prev;
			root.prev = p;
		}
	}
	@Override
	public void addPos(int pos, int val) 
	{
		if (pos < 0 || pos > size())
		{
			throw new IndexOutOfBoundsException();
		}
		Node p = new Node(val);
		Node temp;
		if (pos == 0)
		{
			addStart(val);
		} 
		else if (pos == size())
		{
			addEnd(val);
		} 
		else
		{
			if (pos <= size() / 2)
			{
				temp = root;
				for (int i = 0; i < pos; i++)
				{
					temp = temp.next;
				}
			} 
			else
			{
				temp = root.prev;
				for (int i = 1; i < size() - pos; i++)
				{
					temp = temp.prev;
				}
			}
			temp.prev.next = p;
			p.prev = temp.prev;
			p.next = temp;
			temp.prev = p;
		}
	}
	@Override
	public int delStart() 
	{
		if (size() == 0)
		{
			throw new NullPointerException();
		}
		int ret = root.val;
		
		root = root.next;
		
		return ret;
	}
	@Override
	public int delEnd() 
	{
		if (size() == 0)
		{
			throw new NullPointerException();
		}
		
		int ret = root.prev.val;
		
		root = null;
		
		return ret;
	}
	@Override
	public int delPos(int pos) 
	{
		if (pos < 0 || pos > size())
		{
			throw new IndexOutOfBoundsException();
		}
		Node p;
		int ret = 0;
		if (pos == 0)
		{
			ret = delStart();
		} 
		else if (pos == size() - 1)
		{
			ret = delEnd();
		} 
		else
		{
			if (pos <= size() / 2)
			{
				p = root;
				for (int i = 0; i < pos; i++)
				{
					p = p.next;
				}
				ret = p.val;
			} 
			else
			{
				p = root.prev;
				for (int i = 1; i < size() - pos; i++)
				{
					p = p.prev;
				}
				ret = p.val;
			}
			p.prev.next = p.next;
			p.next.prev = p.prev;
		}
		return ret;
		
	}
	@Override
	public int get(int pos) 
	{
		if (pos < 0 || pos > size())
		{
			throw new IndexOutOfBoundsException();
		}
		
		Node p;
		if (pos == 0)
		{
			return root.val;
		} 
		else if (pos == size())
		{
			return root.prev.val;
		} 
		else
		{
			if (pos <= size() / 2)
			{
				p = root;
				for (int i = 0; i < pos; i++)
				{
					p = p.next;
				}
			} 
			else
			{
				p = root.prev;
				for (int i = 1; i < size() - pos; i++)
				{
					p = p.prev;
				}
			}
			return p.val;
		}
	}
	@Override
	public void set(int pos, int val) 
	{
		if (pos < 0 || pos > size())
		{
			throw new IndexOutOfBoundsException();
		}
		
		Node p;
		if (pos == 0)
		{
			root.val = val;
		} 
		else if (pos == size())
		{
			root.prev.val = val;
		} 
		else
		{
			if (pos <= size() / 2)
			{
				p = root;
				for (int i = 0; i < pos; i++)
				{
					p = p.next;
				}
			} 
			else
			{
				p = root.prev;
				for (int i = 1; i < size() - pos; i++)
				{
					p = p.prev;
				}
			}
			p.val = val;
		}
	}
	@Override
	public int min() 
	{
		if (size() == 0)
		{
			throw new NegativeArraySizeException();
		}
		
		Node p = root;
		int min = p.val;
		
		while (p != null)
		{			
			if (min > p.val)
			{
				min = p.val;
			}
			p = p.next;
		}
		
		return min;
	}
	@Override
	public int max() 
	{
		if (size() == 0)
		{
			throw new NegativeArraySizeException();
		}
		
		Node p = root;
		int max = p.val;
		
		while (p != null)
		{
			if (max < p.val)
			{
				max = p.val;
			}
			p = p.next;
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
		
		Node p = root;
		int i = 0, index = 0;
		int min = p.val;
		
		while (p != null)
		{
			if (min > p.val)
			{
				min = p.val;
				index = i;
			}
			i++;
			p = p.next;
		}
		
		return index;
	}
	@Override
	public int maxIndex() 
	{
		if (size() == 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		Node p = root;
		int i = 0, index = 0;
		int max = p.val;
		while (p != null)
		{
			if (max < p.val)
			{
				max = p.val;
				index = i;
			}
			i++;
			p = p.next;
		}
		
		return index;
	}
	@Override
	public void reverse() 
	{
		if (size() == 0)
		{
			throw new NegativeArraySizeException();
		}
		
		Node p = root;
		root = null;
		
		while (p != null)
		{
			addStart(p.val);
			p = p.next;
		}
	}
	@Override
	public void sort() 
	{
		for (int i = size() - 1; i >= 1; i--)
		{
			boolean sorted = true;
			for (int j = 0; j < i; j++)
			{
				if (get(j) > get(j + 1))
				{
					int temp = get(j);
					set(j, get(j + 1));
					set(j + 1, temp);
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
		if (size() == 0)
		{
			throw new NegativeArraySizeException();
		}
		
		Node p = root; 
		Node temp = null; 
		int dx = (size()%2 == 0 ? 0 : 1); 
		
		for (int i = 0; i< size()/2; i++) 
		{ 
			temp = p; 
			for (int j = 0; j < size()/2 + dx; j++) 
			{ 
				temp = temp.next; 
			} 
			int tmpVal = temp.val; 
			temp.val = p.val; 
			p.val = tmpVal; 

			p = p.next; 
		}
	}
}
