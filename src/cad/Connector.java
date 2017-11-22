package cad;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.StringTokenizer;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import model.iModel;

public class Connector implements iCAD {

	private iModel model;
	public SerialPort serialPort;
	private CommPortIdentifier selectedPortIdentifier;
	private Enumeration ports = null;
	float tempInt, tempExt, tempPeltier, tauxHumi;
	int consigne;
	public int tempext, txhumi;
	private String usedPort;
	// map the port names to CommPortIdentifiers
	private HashMap portMap = new HashMap();

	// the timeout value for connecting with the port
	final static int TIMEOUT = 2000;

	// ascii values for for certain things
	final static int SPACE_ASCII = 32;
	final static int DASH_ASCII = 45;
	final static int NEW_LINE_ASCII = 10;
	public String inputString = "0_0_0_0_0_;";

	public InputStream in;
	public OutputStream out;

	public Connector(iModel model) {
		setModel(model);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread reader = new Thread(new SerialReader(this));
		reader.start();
		
		while(true){
		updateModel();
		changerConsigne();
		}

	}

	@Override
	public String searchForPorts() {
		ports = CommPortIdentifier.getPortIdentifiers();

		while (ports.hasMoreElements()) {
			CommPortIdentifier curPort = (CommPortIdentifier) ports.nextElement();

			// get only serial ports
			if (curPort.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				portMap.put(curPort.getName(), curPort);
				return curPort.getName();
				/*
				 * window.cboxPorts.addItem(curPort.getName());
				 * portMap.put(curPort.getName(), curPort);
				 */
			}
		}
		// throw exception aucun port
		return null;
	}

	@Override
	public void connect(String selectedPort) {

		selectedPortIdentifier = (CommPortIdentifier) portMap.get(selectedPort);

		CommPort commPort = null;

		try {
			// the method below returns an object of type CommPort
			commPort = selectedPortIdentifier.open("TigerControlPanel", TIMEOUT);
			// the CommPort object can be casted to a SerialPort object
			serialPort = (SerialPort) commPort;
			
			in = serialPort.getInputStream();
			out = serialPort.getOutputStream();

			// CODE ON SETTING BAUD RATE ETC OMITTED
			// XBEE PAIR ASSUMED TO HAVE SAME SETTINGS ALREADY
		} catch (PortInUseException e) {
			model.setLog(selectedPort + " is in use. (" + e.toString() + ")");
		} catch (Exception e) {
			model.setLog("Failed to open " + selectedPort + "(" + e.toString() + ")");
		}
	}

	@Deprecated
	@Override
	public void readSerialPort() {
		byte[] buffer = new byte[1024];
		int len = -1;
		try {
			while ((len = this.in.read(buffer)) > -1) {
				inputString = new String(buffer, 0, len);
				System.out.println(inputString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeSerialPort(String data) {
		try {
			out.write(data.getBytes());
		} catch (IOException e) {
			System.out.print("error ");
			e.printStackTrace();
		}
	}

	@Override
	public void setModel(iModel model) {
		this.model = model;
	}

	@Override
	public void getCurrentTempInt() {
		StringTokenizer stok = new StringTokenizer(inputString, "_");
		String toConvert = stok.nextToken();
		this.tempInt = Float.parseFloat(toConvert);
	}

	@Override
	public void getCurrentTempExt() {
		StringTokenizer stok = new StringTokenizer(inputString, "_");
		stok.nextToken(); // on skip la temp�rature interne
		String toConvert = stok.nextToken();
		this.tempExt = Float.parseFloat(toConvert);
	}

	@Override
	public void getCurrentTempPeltier() {
		StringTokenizer stok = new StringTokenizer(inputString, "_");
		stok.nextToken(); // on skip la temp�rature interne
		stok.nextToken(); // on skip la temp�rature externe
		String toConvert = stok.nextToken();
		this.tempPeltier = Float.parseFloat(toConvert);
	}

	@Override
	public void getCurrentTauxHumi() {
		StringTokenizer stok = new StringTokenizer(inputString, "_");
		stok.nextToken(); // on skip la temp�rature interne
		stok.nextToken(); // on skip la temp�rature externe
		stok.nextToken(); // on skip la temp�rature du pletier
		String toConvert = stok.nextToken();
		this.tauxHumi = Float.parseFloat(toConvert);
	}

	@Override
	public void getCurrentConsigne() {
		StringTokenizer stok = new StringTokenizer(inputString, "_");
		stok.nextToken(); // on skip la temp�rature interne
		stok.nextToken(); // on skip la temp�rature externe
		stok.nextToken(); // on skip la temp�rature du pletier
		stok.nextToken(); // on skip le taux d'humidit�
		String toConvert = stok.nextToken();
		try {
			this.consigne = Integer.parseInt(toConvert);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void changerConsigne() {
		// TODO Auto-generated method stub
		// lis la consgine dans le model
		
		//check si le port est diponible
		//if (){
			writeSerialPort(Integer.toString(consigne));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}
		
	}

	@Override
	public void updateModel() {

		
		
		//on affecte d�coupe la string re�ue 
		//et on affecte les variables locales re�ues
		getCurrentTempInt();
		getCurrentTempExt();
		getCurrentTempPeltier();
		getCurrentTauxHumi();
		getCurrentConsigne();
		model.setTempInt(tempInt);
		model.setTempExt(tempExt);
		model.setTempPeltier(tempPeltier);
		model.setTempConsigne(consigne);
		model.setTauxHumi(tauxHumi);
		
		System.out.println("temp int: "+model.getTempInt());
		System.out.println("temp ext: "+model.getTempExt());
		System.out.println("temp peltier: "+model.getTempPeltier());
		System.out.println("taux humi : "+model.getTauxHumi());
		System.out.println("temp consigne: "+model.getTempConsigne());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
