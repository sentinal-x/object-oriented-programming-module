public class University {

	// 3 instance attributes
	private ModuleDescriptor[] moduleDescriptors;
	private Student[] students;	
	private Module[] modules;

	//returns number of students in the university
	public int getTotalNumberStudents() {
		return students.length;
	}

	//returns student with the highest gpa
	public Student getBestStudent() {
		double highestGpa = 0.0;
		int bestStudent = 0;
		for (int i = 0; i < students.length; i++) {
			double score = students[i].getGpa();
			if (score > highestGpa) {
				highestGpa = score;
				bestStudent = i;
			}
		}
		return students[bestStudent];
	}

	//returns module with the highest average grade
	public Module getBestModule() {
		double highestScore = 0.0;
		int bestModule = 0;
		for (int i = 0; i < modules.length; i++) {
			double score = modules[i].getFinalAverageGrade();
			if (score > highestScore) {
				highestScore = score;
				bestModule = i;
			}
		}
		return modules[bestModule];
	}
	
	// for testing purposes
	public void printModuleDescriptors() {
		for (int i = 0; i < moduleDescriptors.length; i++) {
		System.out.println(moduleDescriptors[i]);
		}
	}
	
	// for testing purposes
	public void printStudents() {
		for (int i = 0; i < students.length; i++) {
		System.out.println(students[i]);
		}
	}
	
	// for testing purposes
	public void printModules() {
		for (int i = 0; i < modules.length; i++) {
		System.out.println(modules[i]);
		}
	}
	
	// adds student record to module and student
	public void addStudentRecord(Student student, Module module, double[] marks) {
		StudentRecord record;
		record = new StudentRecord(student, module, marks);
		student.addRecord(record);
		module.addRecord(record);
	}
	
	// adds all student records
	public void addRecords() {
		addStudentRecord(students[0], modules[0], new double[]{9,10,10,10});
		addStudentRecord(students[1], modules[0], new double[]{8,8,8,9});
		addStudentRecord(students[2], modules[0], new double[]{5,5,6,5});
		addStudentRecord(students[3], modules[0], new double[]{6,4,7,9});
		addStudentRecord(students[4], modules[0], new double[]{10,9,10,9});
		addStudentRecord(students[5], modules[1], new double[]{9,9});
		addStudentRecord(students[6], modules[1], new double[]{6,9});
		addStudentRecord(students[7], modules[1], new double[]{5,6});
		addStudentRecord(students[8], modules[1], new double[]{9,7});
		addStudentRecord(students[9], modules[1], new double[]{8,5});
		addStudentRecord(students[0], modules[2], new double[]{10,10,9.5,10});
		addStudentRecord(students[1], modules[2], new double[]{7,8.5,8.2,8});
		addStudentRecord(students[2], modules[2], new double[]{6.5,7.0,5.5,8.5});
		addStudentRecord(students[3], modules[2], new double[]{5.5,5,6.5,7});
		addStudentRecord(students[4], modules[2], new double[]{7,5,8,6});
		addStudentRecord(students[5], modules[3], new double[]{9,10,10,10});
		addStudentRecord(students[6], modules[3], new double[]{8,8,8,9});
		addStudentRecord(students[7], modules[3], new double[]{5,5,6,5});
		addStudentRecord(students[8], modules[3], new double[]{6,4,7,9});
		addStudentRecord(students[9], modules[3], new double[]{10,9,8,9});
		addStudentRecord(students[0], modules[4], new double[]{10,10,10});
		addStudentRecord(students[1], modules[4], new double[]{8,7.5,7.5});
		addStudentRecord(students[2], modules[4], new double[]{9,7,7});
		addStudentRecord(students[3], modules[4], new double[]{9,8,7});
		addStudentRecord(students[4], modules[4], new double[]{2,7,7});
		addStudentRecord(students[5], modules[4], new double[]{10,10,10});
		addStudentRecord(students[6], modules[4], new double[]{8,7.5,7.5});
		addStudentRecord(students[7], modules[4], new double[]{10,10,10});
		addStudentRecord(students[8], modules[4], new double[]{9,8,7});
		addStudentRecord(students[9], modules[4], new double[]{8,9,10});
		addStudentRecord(students[0], modules[5], new double[]{10,9,10});
		addStudentRecord(students[1], modules[5], new double[]{8.5,9,7.5});
		addStudentRecord(students[2], modules[5], new double[]{10,10,5.5});
		addStudentRecord(students[3], modules[5], new double[]{7,7,7});
		addStudentRecord(students[4], modules[5], new double[]{5,6,10});
		addStudentRecord(students[5], modules[6], new double[]{8,9,8});
		addStudentRecord(students[6], modules[6], new double[]{6.5,9,9.5});
		addStudentRecord(students[7], modules[6], new double[]{8.5,10,8.5});
		addStudentRecord(students[8], modules[6], new double[]{7.5,8,10});
		addStudentRecord(students[9], modules[6], new double[]{10,6,10});
	}
	
	// Constructor
	public University(ModuleDescriptor[] moduleDescriptors, Student[] students, Module[] modules) {
		this.moduleDescriptors = moduleDescriptors;
		this.students = students;
		this.modules = modules;
	}
	
	public static void main(String[] args) {
		//data from csv files
		ModuleDescriptor[] setModuleDescriptors;
		setModuleDescriptors = new ModuleDescriptor[6];
		setModuleDescriptors[0] = new ModuleDescriptor("Real World Mathematics",  "ECM0002", new double[]{0.1,0.3,0.6});
		setModuleDescriptors[1] = new ModuleDescriptor("Programming", "ECM1400", new double[]{0.25,0.25,0.25,0.25});
		setModuleDescriptors[2] = new ModuleDescriptor("Data Structures", "ECM1406", new double[]{0.25,0.25,0.5});
		setModuleDescriptors[3] = new ModuleDescriptor("Object-Oriented Programming", "ECM1410", new double[]{0.2,0.3,0.5});
		setModuleDescriptors[4] = new ModuleDescriptor("Information Systems", "BEM2027", new double[]{0.1,0.3,0.3,0.3});
		setModuleDescriptors[5] = new ModuleDescriptor("Thermal Physics", "PHY2023", new double[]{0.4,0.6});
		Student[] setStudents;	
		setStudents = new Student[10];
		setStudents[0] = new Student(1000, "Ana", 'F');
		setStudents[1] = new Student(1001, "Oliver", 'M');
		setStudents[2] = new Student(1002, "Mary", 'F');
		setStudents[3] = new Student(1003, "John", 'M');
		setStudents[4] = new Student(1004, "Noah", 'M');
		setStudents[5] = new Student(1005, "Chico", 'M');
		setStudents[6] = new Student(1006, "Maria", 'F');
		setStudents[7] = new Student(1007, "Mark", 'X');
		setStudents[8] = new Student(1008, "Lia", 'F');
		setStudents[9] = new Student(1009, "Rachel", 'F');
		Module[] setModules;
		setModules = new Module[7];
		setModules[0] = new Module(2019, (byte)1, setModuleDescriptors[1]);
		setModules[1] = new Module(2019, (byte)1, setModuleDescriptors[5]);
		setModules[2] = new Module(2019, (byte)2, setModuleDescriptors[4]);
		setModules[3] = new Module(2019, (byte)2, setModuleDescriptors[1]);
		setModules[4] = new Module(2020, (byte)1, setModuleDescriptors[2]);
		setModules[5] = new Module(2020, (byte)1, setModuleDescriptors[3]);
		setModules[6] = new Module(2020, (byte)2, setModuleDescriptors[0]);
		// create instance of university called uok (University of Knowledge)
		University uok;
		uok = new University(setModuleDescriptors, setStudents, setModules);
		uok.addRecords();
		
		//just for me to test data was entered correctly
		//uok.printModuleDescriptors();
		//uok.printStudents();
		//uok.printModules();
		
		//find best module
		System.out.println("The best module is: ");
		System.out.println();
		System.out.println(uok.getBestModule());
		System.out.println();
		
		//find number of students
		System.out.println("The number of students at the University are: ");
		System.out.println();
		System.out.println(uok.getTotalNumberStudents());
		System.out.println();
		
		//find best student
		System.out.println("The best of these students is: ");
		System.out.println();
		Student theBestStudent;
		theBestStudent = uok.getBestStudent();
		System.out.println(theBestStudent);
		System.out.println();
		theBestStudent.printTranscript();
		
		
	}
}
