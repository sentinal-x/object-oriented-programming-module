// The Booking class:
public class Booking{
	
	// A booking consists of matching a bookable room and an assistant on shift at a specific time-slot to perform a COVID-19 test on a student. It is the main function of the system.
	
	// 4 instance attributes:
	private BookableRoom room;
	private AssistantOnShift assistant;
	private String studentEmail;
	private String status;
	
	// Methods:
	
	// toString Method -
	public String toString(){
	  return "| "+room.getTimeSlot()+" | "+status+" | " +assistant.getEmail()+" | "+room.getCode()+" | "+studentEmail+" |";
	}
	
	// updates the status of the booking to "COMPLETED".
	public void testCompleted() {
			this.status = "COMPLETED";
	}
	
	//returns true if status is "COMPLETED" and false if not.
	public boolean isComplete() {
		if (status == "COMPLETED") {
			return true;
		} else {
			return false;
		}
	}
	
	// allows you to set the students email in the booking
	public void setEmail(String newEmail) {
		// Checks email ends with '@uok.ac.uk'.
		if (newEmail.endsWith("@uok.ac.uk") == true) {
			this.studentEmail = newEmail;
		} else {
			System.out.println("Could not set this email address as it does not end with '@uok.ac.uk'.");
		}
	}
	
	// Getters -
	// These are needed to return the values of the attributes as they are private...
	
	public String getStatus() {
		return status;
	}
	
	public AssistantOnShift getAssistantOnShift() {
		return assistant;
	}
	
	public BookableRoom getBookableRoom() {
		return room;
	}
	
	public String getStudentEmail() {
		return studentEmail;
	}
	
	// Constructor:
	public Booking(BookableRoom room, AssistantOnShift assistant, String email) {
		this.room = room;
		this.assistant = assistant;
		setEmail(email);
		this.status = "SCHEDULED";
		
	}

}