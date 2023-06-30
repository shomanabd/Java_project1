// LibraryDriver to test all 
// implemented methods and the other classes.

package Library;
import java.time.LocalDate;
import java.util.Scanner;
public class LibraryDriver {

	public static void main(String[] args)  {
		
		
		// create library
		Library bzu= new Library ("bzuSchoolLibrary ");
		LibraryFileManager file =new LibraryFileManager("item.dat");
		
		
        // create menu to let the user insert the information 
        int choice = 0;

        
        do {
            displayMenu();
            choice = getChoice();

            switch (choice) {
            // add item (CD or book)
            case 1 :
            	try {addLibraryItem(bzu); 
            	}catch (MyException ex) {
            		
            		System.out.println(ex);
            		
            	}

            	break;            
            // search for library item
            case 2 : searchLibraryItem(bzu);                       break;
            // delete library item by title 
            case 3 : deleteLibreitem(bzu);                         break;
            // update library item by title 
            case 4 : updateLibreitem( bzu);                        break;
            // add new member (student or professor)
            case 5 : addLibraryMember(bzu);                        break;
            //   search for library member
            case 6 : searchLibraryMember(bzu);                     break;    
            // delete library member by name 
            case 7 : deleteLibraryMember(bzu);                     break;
            // update library member 
            case 8 : updateLibraryMember(bzu);                     break;
            //  borrow Library Item
            case 9 : borrowLibraryItem(bzu);                       break;
            // borrow cancellation of library item
            case 10: borrowCancellation( bzu);                     break;
            // update borrow dueDate  item from the school libraryMember.
            case 11: updateBorrowDueDate(bzu);                     break;
            // print all the member items 
            case 12: printItems( bzu);                             break;
            // print all the library items 
            case 13: bzu.libraryReport();                          break;
            // write All Items To File
            case 14: file.writeAllItemsToFile(bzu);                break;
            // to search for item position by title
            case 15: serchInFile(file);                            break;
            // delete Library item in the file
            case 16: deleteLibreitem(file);                        break;
            // add Library item to the file
            case 17: addtofile(file);                              break;
            // update library item in the file 
            case 18: updateFile(file);                             break;
            // add item from file 
            case 19:addFromFile(file,bzu);                         break;
            // close the file 
            case 20: file.close();                                 break;
            
            // exit the program 
            case 21: 
            	System.out.println("Exiting the program...");    
            	System.exit(0);

            	// the default case (let user insert again )
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        } while (choice != 21);
        
        

        
    }
	
	
	

    private static void displayMenu() {
        System.out.println("Library Management Menu.");
        System.out.println("1.  Add Library item.");
        System.out.println("2.  Search Library item.");
        System.out.println("3.  Delete Library item.");
        System.out.println("4.  Update Library item.");
        System.out.println("5.  Add Library member.");
        System.out.println("6.  Search Library member.");
        System.out.println("7.  Delete Library member.");
        System.out.println("8.  Update Library member.");
        System.out.println("9.  borrow Library Item.");
        System.out.println("10. Library Item Borrow cancellation.");
        System.out.println("11. update borrow dueDate  item from the school libraryMember.");
        System.out.println("12. print all the library items borrowed by library member.");
        System.out.println("13. print library report.");
        System.out.println("14. write All Items To File.");
        System.out.println("15. search for item in the file.");
        System.out.println("16. delete item in the file.");
        System.out.println("17. add Library item to the file.");
        System.out.println("18. update library item in the file.");
        System.out.println("19. add item form the file.");
        System.out.println("20. Close the file.");
        System.out.println("21. Exit");
    }
   
  

    // get the choice from the user 
    private static int getChoice() {
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice=0;
        try{
         choice =scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        }catch(java.util.InputMismatchException ex) {
        	
        	System.out.println("Invalid input. Please enter a valid choice.");
        	 scanner.nextLine(); // Consume newline character
        	 getChoice();// try again
        }
        

        return choice;
    } 
    
    
    
    // to add library item it can be book or CD
    private static void addLibraryItem(Library bzu) throws MyException {
        System.out.println("Adding Library item");
        Scanner scanner = new Scanner(System.in);
        
        // Prompt for member details
        System.out.print("Enter item type (CD/Book): ");
        String itemType = scanner.nextLine();
        
        // Create member instance based on member type
        if (itemType.equalsIgnoreCase("CD")) {
        	
            // insert title
        	System.out.print("Enter item title: "); 
        	String title =scanner.nextLine();
        	
            // insert numberOfCopies
            System.out.print("Enter item numberOfCopies: ");
            int numberOfCopies = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            if(numberOfCopies<0)
            	throw new MyException("number Of Copies cannot be negative");
            	

            // insert NumberOfborrow
            System.out.print("Enter item NumberOfborrow: ");
            int NumberOfborrow = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            if(NumberOfborrow<0)
            	throw new MyException("Number Of borrow cannot be negative");
            	
            
            // insert trackNo
            System.out.print("Enter item trackNo: ");
            int  trackNo = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
                   
            // get the composer name
            System.out.print("Enter composer first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter composer last name: ");
            String lasttName = scanner.nextLine();
      
            //add the CD
            if(bzu.addLibraryItem( new CD(title, numberOfCopies, NumberOfborrow,trackNo, new Name(firstName ,lasttName),new Borrow(new NewDate(),new NewDate(),null))))
            System.out.println("CD added successfully.");
            
        } else if (itemType.equalsIgnoreCase("Book")) {
        	
        	
            // insert title
         	System.out.print("Enter item title: "); 
         	String title =scanner.nextLine();
         	
             // insert numberOfCopies
             System.out.print("Enter item numberOfCopies: ");
             int numberOfCopies = scanner.nextInt();
             scanner.nextLine(); // Consume newline character

             // insert NumberOfborrow
             System.out.print("Enter item NumberOfborrow: ");
             int NumberOfborrow = scanner.nextInt();
             scanner.nextLine(); // Consume newline character            
             
             
             // get the author name
             System.out.print("Enter author first name: ");
             String firstName = scanner.nextLine();
             System.out.print("Enter author last name: ");
             String lasttName = scanner.nextLine();
            

             // get the ISBN
             System.out.print("Enter ISBN: ");
             String ISBN = scanner.nextLine();

             
             //add the CD
             if(bzu.addLibraryItem( new Book(title, numberOfCopies, NumberOfborrow,new Name(firstName ,lasttName), ISBN,new Borrow(new NewDate(),new NewDate(),null))))
             System.out.println("book added successfully.");

        	
        } else {// invalid item type 
        	
            System.out.println("Invalid item type. item not added.");
        }


 
    }
    
    
    // to search library Item 
    // the CD and book and search by title 
    // the CD can search by composer but the Book by author name  
    public static void searchLibraryItem(Library bzu) {
    	
    	// insert the item type
        Scanner scanner=new Scanner(System.in);	
        System.out.print("Enter itemType: ");
		String itemType = scanner.nextLine();
    	
		
		// chick if it book 
        if (itemType.equalsIgnoreCase("book")) {
        	
        	
        			// insert the search argument
        			System.out.print("You search by title or author name: ");
        			String titleorautor = scanner.nextLine();
        				
        			// chick if it author  
        				if(titleorautor.equalsIgnoreCase("author")) {
        					//insert the author name 
        					System.out.print("Enter autor first name: ");
        					String firstName = scanner.nextLine();
        					System.out.print("Enter autor last name: ");
        					String lasttName = scanner.nextLine();
        						
        			
        					System.out.println( bzu.searchForItem(new Name(firstName,lasttName)));}
        				
        				// chick if it title  
        				else if(titleorautor.equalsIgnoreCase("title")) {
        					//insert the title
        					System.out.print("Enter title: ");
        					String title = scanner.nextLine();
        			
        					System.out.println(bzu.searchForItem(title));}
        				else {
        					// invalid choice 
        					System.out.print("invalid choice !");
        			;
        					
        					}
        				
        				// chick if it CD		
        } else if (itemType.equalsIgnoreCase("CD")) {
        	
        	
        	
   			// insert the search argument
			System.out.print("You search by title or composer name: ");
			String titleorcomposer = scanner.nextLine();
				// chick if it composer 
				if(titleorcomposer.equalsIgnoreCase("composer")) {
					// insert the composer name
					System.out.print("Enter composer first name: ");
					String firstName = scanner.nextLine();
					System.out.print("Enter composer last name: ");
					String lasttName = scanner.nextLine();
		
					
					System.out.println( bzu.searchForItem(new Name(firstName,lasttName)));}
				// chick if it title
				else if(titleorcomposer.equalsIgnoreCase("title")) {
					// insert the title
					System.out.print("Enter title: ");
					String title = scanner.nextLine();
					
				
					System.out.println( bzu.searchForItem(title));}
				else {
					// invalid choice
					System.out.print("invalid choice !");
				
				
					}
        }				else {
			// invalid item 
			System.out.print("invalid item !");
		
	
			}
            
    }
    
    
    
    // to delete library item by it's title 
    private static void deleteLibreitem(Library bzu) {
    	
    	// insert the title 
        Scanner scanner=new Scanner(System.in);	
        System.out.print("Enter title: ");
		String title = scanner.nextLine();
		bzu.removeLibraryItem(title);
    		
    }
    
    
    
    

    // to update library item by it's title 
    private static void updateLibreitem(Library bzu) {
    	
    	// insert the title 
        Scanner scanner=new Scanner(System.in);	
        System.out.print("Enter title: ");
		String title = scanner.nextLine();
		bzu.updateItem(title);
		
    }
    
    
    
    
    // to add library member it can student or Professor
    private static void addLibraryMember(Library bzu) {
       

        // insert member type 
    	Scanner scanner=new Scanner(System.in);	
        System.out.print("Enter member type (student/professor): ");
        String memberType = scanner.nextLine();

        // chick if type is student 
        if (memberType.equalsIgnoreCase("student")) {
        	
        	// enter student student  name
            System.out.print("Enter student first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter student last name: ");
            String lastName = scanner.nextLine();

            // enter student phone number 
            System.out.print("Enter studnet  phone numbrer: ");
            String phoneNumber = scanner.nextLine();

            // enter email address 
            System.out.print("Enter studnet  email address: ");
            String emailAddress = scanner.nextLine();
             
            // enter student date of birth
            System.out.print("Enter birth  day: ");
            String birthDay = scanner.nextLine();
            System.out.print("Enter birth Month: ");
            String birthMonth = scanner.nextLine();
            System.out.print("Enter birth Year: ");
            String birthYear = scanner.nextLine();

            // enter number Of borrowed Items
            System.out.print("Enter number Of borrowed Items: ");
            int  numberOfborrowedItems = scanner.nextInt();
            scanner.nextLine();
            
            // enter student number 
            System.out.print("Enter studnet  number: ");
            int  studentNumber = scanner.nextInt();
            scanner.nextLine();
            
            // enter student average mark 
            System.out.print("Enter studnet  average mark : ");
            double  averageMark = scanner.nextDouble();
            scanner.nextLine();
            
            // enter the address 
            System.out.println("Enter the country:");
            String country = scanner.nextLine();
            System.out.println("Enter the city:");
            String city = scanner.nextLine();
            System.out.println("Enter the street:");
            String street = scanner.nextLine();
            System.out.println("Enter the building name:");
            String buildingname = scanner.nextLine();
            System.out.println("Enter the post office box number:");
            String pobox = scanner.nextLine();
            String address =country+"@"+city+"@"+street+"@"+buildingname+"@"+pobox;
            
        
            bzu.addLibraryMember(new Student(new Name(firstName, lastName), phoneNumber,emailAddress,new NewDate(birthDay,birthMonth,birthYear),numberOfborrowedItems,studentNumber,averageMark,address));
            System.out.println("Student added successfully.");
        } else if (memberType.equalsIgnoreCase("professor")) {
        	
        	// enter student professor  name
            System.out.print("Enter professor first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter professor last name: ");
            String lastName = scanner.nextLine();

            // enter student phone number 
            System.out.print("Enter professor  phone numbrer: ");
            String phoneNumber = scanner.nextLine();

            // enter email address 
            System.out.print("Enter professor  email address: ");
            String emailAddress = scanner.nextLine();
             
            // enter professor date of birth
            System.out.print("Enter birth  day: ");
            String birthDay = scanner.nextLine();
            System.out.print("Enter birth Month: ");
            String birthMonth = scanner.nextLine();
            System.out.print("Enter birth Year: ");
            String birthYear = scanner.nextLine();

            // enter number Of borrowed Items
            System.out.print("Enter number Of borrowed Items: ");
            int  numberOfborrowedItems = scanner.nextInt();
            scanner.nextLine();          
            
            // enter professor salary 
            System.out.print("Enter professor salary: ");
            double  salary = scanner.nextDouble();
            scanner.nextLine();
            
            // enter the address 
            System.out.println("Enter the country:");
            String country = scanner.nextLine();
            System.out.println("Enter the city:");
            String city = scanner.nextLine();
            System.out.println("Enter the street:");
            String street = scanner.nextLine();
            System.out.println("Enter the building name:");
            String buildingname = scanner.nextLine();
            System.out.println("Enter the post office box number:");
            String pobox = scanner.nextLine();
            String address =country+"@"+city+"@"+street+"@"+buildingname+"@"+pobox;
            
          
            bzu.addLibraryMember(new Professor(new Name(firstName, lastName), phoneNumber,emailAddress,new NewDate(birthDay,birthMonth,birthYear),numberOfborrowedItems,salary,address));
            System.out.println("Professor added successfully.");
        } else {
            System.out.println("Invalid member type. Member not added.");
        }
    }

    
    
    // to search library member by name 
    private static void searchLibraryMember(Library bzu) {
    	
    	// insert the name 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter member first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter member last name: ");
        String lastName = scanner.nextLine();

        // search by the name 
        LibraryMember member = bzu.searchForMember(new Name(firstName,lastName));
        if (member != null) {
            System.out.println("Member found:");
            System.out.println(member);
        } else {
            System.out.println("Member not found.");
        }
    }

    
    // to delete library member by name 
    private static void deleteLibraryMember(Library bzu) {


    	// insert the name 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter member first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter member last name: ");
        String lastName = scanner.nextLine();
        // remove the member 
        bzu.removeLibraryMember(new Name(firstName,lastName));

    }
    
    
    
    // to update the member by name
    private static void updateLibraryMember(Library bzu) {

    	// insert the name 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter member first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter member last name: ");
        String lastName = scanner.nextLine();
        // update the member 
        bzu.updateMember(new Name(firstName,lastName));
      

    }
    
    
    
    
    
    // burrow library item 
    private static void borrowLibraryItem(Library bzu){
    	
    	// chick if member exist 
    	
    	// insert the name 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter member first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter member last name: ");
        String lastName = scanner.nextLine();

        // search by the name 
        LibraryMember member = bzu.searchForMember(new Name(firstName,lastName));
        if (member != null) { // member found 
            System.out.println("Member found:");
            
            // insert the item type
            System.out.print("Enter itemType: ");
    		String itemType = scanner.nextLine();
        	
    		
    		// chick if it book 
            if (itemType.equalsIgnoreCase("book")) {
            	
            	
            			// insert the search argument
            			System.out.print("You search by title or author name: ");
            			String titleorautor = scanner.nextLine();
            				
            			// chick if it author  
            				if(titleorautor.equalsIgnoreCase("author")) {
            					//insert the author name 
            					System.out.print("Enter autor first name: ");
            					String FirstName = scanner.nextLine();
            					System.out.print("Enter autor last name: ");
            					String lasttName = scanner.nextLine();
            						
            			
            				
            					
            					if(bzu.searchForItem(new Name(FirstName,lasttName))!=null)
            						member.borrowLibraryItem(bzu.searchForItem(new Name(FirstName,lasttName)));
            					else System.out.println("item not found !");
            				
            				
            				}
            				
            				// chick if it title  
            				else if(titleorautor.equalsIgnoreCase("title")) {
            					//insert the title
            					System.out.print("Enter title: ");
            					String title = scanner.nextLine();
            			
            					System.out.println(bzu.searchForItem(title));
            					
            					if(bzu.searchForItem(title)!=null)
            						member.borrowLibraryItem(bzu.searchForItem(title));
            					else System.out.println("item not found !");
            				                                                  }
            				else {
            					// invalid choice 
            					System.out.print("invalid choice !");
            			;
            					
            					}
            				
            				// chick if it CD		
            } else if (itemType.equalsIgnoreCase("CD")) {
            	
            	
            	
       			// insert the search argument
    			System.out.print("You search by title or composer name: ");
    			String titleorcomposer = scanner.nextLine();
    				// chick if it composer 
    				if(titleorcomposer.equalsIgnoreCase("composer")) {
    					// insert the composer name
    					System.out.print("Enter composer first name: ");
    					String FirstName = scanner.nextLine();
    					System.out.print("Enter composer last name: ");
    					String lasttName = scanner.nextLine();
    		
    					
    					if(bzu.searchForItem(new Name(FirstName,lasttName))!=null)
    						member.borrowLibraryItem(bzu.searchForItem(new Name(FirstName,lasttName)));
    					else System.out.println("item not found !");
    						
    							                                         }
    				// chick if it title
    				else if(titleorcomposer.equalsIgnoreCase("title")) {
    					// insert the title
    					System.out.print("Enter title: ");
    					String title = scanner.nextLine();
    					
    				if(bzu.searchForItem(title)!=null)
    					member.borrowLibraryItem( bzu.searchForItem(title));
    				else System.out.println("item not found !");
    				
    																	}
    				else {
    					// invalid choice
    					System.out.print("invalid choice !");
    				
    				
    					}
            }				else {
    			// invalid item 
    			System.out.print("invalid item !");
    		
    	
    			}
            

            
        } else {
            System.out.println("Member not found.");
        }
    	
    }
    
    
    
    
    // Library Item Borrow cancellation
    private static void borrowCancellation(Library bzu){
    	
    
    	// chick if member exist 
    	
    	// insert the name 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter member first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter member last name: ");
        String lastName = scanner.nextLine();

        // search by the name 
        LibraryMember member = bzu.searchForMember(new Name(firstName,lastName));
        if (member != null) { // member found 
            System.out.println("Member found:");
            // insert item title 
			System.out.print("Enter title: ");
			String title = scanner.nextLine();
			
			member.removeLibraryItem(title);
            
        } else {
            System.out.println("Member not found.");
        }
    }
    
    

 // update borrow dueDate  item from the school libraryMember.
    private static void  updateBorrowDueDate(Library bzu){
    	
        
    	// chick if member exist 
    	
    	// insert the name 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter member first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter member last name: ");
        String lastName = scanner.nextLine();

        // search by the name 
        LibraryMember member = bzu.searchForMember(new Name(firstName,lastName));
        if (member != null) { // member found 
            System.out.println("Member found:");
            // insert item title 
			System.out.print("Enter title: ");
			String title = scanner.nextLine();
			
			member.updateItem(title);
            
        } else {
            System.out.println("Member not found.");
        }
    }
    
    
    
    
    // print all the library items borrowed by library member 
    private static void  printItems(Library bzu){
    	
    	
// chick if member exist 
    	
    	// insert the name 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter member first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter member last name: ");
        String lastName = scanner.nextLine();

        // search by the name 
        LibraryMember member = bzu.searchForMember(new Name(firstName,lastName));
        if (member != null) { // member found 
            System.out.println("Member found:");
	
			member.memberIteamsReport();
            
        } else {
            System.out.println("Member not found.");
        }
    	
    	
    }
    
    
    
    
    // to search in the file
	static void serchInFile(LibraryFileManager file) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ensert the title :");
		String title=scanner.nextLine();
		
		LibraryItem item=file.searchByTitle(title);
		if(item!=null) { 
		System.out.println("Item found !");
		System.out.println(item);
		}
		else 
			System.out.println("Item not found !");
	
	}
	
	
	
	
	
