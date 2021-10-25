// The BookableRoom class:
public class BookableRoom{
	
	// A bookable room is a room registered by the university that can be effectively used for tests. As the name suggests, it is a room available for booking.
	
	// 4 instance attributes:
	private String status;
	private String timeSlot;
	private Room room;
	private int occupancy = 0;
	
	// Methods:
	
	// toString Method -
	public String toString(){
	  return "| "+timeSlot+" | "+status+" | "+room.getCode()+" | occupancy: "+occupancy+" |";
	}
	
	// returns true if status is "FULL" and false if not.
	public boolean isFull() {
		if (status == "FULL") {
			return true;
		} else {
			return false;
		}
	}
	
	//returns true if status is "EMPTY" and false if not.
	public boolean isEmpty() {
		if (status == "EMPTY") {
			return true;
		} else {
			return false;
		}
	}
	
	// used when a booking is added.
	public void addBooking() {
		occupancy += 1;
		setStatus();
	}
	
	// used when a booking is completed.
	public void completeBooking() {
		occupancy -= 1;
		setStatus();
	}
	
	// allows the user to change the status.
	public void setStatus() {
		if (occupancy == 0) {
			this.status = "EMPTY";
		} else if (room.getCapacity() - occupancy > 0) {
			this.status = "AVAILABLE";
		} else {
			this.status = "FULL";
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
	
	public Room getRoom() {
		return room;
	}
	
	public int getOccupancy() {
		return occupancy;
	}
	
	public String getCode() {
		return room.getCode();
	}
	
	// Constructor:
	public BookableRoom(String timeSlot, Room room) {
		this.room = room;
		this.timeSlot = timeSlot;
		this.occupancy = 0;
		setStatus();
		
	}

}