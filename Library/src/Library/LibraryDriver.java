// LibraryDriver to test all 
// implemented methods and the other classes.

package Library;

public class LibraryDriver {

	public static void main(String[] args) {
		
		
		// create library
		Library bzu= new Library ("bzuSchoolLibrary ");
		
        // Create library items
        Book book1 = new Book("Java Programming", 5,20,new Name("John", "Smith"),"122",new Borrow(new NewDate("6","10","2023"),new NewDate("6","10","2024"),null));
        Book book2 = new Book("Introduction to Python", 10,5,new Name("Jane", "Doe"),"123",new Borrow(new NewDate("6","10","2023"),new NewDate("6","10","2024"),null));
        Book book3 = new Book("Classical Music", 2,7,new Name("Beethoven", ""),"124",new Borrow(new NewDate("6","10","2023"),new NewDate("6","10","2024"),null));
        CD cd1 = new CD("Introduction to Programming", 10, 1,6, new Name("John" ,"Smith"),new Borrow(new NewDate("6","10","2023"),new NewDate("6","10","2024"),null));
        CD cd2 = new CD("Database Management", 5, 2,5, new Name("Jane", "Doe"),new Borrow(new NewDate("6","10","2023"),new NewDate("6","10","2024"),null));
        CD cd3 = new CD("Network Security", 3, 3,3, new Name("Alex", "Johnson"),new Borrow(new NewDate("6","10","2023"),new NewDate("6","10","2024"),null));
        
        
        // Add library items to the library
        bzu.addLibraryItem(book1);
        bzu.addLibraryItem(book2);
        bzu.addLibraryItem(book3);
        bzu.addLibraryItem(cd1);
        bzu.addLibraryItem(cd2);
        bzu.addLibraryItem(cd3);

        // Search for library items
        LibraryItem item1 = bzu.searchForItem("Java Programming");
        LibraryItem item2 = bzu.searchForItem("Introduction to Python");
        LibraryItem item3 = bzu.searchForItem("Classical Music");

        // Display search results
        System.out.println("Search Results:");
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);

        // Remove a library item
        bzu.removeLibraryItem(book2);
        
        // update item
        bzu.updateItem(book2);// not found (deleted)
       // bzu.updateItem(cd3);// update successfully
        
        System.out.println("\n\n");
        // Create a Student instance
        Student student1 = new Student(new Name("John" ,"Smith"), "123456789", "john@example.com",new NewDate("1","may","1999"), 0, 1216077,88.9,"palestine@Jenin@1214466@Huda@111");

        // Create a Professor instance
        Professor professor1 = new Professor(new Name("Jane" ,"Doe"), "987654321", "jane@example.com",new NewDate("1","jun","1980"),0, 3000.0,"palestine@Ramallah@11109@Huda@109");
        
        // print information
        System.out.println(student1);
        System.out.println(professor1);
        
        // add libraryItem to student
        student1.addLibraryItem(book1);
        student1.addLibraryItem(book1);// already exist
        student1.addLibraryItem(book2);
        student1.addLibraryItem(book3);
        student1.addLibraryItem(cd1);
        student1.addLibraryItem(cd2);
        student1.addLibraryItem(cd3);// Maximum borrowing limit reached
        System.out.println();
        
        //  items along with their information in sorted order by number of borrow
        bzu.libraryReport();
        
        

	}

}
