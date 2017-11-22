package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;

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
		
		if(model.getTauxHumi() > 90)			
			view.switchHumiIcon(1);
		else	
			view.switchHumiIcon(0);
		
	}
	
	// Alerte porte ouverte
	@Override
	public void alertePorteOuvrte() {
		
		float[] tempTable = model.getTempTable();
		
		if(tempTable[10] - tempTable[0] > 10) {
			view.switchDoorIcon(1);
		} else {
			view.switchDoorIcon(0);
		}
		
	}
	
	@Override
	public void update(Observable obs, Object obj) {
		
		view.tempInt.setText(String.valueOf(model.getTempInt()));
		view.tempExt.setText(String.valueOf(model.getTempExt()));
		view.tauxHumi.setText(String.valueOf(model.getTauxHumi()));
		view.tempPeltier.setText(String.valueOf(model.getTempPeltier()));
		view.tempConsigne.setText(String.valueOf(model.getTempConsigne()));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() instanceof JButton)
			model.setTempConsigne(Float.parseFloat(view.tempConsigne.getText()));
		
	}

	@Override
	public void run() {
		
		while(true) {
			
			alerteHumidite();
			alertePorteOuvrte();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Getters & Setters
	
	@Override
	public void setModel(iModel model) {
		this.model = model;
	}

	@Override
	public void setView(iView view) {
		this.view = view;
	}
}
