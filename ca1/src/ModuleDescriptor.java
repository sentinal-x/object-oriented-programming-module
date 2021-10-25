// The ModuleDescriptor class:
public class ModuleDescriptor {
	
	// 3 instance attributes
	private String code;
	private String name;
	private double[] continuousAssignmentWeights;
	
	// Methods
	
	//checks that the weights of the assesments are valid
	public boolean checkWeights(double[] continuousAssignmentWeights) {
		double totalWeights = 0.0;
		for(int i = 0; i< continuousAssignmentWeights.length; i++){
			if (continuousAssignmentWeights[i] > 0.0) {
				// Check weights are not negative.
				totalWeights += continuousAssignmentWeights[i];
			}
		}
		if (totalWeights == 1.0) {
			// Check weights sum up to 1.
			return true;
		} else {
			return false;
		}
	}
	
	// turns weights into string for printing
	public String weightsToString() {
		String weightString = "[";
		for (int i = 0; i < continuousAssignmentWeights.length; i++) {
				weightString += continuousAssignmentWeights[i];
				if (i < (continuousAssignmentWeights.length - 1)) {
					weightString += ", ";
				}
		}
		weightString += "]";
		return weightString;
	}
	
	// toString Method:
	public String toString(){
	  return "ModuleDescriptor[code="+code+",name="+name+",CAWeights="+weightsToString()+"]";
	}
	
	// Getters	
	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public double[] getContinuousAssignmentWeights() {
		return continuousAssignmentWeights;
	}
	
	// Constructor
	public ModuleDescriptor(String name, String code, double[] continuousAssignmentWeights) {
		if (code != "") {
			// Check code isn't null.
			this.code = code;
		}
		if (name != "") {
			// Check name isn't null.
			this.name = name;
		}
		// check weights
		boolean weightsFine = checkWeights(continuousAssignmentWeights);
		if (weightsFine == true) {
			this.continuousAssignmentWeights = continuousAssignmentWeights;
			}
	}

}
