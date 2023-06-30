// class Book extends or is a sub class of LibraryItem ("is a" relation ships)
// the class contain the name of the book author and book ISBN
// Two CDs that are related to the same composer are equal.

package Library;

public class CD extends LibraryItem {

	// the track number of CD
	private int trackNo;
	// the composer (writer) of the CD
	private Name composer;
	
	
	
	
		// default constructor
		public CD(){
			this(-1,new Name()); // call CD arguments constructor
		}


		
		
		// arguments constructor for class only 
		private CD(int trackNo, Name composer) {
			super(); //call LibraryItem default constructor
			this.trackNo=trackNo;
			this.composer=composer;
		}
		
		
		
		
		// arguments constructor
		public CD(String title, int numberOfCopies,int NumberOfborrow,
				int trackNo, Name composer,Borrow borrow) {
			super(title,numberOfCopies,NumberOfborrow,borrow);
			this.trackNo = trackNo;
			this.composer =composer;
		}





		// implements the equals method . it return true if 
		// Two CDs that are related to the same composer
		// else return false
		
		public boolean equals(CD obj) {
			
			return (this.composer.equals(obj.composer));
		}
		
		
		
		
		
		// implements the toString  method . it return information 
		// about object  	
		@Override
		public String toString() {
			
			return super.toString()+"trackNo:"+trackNo+"\n"
					+"composer:"+composer.toString();
		}
		
		
		
		
		
		// getters and setters 
		
		
		
		public int getTrackNo() {
			return trackNo;
		}




		public void setTrackNo(int trackNo) {
			this.trackNo = trackNo;
		}




		public Name getComposer() {
			return composer;
		}




		public void setComposer(Name composer) {
			this.composer = composer;
		}
		
		
		
}
