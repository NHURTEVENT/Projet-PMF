package CAD;

import Model.Model;

public class Connector implements iCAD {

	private Model model;

	public Connector(Model model) {
		setModel(model);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setModel(Model model) {
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

}
