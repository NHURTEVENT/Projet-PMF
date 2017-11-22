package cad;

import model.Model;
import model.iModel;

public interface iCAD extends Runnable {
	
	Model model=null;
	
	//Affecte au model la temp�rature int�rieure mesur�e
	public float currentTempInt();
	//Affecte au model la temp�rature ext�rieure mesur�e
	public float currentTempExt();
	//Affecte au model la temp�rature calcul�e du module Peltier
	public float currentTempPeltier();
	//Affecte au model le taux d'humidit� mesur�
	public float currentTauxHumi();
	//Lis la consigne dans le mod�le et la transmet � l'Arduino
	public void changerConsigne();
	//Lis les donn�es fournies par l'arduino
	public void getInputStream();
	//set la variable locale avec le mod�le fournis
	public void setModel(iModel model);
}
