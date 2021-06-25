/*
 * Contact.java
 * This class represents an address book contact.
 */

package Apps;

public class Contact implements Comparable<Contact> {
	
	// Fields for the name, phone and email of this contact
	private String name, phone, email;

	// Creates a new contact with the given values.
	public Contact(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	// Returns the name of this contact.
	public String getName() {
		return name;
	}

	// Sets the name of this contact to the given value.
	public void setName(String name) {
		this.name = name;
	}

	// Returns the phone of this contact.
	public String getPhone() {
		return phone;
	}

	// Sets the phone of this contact to the given value.
	public void setPhone(String phone) {
		this.phone = phone;
	}

	// Returns the email of this contact.
	public String getEmail() {
		return email;
	}

	// Sets the email of this contact to the given value.
	public void setEmail(String email) {
		this.email = email;
	}
	
	// Returns a negative, zero or positive integer when comparing this 
	// contact to another based on their names.
	@Override
	public int compareTo(Contact other) {
		return this.name.compareTo(other.name);
	}

	// Returns true if this contact has the same name of another.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (! (obj instanceof Contact))
			return false;
		Contact other = (Contact)obj;
		return this.name.equals(other.name);
	}
	
	// Returns a string representation of this contact.
	@Override
	public String toString() {
		return "Contact [name=" + name + ", phone=" + phone + ", email="
				+ email + "]";
	}
	

}

