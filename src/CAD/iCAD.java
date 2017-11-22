package CAD;

import model.iModel;

public interface iCAD extends Runnable {
	
	iModel model=null;
	float tempInt = 0;
	float tempExt = 0;
	float tauxHumi = 0;
	int consigne = 0;
	
	//Lis la température intérieure mesurée
	public void getCurrentTempInt();
	
	//Lis la température extérieure mesurée
	public void getCurrentTempExt();
	
	//Lis la température calculée du module Peltier
	public void getCurrentTempPeltier();
	
	//Lis le taux d'humidité mesuré
	public void getCurrentTauxHumi();
	
	//Lis la consigne actuelle
	public void getCurrentConsigne();
	
	//Lis la consigne dans le modèle et la transmet à l'Arduino
	public void changerConsigne();
	
	//set la variable locale avec le modèle fournis
	public void setModel(iModel model);
	
	public void updateModel();
	
	public String searchForPorts();
	
	public void connect(String selectedPort);
	
	public void readSerialPort();
}
