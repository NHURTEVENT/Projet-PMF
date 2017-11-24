package main;


import cad.Connector;
import cad.iCAD;
import controller.Controller;
import model.Model;
import model.iModel;
import view.View;
import view.iView;


public class Main {

	public static void main(String[] args) {
		
		// Creation Model / View
		iModel model = new Model();
		iView view = new View();
		
		// Creation Controller
		iCAD connector = new Connector(model,view);
		Controller controller = new Controller(view, model, connector);
		Thread t1 = new Thread(controller);
		t1.start();
		
		// Creation CAD
		connector.connect(connector.searchForPorts());
		connector.run();
		view.makeVisible(true);
		
	}
	
}