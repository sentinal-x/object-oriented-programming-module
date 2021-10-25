import java.util.Scanner;
import java.io.IOException;

public class BookingApp {
	
	// 2 instance attributes:
	private BookingSystem uokBS;
	public boolean quitter;
	
	
	// METHODS:
	
	public void menuUserInput(){
		boolean validInput;
		Scanner in = new Scanner(System.in);
		do {
			// main menu section (very cool) and very self explaitory. They enter number it do the thing it says next to it on the menu.
			printMainMenu();
			String inStr = in.next();
			validInput = true;
			switch(inStr){
			case "1":
				listBookableRooms();
				break;
			case "2":
				addBookableRoom();
				break;
			case "3":
				removeBookableRoom();
				break;
			case "4":
				listAssistantOnShifts();
				break;
			case "5":
				addAssistantOnShift();
				break;
			case "6":
				removeAssistantOnShift();
				break;
			case "7":
				listBookings();
				break;
			case "8":
				addBooking();
				break;
			case "9":
				removeBooking();
				break;
			case "10":
				concludeBooking();
				break;
			case "-1":
				this.quitter = true;
				break;
			default:
				System.out.println("Invalid input.");
				validInput = false;
			}
		} while (!validInput);
	}
	
	public static void clearScreen() {
		// i must confess i found this on stack overflow, it clears the console on Windows. If you are not using windows, I do not know if it will work, but I can assure you it works well on windows. :) 		
		try {
			if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
		System.out.flush();  
	} 
	
	private int convertStringToInt(String number) {
		//just a little string to int function cause I gor fed up of typing it out each time.
        return Integer.parseInt(number);
    }
	
	public void printMainMenu() {
		// main menu printer
		System.out.println((uokBS.getUniversity()).getName() + " - COVID test");
		System.out.println("");
		System.out.println("Manage Bookings");
		System.out.println("");
		System.out.println("Please, enter the number to select your option:");
		System.out.println("");
		System.out.println("To manage Bookable Rooms:");
		System.out.println("	1. List");
		System.out.println("	2. Add");
		System.out.println("	3. Remove");
		System.out.println("To manage Assistants on Shift:");
		System.out.println("	4. List");
		System.out.println("	5. Add");
		System.out.println("	6. Remove");
		System.out.println("To manage Bookings:");
		System.out.println("	7. List");
		System.out.println("	8. Add");
		System.out.println("	9. Remove");
		System.out.println("	10. Conclude");
		System.out.println("After selecting one the options above, you will be presented other screens.");
		System.out.println("If you press 0, you will be able to return to this main menu.");
		System.out.println("Press -1 (or ctrl+c) to quit this application.");
		System.out.println("");
		// wow very cool
	}
	
	public void listBookableRooms() {
		// 1.
		boolean validInput;
		Scanner in = new Scanner(System.in);
		do {
			System.out.println((uokBS.getUniversity()).getName() + " - COVID test");
			System.out.println("");
			for (int i = 0; i < uokBS.getRoomsLength(); i++) {
				System.out.println(i+11 +". "+ uokBS.getBookableRoom(i));
			}
			//prints all bookable rooms
			System.out.println("");
			System.out.println("0. Back to main menu.");
			System.out.println("-1. Quit application.");
			System.out.println("");
			String inStr = in.next(); // take input 
			validInput = true;
			switch(inStr){
			case "0":
				break;
			case "-1":
				this.quitter = true;
				break;
			default:
				System.out.println("Invalid input.");
				validInput = false;
			}
		} while (!validInput);
	}
	
	public void addBookableRoom() {
		// 2.
		boolean validInput;
		Scanner in = new Scanner(System.in);
		System.out.println((uokBS.getUniversity()).getName() + " - COVID test");
		System.out.println("");
		System.out.println("Adding bookable room");
		System.out.println("");
		(uokBS.getUniversity()).printRooms(); //prints all rooms in class university
		do {
			System.out.println("Please, enter one of the following:");
			System.out.println("");
			System.out.println("The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM),");
			System.out.println("separated by a white space.");
			System.out.println("0. Back to main menu.");
			System.out.println("-1. Quit application.");
			System.out.println("");
			String inStr = in.nextLine();
			validInput = true;
			try {
				switch(inStr){
				case "0":
					break;
				case "-1":
					this.quitter = true;
					break;
				default:
					String[] splitInput = inStr.split(" ");
					//split string into array at spaces
					int index = convertStringToInt(splitInput[0]);
					if (index > 10) {
						if (index < ((uokBS.getUniversity()).getRoomsLength() + 11)) {
							String timeSlot = ("" + splitInput[1] + " " + splitInput[2]);
							if (uokBS.checkTimeSlotValid(timeSlot) == true) {
								uokBS.createBookableRoom(timeSlot, (uokBS.getUniversity()).getRoom(index - 11));
								System.out.println("Bookable Room added successfully:");
								System.out.println(uokBS.getBookableRoom(uokBS.getRoomsLength()-1));
								validInput = false;
							} else {
								System.out.println("Invalid date / time.");
								validInput = false;
							}
						} else {
							System.out.println("Invalid input. Room index not found!");
							validInput = false;
						}
					} else {
						System.out.println("Invalid input. Room index not found!");
						validInput = false;
					}
				}
			}
			catch (Exception e) {
						System.out.println("Invalid input.");
						validInput = false;
					}
		} while (!validInput);
	}
	
	public void removeBookableRoom() {
		// 3.
		boolean validInput;
		Scanner in = new Scanner(System.in);
		System.out.println((uokBS.getUniversity()).getName() + " - COVID test");
			System.out.println("");
			for (int i = 0; i < uokBS.getRoomsLength(); i++) {
				if ((uokBS.getBookableRoom(i)).isEmpty() == true) {
					System.out.println(i+11 +". "+ uokBS.getBookableRoom(i));
				}
			} 
			System.out.println("Removing bookable room");
			System.out.println("");
		do {
			System.out.println("Please, enter one of the following:");
			System.out.println("");
			System.out.println("The sequential ID to select the bookable room to be removed.");
			System.out.println("0. Back to main menu.");
			System.out.println("-1. Quit application.");
			System.out.println("");
			String inStr = in.next(); //input
			validInput = true;
			try {
				switch(inStr){
				case "0":
					break;
				case "-1":
					this.quitter = true;
					break;
				default:
					int index = convertStringToInt(inStr);
					if (index > 10) {
						if (index < (uokBS.getRoomsLength() + 11)) {
							BookableRoom roomToDelete = uokBS.getBookableRoom(index-11);
							if (roomToDelete.isEmpty() == true) {
								//checks room is empty
								uokBS.deleteBookableRoom(roomToDelete);
								System.out.println("Bookable Room removed successfully:");
								System.out.println(roomToDelete);
								validInput = false;
							} else {
								System.out.println("Error!");
								System.out.println("Invalid input. Room not EMPTY!");
								validInput = false;
							}
						} else {
							System.out.println("Error!");
							System.out.println("Invalid input. Room index not found! The index should be < " + (uokBS.getRoomsLength() + 11) + ".");
							validInput = false;
						}
					} else {
						System.out.println("Error!");
						System.out.println("Invalid input. Room index not found! The index should be > 10.");
						validInput = false;
					}
				}
			}
			catch (Exception e) {
				System.out.println("Error!");
				System.out.println("Invalid input.");
				validInput = false;
			}
		} while (!validInput);
	}
	
	public void listAssistantOnShifts() {
		//4. 
		boolean validInput;
		Scanner in = new Scanner(System.in);
		do {
			System.out.println((uokBS.getUniversity()).getName() + " - COVID test");
			System.out.println("");
			for (int i = 0; i < uokBS.getAssistantsLength(); i++) {
				System.out.println(i+11 +". "+ uokBS.getAssistantOnShift(i));
				//print all AssistantOnShifts
			}
			System.out.println("");
			System.out.println("0. Back to main menu.");
			System.out.println("-1. Quit application.");
			System.out.println("");
			String inStr = in.next();
			validInput = true;
			switch(inStr){
			case "0":
				break;
			case "-1":
				this.quitter = true;
				break;
			default:
				System.out.println("Invalid input.");
				validInput = false;
			}
		} while (!validInput);
	}
	
	public void addAssistantOnShift() {
		//5.
		boolean validInput;
		Scanner in = new Scanner(System.in);
		System.out.println((uokBS.getUniversity()).getName() + " - COVID test");
		System.out.println("");
		System.out.println("Adding assistant on shift");
		System.out.println("");
		(uokBS.getUniversity()).printAssistants();
		do {
			System.out.println("Please, enter one of the following:");
			System.out.println("");
			System.out.println("The sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space.");
			System.out.println("0. Back to main menu.");
			System.out.println("-1. Quit application.");
			System.out.println("");
			String inStr = in.nextLine();
			validInput = true;
			try {
				switch(inStr){
				case "0":
					break;
				case "-1":
					this.quitter = true;
					break;
				default:
					String[] splitInput = inStr.split(" ");
					//split string into array at spaces
					int index = convertStringToInt(splitInput[0]);
					if (index > 10) {
						if (index < ((uokBS.getUniversity()).getAssistantsLength() + 11)) {
							String timeSlot = ("" + splitInput[1] + " 07:00");
							if (uokBS.checkTimeSlotValid(timeSlot) == true) {
								uokBS.createAssistantOnShift(timeSlot, (uokBS.getUniversity()).getAssistant(index - 11));
								System.out.println("Assistant on Shift added successfully:");
								System.out.println(uokBS.getAssistantOnShift(uokBS.getAssistantsLength()-1));
								timeSlot = ("" + splitInput[1] + " 08:00");
								uokBS.createAssistantOnShift(timeSlot, (uokBS.getUniversity()).getAssistant(index - 11));
								System.out.println("Assistant on Shift added successfully:");
								System.out.println(uokBS.getAssistantOnShift(uokBS.getAssistantsLength()-1));
								timeSlot = ("" + splitInput[1] + " 09:00");
								uokBS.createAssistantOnShift(timeSlot, (uokBS.getUniversity()).getAssistant(index - 11));
								System.out.println("Assistant on Shift added successfully:");
								System.out.println(uokBS.getAssistantOnShift(uokBS.getAssistantsLength()-1));
								validInput = false;
								// creates 3 Assistants (they work 3 shifts per date)
							} else {
								System.out.println("Invalid date / time.");
								validInput = false;
							}
						} else {
							System.out.println("Invalid input. Assistant index not found!");
							validInput = false;
						}
					} else {
						System.out.println("Invalid input. Assistant index not found!");
						validInput = false;
					}
				}
			}
			catch (Exception e) {
						System.out.println("Invalid input.");
						validInput = false;
					}
		} while (!validInput);
	}
	
	public void removeAssistantOnShift() {
		// 6.
		boolean validInput;
		Scanner in = new Scanner(System.in);
		System.out.println((uokBS.getUniversity()).getName() + " - COVID test");
			System.out.println("");
			for (int i = 0; i < uokBS.getAssistantsLength(); i++) {
				if ((uokBS.getAssistantOnShift(i)).isBusy() == false) {
					//prints all free assistants
					System.out.println(i+11 +". "+ uokBS.getAssistantOnShift(i));
				}
			} 
			System.out.println("Removing assistant on shift");
			System.out.println("");
		do {
			System.out.println("Please, enter one of the following:");
			System.out.println("");
			System.out.println("The sequential ID to select the assistant on shift to be removed.");
			System.out.println("0. Back to main menu.");
			System.out.println("-1. Quit application.");
			System.out.println("");
			String inStr = in.next();
			validInput = true;
			try {
				switch(inStr){
				case "0":
					break;
				case "-1":
					this.quitter = true;
					break;
				default:
					int index = convertStringToInt(inStr);
					if (index > 10) {
						if (index < (uokBS.getAssistantsLength() + 11)) {
							AssistantOnShift assistantToDelete = uokBS.getAssistantOnShift(index-11);
							if (assistantToDelete.isBusy() == false) {
								// check the AssistantOnShift is FREE
								uokBS.removeAssistantOnShift(assistantToDelete);
								System.out.println("Assistant on Shift removed successfully:");
								System.out.println(assistantToDelete);
								validInput = false;
							} else {
								System.out.println("Error!");
								System.out.println("Invalid input. AssistantOnShift not FREE!");
								validInput = false;
							}
						} else {
							System.out.println("Error!");
							System.out.println("Invalid input. AssistantOnShift index not found! The index should be < " + (uokBS.getAssistantsLength() + 11) + ".");
							validInput = false;
						}
					} else {
						System.out.println("Error!");
						System.out.println("Invalid input. AssistantOnShift index not found! The index should be > 10.");
						validInput = false;
					}
				}
			}
			catch (Exception e) {
				System.out.println("Error!");
				System.out.println("Invalid input.");
				validInput = false;
			}
		} while (!validInput);
	}
	
	public void listBookings() {
		// 7.
		boolean validInput = false;
		Scanner in = new Scanner(System.in);
		System.out.println((uokBS.getUniversity()).getName() + " - COVID test");
			System.out.println("");
			System.out.println("Select which booking to list:");
			System.out.println("1. All");
			System.out.println("2. Only bookings status:SCHEDULED");
			System.out.println("3. Only bookings status:COMPLETED");
			System.out.println("0. Back to main menu.");
			System.out.println("-1. Quit application.");
			String inStr = in.next(); // input
			System.out.println("");
			switch(inStr){
			case "2":
				for (int i = 0; i < uokBS.getBookingsLength(); i++) {
					if ((uokBS.getBooking(i)).isComplete() == false) {
						// ONLY SCHEDULED
						System.out.print((i+11) +". "+ uokBS.getBooking(i));
					}
				}
				validInput = false;
				break;
			case "3":
				for (int i = 0; i < uokBS.getBookingsLength(); i++) {
					if ((uokBS.getBooking(i)).isComplete() == true) {
						// ONLY COMPLETED
						System.out.print((i+11) +". "+ uokBS.getBooking(i));
					}
				}
				validInput = false;
				break;
			case "0":
				validInput = true;
				break;
			case "-1":
				this.quitter = true;
				validInput = true;
				break;
			default:
				for (int i = 0; i < uokBS.getBookingsLength(); i++) {
					System.out.print(i+11 +". "+ uokBS.getBooking(i));
					validInput = false;
					// ALL BOOKINGS
				}
				break;
			}
		if (validInput == false) { // if they haven't asked to leave
			do {
				System.out.println("");
				System.out.println("0. Back to main menu.");
				System.out.println("-1. Quit application.");
				System.out.println("");
				inStr = in.next();
				validInput = true;
				switch(inStr){
				case "0":
					break;
				case "-1":
					this.quitter = true;
					break;
				default:
					System.out.println("Invalid input.");
					validInput = false;
				}
			} while (!validInput);
		}
		
	}
	
	public void addBooking() {
		// 8.
		boolean validInput;
		Scanner in = new Scanner(System.in);
		System.out.println((uokBS.getUniversity()).getName() + " - COVID test");
		System.out.println("");
		System.out.println("Adding booking (appointment for a COVID test) to the system");
		do {
			System.out.println("");
			System.out.println("List of available time-slots:");
			uokBS.createBookingTimeSlots(); //create timeslots for bookings
			for (int i = 0; i < uokBS.getTSLength(); i++) {
				System.out.println(i+11 +". "+ uokBS.getTimeSlot(i)); //print time slots
			}
			System.out.println("Please, enter one of the following:");
			System.out.println("");
			System.out.println("The sequential ID of an available time-slot and the student email, separated by a white space.");
			System.out.println("0. Back to main menu.");
			System.out.println("-1. Quit application.");
			System.out.println("");
			String inStr = in.nextLine();
			validInput = true;
			try {
				switch(inStr){
				case "0":
					break;
				case "-1":
					this.quitter = true;
					break;
				default:
					String[] splitInput = inStr.split(" ");
					//split string into array at spaces
					int index = convertStringToInt(splitInput[0]);
					if (index > 10) {
						if (index < ((uokBS.getTSLength() + 11))) {
							String email = ("" + splitInput[1]);
							uokBS.createBooking(uokBS.getTimeSlot(index-11).getRoom(), uokBS.getTimeSlot(index-11).getAssistant(), email); //create booking
							System.out.println("Booking added successfully:");
							System.out.println(uokBS.getBooking(uokBS.getBookingsLength()-1)); // get from list
							validInput = false;
						} else {
							System.out.println("Invalid input. Room index not found!");
							validInput = false;
						}
					} else {
						System.out.println("Invalid input. Room index not found!");
						validInput = false;
					}
				}
			}
			catch (Exception e) {
						System.out.println("Invalid input.");
						validInput = false;
					}
		} while (!validInput);
	}
	
	public void removeBooking() {
		// 9.
		boolean validInput;
		Scanner in = new Scanner(System.in);
		System.out.println((uokBS.getUniversity()).getName() + " - COVID test");
			System.out.println("");
			for (int i = 0; i < uokBS.getBookingsLength(); i++) {
				if ((uokBS.getBooking(i)).getStatus() == "SCHEDULED") {
					System.out.println(i+11 +". "+ uokBS.getBooking(i)); //show all removeable bookings
				}
			} 
			System.out.println("Removing booking from the system");
			System.out.println("");
		do {
			System.out.println("Please, enter one of the following:");
			System.out.println("");
			System.out.println("The sequential ID to select the booking to be removed from the listed bookings above.");
			System.out.println("0. Back to main menu.");
			System.out.println("-1. Quit application.");
			System.out.println("");
			String inStr = in.next();
			validInput = true;
			try {
				switch(inStr){
				case "0":
					break;
				case "-1":
					this.quitter = true;
					break;
				default:
					int index = convertStringToInt(inStr);
					if (index > 10) {
						if (index < (uokBS.getBookingsLength() + 11)) {
							Booking bookingToDelete = uokBS.getBooking(index-11);
							if (bookingToDelete.getStatus() == "SCHEDULED") {
								uokBS.removeBooking(bookingToDelete); //delete
								System.out.println("Booking removed successfully:");
								System.out.println(bookingToDelete);
								validInput = false;
							} else {
								System.out.println("Error!");
								System.out.println("Invalid input. Booking is already COMPLETED!");
								validInput = false;
							}
						} else {
							System.out.println("Error!");
							System.out.println("Invalid input. Booking index not found! The index should be < " + (uokBS.getBookingsLength() + 11) + ".");
							validInput = false;
						}
					} else {
						System.out.println("Error!");
						System.out.println("Invalid input. Booking index not found! The index should be > 10.");
						validInput = false;
					}
				}
			}
			catch (Exception e) {
				System.out.println("Error!");
				System.out.println("Invalid input.");
				validInput = false;
			}
		} while (!validInput);
	}
	
	public void concludeBooking() {
		// 10.
		boolean validInput;
		Scanner in = new Scanner(System.in);
		System.out.println((uokBS.getUniversity()).getName() + " - COVID test");
			System.out.println("");
			for (int i = 0; i < uokBS.getBookingsLength(); i++) {
				if ((uokBS.getBooking(i)).getStatus() == "SCHEDULED") {
					//only not completed bookings
					System.out.println(i+11 +". "+ uokBS.getBooking(i));
				}
			} 
			System.out.println("Conclude booking");
			System.out.println("");
		do {
			System.out.println("Please, enter one of the following:");
			System.out.println("");
			System.out.println("The sequential ID to select the booking to be completed.");
			System.out.println("0. Back to main menu.");
			System.out.println("-1. Quit application.");
			System.out.println("");
			String inStr = in.next();
			validInput = true;
			try {
				switch(inStr){
				case "0":
					break;
				case "-1":
					this.quitter = true;
					break;
				default:
					int index = convertStringToInt(inStr);
					if (index > 10) {
						if (index < (uokBS.getBookingsLength() + 11)) {
							Booking bookingToComplete = uokBS.getBooking(index-11);
							if (bookingToComplete.getStatus() == "SCHEDULED") {
								uokBS.completeBooking(bookingToComplete); //similar to removeBooking()
								System.out.println("Booking completed successfully:");
								System.out.println(bookingToComplete);
								validInput = false;
							} else {
								System.out.println("Error!");
								System.out.println("Invalid input. Booking is already COMPLETED!");
								validInput = false;
							}
						} else {
							System.out.println("Error!");
							System.out.println("Invalid input. Booking index not found! The index should be < " + (uokBS.getBookingsLength() + 11) + ".");
							validInput = false;
						}
					} else {
						System.out.println("Error!");
						System.out.println("Invalid input. Booking index not found! The index should be > 10.");
						validInput = false;
					}
				}
			}
			catch (Exception e) {
				System.out.println("Error!");
				System.out.println("Invalid input.");
				validInput = false;
			}
		} while (!validInput);
	}
	
	// Constructor
	public BookingApp(BookingSystem uokBS) {
		this.uokBS = uokBS;
		this.quitter = false;
	}
	
	public static void main(String[] args) {
		// hardcoding initialization
		boolean quitter = false;
		
		Assistant[] setAssistants;
		setAssistants = new Assistant[12];
		setAssistants[0] = new Assistant("Dr John Doe",  "JD912@uok.ac.uk");
		setAssistants[1] = new Assistant("Mr Bob Bobson", "BB103@uok.ac.uk");
		setAssistants[2] = new Assistant("Miss Persona Reala", "PR753@uok.ac.uk");
		setAssistants[3] = new Assistant("Dr Percy McPersonface",  "PP816@uok.ac.uk");
		setAssistants[4] = new Assistant("Dr Reginald Body", "RB617@uok.ac.uk");
		setAssistants[5] = new Assistant("Mrs Agatha Harkness", "AH666@uok.ac.uk");
		setAssistants[6] = new Assistant("Mr Victor Blisk",  "VB348@uok.ac.uk");
		setAssistants[7] = new Assistant("Miss Emily Wattson", "EW900@uok.ac.uk");
		setAssistants[8] = new Assistant("Miss Hana Bacon", "HB517@uok.ac.uk");
		setAssistants[9] = new Assistant("Professor Bennyg Ames", "BA282@uok.ac.uk");
		setAssistants[10] = new Assistant("Dr Walter Black", "WB878@uok.ac.uk");
		setAssistants[11] = new Assistant("Mrs Lori Driver", "LD421@uok.ac.uk");
		
		Room[] setRooms;
		setRooms = new Room[3];
		setRooms[0] = new Room("IC215", 3);
		setRooms[1] = new Room("SH102", 1);
		setRooms[2] = new Room("HB108", 2);
		
		University uok = new University(setAssistants, setRooms);
		BookingSystem uokBS = new BookingSystem(uok);
		
		uokBS.createBookableRoom("25/02/2021 09:00", uok.getRoom(2));
		uokBS.createBookableRoom("26/02/2021 07:00", uok.getRoom(0));
		uokBS.createBookableRoom("26/02/2021 08:00", uok.getRoom(0));
		uokBS.createBookableRoom("26/02/2021 09:00", uok.getRoom(0));
		uokBS.createBookableRoom("26/02/2021 07:00", uok.getRoom(1));
		uokBS.createBookableRoom("26/02/2021 08:00", uok.getRoom(1));
		uokBS.createBookableRoom("26/02/2021 09:00", uok.getRoom(1));
		uokBS.createBookableRoom("26/02/2021 07:00", uok.getRoom(2));
		uokBS.createBookableRoom("26/02/2021 08:00", uok.getRoom(2));
		uokBS.createBookableRoom("26/02/2021 09:00", uok.getRoom(2));
		
		uokBS.createAssistantOnShift("25/02/2021 09:00", uok.getAssistant(0));
		uokBS.createAssistantOnShift("26/02/2021 07:00", uok.getAssistant(3));
		uokBS.createAssistantOnShift("26/02/2021 08:00", uok.getAssistant(3));
		uokBS.createAssistantOnShift("26/02/2021 09:00", uok.getAssistant(3));
		uokBS.createAssistantOnShift("26/02/2021 07:00", uok.getAssistant(5));
		uokBS.createAssistantOnShift("26/02/2021 08:00", uok.getAssistant(5));
		uokBS.createAssistantOnShift("26/02/2021 09:00", uok.getAssistant(5));
		uokBS.createAssistantOnShift("26/02/2021 07:00", uok.getAssistant(9));
		uokBS.createAssistantOnShift("26/02/2021 08:00", uok.getAssistant(9));
		uokBS.createAssistantOnShift("26/02/2021 09:00", uok.getAssistant(9));
		
		uokBS.createBooking(uokBS.getBookableRoom(0), uokBS.getAssistantOnShift(0), "SD420@uok.ac.uk");
		uokBS.createBooking(uokBS.getBookableRoom(1), uokBS.getAssistantOnShift(1), "HK433@uok.ac.uk");
		uokBS.createBooking(uokBS.getBookableRoom(5), uokBS.getAssistantOnShift(5), "SP782@uok.ac.uk");
		uokBS.createBooking(uokBS.getBookableRoom(9), uokBS.getAssistantOnShift(9), "LA205@uok.ac.uk");
		
		uokBS.completeBooking(uokBS.getBooking(0));
		
		//end of hardcoding
		
		BookingApp thisApp;
		thisApp = new BookingApp(uokBS);
		do {
			thisApp.clearScreen();
			thisApp.menuUserInput();
		} while (!thisApp.quitter);
	}
}