package Model;

import java.util.Observable;

public class Model extends Observable {
	
	private float tempInt, tempExt, tempConsigne, tauxHumi, tempPeltier;

	public Model() {
	}

	public float getTempInt() {
		return tempInt;
	}

	public void setTempInt(float tempInt) {
		this.tempInt = tempInt;
	}

	public float getTempExt() {
		return tempExt;
	}

	public void setTempExt(float tempExt) {
		this.tempExt = tempExt;
	}

	public float getTempConsigne() {
		return tempConsigne;
	}

	public void setTempConsigne(float tempConsigne) {
		this.tempConsigne = tempConsigne;
	}

	public float getTauxHumi() {
		return tauxHumi;
	}

	public void setTauxHumi(float tauxHumi) {
		this.tauxHumi = tauxHumi;
	}

	public float getTempPeltier() {
		return tempPeltier;
	}

	public void setTempPeltier(float tempPeltier) {
		this.tempPeltier = tempPeltier;
	}
}
