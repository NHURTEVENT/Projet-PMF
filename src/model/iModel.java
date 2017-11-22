package model;

public interface iModel {

	float tempInt = 0;
	float tempExt = 0;
	float tempConsigne = 0;
	float tauxHumi = 0;
	float tempPeltier = 0;
	
	float[] getTempInt();
	void setTempInt(float[] tempInt);
	float getTempExt();
	void setTempExt(float tempExt);
	float getTempConsigne();
	void setTempConsigne(float tempConsigne);
	float getTauxHumi();
	void setTauxHumi(float tauxHumi);
	float getTempPeltier();
	void setTempPeltier(float tempPeltier);
}
