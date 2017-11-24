package model;

import java.util.LinkedList;
import java.util.Observer;

public interface iModel {

	float tempInt = 0;
	float tempExt = 0;
	int tempConsigne = 0;
	float tauxHumi = 0;
	float tempPeltier = 0;
	float prevTemp =0;
	
	float getTempInt();
	void setTempInt(float tempInt);
	float getTempExt();
	void setTempExt(float tempExt);
	int getTempConsigne();
	void setTempConsigne(int tempConsigne);
	float getTauxHumi();
	void setTauxHumi(float tauxHumi);
	float getTempPeltier();
	void setTempPeltier(float tempPeltier);
	public LinkedList getTempTable();
	public void setTempTable(LinkedList tempTable);
	void setLog(String txt);
	void hasBeenChanged();
	void doAddObserver(Observer obs);
	int getConsigneVoulue();
	void setConsigneVoulue(int consigne);
	String getLog();
	float getPrevTemp();
	void setPrevTemp(float temp);
}