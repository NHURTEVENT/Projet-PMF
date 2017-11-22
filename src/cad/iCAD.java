package cad;

import model.Model;
import model.iModel;

public interface iCAD extends Runnable {
	
	Model model=null;
	
	//Affecte au model la température intérieure mesurée
	public float currentTempInt();
	//Affecte au model la température extérieure mesurée
	public float currentTempExt();
	//Affecte au model la température calculée du module Peltier
	public float currentTempPeltier();
	//Affecte au model le taux d'humidité mesuré
	public float currentTauxHumi();
	//Lis la consigne dans le modèle et la transmet à l'Arduino
	public void changerConsigne();
	//Lis les données fournies par l'arduino
	public void getInputStream();
	//set la variable locale avec le modèle fournis
	public void setModel(iModel model);
}
