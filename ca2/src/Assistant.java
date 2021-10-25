// The Assistant class:
public class Assistant{
	
	// A COVID-19 test assistant is someone related to the university (staff or student) who is volunteering to perform COVID tests.
	
	// 2 instance attributes:
	private String email;
	private String name;
	
	// Methods:
	
	// toString Method -
	public String toString(){
	  return "| "+name+" | "+email+" |";
	}
	
	// Setters -
	
	public void setEmail(String newEmail) {
		// Checks email ends with '@uok.ac.uk'.
		boolean endCorrect;
		endCorrect = newEmail.endsWith("@uok.ac.uk");
		if (endCorrect == true) {
			this.email = newEmail;
		} else {
			System.out.println("Could not set this email address as it does not end with '@uok.ac.uk'.");
		}
	}
	
	public void setName(String name) {
		if (name != "") {
			// Check name isn't null.
			this.name = name;
		}
	}
	
	// Getters -
	// These are needed to return the values of the attributes as they are private...
	
	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}
	
	// Constructor:
	public Assistant(String name, String email) {
		setName(name);
		setEmail(email);
	}

}
