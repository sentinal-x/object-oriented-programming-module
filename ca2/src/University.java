public class University {
	
	// The University has a list of assistants and a list of rooms.

	// 3 instance attributes
	private Assistant[] assistants;
	private Room[] rooms;
	private String name = "University of Knowledge";
	
	// Getters -
	// These are needed to return the values of the attributes as they are private...
	
	public String getName() {
		return name;
	}
	
	public Room getRoom(int index) {
		return rooms[index];
	}
	
	public Assistant getAssistant(int index) {
		return assistants[index];
	}
	
	// Gets length of arrays:
	
	public int getRoomsLength() {
		return rooms.length;
	}
	
	public int getAssistantsLength() {
		return assistants.length;
	}
	
	// Prints the values in the arrays:
	
	public void printRooms() {
		for (int i = 0; i < rooms.length; i++) {
			System.out.println((i+11)+". "+rooms[i]);
		}
		System.out.println("");
	}
	
	public void printAssistants() {
		for (int i = 0; i < assistants.length; i++) {
			System.out.println((i+11)+". "+assistants[i]);
		}
		System.out.println("");
	}
	
	// Constructor
	public University(Assistant[] assistants, Room[] rooms) {
		this.assistants = assistants;
		this.rooms = rooms;
	}
	
	// second constructor incase you want to change the name.
	public University(Assistant[] assistants, Room[] rooms, String name) {
		this.assistants = assistants;
		this.rooms = rooms;
		this.name = name;
	}
	
}
