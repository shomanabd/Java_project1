// class student subclass of Library Member
// the class store information about like :
// student number and average marks 
// the method IsEligabileToInRoll determines if 
// student borrows more than 5 items 

package Library;

public class Student  extends LibraryMember{
	
	// the number of the student
	private int studentNumber;
	// the average of the student mark
	private double averageMark;
	
	
	
	
	// default constructor 
	public Student() {
		this(0,0.0); // call argument constructor
	}



	
	// argument constructor for class only
	private Student(int studentNumber,double averageMark) {
		// call parent default constructor
		super();
		this.studentNumber=studentNumber;
		this.averageMark=averageMark;
	}
	
	
	
	
	// argument constructor 
	public Student(Name name, String phoneNumber,
			String emailAddress,NewDate dateOfBirth, int numberOfborrowedItems,
			int studentNumber,double averageMark,String address) {
		super(name, phoneNumber, emailAddress,dateOfBirth, numberOfborrowedItems,address);
		this.studentNumber=studentNumber;
		this.averageMark=averageMark;
	}




	// the method return if the student mark is Eligible 
	// To Enroll to the next course
	public static boolean IsEligibleToEnroll(double Mark) {
		return Mark>=60;
	}
	
	
	
	
	
	// implement toString method it return professor information
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append(super.toString()+"\n");
	    sb.append("studentNumber: ").append(studentNumber).append("\n");
	    sb.append("averageMark: ").append(averageMark).append("\n");
	     sb.append("Library Items:\n");
	    
	    for (LibraryItem item : getLibraryItem()) {
	        sb.append(item).append("\n");
	    }
	    
	    return sb.toString();
	}
	
	
	
	
	
	// getters and setters 
	
	
	public int getStudentNumber() {
		return studentNumber;
	}




	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}




	public double getAverageMark() {
		return averageMark;
	}




	public void setAverageMark(double averageMark) {
		this.averageMark = averageMark;
	}
	

	




	
	
	
	
	
	

}
