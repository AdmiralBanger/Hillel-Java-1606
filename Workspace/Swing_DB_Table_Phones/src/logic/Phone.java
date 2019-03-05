package logic;

public class Phone 
{
	public int phone_id;
	public int person_id;
	public String type;
	public String phone;
	
	public Phone(int phone_id, int person_id, String type, String phone) 
	{
		this.phone_id = phone_id;
		this.person_id = person_id;
		this.type = type;
		this.phone = phone;
	}
}
