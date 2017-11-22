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
		
		// Create Model
		iModel model = new Model();
		
		// Create View
		iView view = new View();
		
		// Create Controller
		iController ctrl = new Controller(model, view);
		SwingUtilities.invokeLater(ctrl);
		
		// Create CAD
		iCAD cad = new Connector(model);
		Thread t = new Thread(cad);
		t.start();
		
	}
	
}
