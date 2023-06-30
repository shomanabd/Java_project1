// class Library file manager to random access files
// to enable efficient retrieval, modification, and deletion of LibraryItem

package Library;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.Scanner;

public class LibraryFileManager extends Library{
	
	// store file name 
    private RandomAccessFile file;

    
    
    
    // default constructor 
    public LibraryFileManager() {
        this("library.dat");
    }
    
    
    
    
    // argument constructor 
    public LibraryFileManager(String filename) {
        try {
            file = new RandomAccessFile(filename, "rw");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    // Write all library items to the file
    public void writeAllItemsToFile(Library bzu) {
    

    	try {
            file.setLength(0); // Clear the existing file contents

            for (LibraryItem item : bzu.getItems()) {
                file.writeUTF(item.toString());
                file.writeUTF("\n");
            }
            System.out.println("Write successful !");
        } catch (IOException e) {
            e.printStackTrace();
        }
}
        
        
        // to count the number of lines in the file
    public int countLines() {
        try {
            int lineCount = 0;
            file.seek(0);

            while (file.readLine() != null) {
                lineCount++;
            }

            return lineCount;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public LibraryItem searchByTitle(String title) {
        int numberOfItems = countLines() / 7;

        StringBuilder s=new StringBuilder();
        try {
            file.seek(0);

            while (numberOfItems > 0) {
                String line = file.readLine();
                String[] t = line.split(":");

                if (t[1].equals(title)) {
                	s.append(line);
                	s.append("\n");
                    for (int i = 1; i < 7; i++) {
                    	s.append(file.readLine());
                    	s.append("\n");
                    }
                    return createItem(s.toString());
                } else {
                    for (int i = 1; i < 7; i++) {
                        file.readLine();
                    }
                }

                numberOfItems--;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }




    
    
    
    // to create library item it can be book or CD
    private static LibraryItem createItem(String obj )  {

      String lines[]=obj.split("\n");
      
     

      try {
        
        // Create member instance based on member type
        if (lines[5].split(":")[0].equalsIgnoreCase("trackNo")) {
        	
 
        	String title =lines[1].split(":")[1];
        	
            int numberOfCopies = Integer.valueOf(lines[1].split(":")[1]);
            
            if(numberOfCopies<0)
            	throw new MyException("number Of Copies cannot be negative");
            	
            
            int NumberOfborrow = Integer.valueOf(lines[2].split(":")[1]);

            if(NumberOfborrow<0)
            	throw new MyException("Number Of borrow cannot be negative");
       

            int  trackNo = Integer.valueOf(lines[5].split(":")[1]);

                   
            // get the composer name
            String firstName = lines[6].split(":")[1].split(" ")[0];
            String lasttName = lines[6].split(":")[1].split(" ")[2];
      
        
           return new CD(title, numberOfCopies, NumberOfborrow,trackNo, new Name(firstName ,lasttName),new Borrow(new NewDate(),new NewDate(),null));

            
        } else if (lines[5].split(":")[0].equalsIgnoreCase("author")) {
        	
        	
            // insert title
        	String title =lines[0].split(":")[1];
         	
             // insert numberOfCopies
            int numberOfCopies = Integer.valueOf(lines[1].split(":")[1]);
            
            if(numberOfCopies<0)
            	throw new MyException("number Of Copies cannot be negative");

             // insert NumberOfborrow
            int NumberOfborrow = Integer.valueOf(lines[2].split(":")[1]);

            if(NumberOfborrow<0)
            	throw new MyException("Number Of borrow cannot be negative");
                 
             
             
             // get the author name
            String firstName = lines[5].split(":")[1].split(" ")[0];
            String lasttName = lines[5].split(":")[1].split(" ")[2];
            

             // get the ISBN

             String ISBN = lines[6].split(":")[1].split(" ")[0];

             

             return( new Book(title, numberOfCopies, NumberOfborrow,new Name(firstName ,lasttName), ISBN,new Borrow(new NewDate(),new NewDate(),null)));


        	
        } else {// invalid item type 
        	
            System.out.println("Invalid item type.");
            return null;
        }


      }catch(MyException ex) {
    	  ex.getMessage();
    	  return null;
      }
    }
    
    
    
    
    // Add a new library item to the end of the file
    public boolean addItem(LibraryItem item) {
        try {
        	if(searchByTitle(item.getTitle())!=null) {
        		
        		System.out.println("item already exsist !");
        		return false;
        		
        	}
        	
            file.seek(file.length());
            file.writeUTF(item.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("added successfully !");
        return true;
    }

    
    
    
    // Delete a library item in the file by title
    public boolean deleteByTitle(String title) {
    	
    	if(searchByTitle(title)==null) {
    		
    		System.out.println("item not found !");
    		return false ;
    	}else {
    		
    		 Scanner scanner = new Scanner(System.in);
			 System.out.println("enter 1 to remove !");
			 if(scanner.nextInt()==1) {
					 scanner.nextLine();

			 }else {
				 	scanner.nextLine();
				 	return false;
			 		}
    		
    		
    		
    	}
    		
    	
    	
        int numberOfItems = countLines() / 7;
        StringBuilder s = new StringBuilder();

        try {
            file.seek(0);

            while (numberOfItems > 0) {
                String line = file.readLine();
                String[] t = line.split(":");

                if (t[1].equals(title)) {
                	s.append(line); 
                    s.append("\n");
                    for (int i = 1; i < 7; i++) {
                        s.append(file.readLine());
                        s.append("\n");
                    }
                    // Move the file pointer back to the start of the item to be deleted
                    file.seek(file.getFilePointer() - s.length());
                    // Write empty lines or null characters to effectively delete the item
                    for (int i = 0; i < s.length(); i++) {
                        file.writeByte(0); // Write null characters to delete the item
                    }
					System.out.println("remove successfully");
                    return true;
                } else {
                    for (int i = 1; i < 7; i++) {
                        file.readLine();
                    }
                }

                numberOfItems--;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    
    
    // update the title, number of copies and number of borrow in the file 
    	public boolean updateItem(String title) {
    		
        	
        	if(searchByTitle(title)==null) {
        		
        		System.out.println("item not found !");
        		return false ;
        	}
        	Scanner scanner=new Scanner(System.in);
    	    int numberOfItems = countLines() / 7;

    	    try {
    	        file.seek(0);

    	        while (numberOfItems > 0) {
    	            long currentPosition = file.getFilePointer();
    	            String line = file.readLine();
    	            String[] t = line.split(":");

    	            if (t[1].trim().equals(title)) {
    	                // Update the title
    	                System.out.print("Enter the updated title: ");
    	                String updatedTitle = scanner.nextLine();

    	                // Update the number of copies
    	                System.out.print("Enter the updated number of copies: ");
    	                int updatedNumberOfCopies = scanner.nextInt();
    	                scanner.nextLine();

    	                // Update the number of borrows
    	                System.out.print("Enter the updated number of borrows: ");
    	                int updatedNumberOfBorrows = scanner.nextInt();
    	                scanner.nextLine();

    	                // Move the file pointer back to the beginning of the current item
    	                file.seek(currentPosition+2);

    	                // Write the updated lines to the file
    	                file.writeBytes("title:" + updatedTitle + "\n");
    	                file.writeBytes("number of copies:" + updatedNumberOfCopies + "\n");
    	                file.writeBytes("NumberOfborrow:" + updatedNumberOfBorrows + "\n");

                        

    	                System.out.println("Updated successfully!");
    	                return true;
    	            } else {
    	                // Skip the next six lines (all fields in the current item)
    	                for (int i = 1; i < 7; i++) {
    	                    file.readLine();
    	                }
    	            }

    	            numberOfItems--;
    	        }

    	        System.out.println("Item not found!");
    	        return false;
    	    } catch (IOException ex) {
    	        ex.printStackTrace();
    	        return false;
    	    }
    	}
    

    // Restore a library item at the specified position with a new item
    public void restoreItem(int position, LibraryItem item) {
        try {
            long recordSize = file.length() / 2;
            long shiftSize = recordSize * (position - 1);

            // Overwrite the existing item with the new item
            file.seek(shiftSize);
            file.writeUTF(item.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}

