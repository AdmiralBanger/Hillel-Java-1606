package Lists;

public interface ListInterface 
{
	public void init(int[] a);
	public void print();
	public void clear();
	public String toString();
	public int[] toArray();
	public int size();
	public void addStart(int val);
	public void addEnd(int val);
	public void addPos(int pos, int val);
	public int delStart();
	public int delEnd();
	public int delPos(int pos);
	public int get(int pos);
	public void set(int pos, int val);	
	public int min();
	public int max();
	public int minIndex();
	public int maxIndex();
	public void reverse();
	public void sort();
	public void halfReverse();
}
