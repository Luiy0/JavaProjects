package Banker;

public class Banker {

	private int timePassed;
	private int[] originalMatrix;
	private int[] resourcesObtainedMatrix;
	private boolean allPossibleResourcesAssigned;
	private String processID;

	public Banker(String processID, int[] originalMatrix) {
		
		timePassed = 0;

		this.processID = processID;
		this.originalMatrix = originalMatrix;
		allPossibleResourcesAssigned = false;

		//Initialize the resourcesObtainedMatrix in zero completely.
		resourcesObtainedMatrix = new int[originalMatrix.length];
		
		for (int i = 0; i < resourcesObtainedMatrix.length; i++) 
			resourcesObtainedMatrix[i] = 0;
		
	}//final del constructor

	/**
	 * Gets the time that has passed since the process was admitted.
	 * @return The time the process has passed waiting.
	 */
	
	public int getTimePassed() {
		return timePassed;
	}//getTimePassed
	
	/**
	 * This method gets the original matrix.
	 * @return The original matrix of the resources asked for.
	 */
	public int[] getOriginalMatrix() {
		return originalMatrix;
	}//getOriginalMatrix
	
	/**
	 * This method returns the resources obtained matrix.
	 * @return The matrix of the resources assigned to the process.
	 */
	public int[] getResourcesObtainedMatrix() {
		return resourcesObtainedMatrix;
	}//getResourcesObtainedMatrix

	public boolean isAllPossibleResourcesAssigned() {
		return allPossibleResourcesAssigned;
	}//final de isAllPossibleResourceAssigned

	/**
	 * This method gets the name of the process.
	 * @return The name of the process.
	 */
	public String getProcessID() {
		return processID;
	}//final del getProcessID

	//Public methods

	/**
	 * This method adds one to the timePassed counter.
	 */
	public void addTime() {
		timePassed++;
	}//final del addTime

	/**
	 * This method resets the process's allPossibleResourcesAssigned variable
	 * so it can be assigned resources later on in another iteration.
	 */
	public void reset() {
		allPossibleResourcesAssigned = false;
	}//final del reset

	/**
	 * This method adds resources to the matrix. This implies that all
	 * possible resources have been assigned to this process.
	 * @param resources The resources that will be added to the matrix.
	 */
	public int[] addResources(int[] resources) {

		int[] newMatrix = resources;
		int[] temp = getDifferenceMatrix();

		for (int i = 0; i < resources.length; i++) {
			
			//Lower or equal than
			if(temp[i] <= resources[i]) { 
				
				resourcesObtainedMatrix[i] += temp[i]; 
				newMatrix[i] -= temp[i]; 
				
			}//final del if
			
			//Higher than
			else {	
				resourcesObtainedMatrix[i] += resources[i];
				newMatrix[i] -= resources[i];
				
			}//final del else	
			
		}//final del for
		
		this.allPossibleResourcesAssigned = true;
		return newMatrix;
		
	}//final de addResource

	/**
	 * This method gets how many resources are left to be assigned to the process.
	 * @return The resources left to be assigned to the matrix.
	 */
	public int[] getDifferenceMatrix() {
		
		int[] temp = new int[originalMatrix.length];
		
		for (int i = 0; i < temp.length; i++) 
			temp[i] = originalMatrix[i] - resourcesObtainedMatrix[i];
	
		return temp;
		
	}//final de getDifferenceMatrix

	public int[] returnResources(int[] resources) {
		
		int[] newMatrix = resources;

		for (int i = 0; i < resourcesObtainedMatrix.length; i++)
			newMatrix[i] += resourcesObtainedMatrix[i];

		return newMatrix;
		
	}//final del returnResource

	public boolean isFull() {
		
		int sum = 0, sum2 = 0;

		for (int i = 0; i < originalMatrix.length; i++) 
			sum += originalMatrix[i];

		for (int i = 0; i < resourcesObtainedMatrix.length; i++) 
			sum2 += resourcesObtainedMatrix[i];

		return (sum == sum2) ? true : false;
		
	}//final de isFull

	public boolean isZeroMatrix() {
		
		int sum = 0;
		
		for (int i = 0; i < originalMatrix.length; i++)
			sum += originalMatrix[i];

		if(sum == 0) {
			
			this.allPossibleResourcesAssigned = true;
			return true;
			
		}//final del if
		
		else
			return false;

	}//final de is zero matrix

	public String toString() {
		
		String information = "Process ID: " + processID + " ";

		information += "\nOriginal matrix: [" + originalMatrix[0];
		
		for (int i = 1; i < originalMatrix.length; i++) {
			information += ", " + originalMatrix[i];
			
		}//final del for
		
		information += "]";

		return information;
		
	}//finl del toString
	
}//final de la clase