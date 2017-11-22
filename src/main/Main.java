package main;

import javax.swing.SwingUtilities;

import cad.Connector;
import cad.iCAD;
import controller.Controller;
import controller.iController;
import model.Model;
import model.iModel;
import view.View;
import view.iView;


public class Main {

	public static void main(String[] args) {
		iModel model = new Model();
		iView view = new View();
		iCAD connector = new Connector(model);
		Controller controller = new Controller(view, model, connector);
		connector.connect(connector.searchForPorts());
		connector.run();
		
	}
	
}
