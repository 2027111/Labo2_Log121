package labo2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class SujetObserver{

	public ArrayList<Observateur> observateurActuels = new ArrayList<>();;
	public void AjouterObservateur(Observateur o) {
		observateurActuels.add(o);
	}
	
	public void RetirerObservateur(Observateur o) {
		observateurActuels.remove(o);
	}
	
	public void NotifierObservateurs() {
		for(Observateur o : observateurActuels) {
			o.actualiser();
		}
	}
	
	
	
}
