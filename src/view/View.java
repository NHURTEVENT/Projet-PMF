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
	private final String PORTE_ICON = "C:\\Users\\Nico\\git\\Projet-PMF\\res\\OpenDoor_Icon.png";
	private final String HUMID_ICON = "C:\\Users\\Nico\\git\\Projet-PMF\\res\\Humidity_Icon.png";
	private final String EMPTY_ICON = "C:\\Users\\Nico\\git\\Projet-PMF\\res\\Empty_Icon.png";
	private JLabel lblConsigneActuelle;
	private JLabel consigneActuelle;
	private JScrollPane log;
	private JTextArea txtArea;
	
	// Chart Stuff
	private JFreeChart chartTemp;
	private JFreeChart chartHumi;
	private ChartPanel chartTempPanel;
	private ChartPanel chartHumiPanel;
	private DefaultCategoryDataset datasetTemp;
	private DefaultCategoryDataset datasetHumi;
	
	public void append(String s) {
		this.tempConsigne.setText(this.tempConsigne.getText()+s);
	}

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 2
		tempConsigne = new JTextField();
		tempConsigne.setBounds(150, 30, 86, 20);
		contentPane.add(tempConsigne);
		tempConsigne.setColumns(10);
		
		btnConfirmer = new JButton("Confirmer");
		
		txtArea = new JTextArea(300,800);

		log = new JScrollPane(txtArea);
		log.setBounds(10, 220, 375, 200);
		contentPane.add(log);
		
		// 3
		btnConfirmer.setBounds(250, 30, 95, 20);
		contentPane.add(btnConfirmer);
		
		tempInt = new JLabel("");
		tempInt.setBounds(200, 50, 50, 20);
		contentPane.add(tempInt);
		
		JLabel lblTempInt = new JLabel("Temp\u00E9rature interne");
		lblTempInt.setBounds(10, 50, 200, 20);
		contentPane.add(lblTempInt);
		
		JLabel lbltempExt = new JLabel("Temp\u00E9rature externe");
		lbltempExt.setBounds(10, 70, 200, 20);
		contentPane.add(lbltempExt);
		
		
		tempExt = new JLabel("");
		tempExt.setBounds(200, 70, 50, 20);
		contentPane.add(tempExt);
		
		JLabel lblTauxHumi = new JLabel("Taux d'humidit\u00E9");
		lblTauxHumi.setBounds(10, 90, 200, 20);
		contentPane.add(lblTauxHumi);
		
		tauxHumi = new JLabel("");
		tauxHumi.setBounds(200, 90, 50, 20);
		contentPane.add(tauxHumi);
		
		JLabel lblTempPeltier = new JLabel("Temp\u00E9rature Peltier");
		lblTempPeltier.setBounds(10, 110, 200, 20);
		contentPane.add(lblTempPeltier);
		
		tempPeltier = new JLabel("");
		tempPeltier.setBounds(200, 110, 50, 20);
		contentPane.add(tempPeltier);
		
		lblAlerteHumi = new JLabel("");
		lblAlerteHumi.setIcon(new ImageIcon(EMPTY_ICON));
		lblAlerteHumi.setBounds(84, 140, 64, 64);
		contentPane.add(lblAlerteHumi);
		
		lblAlertePorte = new JLabel("");
		lblAlertePorte.setIcon(new ImageIcon(EMPTY_ICON));
		lblAlertePorte.setBounds(10, 140, 64, 64);
		contentPane.add(lblAlertePorte);
		
		JLabel lblConsigne = new JLabel("Consigne");
		lblConsigne.setBounds(10, 30, 200, 20);
		contentPane.add(lblConsigne);
		
		lblConsigneActuelle = new JLabel("Consigne actuelle");
		lblConsigneActuelle.setBounds(10, 10, 200, 20);
		contentPane.add(lblConsigneActuelle);
		
		consigneActuelle = new JLabel("");
		consigneActuelle.setBounds(200, 10, 50, 20);
		contentPane.add(consigneActuelle);
		
		// Temperature Chart
		datasetTemp = new DefaultCategoryDataset();
		chartTemp = ChartFactory.createLineChart("", "Temps (Sec)", "Temperature (°C)", datasetTemp);
		
		chartTempPanel = new ChartPanel(chartTemp);
		chartTempPanel.setBounds(400,10,400,200);
		contentPane.add(chartTempPanel);
		
		// Humidity Cart
		datasetHumi = new DefaultCategoryDataset();
		chartHumi = ChartFactory.createLineChart("", "Temps (Sec)", "Humidité (%)", datasetHumi);
		
		chartHumiPanel = new ChartPanel(chartHumi);
		chartHumiPanel.setBounds(400,220,400,200);
		contentPane.add(chartHumiPanel);
		
		//TODO trouver comment suppr ça
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
	
	public DefaultCategoryDataset getDatasetTemp() {
		return datasetTemp;
	}
	
	public DefaultCategoryDataset getDatasetHumi() {
		return datasetHumi;
	}
	
}