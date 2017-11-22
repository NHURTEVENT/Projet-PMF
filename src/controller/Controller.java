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
		
		if(model.getTauxHumi() > 90) {
			
			// Set icon 1 in view
			
			
		} else {
			
			// Set icon 2 in view
			
			
		}
		
	}
	
	// Alerte porte ouverte
	@Override
	public void alertePorteOuvrte() {
		
		float[] tempTable = model.getTempTable();
		
		// Si la temperature augmente de 10 degres entre la premiere et la derniere case du tableau
		if(tempTable[10] - tempTable[0] > 10) {
			
			// Set icon 1 in view
			
			
		} else {

			// Set icon 2 in view
			
			
		}
		
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
	public void run() {
		
		while(true) {
			
			// TODO
			
			// Update Values in view
			// Humidity Alert
			// Open Door Alert
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	// Getters & Setters
	@Override
	public void setConsigne() {
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
}
