// class to track and to manage the items for example  
// delete , remove , update and report  in the school library 

package Library;
import java.util.ArrayList;
import java.util.Scanner;

public  class Library {
	
	
	// list to store library member it can be student or professor 
    private ArrayList<LibraryMember> members;
	// list to store library item it can be book or cd 
    private ArrayList<LibraryItem> list;
    // Store the name of library 
    private String libraryName;
    

    
    
    // default constructor
   public  Library(){
    	
    	this("No name"); // call argument constructor 
    }
    
    
   
   
    // argument constructor 
    public Library(String libraryName) {
    	
        this.libraryName = libraryName;
        this.list = new ArrayList<>();
        this.members=new ArrayList<>();
    }
  
   
    
    
    
    
    // to add new item into the school library
	// return true if added successfully else return false
	public boolean addLibraryItem(LibraryItem x) {   	

     // check if item is exist or not 
		if(searchForItem( x.getTitle())==null) {
        // Add the item to the list
        list.add(x);
        System.out.println("added successfully");
        return true;
    }
		else {
			System.out.println("already exist !");
			
			return false;
		}
		
	}
    
    
    
    
    
    // to add new member into the school library
	// return true if added successfully else return false
	public boolean addLibraryMember(LibraryMember x) {   	

     // check if member is exist or not 
		if(searchForMember( x.getName())==null) {
        // Add the item to the list
        members.add(x);
        System.out.println("added successfully");
        return true;
    }
		else {
			System.out.println("already exist !");
			
			return false;
		}
		
	}
	
	
	
	
	
	
	// to remove  item from the school library based on title
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
					 list.remove(searchForItem( title));
						System.out.println("remove successfully");
						 scanner.nextLine();
					
						return true;
				 }
				 scanner.nextLine();
		
				return false;
			}
			
		}
		
		
		
		

		// to remove  member from the school library based on name
		// return true if remove successfully else return false
			public boolean removeLibraryMember(Name name ) {   	

		     // check if item is exist or not 
				if(searchForMember( name)==null) {

		        System.out.println("member not found !");
		        return false;
		    }
				else {
					 Scanner scanner = new Scanner(System.in);
					 System.out.println("enter 1 to remove !");
					 if(scanner.nextInt()==1) {
						 members.remove(searchForMember( name));
							System.out.println("remove successfully");
							 scanner.nextLine();
					
							return true;
					 }
					 scanner.nextLine();
			
					return false;
				}
				
			}
		
		
		
		
		
    // to search for book in the school library or CD based on title

    public  LibraryItem searchForItem(String title) {
    	
        for (LibraryItem item : list) {
            // Perform the search based on the provided parameters
            if ( title.equals(item.getTitle()) ) 
                return item;
            }
        
        
        return null; // Item not found
    }
    
    
    
    
    
    // to search for CD based on trackNo
    public  LibraryItem searchForItem(int trackNo) {
    	
    	
    	
        for (LibraryItem item : list) {
            // Perform the search based on the provided parameters
            if ( (item instanceof CD) && trackNo== ((CD)item).getTrackNo()){
                return item;
            }
        }
        
        return null; // Item not found
    }

    
    
    
    
    // to search for CD or book  based on author or composer name
    public  LibraryItem searchForItem(Name authororcomposor) {
    	
        for (LibraryItem item : list) {
            // Perform the search based on the provided parameters
            if ( ((item instanceof Book)&&((Book)item).
            		getAuthor().equals(authororcomposor) )||
            		((item instanceof CD)&&((CD)item).getComposer()
            				.equals(authororcomposor))){
                return item;
            }
        }
        
        return null; // Item not found
    }
    
    
    
    
    
    // to search for library member (student or professor) based on title

    public  LibraryMember searchForMember(Name name) {
    	
        for (LibraryMember m : members) {
            // Perform the search based on the provided parameters
            if ( m.getName().equals(name) ) 
                return m;
            }
        
        
        return null; // Item not member
    }
    
    
    
    
    
    //  to update an item from the school library. Return true if the item was
    // successfully updated.
    public boolean updateItem(String title) {
    	    // Search for the library member in the collection
    	LibraryItem s=searchForItem(title);
    	    if (s!= null) {
    	    	 Scanner scanner = new Scanner(System.in);

    	    	    // Update the title
    	    	    System.out.print("Enter the updated title: ");
    	    	    String updatedTitle = scanner.nextLine();
    	    	    s.setTitle(updatedTitle) ;

    	    	    // Update the number of copies
    	    	    System.out.print("Enter the updated number of copies: ");
    	    	    int updatedNumberOfCopies = scanner.nextInt();
    	    	    s.setNumberOfCopies(updatedNumberOfCopies) ;

    	    	    // Update the number of borrows
    	    	    System.out.print("Enter the updated number of borrows: ");
    	    	    int updatedNumberOfBorrows = scanner.nextInt();
    	    	    s.setNumberOfborrow(updatedNumberOfBorrows) ;

    	    	    System.out.println("Library item information updated successfully.");
    	    } else {
    	        System.out.println("Library iteam not found.");
    	        return false;
    	    }
    	return false;
      
    }
    
    
    
    

    //  to update an member from the school library. Return true if the item was
    // successfully updated.
    public boolean updateMember(Name name) {
    	    // Search for the library member in the collection
    	LibraryMember m=searchForMember(name);
    	    if (m!= null) {
    	    	 Scanner scanner = new Scanner(System.in);

    	    	    // Update the phone Number
    	    	    System.out.print("Enter the updated phone Number: ");
    	    	    String updatedphoneNumber = scanner.nextLine();
    	    	    m.setPhoneNumber(updatedphoneNumber);

    	    	    // Update the email Address
    	    	    System.out.print("Enter the updated email Address: ");
    	    	    String updatedemailAddress = scanner.nextLine();
    	    	    m.setEmailAddress(updatedemailAddress);

    	    	    // Update the address
    	            System.out.println("Enter the updated country:");
    	            String country = scanner.nextLine();
    	            System.out.println("Enter the updated city:");
    	            String city = scanner.nextLine();
    	            System.out.println("Enter the updated street:");
    	            String street = scanner.nextLine();
    	            System.out.println("Enter the updated building name:");
    	            String buildingname = scanner.nextLine();
    	            System.out.println("Enter the updated post office box number:");
    	            String pobox = scanner.nextLine();
    	            String address =country+"@"+city+"@"+street+"@"+buildingname+"@"+pobox;

    	            m.setAddress(new Address(address));
    	            
    	    	    System.out.println("Library member information updated successfully.");
    	    } else {
    	        System.out.println("Library member not found.");
    	        return false;
    	    }
    	return false;
      
    }
    
    
    
    
    
   // to print all the library items along with 
   // their information in a sorted order).
    public void libraryReport() {
    	
    	// print the name of the library first 
        System.out.println("Library Name: " + libraryName);
        
        //sort the list
        java.util.Collections.sort(list);
        
        System.out.println("Library iteams: \n\n");
        
        int i=0;
        // print all item in LibraryItem list 
        for (LibraryItem item : list) {
            // Print details of each item
        	 System.out.println("item "+(++i));
            System.out.println(item.toString()+"\n");
        }
        
        i=0;
        System.out.println("\nLibrary members: \n\n");
        for (LibraryMember m : members) {
            // Print details of each members
        	 System.out.println("member "+(++i));
            System.out.println(m.toString()+"\n");
        }
    }
   
    
    
    // to get Items list 
    protected ArrayList<LibraryItem> getItems(){
    return list;
    }
   
}
