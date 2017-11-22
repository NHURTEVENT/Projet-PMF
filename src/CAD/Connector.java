package CAD;

import Model.Model;

public class Connector implements iCAD {

	private Model model;
	private float tempInt = 0;
	private float tempExt = 0;
	private float tauxHumi = 0;
	private int consigne = 0;

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
	public float getCurrentTempInt(String input) {
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

	@Override
	public float getCurrentTempExt(String input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getCurrentTempPeltier(String input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getCurrentTauxHumi(String input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCurrentConsigne(String input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void getCurrentInputStream() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateModel() {
		// TODO Auto-generated method stub
		
	}

}
