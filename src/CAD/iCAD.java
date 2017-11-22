package CAD;

import Model.Model;

public interface iCAD extends Runnable {
	
	Model model=null;
	float tempInt = 0;
	float tempExt = 0;
	float tauxHumi = 0;
	int consigne = 0;
	
	//Lis la température intérieure mesurée
	public float getCurrentTempInt(String input);
	
	//Lis la température extérieure mesurée
	public float getCurrentTempExt(String input);
	
	//Lis la température calculée du module Peltier
	public float getCurrentTempPeltier(String input);
	
	//Lis le taux d'humidité mesuré
	public float getCurrentTauxHumi(String input);
	
	//Lis la consigne actuelle
	public int getCurrentConsigne(String input);
	
	//Lis la consigne dans le modèle et la transmet à l'Arduino
	public void changerConsigne();
	
	//Lis les données fournies par l'Arduino
	public void getCurrentInputStream();
	
	//set la variable locale avec le modèle fournis
	public void setModel(Model model);
	
	public void updateModel();
}
