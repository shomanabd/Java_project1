// NewDate class replace the Date class in Java.
// it contains day ,month and year as strings

package Library;

public class NewDate {
	
	// to store day 
	private String Day;
	// to store Month
	private String Month;
	// to store Year
	private String Year;
	
	
	
	
	// default constructor give initial values to argument constructor
	public NewDate() {
		// give default values to argument constructor
		this("empty","empty","empty");
	}
	
	
	
	// argument constructor 
	public NewDate(String day, String month, String year) {
		super();
		Day = day;
		Month = month;
		Year = year;
	}
	
	
	// override the implementation of toString 
	// toString return string represents the information 
	// about Date in the following format: 
	// Day-Month-Year
	@Override
	public String toString() {
		
		return Day+"-"+Month+"-"+Year;
	}


	
	
	// getters and setters 
	
	// get day 
	public String getDay() {
		return Day;
	}


	// update day
	public void setDay(String day) {
		Day = day;
	}


	// get month
	public String getMonth() {
		return Month;
	}


	// update month
	public void setMonth(String month) {
		Month = month;
	}


	// get year
	public String getYear() {
		return Year;
	}


	// update year
	public void setYear(String year) {
		Year = year;
	}

	
	
	
	

}
