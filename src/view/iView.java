package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public interface iView {

	JLabel tempInt = null;
	JLabel tempExt = null;
	JLabel tempPeltier = null;
	JLabel tauxHumi = null;
	JTextField tempConsigne = null;
	JButton btnConfirmer = null;
	
	public void switchDoorIcon(int i);
	public void switchHumiIcon(int i);
	
}
