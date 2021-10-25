import java.util.ArrayList; // import the ArrayList class
public class BookingSystem {
	
	// The University has a list of assistants and a list of rooms.

	// 6 instance attributes
	private ArrayList<BookableRoom> rooms;
	private ArrayList<AssistantOnShift> assistants;
	private ArrayList<Booking> bookings;
	private ArrayList<TimeSlot> listTimeSlots;
	private int numberOfBookings;
	private University universityResources;
	
	public boolean checkTimeSlotValid(String timeSlot) {
		// check in format "dd/mm/yyyy HH:MM"
		boolean isValid = false;
		if (timeSlot.length() == 16) {
			// Check timeSlot isn't null and is correct length (16 chars).
			char timeSlotArray[] = timeSlot.toCharArray();
			String symbols = "" + timeSlotArray[2] + timeSlotArray[5] + timeSlotArray[10] + timeSlotArray[13];
			if (symbols.equals("// :") == true) {
				String year = "" + timeSlotArray[6] + timeSlotArray[7] + timeSlotArray[8] + timeSlotArray[9];
				String month = "" + timeSlotArray[3] + timeSlotArray[4];
				String day = "" + timeSlotArray[0] + timeSlotArray[1];
				String hour = "" + timeSlotArray[11] + timeSlotArray[12];
				String minute = "" + timeSlotArray[14] + timeSlotArray[15];
				boolean hourCorrect = false;
				//checks it is between 7 and 10 am
				if (hour.equals("07")) {
					hourCorrect = true;
				} else if (hour.equals("08")) {
					hourCorrect = true;
				} else if (hour.equals("09")) {
					hourCorrect = true;
				}
				if (hourCorrect == true) {
					int intMinute;
					try {
							intMinute = Integer.parseInt(minute);
						}
						catch (NumberFormatException e) {
							intMinute = -1;
						}
					if ((intMinute < 60) && (intMinute >= 0)) {
						// checks minutes are valid
						int intYear;
						try {
							intYear = Integer.parseInt(year);
						}
						catch (NumberFormatException e) {
							intYear = -1;
						}
						if (intYear > 2020) {
							// checks its atleast 2021
							int intDay;
							try {
								intDay = Integer.parseInt(day);
							}
							catch (NumberFormatException e) {
								intDay = -1;
							}
							if (month.equals("01")) {
								//JANUARY
								if ((intDay <= 31) && (intDay > 0)) {
									isValid = true;
								}
							} else if (month.equals("02")) {
								//FEBUARY
								if ((intDay <= 28) && (intDay > 0)) {
									isValid = true;
								} else if (intDay == 29) {
									if (intYear % 4 == 0) {
										isValid = true;
										// leap year cause i am very pedantic
									}
								}
							} else if (month.equals("03")) {
								//MARCH
								if ((intDay <= 31) && (intDay > 0)) {
									isValid = true;
								}
							} else if (month.equals("04")) {
								//APRIL
								if ((intDay <= 30) && (intDay > 0)) {
									isValid = true;
								}
							} else if (month.equals("05")) {
								//MAY (THE BEST MONTH CLEARLY SUPERIOR)
								if ((intDay <= 31) && (intDay > 0)) {
									isValid = true;
								}
							} else if (month.equals("06")) {
								//JUNE
								if ((intDay <= 30) && (intDay > 0)) {
									isValid = true;
								}
							} else if (month.equals("07")) {
								//JULY
								if ((intDay <= 31) && (intDay > 0)) {
									isValid = true;
								}
							} else if (month.equals("08")) {
								//AUSUST
								if ((intDay <= 31) && (intDay > 0)) {
									isValid = true;
								}
							} else if (month.equals("09")) {
								//SEPTEMBER
								if ((intDay <= 30) && (intDay > 0)) {
									isValid = true;
								}
							} else if (month.equals("10")) {
								//OCTOBER spoooookkyy
								if ((intDay <= 31) && (intDay > 0)) {
									isValid = true;
								}
							} else if (month.equals("11")) {
								//NOVEMBER
								if ((intDay <= 30) && (intDay > 0)) {
									isValid = true;
								}
							} else if (month.equals("12")) {
								//DECEMBER (also cool)
								if ((intDay <= 31) && (intDay > 0)) {
									isValid = true;
								}
							}
						}
					}
				}
			}
		}
		
		return isValid;
		// this is all very unnecessary but I am very thorough 
	}
	
