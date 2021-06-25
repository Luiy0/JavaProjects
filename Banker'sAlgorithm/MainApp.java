package Banker;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class MainApp {

	static int[] originalResourceMatrix;
	static int[] resourceMatrix; 
	static LinkedList<Banker> admittedProcesses = new LinkedList<Banker>();
	static final int MAX_SIZE = 4;

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{

		//This is the amount of processes attended and the number of iterations.
		int iteraciones = 0;
		int processesAttended = 0;

		//Create File and Scanner object to read from the file.
		File infile = new File("File.txt");
		Scanner reader = new Scanner(infile);

		PrintWriter writer = new PrintWriter("Archive.txt");

		//Keep reading files while you can.
		if(reader.hasNext()) {

			//Convert the first line to an integer array.
			String[] temp = trimArray(reader.nextLine().split(","));

			originalResourceMatrix = convertToIntArray(temp);

			resourceMatrix = convertToIntArray(temp);

			//Create a String array.
			String[] array = new String[resourceMatrix.length + 1];

			do {

				System.out.println("Iteration : " + (iteraciones + 1) + "\n");

				writer.println("ITERACION#: " + (iteraciones + 1) + "\n\n");

				//Max out the queue
				while (reader.hasNext() && admittedProcesses.size() < MAX_SIZE) {

					//Input values and remove extra spaces to array.
					array = trimArray(reader.nextLine().split(","));

					int[] intArray = new int[resourceMatrix.length];

					//Input values to intArray.
					for (int i = 0; i < intArray.length; i++) 
						intArray[i] = Integer.valueOf(array[i + 1]);

					//Initialize the process.
					Banker process = new Banker(array[0], intArray);

					//Check that the process is valid.
					if (!isValidProcess(array)) {

						System.out.println("REJECTED:\n" +
								process + "\nNo resources available.\n");
						writer.println("REJECTED:\n" +
								process + "\nNo resources available.\n");
						continue;

					}//final del if

					admittedProcesses.add(process);
					System.out.println("ADMITTED:\n" +
							process + "\n");
					writer.println("ADMITTED:\n" +
							process + "\n");

				}//fin del while

				//This was added.
				if(!admittedProcesses.isEmpty()) {

					int counter = admittedProcesses.get(0).getTimePassed();
					int indexOfProcessWithLowestIOC = -1;

					//While I have processes to check.
					while(counter >= 0) {

						//Get the index of the process with lowest IOC and correct counter.
						do {

							indexOfProcessWithLowestIOC = getProcessWithLowestIOCAndCounter(admittedProcesses, counter);

							//If I find something, assign resources to it.
							if (indexOfProcessWithLowestIOC >= 0) 
								resourceMatrix = admittedProcesses.get(indexOfProcessWithLowestIOC).addResources(resourceMatrix);

						}while(indexOfProcessWithLowestIOC != -1);

						counter--;

					}//final del if

					//Remove any processes if possible.
					for (int i = 0; i < admittedProcesses.size(); ) {

						if (admittedProcesses.get(i).isFull()) {

							resourceMatrix = admittedProcesses.get(i).returnResources(resourceMatrix);
							System.out.println("RELEASED:\n" + admittedProcesses.get(i) + "\n");
							writer.println("RELEASED:\n" + admittedProcesses.get(i) + "\n");
							admittedProcesses.remove(i);
							processesAttended++;

						}//final del if

						else
							i++;

					}//final del for

					for (int i = 0; i < admittedProcesses.size(); i++) {

						admittedProcesses.get(i).addTime();
						admittedProcesses.get(i).reset();

					}//final del for interno

				}//final del for externo

				iteraciones++;

			}while (reader.hasNext() || admittedProcesses.isEmpty() == false);

			System.out.println("**There are no more processes**");
			reader.close();
			System.out.println("Released: " + processesAttended);
			System.out.println("Iteraciones: " + iteraciones);
			System.out.println("Average: " + ((double)processesAttended / iteraciones));
			writer.println("Released: " + processesAttended);
			writer.println("Iteraciones: " + iteraciones);
			writer.println("Average: " + ((double)processesAttended / iteraciones));
			writer.close();
		}
	}//final del main

	private static int getProcessWithLowestIOCAndCounter(LinkedList<Banker> admittedProcesses2, int counter) {

		//The process hasn't been found by default.
		int checkPoint = -1;

		//Find the first process with correct counter(time) and that it 
		//hasn't been already assigned resources.
		for (int i = 0; i < admittedProcesses2.size(); i++) {

			//Get the process, the time, and if it has been assigned resources.
			Banker process = admittedProcesses2.get(i);

			int processCount = process.getTimePassed();

			boolean allPossibleResourcesAssigned = process.isAllPossibleResourcesAssigned();
			if(processCount == counter && allPossibleResourcesAssigned == false) {
				checkPoint = i;
				break;
			}
		}

		//Check the checkpoint. If lower than zero (nothing found), return -1.
		if (checkPoint < 0) {
			return -1;
		}

		//Right now, checkpoint is process with lowest IOC.
		int indexOfProcessWithLowestIOC = checkPoint;

		//If the program goes into deadlock, change differenceMatrix to originalMatrix.
		double lowestIOC = getIndexOfCompromise(admittedProcesses2.get(checkPoint).getDifferenceMatrix());

		//Compare with the next process and so on.
		for (int i = checkPoint + 1; i < admittedProcesses2.size(); i++) {

			//Get the process, the time, the IOC, and if it has been assigned resources.
			Banker process = admittedProcesses2.get(i);

			int processCount = process.getTimePassed();

			double tempIOC = getIndexOfCompromise(process.getDifferenceMatrix());

			boolean allPossibleResourcesAssigned = process.isAllPossibleResourcesAssigned();

			//There is a big discriminant. As soon as the counter is different than what
			//we are looking, we're done.
			if (processCount != counter) {
				break;
			}

			//If the IOC of the process is lower and it hasn't been
			//assigned resources already, then this is the process with lowest IOC.
			else if(tempIOC < lowestIOC && allPossibleResourcesAssigned == false &&
					processCount == counter) {
				//System.out.println(tempIOC + " " + lowestIOC + " " + i);
				indexOfProcessWithLowestIOC = i;
			}
			//Repeat until I reach the end of the list.
		}

		return indexOfProcessWithLowestIOC;

	}//final del getProcessWithLowestIOC

	private static double getIndexOfCompromise(int[] array) {

		double number = 0;

		for (int i = 0; i < originalResourceMatrix.length; i++) {

			if (originalResourceMatrix[i] == 0) 
				continue;
			else
				number += (double) array[i] / originalResourceMatrix[i];

		}//final del for

		return number;

	}//final del getIndexofCompromise

	private static int[] convertToIntArray(String[] array) {

		int[] temp = new int[array.length];

		for (int i = 0; i < temp.length; i++)

			temp[i] = Integer.valueOf(array[i]);

		return temp;

	}//final de convertToIntArray

	private static String[] trimArray(String[] array) {

		for (int i = 0; i < array.length; i++)

			array[i] = array[i].trim();

		return array;

	}//final del trimArray

	private static boolean isValidProcess(String[] array) {

		for (int i = 1; i < array.length; i++) 

			if(Integer.valueOf(array[i]) > originalResourceMatrix[i - 1])

				return false;

		return true;

	}//final de isValidProcess

}//final de la class