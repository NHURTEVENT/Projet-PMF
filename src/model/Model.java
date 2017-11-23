package model;

import java.util.Observable;
import java.util.Observer;

public class Model extends Observable implements iModel {
	
	private float tempInt, tempExt, tempConsigne, tauxHumi, tempPeltier;
	private float[] tempTable;
	public String log;
	
	public Model() {
		tempInt = 0;
		tempExt = 0;
		tempConsigne =0;
		tauxHumi = 0;
		tempPeltier = 0;
	}

	public float[] getTempTable() {
		return tempTable;
	}

	public void setTempTable(float[] tempTable) {
		this.tempTable = tempTable;
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
	
	public void setLog(String txt){
		this.log = txt;
	}
	
	public void hasBeenChanged() {
		setChanged();
		this.notifyObservers();
	}
	
	public void doAddObserver(Observer obs){
		this.addObserver(obs);
	}
	
	public String getLog(){
		return this.log;
	}
}