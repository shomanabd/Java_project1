// address class to store information about the address
// like country ,building name , street name and cityobox
//  address stored based on the following format:
//  country@city@streetname@buildingname@pobox

package Library;

public class Address {

	// store name of country
	private String country;
	// store city name
	private String city;
	// store street name
	private String street;
	// store building name
	private String buildingname;
	// store the  number of "post office box."
	private int pobox;




	// default constructor give default value to argument constructor
	public Address(){
		this("empty@empty@empty@empty@-1");// call argument constructor
	}


	// argument constructor
	// the address store in this format :
	// country@city@streetname@buildingname@pobox
	// so the constructor separate each field and store them
	public Address(String address){

		// split the address by "@" delimiter
	    String[] addressparts = address.split("@");

	    // assign values to instance variables
	    if (addressparts.length >= 5) {
	        country = addressparts[0];
	        city = addressparts[1];
	        street = addressparts[2];
	        buildingname=addressparts[3];
	        pobox = Integer.parseInt(addressparts[4]);
	    }
	}





	// override the implementation of tostring
	// tostring return string represents the information
	// about address in the following format:
	// country@city@streetname@buildingname@pobox
	@Override
	public String toString() {

		return country+"@"+city+"@"+street+"@"+buildingname+"@"+pobox ;
	}




	// getters and setters


	// get the country name
	public String getcountry() {
		return country;
	}


	// update the country name
	public void setcountry(String country) {
		this.country = country;
	}


	// get the city name
	public String getcity() {
		return city;
	}


	// update the city name
	public void setcity(String city) {
		this.city = city;
	}


	// get the street name
	public String getstreet() {
		return street;
	}


	// update the street name
	public void setstreet(String street) {
		this.street = street;
	}


	// get the building name
	public String getbuildingname() {
		return buildingname;
	}


	// update the building name
	public void setbuildingname(String buildingname) {
		this.buildingname = buildingname;
	}


	// get the "post office box." number
	public int getpobox() {
		return pobox;
	}


	// update "post office box."
	public void setpobox(int pobox) {
		pobox = pobox;
	}
	
	
}


