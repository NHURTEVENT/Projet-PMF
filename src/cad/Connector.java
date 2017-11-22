package cad;

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
		// TODO récup les valeurs et les mettre dans les variables
	}

	@Override
	public void changerConsigne() {
		// TODO Auto-generated method stub
		// lis la consgine dans le model
	}

}
