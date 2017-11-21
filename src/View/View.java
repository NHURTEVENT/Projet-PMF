package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class View extends JFrame {

	private JPanel contentPane;
	JTextField tempConsigne;
	public JButton btnConfirmer;

	public void append(String s){
		this.tempConsigne.setText(this.tempConsigne.getText()+s);
	}
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
					connector = new Connector(this);
					connector.searchForPorts();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tempConsigne = new JTextField();
		tempConsigne.setBounds(127, 11, 86, 20);
		contentPane.add(tempConsigne);
		tempConsigne.setColumns(10);
		
		JButton btnConfirmer = new JButton("Confirmer");
		
		btnConfirmer.setBounds(245, 10, 89, 23);
		contentPane.add(btnConfirmer);
		
		JLabel tempInt = new JLabel("");
		tempInt.setBounds(167, 44, 46, 14);
		contentPane.add(tempInt);
		
		JLabel lblTempInt = new JLabel("Temp\u00E9rature interne");
		lblTempInt.setBounds(43, 42, 106, 14);
		contentPane.add(lblTempInt);
		
		JLabel lbltempExt = new JLabel("Temp\u00E9rature interne");
		lbltempExt.setBounds(43, 67, 106, 14);
		contentPane.add(lbltempExt);
		
		JLabel tempExt = new JLabel("");
		tempExt.setBounds(167, 67, 46, 14);
		contentPane.add(tempExt);
		
		JLabel lblTauxHumi = new JLabel("Taux d'humidit\u00E9");
		lblTauxHumi.setBounds(43, 92, 106, 14);
		contentPane.add(lblTauxHumi);
		
		JLabel TauxHumi = new JLabel("");
		TauxHumi.setBounds(167, 92, 46, 14);
		contentPane.add(TauxHumi);
		
		JLabel lblTempPeltier = new JLabel("Temp\u00E9rature du module Peltier");
		lblTempPeltier.setBounds(43, 117, 122, 14);
		contentPane.add(lblTempPeltier);
		
		JLabel tempPeltier = new JLabel("");
		tempPeltier.setBounds(177, 117, 46, 14);
		contentPane.add(tempPeltier);
		
		JLabel lblAlerteHumi = new JLabel("");
		lblAlerteHumi.setBounds(43, 175, 46, 14);
		contentPane.add(lblAlerteHumi);
		
		JLabel lblAlertePorte = new JLabel("");
		lblAlertePorte.setBounds(227, 175, 46, 14);
		contentPane.add(lblAlertePorte);
		
		JLabel lblConsigne = new JLabel("Consigne");
		lblConsigne.setBounds(43, 14, 46, 14);
		contentPane.add(lblConsigne);
	}
}
