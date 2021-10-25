// The TimeSlot class:
public class TimeSlot {
	
	// A TimeSlot is a funky class I just made cause I was like why the heck not I have no idea how to do this otherwise for the add booking section.
	
	// 3 instance attributes:
	private String timeSlot;
	private BookableRoom room;
	private AssistantOnShift assistant;
	
	// toString Method -
	public String toString(){
	  return timeSlot;
	}
	
	// Getters -
	// These are needed to return the values of the attributes as they are private...
	
	public String getTimeSlot() {
		return timeSlot;
	}
	
	public BookableRoom getRoom() {
		return room;
	}
	
	public AssistantOnShift getAssistant() {
		return assistant;
	}
	
	// Constructor
	
	public TimeSlot(String timeSlot, BookableRoom room, AssistantOnShift assistant) {
		this.timeSlot = timeSlot;
		this.room = room;
		this.assistant = assistant;
	}

}