    // to delete library item by it's title in file
    private static void deleteLibreitem(LibraryFileManager file) {
    	
    	Scanner scanner = new Scanner(System.in);
		System.out.print("Ensert the title :");
		String title=scanner.nextLine();
		file.deleteByTitle(title);
		
    	
    		
    }
    
    
    
    
    // to delete library item by it's title in file
    private static void addtofile(LibraryFileManager file) {
    	
    	
    	try {
    	 System.out.println("Adding Library item in the file");
         Scanner scanner = new Scanner(System.in);
         
         // Prompt for member details
         System.out.print("Enter item type (CD/Book): ");
         String itemType = scanner.nextLine();
         
         // Create member instance based on member type
         if (itemType.equalsIgnoreCase("CD")) {
         	
             // insert title
         	System.out.print("Enter item title: "); 
         	String title =scanner.nextLine();
         	
             // insert numberOfCopies
             System.out.print("Enter item numberOfCopies: ");
             int numberOfCopies = scanner.nextInt();
             scanner.nextLine(); // Consume newline character
             
             if(numberOfCopies<0)
             	throw new MyException("number Of Copies cannot be negative");
             	

             // insert NumberOfborrow
             System.out.print("Enter item NumberOfborrow: ");
             int NumberOfborrow = scanner.nextInt();
             scanner.nextLine(); // Consume newline character
             
             if(NumberOfborrow<0)
             	throw new MyException("Number Of borrow cannot be negative");
             	
             
             // insert trackNo
             System.out.print("Enter item trackNo: ");
             int  trackNo = scanner.nextInt();
             scanner.nextLine(); // Consume newline character
                    
             // get the composer name
             System.out.print("Enter composer first name: ");
             String firstName = scanner.nextLine();
             System.out.print("Enter composer last name: ");
             String lasttName = scanner.nextLine();
       
             //add the CD
             file.addItem( new CD(title, numberOfCopies, NumberOfborrow,trackNo, new Name(firstName ,lasttName),new Borrow(new NewDate(),new NewDate(),null)));

             
         } else if (itemType.equalsIgnoreCase("Book")) {
         	
         	
             // insert title
          	System.out.print("Enter item title: "); 
          	String title =scanner.nextLine();
          	
              // insert numberOfCopies
              System.out.print("Enter item numberOfCopies: ");
              int numberOfCopies = scanner.nextInt();
              scanner.nextLine(); // Consume newline character

              // insert NumberOfborrow
              System.out.print("Enter item NumberOfborrow: ");
              int NumberOfborrow = scanner.nextInt();
              scanner.nextLine(); // Consume newline character            
              
              
              // get the author name
              System.out.print("Enter author first name: ");
              String firstName = scanner.nextLine();
              System.out.print("Enter author last name: ");
              String lasttName = scanner.nextLine();
             

              // get the ISBN
              System.out.print("Enter ISBN: ");
              String ISBN = scanner.nextLine();

              
              //add the CD
              file.addItem( new Book(title, numberOfCopies, NumberOfborrow,new Name(firstName ,lasttName), ISBN,new Borrow(new NewDate(),new NewDate(),null)));


         	
         } else {// invalid item type 
         	
             System.out.println("Invalid item type. item not added.");
         }


    	
     }catch(MyException ex) {
    	 ex.getMessage();
     }
		
}
    
    
    // update library item in the file 
    static void updateFile(LibraryFileManager file) {
    	Scanner scanner = new Scanner(System.in);
        
    	 // insert title
      	System.out.print("Enter item title: "); 
      	String title =scanner.nextLine();
    	file.updateItem(title);
    }
    
    
    
    
    // add item form the file
    static void addFromFile(LibraryFileManager file,Library bzu) {
    	
    	Scanner scanner = new Scanner(System.in);
    	 // insert title
      	System.out.print("Enter item title: "); 
      	String title =scanner.nextLine();
      	LibraryItem item =file.searchByTitle(title);
      	if(item!=null) {
      		System.out.println("Item found!");
      		bzu.addLibraryItem(item);
      	}else {
      		System.out.println("Item not found!");
      	}
      		
      	
    	
    }
    		
    
}
