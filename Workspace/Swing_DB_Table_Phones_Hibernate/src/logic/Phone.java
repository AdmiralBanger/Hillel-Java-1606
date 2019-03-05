package logic;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="person_phones")
public class Phone implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1194089697249941361L;

	@Id
	@Column(name="phone_id")
	public int phone_id;

	@Column(name="person_id")
	public int person_id;

	@Column(name="type")
	public String type;

	@Column(name="phone")
	public String phone;
	
	public Phone()
	{
		
	}
	
	public Phone(int phone_id, int person_id, String type, String phone) 
	{
		this.phone_id = phone_id;
		this.person_id = person_id;
		this.type = type;
		this.phone = phone;
	}

	public int getPhone_id() {
		return phone_id;
	}

	public void setPhone_id(int phone_id) {
		this.phone_id = phone_id;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
