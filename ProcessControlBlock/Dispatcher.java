package asigProcess;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class Dispatcher  {

	//static int processId;

	// This is a FIFO queue
	static Queue<ProcessControlBlock> newQueue = new LinkedList<ProcessControlBlock>();

	// This is a double-ended FIFO queue
	static LinkedList<ProcessControlBlock> readyQueue = new LinkedList<ProcessControlBlock>();
	
	// queue de suspend
	static LinkedList<ProcessControlBlock> suspendQueue = new LinkedList<ProcessControlBlock>();
	// queue de activate
	static LinkedList<ProcessControlBlock> activateQueue = new LinkedList<ProcessControlBlock>();
	
	static ProcessControlBlock processRunning;

	// CREAR LINKEDLIST DE SUSPEND!!!
	
	// This is a FIFO queue
	static Queue<ProcessControlBlock> exitQueue = new LinkedList<ProcessControlBlock>();

	static LinkedList<ProcessControlBlock> blockedQueue = new LinkedList<ProcessControlBlock>();

	static Random random = new Random();

	public Dispatcher() {
		// Adding three processes to the end of the new queue
		// newQueue.add( dispatcher = new ProcessControlBlockJFrame(0, 0) );
		newQueue.add( new ProcessControlBlock(0xAA, 0) );
		newQueue.add( new ProcessControlBlock(0xBB, 0) );
		newQueue.add( new ProcessControlBlock(0xCC, 0) );
		newQueue.add( new ProcessControlBlock(0xCD, 0) );
		newQueue.add( new ProcessControlBlock(0xCE, 0) );
		newQueue.add( new ProcessControlBlock(0xCF, 0) );
	
		System.out.println("This is the new queue...");
		for (ProcessControlBlock process : newQueue){
			System.out.println(process);
		} // final del for
		System.out.println();

		int[] bloquesDeRAM = {5000, 8000, 12000, 15000, 20000, 21000 }; // Son los valores de program counter
		int bloquesDeRAMIndex = 0;

		// Moves the process from the new to the ready queue, uno por uno
		try {
			while( true ) {

				if( !newQueue.isEmpty() ) {
					admit( newQueue.remove(), bloquesDeRAM[ bloquesDeRAMIndex++] );
				} // if

				if( !readyQueue.isEmpty() ) {
					try {
						dispatch(readyQueue.remove()); // la echa a correr
						timeout( processRunning ); // la devuelve a Ready
					} catch (IOException e) {
						
						if (random.nextInt(8) == 0){
							release(processRunning);
						} else
						
						EventWait(processRunning);
						
					} // catch
				} // if

				if( random.nextInt(6) == 0
						&& !blockedQueue.isEmpty() ) {
					EventOccurs();
				} // Event occurs.
				
				if( random.nextInt(8) == 0
						&& !blockedQueue.isEmpty() ) { // random para suspender el proceso
					Suspend();
				} // Suspend.
				
				if( random.nextInt(4) == 0
						&& !suspendQueue.isEmpty() ) {
					Activate();
				} // Activate.
				
				
			} // final del while

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // final del catch
	}
	
	private void Suspend() throws Exception {		
		if( !blockedQueue.isEmpty() ) { // el que se saque es al azar
			ProcessControlBlock procesito;
			int index = random.nextInt(blockedQueue.size() );
			suspendQueue.add( procesito = blockedQueue.remove(index) );
			procesito.setProcessStatus(ProcessStatus.SUSPEND);
		} // if
		
	}
	
	
	private void Activate() throws Exception {		
		if( !suspendQueue.isEmpty() ) { // el que se saque es al azar
			ProcessControlBlock procesito;
			int index = random.nextInt(suspendQueue.size() );
			readyQueue.add( procesito = suspendQueue.remove(index) );
			procesito.setProcessStatus(ProcessStatus.READY);
		} // if
		
	}	

	private void EventOccurs() throws Exception {
		if( !blockedQueue.isEmpty() ) { // el que se saque es al azar
			ProcessControlBlock procesito;
			int index = random.nextInt(blockedQueue.size() );
			readyQueue.add( procesito = blockedQueue.remove(index) );
			procesito.setProcessStatus(ProcessStatus.READY);
		} // if
	}

	private void EventWait(ProcessControlBlock procesito) throws Exception {
		procesito.setProcessStatus(ProcessStatus.BLOCKED);
		blockedQueue.add( procesito);
		//processRunning2 = null;
	}

	private static void admit( ProcessControlBlock process, int programCounter ) throws Exception {
		// Moves the process from the new to the ready queue
		if( process.getStatus().equals( ProcessStatus.NEW ) ) {
			readyQueue.add( process );
			process.setProcessStatus( ProcessStatus.READY );
			process.setProgramCounter( programCounter );

			System.out.println();
			System.out.println("Admit: This is the Ready queue...");
			for (ProcessControlBlock dummy : readyQueue)
				System.out.println( dummy );

			System.out.println();
			System.out.println("Admit: This is the New queue...");
			for (ProcessControlBlock dummy : newQueue)
				System.out.println( dummy );

			System.out.println();
		}
		else {
			throw new Exception("Error en Admit con el proceso " + process.getPid() );
		} // else

	} // Admit()

	public static void release(ProcessControlBlock processRunning2) throws Exception {
		//processRunning2.setVisible(false); o cambiar el color
		processRunning2.setProcessStatus(ProcessStatus.EXIT);
		exitQueue.add(processRunning2);
		System.out.println("\nAdmit: This is the Exit queue...");
		for (ProcessControlBlock dummy : exitQueue) {
			System.out.println( dummy );
		} // for
	} // release

	private static void dispatch(ProcessControlBlock process) throws Exception { 
		if( process.getStatus() == ProcessStatus.READY ) {
			processRunning = process;
			processRunning.run();
			if( processRunning.getStatus().equals(ProcessStatus.EXIT ) ) 
				release(processRunning);
		} // if
		else
			throw new Exception("Error in dispatch: " + process.getPid() 
					+ "\n status is: " + process.getStatus() );
	} // dispatch


	private static void timeout(ProcessControlBlock procesito) throws Exception {
		procesito.setProcessStatus(ProcessStatus.READY);
		readyQueue.add(procesito);
	} // timeout

	public static void main(String[] args) {

		new Dispatcher();

	} // final del main

} // final de la class