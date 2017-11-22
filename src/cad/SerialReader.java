package cad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TooManyListenersException;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class SerialReader implements Runnable {

	Connector connector;
	String fullInput = "";
	BufferedReader input;

	public SerialReader(Connector connector) {
		this.connector = connector;
		 input = new BufferedReader(new InputStreamReader(connector.in));
	}

	@Override
	public void run() {
		
/*		
		try {
			connector.serialPort.addEventListener(new SerialPortEventListener() {
				byte[] buffer = new byte[1024];
			    @Override
			    public void serialEvent(SerialPortEvent arg0) {
			        // TODO Auto-generated method stub
			        if(arg0.getEventType() == SerialPortEvent.DATA_AVAILABLE)
			        {
			            try {
			            	int len = -1;
			                while(input.ready()){
			                	while((len = connector.in.read(buffer)) > -1){
			                		String temp = (new String(buffer, 0, len));
			                		fullInput += temp;
			                		System.out.println("           "+temp);

			        				if (temp.contains(";")) {
			        					connector.inputString = fullInput;
			        					System.out.println("full input: "+fullInput);
			        					fullInput = "";
			        				}

			                	}
			                }
			            } catch (IOException e) {
			                // TODO Auto-generated catch block
			                e.printStackTrace();
			            }
			        }
			        
			    }
			});
		} catch (TooManyListenersException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        connector.serialPort.notifyOnDataAvailable(true);
*/		
        
        
        
        
        
		
		byte[] buffer = new byte[1024];
		int len = -1;
		try {
			while ((len = this.connector.in.read(buffer)) > -1) {
				String temp = (new String(buffer, 0, len));
				fullInput += temp;

				if (temp.contains(";")) {
					connector.inputString = fullInput;
					System.out.println("full input: "+fullInput);
					fullInput = "";
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
