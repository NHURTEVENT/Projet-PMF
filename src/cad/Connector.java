package cad;

import model.Model;
import model.iModel;

public class Connector implements iCAD {

	private iModel model;

	public Connector(iModel model) {
		setModel(model);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setModel(iModel model) {
		this.model = model;
	}

	@Override
	public float currentTempInt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float currentTempExt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float currentTempPeltier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float currentTauxHumi() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void getInputStream() {
		// TODO r�cup les valeurs et les mettre dans les variables
	}

	@Override
	public void changerConsigne() {
		// TODO Auto-generated method stub
		// lis la consgine dans le model
	}

	@Override
	public String searchForPorts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void connect(String selectedPort) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readSerialPort() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setModel(Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateModel() {
		// TODO Auto-generated method stub
		
	}

}
