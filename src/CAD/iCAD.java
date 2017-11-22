package CAD;

import Model.Model;

public interface iCAD extends Runnable {
	
	Model model=null;
	float tempInt = 0;
	float tempExt = 0;
	float tauxHumi = 0;
	int consigne = 0;
	
	//Lis la temp�rature int�rieure mesur�e
	public float getCurrentTempInt(String input);
	
	//Lis la temp�rature ext�rieure mesur�e
	public float getCurrentTempExt(String input);
	
	//Lis la temp�rature calcul�e du module Peltier
	public float getCurrentTempPeltier(String input);
	
	//Lis le taux d'humidit� mesur�
	public float getCurrentTauxHumi(String input);
	
	//Lis la consigne actuelle
	public int getCurrentConsigne(String input);
	
	//Lis la consigne dans le mod�le et la transmet � l'Arduino
	public void changerConsigne();
	
	//Lis les donn�es fournies par l'Arduino
	public void getCurrentInputStream();
	
	//set la variable locale avec le mod�le fournis
	public void setModel(Model model);
	
	public void updateModel();
}
