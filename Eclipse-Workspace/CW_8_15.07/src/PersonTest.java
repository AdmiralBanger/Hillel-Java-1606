
public class PersonTest 
{
	
	public static void main(String[] args) 
	{
		Person[] pr = new Person[6];

		pr[0] = new Person(1, "", "", 18);
		pr[1] = new Person(2, "", "", 18);
		pr[2] = new Person(3, "", "", 18);
		pr[3] = new Person(4, "", "", 18);
		pr[4] = new Person(5, "", "", 18);
		
		print(pr);
	}
	
	public static void print(Person[] pr) 
	{
		for (Person p : pr) 
		{
			System.out.println(p);
		}
	}
}