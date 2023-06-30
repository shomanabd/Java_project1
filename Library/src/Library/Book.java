// class Book extends or is a sub class of LibraryItem ("is a" relation ships)
// the class contain the name of the book author and book ISBN
// the two Book objects are equal if they are written by the same author

package Library;

public class Book  extends LibraryItem{

	// the name of the author 
	private Name author;
	
	// the ISBN( International student book number ) of the book 
	private String ISBN;
	
	
	
	
	// default constructor
	public Book(){
		this(new Name(),"empty"); // call Book arguments constructor
	}
	
	


	// argument constructor only for class 
	private Book(Name  author, String ISBN) {
		super();
		this.author = author;
		this.ISBN = ISBN;
	}
	
	
	
	
	// arguments constructor
	public Book(String title, int numberOfCopies,int NumberOfborrow,
			Name  author, String ISBN,Borrow borrow) {
		super(title,numberOfCopies,NumberOfborrow,borrow);
		this.author = author;
		this.ISBN = ISBN;
	}

	

	
	
	// implements the equals method . it return true if 
	// object  are written by the same author else return false
	
	public boolean equals(Book obj) {
		
		return (this.author.equals(obj.author));
	}
	

	
	
	// implements the toString  method . it return information 
	// about object  	
	@Override
	public String toString() {
		
		return super.toString()+"author:"+author+"\nISBN:"+ISBN;
	}
	
	
	
	
	
	// getters and setters for author and ISBN 




	// to get the author name 
	public Name getAuthor() {
		return author;
	}

	
	// to update author name 
	public void setAuthor(Name author) {
		this.author = author;
	}


	// to get ISBN 
	public String getISBN() {
		return ISBN;
	}

	
	// to update ISBN
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


	

	



	
	
	
	
}
