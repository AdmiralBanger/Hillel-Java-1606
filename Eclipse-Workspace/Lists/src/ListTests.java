import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ListTests 
{
	@Parameterized.Parameters
	public static Collection<Object[]> listOfLists() 
	{
		return Arrays.asList(new Object[][]{
				//{ new List0() },
				//{ new List1() },
				//{ new List2() },
				//{ new LList1() },
				{ new LList2() }
				});
	}
	
	ListInterface list = null;
	public ListTests(ListInterface param) 
	{
		list = param;
	}
	@Before
	public void setUp()
	{
		list.clear();
	}

	@Test(expected=NullPointerException.class)
	public void testInitNull() 
	{
		int[] arr = null;
		list.init(arr);
	}
	@Test
	public void testInitZero()
	{
		int[] arr = {};
		int[] exp = {};
		list.init(arr);
		assertArrayEquals(exp, list.toArray());
	}
	@Test
	public void testInit1() 
	{
		int[] arr = {1};
		int[] exp = {1};
		list.init(arr);
		arr = list.toArray();
		assertArrayEquals(exp, list.toArray());
	}
	@Test
	public void testInit2() 
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		int[] exp = {2, 6, 1, 5, 8, 3, 4};
		list.init(arr);
		assertArrayEquals(exp, list.toArray());
	}
	
	@Test
	public void testClearZero() 
	{
		int[] arr = {};
		int[] exp = {};
		list.init(arr);
		list.clear();
		assertArrayEquals(exp, list.toArray());
	}
	@Test
	public void testClear1() 
	{
		int[] arr = {1};
		int[] exp = {};
		list.init(arr);
		list.clear();
		assertArrayEquals(exp, list.toArray());
	}
	@Test
	public void testClear2() 
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		int[] exp = {};
		list.init(arr);
		list.clear();
		assertArrayEquals(exp, list.toArray());
	}
	
	@Test 
	public void testToStringZero() 
	{
		int[] arr = {};
		String exp = "";
		list.init(arr);
		assertEquals(exp, list.toString());
	}
	@Test
	public void testToString1() 
	{
		int[] arr = {1};
		String exp = "1";
		list.init(arr);
		assertEquals(exp, list.toString());
	}
	@Test
	public void testToString2() 
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		String exp = "2615834";
		list.init(arr);
		assertEquals(exp, list.toString());
	}
	
	@Test 
	public void testSizeZero() 
	{
		int[] arr = {};
		int exp = 0;
		list.init(arr);
		assertEquals(exp, list.size());
	}
	@Test
	public void testSize1() 
	{
		int[] arr = {1};
		int exp = 1;
		list.init(arr);
		assertEquals(exp, list.size());
	}
	@Test
	public void testSize2() 
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		int exp = 7;
		list.init(arr);
		assertEquals(exp, list.size());
	}
	
	@Test 
	public void testAddStartZero() 
	{
		int[] arr = {};
		int[] exp = {6};
		list.init(arr);
		list.addStart(6);
		assertArrayEquals(exp, list.toArray());
	}
	@Test
	public void testAddStart1() 
	{
		int[] arr = {1};
		int[] exp = {3, 1};
		list.init(arr);
		list.addStart(3);
		assertArrayEquals(exp, list.toArray());
	}
	@Test
	public void testAddStart2() 
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		int[] exp = {7, 2, 6, 1, 5, 8, 3, 4};
		list.init(arr);
		list.addStart(7);
		assertArrayEquals(exp, list.toArray());
	}

	@Test 
	public void testAddEndZero() 
	{
		int[] arr = {};
		int[] exp = {6};
		list.init(arr);
		list.addEnd(6);
		assertArrayEquals(exp, list.toArray());
	}
	@Test
	public void testAddEnd1() 
	{
		int[] arr = {1};
		int[] exp = {1, 3};
		list.init(arr);
		list.addEnd(3);
		assertArrayEquals(exp, list.toArray());
	}
	@Test
	public void testAddEnd2() 
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		int[] exp = {2, 6, 1, 5, 8, 3, 4, 7};
		list.init(arr);
		list.addEnd(7);
		assertArrayEquals(exp, list.toArray());
	}

	@Test 
	public void testAddPosZero() 
	{
		int[] arr = {};
		int[] exp = {6};
		list.init(arr);
		list.addPos(0, 6);
		assertArrayEquals(exp, list.toArray());
	}
	@Test
	public void testAddPos1() 
	{
		int[] arr = {1};
		int[] exp = {3, 1};
		list.init(arr);
		list.addPos(0, 3);
		assertArrayEquals(exp, list.toArray());
	}
	@Test
	public void testAddPos2() 
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		int[] exp = {2, 6, 1, 7, 5, 8, 3, 4};
		list.init(arr);
		list.addPos(3, 7);
		assertArrayEquals(exp, list.toArray());
	}
	@Test
	public void testAddPos3() 
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		int[] exp = {2, 6, 1, 5, 8, 3, 7, 4};
		list.init(arr);
		list.addPos(6, 7);
		assertArrayEquals(exp, list.toArray());
	}
	@Test(expected=IndexOutOfBoundsException.class) 
	public void testAddPosExceptionBelow() 
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		list.init(arr);
		list.addPos(-1, 7);
	}
	@Test(expected=IndexOutOfBoundsException.class) 
	public void testAddPosExceptionAbove() 
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		list.init(arr);
		list.addPos(22, 7);
	}

	@Test(expected=NullPointerException.class)
	public void testDelStartZero() 
	{
		int[] arr = {};
		list.init(arr);
		list.delStart();
	}
	@Test
	public void testDelStart1() 
	{
		int[] arr = {1};
		list.init(arr);
		assertEquals(1, list.delStart());
	}
	@Test
	public void testDelStart2() 
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		list.init(arr);
		assertEquals(2, list.delStart());
	}
	
	@Test(expected=NullPointerException.class)
	public void testDelEndZero() 
	{
		int[] arr = {};
		list.init(arr);
		list.delEnd();
	}
	@Test
	public void testDelEnd1() 
	{
		int[] arr = {1};
		list.init(arr);
		assertEquals(1, list.delEnd());
	}
	@Test
	public void testDelEnd2() 
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		list.init(arr);
		assertEquals(4, list.delEnd());
	}

	@Test(expected=NullPointerException.class)
	public void testDelPosZero() 
	{
		int[] arr = {};
		list.init(arr);
		list.delPos(0);
	}
	@Test
	public void testDelPos1() 
	{
		int[] arr = {1};
		list.init(arr);
		assertEquals(1, list.delPos(0));
	}
	@Test
	public void testDelPos2() 
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		list.init(arr);
		assertEquals(5, list.delPos(3));
	}
	@Test
	public void testDelPos3() 
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		list.init(arr);
		assertEquals(4, list.delPos(6));
	}
	@Test(expected=IndexOutOfBoundsException.class) 
	public void testDelPosExceptionBelow() 
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		list.init(arr);
		list.delPos(-1);
	}
	@Test(expected=IndexOutOfBoundsException.class) 
	public void testDelPosExceptionAbove() 
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		list.init(arr);
		list.delPos(22);
	}

	@Test
	public void testGet1() 
	{
		int[] arr = {1};
		list.init(arr);
		assertEquals(1, list.get(0));
	}
	@Test
	public void testGet2()
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		list.init(arr);
		assertEquals(8, list.get(4));
	}
	@Test(expected=IndexOutOfBoundsException.class)
	public void testGetExceptionBelow()
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		list.init(arr);
		list.get(-1);
	}
	@Test(expected=IndexOutOfBoundsException.class) 
	public void testGetExceptionAbove()
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		list.init(arr);
		list.get(22);
	}

	public void testSetZero() 
	{
		int[] arr = {};
		int[] exp = {3};
		list.init(arr);
		list.set(0, 3);
		assertArrayEquals(exp, list.toArray());
	}
	@Test
	public void testSet1() 
	{
		int[] arr = {1};
		int[] exp = {4};
		list.init(arr);
		list.set(0, 4);
		assertArrayEquals(exp, list.toArray());
	}
	@Test
	public void testSet2()
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		int[] exp = {2, 6, 1, 5, 8, 2, 4};
		list.init(arr);
		list.set(5, 2);
		assertArrayEquals(exp, list.toArray());
	}
	@Test(expected=IndexOutOfBoundsException.class)
	public void testSetExceptionBelow() 
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		list.init(arr);
		list.set(-1, 1);
	}
	@Test(expected=IndexOutOfBoundsException.class) 
	public void testSetExceptionAbove()
	{
		int[] arr = {2, 6, 1, 5, 8, 3, 4};
		list.init(arr);
		list.set(22, 2);
	}

	@Test
	public void testMin1() 
	{
		int[] arr = {1};
		list.init(arr);
		assertEquals(1, list.min());
	}
	@Test
	public void testMin2()
	{
		int[] arr = {7, 6, 2, 5, 8, 3, 4};
		list.init(arr);
		assertEquals(2, list.min());
	}

	@Test
	public void testMax1() 
	{
		int[] arr = {1};
		list.init(arr);
		assertEquals(1, list.max());
	}
	@Test
	public void testMax2()
	{
		int[] arr = {7, 6, 2, 5, 8, 3, 4};
		list.init(arr);
		assertEquals(8, list.max());
	}

	@Test
	public void testMinIndex1() 
	{
		int[] arr = {1};
		list.init(arr);
		assertEquals(0, list.minIndex());
	}
	@Test
	public void testMinIndex2()
	{
		int[] arr = {7, 6, 2, 5, 8, 3, 4};
		list.init(arr);
		assertEquals(2, list.minIndex());
	}

	@Test
	public void testMaxIndex1() 
	{
		int[] arr = {1};
		list.init(arr);
		assertEquals(0, list.maxIndex());
	}
	@Test
	public void testMaxIndex2()
	{
		int[] arr = {6, 8, 2, 5, 7, 3, 4};
		list.init(arr);
		assertEquals(1, list.maxIndex());
	}

	public void testReverse1() 
	{
		int[] arr = {1};
		int[] exp = {1};
		list.init(arr);
		list.reverse();
		assertArrayEquals(exp, list.toArray());
	}
	@Test
	public void testReverse2()
	{
		int[] arr = {6, 8, 2, 5, 7, 3, 4};
		int[] exp = {4, 3, 7, 5, 2, 8, 6};
		list.init(arr);
		list.reverse();
		assertArrayEquals(exp, list.toArray());
	}
	
	@Test
	public void testSort1() 
	{
		int[] arr = {1};
		int[] exp = {1};
		list.init(arr);
		list.sort();
		assertArrayEquals(exp, list.toArray());
	}
	@Test
	public void testSort2()
	{
		int[] arr = {6, 8, 2, 5, 7, 3, 4};
		int[] exp = {2, 3, 4, 5, 6, 7, 8};
		list.init(arr);
		list.sort();
		assertArrayEquals(exp, list.toArray());
	}

	@Test
	public void testHalfReverse1() 
	{
		int[] arr = {1};
		int[] exp = {1};
		list.init(arr);
		list.halfReverse();
		assertArrayEquals(exp, list.toArray());
	}
	@Test
	public void testHalfReverse2()
	{
		int[] arr = {6, 8, 2, 5, 7, 3, 4};
		int[] exp = {7, 3, 4, 5, 6, 8, 2};
		list.init(arr);
		list.halfReverse();
		assertArrayEquals(exp, list.toArray());
	}	
	
}
