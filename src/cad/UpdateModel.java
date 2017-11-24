package cad;

public class UpdateModel implements Runnable{

	Connector connector;
	
	public UpdateModel(Connector connector){
		this.connector = connector;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			updateModel();
		}
	}
	
	public void updateModel() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connector.writeSerialPort("updt");
		
		//on affecte d�coupe la string re�ue 
		//et on affecte les variables locales re�ues
		connector.getCurrentTempInt();
		connector.getCurrentTempExt();
		connector.getCurrentTempPeltier();
		connector.getCurrentTauxHumi();
		connector.getCurrentConsigne();
		connector.getModel().setTempInt(connector.tempInt);
		connector.getModel().setTempExt(connector.tempExt);
		connector.getModel().setTempPeltier(connector.tempPeltier);
		connector.getModel().setTempConsigne(connector.consigne);
		connector.getModel().setTauxHumi(connector.tauxHumi);
		
		System.out.println("temp int: "+connector.getModel().getTempInt());
		System.out.println("temp ext: "+connector.getModel().getTempExt());
		System.out.println("temp peltier: "+connector.getModel().getTempPeltier());
		System.out.println("taux humi : "+connector.getModel().getTauxHumi());
		System.out.println("temp consigne: "+connector.getModel().getTempConsigne());
		connector.getModel().hasBeenChanged();
		
		
	}

}
