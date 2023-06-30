// Library members abstract class can be either students or professors.
// Library members can borrow a book or/and a CD.
// There is a maximum limit of 5 books and CDs combined that students
// are allowed to borrow, while professors
// have no restrictions in this regard. 

package Library;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class LibraryMember {

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
	        
	        if(searchForItem(item.getTitle())==null) {

	        // increase the number of borrow 
	        item.setNumberOfborrow((item.getNumberOfborrow()+1));
	        // clone library item 
	        LibraryItem temp=(LibraryItem)item.clone();
	        
	        
	        // get the date information
          // to get the current time 
          LocalDate currentDate = LocalDate.now();
          String currentDay = String.valueOf(currentDate.getDayOfMonth());
          String currentMonth = String.valueOf(currentDate.getMonthValue());
          String currentYear = String.valueOf(currentDate.getYear());
          
          // get the due date 
          Scanner scanner = new Scanner(System.in);
          System.out.print("Enter dueDate day: ");
          String dueDay = scanner.nextLine();
          System.out.print("Enter dueDate Month: ");
          String dueMonth = scanner.nextLine();
          System.out.print("Enter dueDate Year: ");
          String dueYear = scanner.nextLine();
	        
	        // set the date 
	        temp.getBorrow().setAcquisitionDate(new NewDate(currentDay,currentMonth,currentYear));
	        temp.getBorrow().setDueDate(new NewDate(dueDay,dueMonth,dueYear));
	        temp.getBorrow().setWho(this);
	        // add the item 
	        LibraryItem.add(temp);
	        ++NumberOfborrowedItems;
	        System.out.println("borrow successfully");
	        return true;
	        }
	        else {
	              System.out.println("alredy exist !");
	              return false;
	        }
	        	
	    }
	    
	    
	    
	    
	    
	    
	    
		// to remove  item from the school libraryMrmber based on title
		// return true if remove successfully else return false
			public boolean removeLibraryItem(String title) {   	

		     // check if item is exist or not 
				if(searchForItem( title)==null) {

		        System.out.println("item not found !");
		        return false;
		    }
				else {
					 Scanner scanner = new Scanner(System.in);
					 System.out.println("enter 1 to remove !");
					 if(scanner.nextInt()==1) {
						boolean t= LibraryItem.remove((searchForItem( title)));
							System.out.println("remove successfully");
							--NumberOfborrowedItems;
							return t;
					 }
					return false;
				}
				
			}
			
			
			
			
			
		    // to search for book in the school library or CD based on title

		    public  LibraryItem searchForItem(String title) {
		    	
		        for (LibraryItem item : LibraryItem) {
		            // Perform the search based on the provided parameters
		            if ( title.equals(item.getTitle()) ) 
		                return item;
		            }
		        
		        
		        return null; // Item not found
		    }
		    
		    
		    
		      
		    
		    //  to update borrow dueDate  item from the school libraryMember.
		    //Return true if the item was successfully updated.
		    public boolean updateItem(String title) {
		    	    // Search for the library member in the collection
		    	LibraryItem s=searchForItem(title);
		    	    if (s!= null) {
		    	    	 Scanner scanner = new Scanner(System.in);

		    	    	    // Update the year
		    	    	    System.out.print("Enter the updated dueDate year: ");
		    	    	    String updatedyear = scanner.nextLine();
		    	    	    s.getBorrow().setDueDate(new NewDate()); 

		    	    	    // Update the number of copies
		    	    	    System.out.print("Enter the updated dueDate month: ");
		    	    	    String updatedmonth = scanner.next();
		    	    	
		    	    	    // Update the number of borrows
		    	    	    System.out.print("Enter the updated dueDate day: ");
		    	    	    String updatedday = scanner.next();
		    	    	   
		    	    	    s.getBorrow().setDueDate(new NewDate(updatedday,updatedmonth,updatedyear));
		    	    	    System.out.println("Library item information updated successfully.");
		    	    } else {
		    	        System.out.println("Library member not found.");
		    	        return false;
		    	    }
		    	return false;
		      
		    }
		    
		    
		    
		    
		    
		    // to print all the member items 
		     public void memberIteamsReport() {
		    	 
		    	 System.out.println("Iteams :");
		    	 int i=0;
		    	 for(LibraryItem it :LibraryItem) {
		    		 System.out.println("iteam "+(++i));
		    		 System.out.println(it);
		    	 }
		    	 
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
