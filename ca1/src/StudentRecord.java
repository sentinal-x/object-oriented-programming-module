// The StudentRecord class:
public class StudentRecord {
	
	// 5 instance attributes
	private Student student;
	private Module module;
	private double[] marks;
	private double finalScore;
	private Boolean isAboveAverage;
	
	// Methods
	
	// calculates finalScore by multiplying marks by weights
	public double calculateFinalScore() {
		double[] continuousAssignmentWeights;
		continuousAssignmentWeights = module.getWeights();
		for (int i = 0; i < continuousAssignmentWeights.length; i++) {
				finalScore += (continuousAssignmentWeights[i] * marks[i]);
		}
		return finalScore;
	}
	
	// calculates if final score is greater than the avarage for the class
	public boolean calculateifAboveAverage() {
		if (finalScore > module.getFinalAverageGrade()) {
			return true;
		} else {
			return false;
		}
	}
	
	// Getters
	public double getFinalScore() {
		return finalScore;
	}
	
	public boolean getIsAboveAverage() {
		return isAboveAverage;
	}
	
	public Module getModule() {
		return module;
	}
	
	// toString Method:
	public String toString(){
	  return "StudentRecord[student="+student+",module="+module+",finalScore="+finalScore+",isAboveAverage="+isAboveAverage+"]";
	}
	
	// Constructor
	public StudentRecord(Student student, Module module, double[] marks) {
		this.student = student;
		this.module = module;
		this.marks = marks;
		this.finalScore = calculateFinalScore();
		this.isAboveAverage = calculateifAboveAverage();
	}
	
}
