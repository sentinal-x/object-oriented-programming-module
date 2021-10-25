// The Student class:
public class Student {
	
	// 6 instance attributes
	private int id;
	private String name;
	private char gender = ' ';
	private double gpa = 0.0;
	private StudentRecord[] records;
	private int numberOfModules = 0;
	
	
	// Methods
	
	// prints transcript using the format outlined within the requirements in section 1 of the CA
	public String printTranscript() {
		System.out.println("			University of Knowledge - Official Transcript");
		System.out.println("");
		System.out.println("");
		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("GPA: " + gpa);
		System.out.println("");
		for (int i = 0; i < records.length; i++) {
				System.out.println("| " +records[i].getModule().getYear()+" | "+records[i].getModule().getTerm()+" | "+records[i].getModule().getModuleDescriptor().getCode()+" | "+records[i].getFinalScore()+" |");
				if ((i+1) < records.length) {
					if (records[i].getModule().getTerm() < records[i+1].getModule().getTerm()) {
						System.out.println("");
					} else if (records[i].getModule().getYear() < records[i+1].getModule().getYear()) {
						System.out.println("");
					}
				}
		}
		return "";
	}
	
	// checks gender is one of the valid options to be inputted
	public void setGender(char gender) {
		if (gender == 'F') {
			this.gender = gender;
		} else if (gender == 'M') {
			this.gender = gender;
		} else if (gender == 'X') {
			this.gender = gender;
		}
	}
	
	// adds student record
	public void addRecord(StudentRecord record) {
		numberOfModules = records.length + 1;
		StudentRecord[] records2;
		records2 = new StudentRecord[numberOfModules];
		for (int i = 0; i < records.length; i++) {
				records2[i] = records[i];
		}
		records2[numberOfModules - 1] = record;
		records = new StudentRecord[numberOfModules];
		records = records2;
		calculateGpa();
	}
	
	// prints records (for testing)
	public void printRecords() {
		for (int i = 0; i < records.length; i++) {
				System.out.println(records[i]);
		}
	}
	
	// calculates gpa by finding the average grade
	public void calculateGpa() {
		double totalScore = 0.0;
		for (int i = 0; i < records.length; i++) {
				totalScore += records[i].getFinalScore();
		}
		this.gpa = totalScore / records.length;
	}
	
	
	// Getters
	public double getGpa() {
		return gpa;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	// toString Method:
	public String toString(){
	  return "Student[id="+id+",name="+name+",gender="+gender+",gpa="+gpa+"]";
	}
	
	// Constructor
	public Student(int id, String name, char gender) {
		this.id = id;
		this.name = name;
		setGender(gender);
		records = new StudentRecord[0];
	}
}
