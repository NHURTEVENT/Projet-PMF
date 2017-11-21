package Controler;

import Model.Model;
import View.View;

public interface iController {
	View view=null;
	Model model=null;
	
	void piloterPeltier();
	void alerteHumidite();
	void alertePorteOuvrte();
	void changerConsigne();
	
	
}
