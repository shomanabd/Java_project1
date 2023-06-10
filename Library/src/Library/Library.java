// class to track and to manage the items for example  
// delete , remove , update and report  in the school library 

package Library;
import java.util.ArrayList;
import java.util.Scanner;

public  class Library {
	
	
	
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
    }
  
   
    
    
    
    
    // to add new item into the school library
	// return true if added successfully else return false
	public boolean addLibraryItem(LibraryItem x) {   	

     // check if item is exist or not 
		if(list.indexOf(x)<0) {
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
    
    
    
    
    
    
	// to add new item into the school library
	// return true if remove successfully else return false
		public boolean removeLibraryItem(LibraryItem x) {   	

	     // check if item is exist or not 
			if(list.indexOf(x)<0) {

	        System.out.println("item not found !");
	        return false;
	    }
			else {
				list.remove(x);
				System.out.println("remove successfully");
				return true;
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
            if ( trackNo== ((CD)item).getTrackNo()){
                return item;
            }
        }
        
        return null; // Item not found
    }

    
    
    
    
    // to search for CD or book  based on author or composer name
    public  LibraryItem searchForItem(Name authororcomposor) {
    	
        for (LibraryItem item : list) {
            // Perform the search based on the provided parameters
            if ( ((Book)item).getAuthor().equals(authororcomposor)||
            		((CD)item).getComposer().equals(authororcomposor)){
                return item;
            }
        }
        
        return null; // Item not found
    }
    
    
    
    
    
    //  to update an item from the school library. Return true if the item was
    // successfully updated.
    public boolean updateItem(LibraryItem libraryItem) {
    	    // Search for the library member in the collection
    	    int index = list.indexOf(libraryItem);

    	    if (index != -1) {
    	    	 Scanner scanner = new Scanner(System.in);

    	    	    // Update the title
    	    	    System.out.print("Enter the updated title: ");
    	    	    String updatedTitle = scanner.nextLine();
    	    	    list.get(index).setTitle(updatedTitle) ;

    	    	    // Update the number of copies
    	    	    System.out.print("Enter the updated number of copies: ");
    	    	    int updatedNumberOfCopies = scanner.nextInt();
    	    	    list.get(index).setNumberOfCopies(updatedNumberOfCopies) ;

    	    	    // Update the number of borrows
    	    	    System.out.print("Enter the updated number of borrows: ");
    	    	    int updatedNumberOfBorrows = scanner.nextInt();
    	    	    list.get(index).setNumberOfborrow(updatedNumberOfBorrows) ;

    	    	    System.out.println("Library item information updated successfully.");
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
        
        int i=0;
        // print all item in LibraryItem list 
        for (LibraryItem item : list) {
            // Print details of each item
        	 System.out.println("item "+(++i));
            System.out.println(item.toString()+"\n");
        }
    }
}
