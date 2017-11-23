package view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class View extends JFrame implements iView {

	private JPanel contentPane;
	JTextField tempConsigne;
	
	public JButton btnConfirmer;
	public JLabel tempInt;
	public JLabel tempExt;
	public JLabel tauxHumi;
	public JLabel tempPeltier;
	public JLabel lblAlertePorte;
	public JLabel lblAlerteHumi;
	
	// TODO Write Paths
	private final String PORTE_ICON = "";
	private final String HUMID_ICON = "";
	private final String EMPTY_ICON = "";
	private JLabel lblConsigneActuelle;
	private JLabel consigneActuelle;
	private JScrollPane log;
	private JTextArea txtArea;
	
	// Chart Stuff
	private JFreeChart chart;
	private ChartPanel chartPanel;
	private DefaultCategoryDataset dataset;
	
	public void append(String s) {
		this.tempConsigne.setText(this.tempConsigne.getText()+s);
	}

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tempConsigne = new JTextField();
		tempConsigne.setBounds(127, 55, 86, 20);
		contentPane.add(tempConsigne);
		tempConsigne.setColumns(10);
		
		btnConfirmer = new JButton("Confirmer");
		
		txtArea = new JTextArea(300,800);

		log = new JScrollPane(txtArea);
		log.setBounds(10, 200, 300, 200);
		contentPane.add(log);
		
		
		btnConfirmer.setBounds(245, 54, 89, 23);
		contentPane.add(btnConfirmer);
		
		tempInt = new JLabel("");
		tempInt.setBounds(167, 88, 46, 14);
		contentPane.add(tempInt);
		
		JLabel lblTempInt = new JLabel("Temp\u00E9rature interne");
		lblTempInt.setBounds(43, 86, 106, 14);
		contentPane.add(lblTempInt);
		
		JLabel lbltempExt = new JLabel("Temp\u00E9rature interne");
		lbltempExt.setBounds(43, 111, 106, 14);
		contentPane.add(lbltempExt);
		
		
		tempExt = new JLabel("");
		tempExt.setBounds(167, 111, 46, 14);
		contentPane.add(tempExt);
		
		JLabel lblTauxHumi = new JLabel("Taux d'humidit\u00E9");
		lblTauxHumi.setBounds(43, 136, 106, 14);
		contentPane.add(lblTauxHumi);
		
		tauxHumi = new JLabel("");
		tauxHumi.setBounds(167, 136, 46, 14);
		contentPane.add(tauxHumi);
		
		JLabel lblTempPeltier = new JLabel("Temp\u00E9rature du module Peltier");
		lblTempPeltier.setBounds(43, 161, 122, 14);
		contentPane.add(lblTempPeltier);
		
		tempPeltier = new JLabel("");
		tempPeltier.setBounds(177, 161, 46, 14);
		contentPane.add(tempPeltier);
		
		lblAlerteHumi = new JLabel("");
		lblAlerteHumi.setIcon(new ImageIcon(EMPTY_ICON));
		lblAlerteHumi.setBounds(43, 175, 64, 64);
		contentPane.add(lblAlerteHumi);
		
		lblAlertePorte = new JLabel("");
		lblAlertePorte.setIcon(new ImageIcon(EMPTY_ICON));
		lblAlertePorte.setBounds(227, 175, 64, 64);
		contentPane.add(lblAlertePorte);
		
		JLabel lblConsigne = new JLabel("Consigne");
		lblConsigne.setBounds(43, 58, 46, 14);
		contentPane.add(lblConsigne);
		
		lblConsigneActuelle = new JLabel("Consigne actuelle");
		lblConsigneActuelle.setBounds(43, 26, 86, 14);
		contentPane.add(lblConsigneActuelle);
		
		consigneActuelle = new JLabel("");
		consigneActuelle.setBounds(154, 26, 46, 14);
		contentPane.add(consigneActuelle);
		
		dataset = new DefaultCategoryDataset();
		chart = ChartFactory.createLineChart("", "Temps (Sec)", "Temperature (�C)", dataset);
		
		chartPanel = new ChartPanel(chart);
		chartPanel.setBounds(400,10,800,400);
		//chartPanel.setPreferredSize(new Dimension(800, 400));
		contentPane.add(chartPanel);
		
		//TODO trouver comment suppr �a
		this.setVisible(true);
	}
	
	@Override
	public void switchDoorIcon(int i) {
		
		if(i == 0)	
			lblAlertePorte.setIcon(new ImageIcon(EMPTY_ICON));
		else
			lblAlertePorte.setIcon(new ImageIcon(PORTE_ICON));
		
	}
	
	@Override
	public void switchHumiIcon(int i) {
		
		if(i == 0)
			lblAlerteHumi.setIcon(new ImageIcon(EMPTY_ICON));
		else
			lblAlerteHumi.setIcon(new ImageIcon(HUMID_ICON));
		
	}

	@Override
	public void makeVisible(Boolean isVisible) {
		this.setVisible(isVisible);
	}
	@Override
	public void setTempInt(String temp) {
		this.tempInt.setText(temp);
	}

	@Override
	public void setTempExt(String temp) {
		this.tempExt.setText(temp);		
	}

	@Override
	public void setTauxHumi(String humi) {
		this.tauxHumi.setText(humi);		
	}

	@Override
	public void setTempPeltier(String temp) {
		this.tempPeltier.setText(temp);		
	}

	@Override
	public void setConsigne(String consigne) {
		this.consigneActuelle.setText(consigne);		
	}

	@Override
	public JButton getButton() {
		return this.btnConfirmer;
	}
	@Override
	public String getConsigne() {
		return this.tempConsigne.getText();
	}
	
	public void setLog(String txt){
		this.txtArea.setText(this.txtArea.getText()+"\n"+txt);
	}
	
	public DefaultCategoryDataset getDataset() {
		return dataset;
	}
	
}