package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import model.iModel;
import view.iView;

public class Controller implements iController , ActionListener{

	private iView view;
	private iModel model;

	public Controller(iModel model, iView view) {
		this.view = view;
		this.model = model;
		this.view.btnConfirmer.addActionListener(this);
	}

	
	// Alerte humidité
	@Override
	public void alerteHumidite() {
		
		if(model.getTauxHumi() > 80) {
			
		}
		
	}
	
	// Alerte porte ouverte
	@Override
	public void alertePorteOuvrte() {
		
		
		
	}
	
	@Override
	public void update(Observable obs, Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setModel(iModel model) {
		this.model = model;
	}

	@Override
	public void setView(iView view) {
		this.view = view;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setConsigne() {
		// TODO Auto-generated method stub
		
	}
}
