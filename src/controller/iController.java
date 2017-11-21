package controller;

import java.util.Observer;

import Model.Model;
import View.View;

public interface iController extends Observer{
	View view=null;
	Model model=null;
	
	void piloterPeltier();
	void alerteHumidite();
	void alertePorteOuvrte();
	void changerConsigne();
	void setModel();
	void setView();
	
}
