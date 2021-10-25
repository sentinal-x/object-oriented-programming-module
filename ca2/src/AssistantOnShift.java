// The AssistantOnShift class:
public class AssistantOnShift{
	
	// An assistant on shift is a volunteer already registered within the university that can be effectively allocated to a bookable room to perform a test.

	
	// 3 instance attributes:
	private String status;
	private String timeSlot;
	private Assistant assistant;
	
	// Methods:
	
	// toString Method -
	public String toString(){
	  return "| "+timeSlot+" | "+status+" | "+assistant.getEmail()+" |";
	}
	
	//returns true if status is "BUSY" and false if not.
	public boolean isBusy() {
		if (status == "BUSY") {
			return true;
		} else {
			return false;
		}
	}
	
	// allows you to change the status of the AssistantOnShift
	public void isBooked(boolean booked) {
		if (booked == true) {
			this.status = "BUSY";
		} else {
			this.status = "FREE";
		}
	}
	
	// Getters -
	// These are needed to return the values of the attributes as they are private...
	
	public String getStatus() {
		return status;
	}
	
	public String getTimeSlot() {
		return timeSlot;
	}
	
	public Assistant getAssistant() {
		return assistant;
	}
	
	public String getEmail() {
		return assistant.getEmail();
	}
	
	// Constructor:
	public AssistantOnShift(String timeSlot, Assistant assistant) {
		this.assistant = assistant;
		this.timeSlot = timeSlot;
		this.status = "FREE";
	}

}