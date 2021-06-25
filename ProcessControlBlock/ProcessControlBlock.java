package asigProcess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ProcessControlBlock extends JFrame{

	//private static int processId = 200;

	private int pid;
	private int ppid;
	private int programCounter = 0;
	private ProcessStatus status = ProcessStatus.NEW;
	private JLabel statusJLabel;
	private JLabel programCounterJLabel;
	private JPanel panelJPanel;

	private Random random = new Random();

	public ProcessControlBlock(int pid, int ppid ) {
		this.pid = pid;
		this.ppid = ppid;
		createVentana();
	} // final del constructor


	public void setProcessStatus( ProcessStatus status) throws Exception {

		switch (status) {
		case READY :
			if( this.status == ProcessStatus.NEW
			|| this.status == ProcessStatus.RUNNING
			|| this.status == ProcessStatus.BLOCKED
			|| this.status == ProcessStatus.SUSPEND)
				this.status = status;
			else
				throw new Exception( "Error setProcessStatus: " + status
						+ "\n process: " + this.pid
						+ "\n current status: " + this.status);
			break;

		case RUNNING :
			if( this.status == ProcessStatus.READY )
				this.status = status;
			else
				throw new Exception( "Error setProcessStatus: " + status);

			break;
	
		case SUSPEND :
			if(this.status == ProcessStatus.BLOCKED){
				this.status = status;
			}
			else
				throw new Exception("Error setProcessStatus: "+ status);			
			break;				

		case EXIT :
			panelJPanel.setBackground(Color.RED); //Para cambiar color de Exit
			
		case BLOCKED :
			if( this.status == ProcessStatus.RUNNING )
				this.status = status;
			else
				throw new Exception( "Error setProcessStatus: " + status);

			break;			
		default:
			throw new Exception( "Error setProcessStatus: " + status);
		}// switch {}

		statusJLabel.setText(this.status.name() );
	} // setProcessStatus()

	public int getPid() {
		return pid;
	}

	private void createVentana() {
		JFrame frameJFrame = new JFrame( String.valueOf( this.pid ) );
		frameJFrame.add( getPanel( this.pid ) );
		frameJFrame.setSize(200, 100); // frameJFrame.pack();
		frameJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameJFrame.setVisible(true);
	} // final de createVentana


	private Component getPanel(int pid2) {
		panelJPanel = new JPanel(new BorderLayout() );
		statusJLabel = new JLabel( this.status.name() );
		
		statusJLabel.setHorizontalTextPosition(JLabel.CENTER);

		programCounterJLabel = new JLabel( String.valueOf(this.programCounter) );
		programCounterJLabel.setHorizontalTextPosition(JLabel.CENTER);

		panelJPanel.add( statusJLabel, BorderLayout.NORTH );
		panelJPanel.add( programCounterJLabel,BorderLayout.CENTER );

		
		//	JButton closeJButton = new JButton("Close");
		//	closeJButton.addActionListener(new BotonListener() );		
		//	panelJPanel.add(closeJButton, BorderLayout.EAST);
		return panelJPanel;
	}


	public void run() throws Exception {

		this.status = ProcessStatus.RUNNING;
		statusJLabel.setText( this.status.name() );

		Color color = panelJPanel.getBackground();
		panelJPanel.setBackground(Color.YELLOW);
		
		
		// Thread.sleep( random.nextInt(2000) + 500 );
		Thread.sleep( 500 ); // random
		
		statusJLabel.setText( this.status.name() );

		this.programCounter += random.nextInt(20) + 1; // random

		programCounterJLabel.setText( String.format(getLocale(), "program counter: %d", this.programCounter));
		
		panelJPanel.setBackground(color);
		

		if(random.nextInt(4) == 0 ){ // me fui I/O SIMULACION de que el programa se va a blocked
			throw new IOException();
		}
	} // final de run()

	public ProcessStatus getStatus() {
		return this.status;
	} // final de getStatus()


	public void setProgramCounter(int pc) {
		this.programCounter = pc;
	}

	@Override
	public String toString() {
		return "ProcessControlBlock [pid=" + pid + ", ppid=" + ppid
				+ ", programCounter=" + programCounter + ", status=" + status
				+ ", statusJLabel=" + statusJLabel + ", programCounterJLabel="
				+ programCounterJLabel + ", panelJPanel=" + panelJPanel
				+ ", random=" + random + "]";
	}
}
