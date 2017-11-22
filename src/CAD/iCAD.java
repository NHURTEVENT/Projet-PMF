package CAD;

import model.iModel;

public interface iCAD extends Runnable {
	
	iModel model=null;
	float tempInt = 0;
	float tempExt = 0;
	float tauxHumi = 0;
	int consigne = 0;
	
	//Lis la temp�rature int�rieure mesur�e
	public void getCurrentTempInt();
	
	//Lis la temp�rature ext�rieure mesur�e
	public void getCurrentTempExt();
	
	//Lis la temp�rature calcul�e du module Peltier
	public void getCurrentTempPeltier();
	
	//Lis le taux d'humidit� mesur�
	public void getCurrentTauxHumi();
	
	//Lis la consigne actuelle
	public void getCurrentConsigne();
	
	//Lis la consigne dans le mod�le et la transmet � l'Arduino
	public void changerConsigne();
	
	//set la variable locale avec le mod�le fournis
	public void setModel(iModel model);
	
	public void updateModel();
	
	public String searchForPorts();
	
	public void connect(String selectedPort);
	
	public void readSerialPort();
}
