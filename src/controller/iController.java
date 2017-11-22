package controller;

import java.util.Observer;

import model.iModel;
import view.iView;

public interface iController extends Observer{
	iView view=null;
	iModel model=null;
	
	void piloterPeltier();
	void alerteHumidite();
	void alertePorteOuvrte();
	void changerConsigne();
	void setModel();
	void setView();
	
}
