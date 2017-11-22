package controller;

import java.util.Observer;

import model.Model;
import view.View;

public interface iController extends Observer, Runnable {
	View view=null;
	Model model=null;
	
	void piloterPeltier();
	void alerteHumidite();
	void alertePorteOuvrte();
	void changerConsigne();
	void setModel();
	void setView();
	
}
