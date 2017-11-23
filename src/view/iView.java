package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jfree.data.category.DefaultCategoryDataset;

public interface iView {

	JLabel tempInt = null;
	JLabel tempExt = null;
	JLabel tempPeltier = null;
	JLabel tauxHumi = null;
	JTextField tempConsigne = null;
	JButton btnConfirmer = null;
	
	public void switchDoorIcon(int i);
	public void switchHumiIcon(int i);
	void makeVisible(Boolean isVisible);
	void setTempInt(String temp);
	void setTempExt(String temp);
	void setTauxHumi(String humi);
	void setTempPeltier(String temp);
	void setConsigne(String consigne);
	void setLog(String str);
	DefaultCategoryDataset getDataset();
	
	String getConsigne();
	JButton getButton();
	
}