package controller;

import java.util.Observer;

import model.iModel;
import view.iView;

public interface iController extends Observer, Runnable {
	iView view=null;
	iModel model=null;
	
	void alerteHumidite();
	void alertePorteOuvrte();
	void setConsigne();
	void setModel(iModel model);
	void setView(iView view);
	
}
