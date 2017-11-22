package CAD;

import java.io.IOException;

public class SerialReader implements Runnable {

	Connector connector;
	String fullInput = "";

	public SerialReader(Connector connector) {
		this.connector = connector;
	}

	@Override
	public void run() {
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
