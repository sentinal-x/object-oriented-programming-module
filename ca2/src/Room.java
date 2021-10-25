// The Room class:
public class Room{
	
	// The university has several rooms, and some of the rooms can be allocated to apply COVID tests.
	
	// 2 instance attributes:
	private String code;
	private int capacity;
	
	// Methods:
	
	// toString Method -
	public String toString(){
	  return "| "+code+" | capacity: "+capacity+" |";
	}
	
	// Setters -
	
	public void setCode(String code) {
		if (code != "") {
			// Check code isn't null.
			this.code = code;
		}
	}
	
	public void setCapacity(int maxCapacity) {
		if (maxCapacity > 0) {
			// Check capacity is greater than 0.
			this.capacity = maxCapacity;
		}
	}
	
	// Getters -
	// These are needed to return the values of the attributes as they are private...
	
	public String getCode() {
		return code;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	// Constructor:
	public Room(String code, int maxCapacity) {
		setCode(code);
		setCapacity(maxCapacity);
	}

}