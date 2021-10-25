// The Module class:
public class Module {
	
	// 6 instance attributes
	private int year;
	private byte term;
	private ModuleDescriptor module;
	private StudentRecord[] records;
	private double finalAverageGrade = 0.0;
	private int numberOfRecords = 0;
	
	// Methods	
	
	// calculates finalAverageGrade by finding the sum of grades in the module and dividing by number og records
	public double setFinalAverageGrade() {
		double totalScore = 0.0;
		for (int i = 0; i < records.length; i++) {
				totalScore += records[i].getFinalScore();
		}
		return totalScore / records.length;
	}
	
	// adds record 
	public void addRecord(StudentRecord record) {
		numberOfRecords = records.length + 1;
		StudentRecord[] records2;
		records2 = new StudentRecord[numberOfRecords];
		for (int i = 0; i < records.length; i++) {
				records2[i] = records[i];
		}
		records2[numberOfRecords - 1] = record;
		records = new StudentRecord[numberOfRecords];
		records = records2;
		this.finalAverageGrade = setFinalAverageGrade();
	}
	
	// prints records (for testing)
	public void printRecords() {
		for (int i = 0; i < records.length; i++) {
				System.out.println(records[i]);
		}
	}
	
	// Getters	
	public double[]	getWeights() {
		return module.getContinuousAssignmentWeights();
	}
	
	public double getFinalAverageGrade() {
		return finalAverageGrade;
	}
	
	public int getYear() {
		return year;
	}
	
	public byte getTerm() {
		return term;
	}
	
	public ModuleDescriptor getModuleDescriptor() {
		return module;
	}
	
	// toString Method:
	public String toString(){
	  return "Module[year="+year+",term="+term+",ModuleDescriptor="+module+",finalAverageGrade="+finalAverageGrade+"]";
	}
	
	// Constructor
	public Module(int year, byte term, ModuleDescriptor module) {
	   this.year = year;
	   this.term = term;
	   this.module = module;
	   records = new StudentRecord[0];
  }
	
}
