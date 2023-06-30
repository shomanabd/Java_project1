// the name class to store information about name 
// like first name , middle name and last name 
// Name: The user can enter the name in one of the formats listed below :
//FirstName and LastName: Ahmad Mansour
//or
//FirstName MiddleName LastName : Ahmad Khaled Mansour

package Library;

public class Name {
	
	// to store first name
	private String firstName;
	// to store middle name
	private String middleName;
	// to store last name
	private String lastName;
	
	
	
	
	// default constructor give default value to argument constructor
	public Name() {
		// give default values to argument constructor
		this("empty","empty","empty"); 
	}
	
	
	
	// argument constructor take first name and last name 
	public Name(String firstName,  String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName="empty";
	}
	
	
	// arguments constructor take first , middle and last name
	public Name(String firstName,String middleName,  String lastName) {
		this.firstName = firstName;
		this.middleName=middleName;
		this.lastName = lastName;
	}



	
	
	// override the implementation of toString 
	// toString return string represents the information 
	// about name in the following format: 
	// firstName MiddleName lastName
	@Override
	public String toString() {
		
		return firstName+" "+middleName+" "+lastName;
	}
	
	
	
	
	
	// compare two name objects 
	public boolean equals(Name name) {
		// TODO Auto-generated method stub
		return (this.firstName.equals(name.getFirstName())) &&
			   (this.middleName.equals(name.getMiddleName()))&&
			   (this.lastName.equals(name.getLastName()));
	}
	
	
	
	// getters and setters




	// get first name 
	public String getFirstName() {
		return firstName;
	}


	// update first name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	// get middle name
	public String getMiddleName() {
		return middleName;
	}


	// update middle name
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	// get last name
	public String getLastName() {
		return lastName;
	}


	// update last name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	

}
