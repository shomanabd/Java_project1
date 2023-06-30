package Library;

public class Borrow {

	
	private NewDate acquisitionDate;
	
	private NewDate dueDate ;
	
	private LibraryMember who;
	
	
	
	
	// default constructor
	Borrow(){
		this(new NewDate(),new NewDate(),null);
	}

	
	
	// argument constructor
	public Borrow(NewDate acquisitionDate, NewDate dueDate, LibraryMember who) {
		this.acquisitionDate = acquisitionDate;
		this.dueDate = dueDate;
		this.who = who;
	}


	
	
	// implement to string to return information about date 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Acquisition Date:").append(acquisitionDate).append("\n");
        sb.append("Due Date:").append(dueDate).append("\n");
       
        return sb.toString();
    }
	
	// getters and setters 




	public NewDate getAcquisitionDate() {
		return acquisitionDate;
	}




	public void setAcquisitionDate(NewDate ascquisitionDate) {
		this.acquisitionDate = ascquisitionDate;
	}




	public NewDate getDueDate() {
		return dueDate;
	}




	public void setDueDate(NewDate dueDate) {
		this.dueDate = dueDate;
	}




	public LibraryMember getWho() {
		return who;
	}




	public void setWho(LibraryMember who) {
		this.who = who;
	}
	
	
	
}
