package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;

import javax.swing.JButton;

import cad.iCAD;
import model.Model;
import model.iModel;
import view.iView;

public class Controller implements iController, ActionListener {

	private iView view;
	private iModel model;
	private iCAD connector;
	
	private SimpleDateFormat sdf;

	public Controller(iView view, iModel model, iCAD connector) {
		this.view = view;
		this.model = model;
		this.connector = connector;
		
		sdf = new SimpleDateFormat("HH:mm:ss");
		
		this.view.getButton().addActionListener(this);
		model.doAddObserver(this);
	}

	// Alerte humidité
	@Override
	public void alerteHumidite() {

		if (model.getTauxHumi() > 90)
			view.switchHumiIcon(1);
		else
			view.switchHumiIcon(0);

	}

	// Alerte porte ouverte
	@Override
	public void alertePorteOuvrte() {

		float[] tempTable = model.getTempTable();

		if (tempTable[10] - tempTable[0] > 10) {
			view.switchDoorIcon(1);
		} else {
			view.switchDoorIcon(0);
		}

	}

	@Override
	public void update(Observable obs, Object obj) {

		String tempint = String.valueOf(model.getTempInt());
		view.setTempInt(tempint);
		view.setTempExt(String.valueOf(model.getTempExt()));
		view.setTauxHumi(String.valueOf(model.getTauxHumi()));
		view.setTempPeltier(String.valueOf(model.getTempPeltier()));
		view.setConsigne(String.valueOf(model.getTempConsigne()));

		updateGraph();
		
	}

	@Override
	public void updateGraph() {
		
		this.view.getDataset().addValue(model.getTempInt(), "Temperature Interieure", sdf.format(new Date()));
		this.view.getDataset().addValue(model.getTempInt(), "Temperature Exterieure", sdf.format(new Date()));
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton)
			try {
				if (Integer.valueOf(view.getConsigne()) > -12.0 && Integer.valueOf(view.getConsigne()) < 30.0) {
					model.setTempConsigne(Integer.valueOf(view.getConsigne()));
					connector.changerConsigne();
				} else {
					setLog(" Merci d'entrer un entier entre -12 et 30 °C");
				}
			} catch (Exception e1) {
				setLog(" Erreur le nombre rentré n'est pas un entier");
				setLog(e1.getMessage());
			}

	}

	@Override
	public void run() {

		while (true) {

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
	
	public void setLog(String str){
		model.setLog(str);
		view.setLog(str);
		System.out.println("heyyyyyyyyyyyyyyyyyyyyy " + str);
	}
}