	public void createBookingTimeSlots() {
		// a cool algorithm i came up with on the spot at 2am to create time slots for the booking,
		for (int i = 0; i < getRoomsLength(); i++) {
			if (getBookableRoom(i).isFull() == false) {
				String currentTimeSlot = getBookableRoom(i).getTimeSlot();
				boolean match = false;
				for (int j = 0; j < getTSLength(); j++) {
					if (currentTimeSlot == getTimeSlot(j).getTimeSlot()) {
						match = true;
					}
				}
				// checks if its already an option
				if (match == false) {
					int l = 0;
					for (int k = 0; k < getAssistantsLength(); k++) {
						if (getAssistantOnShift(k).isBusy() == false) {
							if (getAssistantOnShift(k).getTimeSlot() == currentTimeSlot) {
								// finds free assistant
								l = k;
								k = getAssistantsLength();
								break;
							}
						}
					}
					
					AssistantOnShift bookingAssistant = getAssistantOnShift(l);
					TimeSlot timeSlotToAdd;
					// make new timeslot object
					timeSlotToAdd = new TimeSlot(currentTimeSlot, getBookableRoom(i), bookingAssistant);
					listTimeSlots.add(timeSlotToAdd);
					// added to TimeSlot array list!!!!
				}
			}	
		}
	}
	
	// to create bookable room and assistant on shift 
	public void createBookableRoom(String timeSlot, Room room) {
		BookableRoom newBookableRoom;
		newBookableRoom = new BookableRoom(timeSlot, room);
		rooms.add(newBookableRoom);
	}
	
	public void createAssistantOnShift(String timeSlot, Assistant assistant) {
		AssistantOnShift newAssistantOnShift;
		newAssistantOnShift = new AssistantOnShift(timeSlot, assistant);
		assistants.add(newAssistantOnShift);
	}
	
	public void removeBookableRoom(BookableRoom room) {
		//completes booking in the room and removes if then needed to
		room.completeBooking();
		if (room.isEmpty() == true) {
			int index = rooms.indexOf(room);
			rooms.remove(index);
		}
	}
	
	public void deleteBookableRoom(BookableRoom room) {
		//like remove but far more extreme :O
		if (room.isEmpty() == true) {
			int index = rooms.indexOf(room);
			rooms.remove(index);
		}
	}
	
	public void removeAssistantOnShift(AssistantOnShift assistant) {
		int index = assistants.indexOf(assistant);
		assistants.remove(index);
		//removes AssistantOnShift from list (they did their shift etc)
	}
	
	public void removeBooking(Booking booking) {
		int index = bookings.indexOf(booking);
		bookings.remove(index);
		// removes non completed booking
	}
	
	public boolean createBooking(BookableRoom room, AssistantOnShift assistant, String email) {
		//creates a booking
		boolean created = false;
		if (assistant.isBusy() == false) {
			if (room.isFull() == false) {
				//checks it should make the booking
				assistant.isBooked(true);
				//updates assistant status
				room.addBooking();
				// updates room status
				Booking newBooking;
				// creates a new booking object
				newBooking = new Booking(room, assistant, email);
				bookings.add(newBooking);
				// adds to list of bookings
				created = true;
			} else {
				System.out.println("Cannot create booking, BookableRoom is full...");
			}
		} else {
			System.out.println("Cannot create booking, AssistantOnShift is busy...");
		}
		return created;
	}
	
	public void completeBooking(Booking booking) {
		//completes a booking
		booking.testCompleted();
		//sets booking as completed
		removeBookableRoom(booking.getBookableRoom());
		// removes a person from the room
		removeAssistantOnShift(booking.getAssistantOnShift());
		// removes assistantonshift
	}
	
	// Getters -
	// These are needed to return the values of the attributes as they are private...
	
	public BookableRoom getBookableRoom(int index) {
		return rooms.get(index);
	}
	
	public int getRoomsLength() {
		return rooms.size();
	}
	
	public AssistantOnShift getAssistantOnShift(int index) {
		return assistants.get(index);
	}
	
	public int getAssistantsLength() {
		return assistants.size();
	}
	
	public Booking getBooking(int index) {
		return bookings.get(index);
	}
	
	public int getBookingsLength() {
		return bookings.size();
	}
	
	public int getTSLength() {
		return listTimeSlots.size();
	}
	
	public TimeSlot getTimeSlot(int index) {
		return listTimeSlots.get(index);
	}
	
	public University getUniversity() {
		return universityResources;
	}
	
	// Constructor
	public BookingSystem(University university) {
		this.numberOfBookings = 0;
		this.universityResources = university;
		this.rooms = new ArrayList<BookableRoom>();
		this.assistants = new ArrayList<AssistantOnShift>();
		this.bookings = new ArrayList<Booking>();
		this.listTimeSlots = new ArrayList<TimeSlot>();
	}
	
}