package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import cad.iCAD;
import model.iModel;
import view.iView;

public class Controller implements iController , ActionListener{

	private iView view;
	private iModel model;
	private iCAD controller;

	public Controller(iView view, iModel model, iCAD controller) {
		this.view = view;
		this.model = model;
		this.controller = controller;
		//this.view.btnConfirmer.addActionListener(this);
	}

	// piloter le peltier
	public void piloterPeltier(){
		
	}
	
	// alerte humidit�
	public void alerteHumidite(){
		
	}
	
	// alerte porte ouverte
	public void alertePorteOuvrte(){
		
	}
	
	// changer consigne
	public void changerConsigne(){
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setModel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setView() {
		// TODO Auto-generated method stub
		
	}
}
