package hello;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.Id;
import org.springframework.data.annotation.Id;

public class Person
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	private String name;
	private String surname;
	private int color;	// 0xRR GG BB (only 3 bytes necessary)
	
	public String getName() {
		return name;
	}

	public void setName (String firstName) {
		this.name = firstName;
	}

	public String getLastName() {
		return surname;
	}

	public void setSurname (String surname) {
		this.surname = surname;
	}
}