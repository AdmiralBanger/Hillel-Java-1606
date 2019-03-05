
public class libraryMath 
{
	public static int g = 10;
	public static double pi = 3.14;
	
	public static void main(String[] args) 
	{
		System.out.println(task_1_getDist(800, 45, false));
		System.out.println(task_2_getDistCar(40, 60, 5, 2));
		System.out.println(task_3_check(1, 1));
		System.out.println(task_4_countExpr(5));
	}
	
	public static double task_1_getDist(double v0, double angle, boolean isRadian) 
	{
		if (!isRadian)
		{
			return (Math.pow(v0, 2) * Math.sin(2 * angle)) / g;
		}
		else
		{
			return (Math.pow(v0, 2) * Math.sin(2 * (angle * (180 / pi)))) / g;
		}
	}
	public static double task_2_getDistCar(double v1, double v2, double s1, double t)
	{
		return s1+(v1+v2)*t;
	}
	public static boolean task_3_check(double x, double y)
	{
		return (((x-y>=0) || (x+y<=0)) && (y-1.5*x+1>=0) && (y+1.5*x+1>=0)) ? true : false;
	}
	public static double task_4_countExpr(double x) 
	{
		return (6 * Math.log(Math.sqrt(Math.exp(x+1) + 2 * Math.exp(x) * Math.cos(x))))/
				Math.log(x - Math.exp(x+1) * Math.sin(x)) + (Math.abs(Math.cos(x) / Math.exp(Math.sin(x))));
	}
}
