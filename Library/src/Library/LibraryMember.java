// Library members abstract class can be either students or professors.
// Library members can borrow a book or/and a CD.
// There is a maximum limit of 5 books and CDs combined that students
// are allowed to borrow, while professors
// have no restrictions in this regard. 

package Library;
import java.util.List;
import java.util.ArrayList;

public abstract class LibraryMember extends Library{

	    // Name of the library member
	    private Name name;    
	    // Phone number of the library member
	    private String phoneNumber;  
	    // Email address of the library member
	    private String emailAddress; 
	    // Date of birth of the library member
	    private NewDate dateOfBirth;
	    // Address of the library member
	    private Address address;     
	    // List of library items
	    private List<LibraryItem> LibraryItem;
	    // number of borrowed items 
	    private int NumberOfborrowedItems;
  
	    
	    
	    
	    // Default constructor
	    public LibraryMember() {
	       this(new Name(),"empty","empty",new NewDate(),0,null);// call argument constructor
	    }



        // argument constructor 
		public LibraryMember(Name name, String phoneNumber, 
				String emailAddress,NewDate dateOfBirth, int numberOfborrowedItems,String address) {
			this.name = name;
			this.phoneNumber = phoneNumber;
			this.emailAddress = emailAddress;
			this.dateOfBirth = dateOfBirth;
			this.address = new Address(address);
			this.dateOfBirth=dateOfBirth;
			LibraryItem = new ArrayList<LibraryItem>();
			NumberOfborrowedItems = numberOfborrowedItems;
		}


		
		
		
	    public boolean borrowLibraryItem(LibraryItem item) {
	        if (this instanceof Student && NumberOfborrowedItems + 1 > 5) {
	            System.out.println("Maximum borrowing limit reached for students.");
	            return false;
	        }

	        LibraryItem.add(item);
	        ++NumberOfborrowedItems;
	        
	        return true;
	    }
	    
	    
	    
	    
	    
	    // implement toStrubg 
	    @Override
		public String toString() {
		
		 return "Name: " + name.toString() +
	                "\nPhone Number: " + phoneNumber +
	                "\nEmail Address: " + emailAddress +
	                "\nDate of Birth: " + dateOfBirth.toString() +
	                "\nAddress: " + address.toString() +
	                "\nNumber of Borrowed Items: " + String.valueOf(NumberOfborrowedItems);
		}
	    
	    
	    
	    
	    
	    // override addlibraryItem to deal with student and professor
	    @Override
		public boolean addLibraryItem(LibraryItem x) {
			
	        // check if item is exist or not 
			if(LibraryItem.indexOf(x)<0) {
	        // Add the item to the list
				if (this instanceof Student && NumberOfborrowedItems + 1 > 5) {
		            System.out.println("Maximum borrowing limit reached for students.");
		            return false;
		        }

		        LibraryItem.add(x);
		        ++NumberOfborrowedItems;
		        
		        System.out.println("added successfully");
		        return true;
	      
	      
	    }
			
			else {
				System.out.println("already exist !");
								return false;
			}
			
	    }
	    	
	    	
	    
	    
	    
	    
	    
		// getters and setters 

		



		public Name getName() {
			return name;
		}



		public void setName(Name name) {
			this.name = name;
		}



		public String getPhoneNumber() {
			return phoneNumber;
		}



		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}



		public String getEmailAddress() {
			return emailAddress;
		}



		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}



		public NewDate getDateOfBirth() {
			return dateOfBirth;
		}



		public void setDateOfBirth(NewDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}



		public Address getAddress() {
			return address;
		}



		public void setAddress(Address address) {
			this.address = address;
		}



		public int getNumberOfborrowedItems() {
			return NumberOfborrowedItems;
		}



		public void setNumberOfborrowedItems(int numberOfborrowedItems) {
			NumberOfborrowedItems = numberOfborrowedItems;
		}
		
		
		
		public List<LibraryItem> getLibraryItem(){
			return LibraryItem;
		}
	    
	    
	    
}
