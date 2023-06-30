// Library items is abstract class 
// can be a book or a CD.
// it include the general information about 
// library item like title and number of copies


package Library;

public abstract class LibraryItem implements Comparable<LibraryItem>,  Cloneable{
	// the class have CompareTo method so you can use sort for 
	// It  compare LibraryItem based on how often they  have been borrowed.
	
    


	// the title of the item (CD or Book)
	private String title;
	// the number of item copies (CD or Book)
	private int numberOfCopies;
	 // number of how number they have been borrowed
    private int  NumberOfborrow;
	// to store information about current borrrow
    private Borrow borrow ;
 
	
	
	
	
	// default constructor 
	public LibraryItem(){
		
		this("No thitle",0,0,new Borrow()); //call argument constructor
	}

	
	// argument constructor
	public LibraryItem(String title, int numberOfCopies,int  NumberOfborrow,Borrow borrow) {

		this.title = title;
		this.numberOfCopies = numberOfCopies;
		this.NumberOfborrow=NumberOfborrow;
		this.borrow=borrow;
	}
	

	

	
    // compare library item  based on how often they have been borrowed
    @Override
 	public  int compareTo(LibraryItem o) {
    	
    	return NumberOfborrow-o.NumberOfborrow;
    };
	
	
	
	
	
	// the method return string contain information of object(data field values)
	public String toString() {
		
		// return string represent the object information
		return "title:"+title+"\n"+"number of copies:"+numberOfCopies +
		"\n"+"NumberOfborrow:"+NumberOfborrow		+"\n"+borrow.toString();
	}
	
	
	
	
	// override clone method 
	@Override
	protected Object clone()  {
		try {
		return super.clone();
		
		}catch(java.lang.CloneNotSupportedException ex) {
			return null;
		}
	}
	
	
	
	
	//  getters and setters 
	

	

	// to get the title of the item
	public String getTitle() {
		return title;
	}

	// to update the title 
	protected void setTitle(String title) {
		this.title = title;
	}

	// to get the number of item copies 
	public int getNumberOfCopies() {
		return numberOfCopies;
	}

	// to update the number of copies 
	protected void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}


	public int getNumberOfborrow() {
		return NumberOfborrow;
	}


	public void setNumberOfborrow(int numberOfborrow) {
		NumberOfborrow = numberOfborrow;
	}


	public Borrow getBorrow() {
		return borrow;
	}


	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}
	
	
	
	
	
	
}
