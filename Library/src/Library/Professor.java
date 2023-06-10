// class Professor subclass of Library Member
// the class store information  like :
// Professor salary
// Professor don't have limit to borrows items 


package Library ;

public class Professor extends LibraryMember{

	// the salary of the professor
	private double salary;
	
	
	
	
	
	// default constructor
	public Professor() {
		super();
		salary=0.0;
	}
	
	
	
	
	// argument constructor 
	public Professor(Name name, String phoneNumber,
			String emailAddress, NewDate dateOfBirth, int numberOfborrowedItems,
			double salary,String address) {
		super(name, phoneNumber, emailAddress,dateOfBirth, numberOfborrowedItems,address);
		this.salary=salary;
	}




	
	// implement toString method it return professor information
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append(super.toString()+"\n");
	    sb.append("Salary: ").append(salary).append("\n");
	    sb.append("Library Items:\n");
	    
	    for (LibraryItem item : getLibraryItem()) {
	        sb.append(item).append("\n");
	    }
	    
	    return sb.toString();
	}
	
	
	
	
	// getters and setters
	
	
	// get salary
	public double getSalary() {
		return salary;
	}



	// update salary
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	
	
}
