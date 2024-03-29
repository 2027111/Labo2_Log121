package labo2;

import java.util.Stack;

public class GestionCommande {

	
	public Stack<ICommand> HistoriqueCommandePasser = new Stack();
	public Stack<ICommand> HistoriqueCommandeRetablie = new Stack();
	public static GestionCommande Singleton;
	
	public GestionCommande() {
		if(Singleton == null) {
			Singleton = this;
		}
	}
	
	public void ajouterCommandePasser(ICommand command){
		
		HistoriqueCommandePasser.add(command);
	}
	public void ajouterCommandeAnnuler(ICommand command){

		HistoriqueCommandeRetablie.add(command);
	}
	
	public void AnnulerCommande() {
		if(HistoriqueCommandePasser.capacity() > 0) {
		ICommand commande = HistoriqueCommandePasser.pop();
		commande.undo();
		}
	}
	
	
	public void RetablirCommande() {

		if(HistoriqueCommandeRetablie.capacity() > 0) {
		ICommand commande = HistoriqueCommandeRetablie.pop();
		commande.execute();
		}
	}

	public void ClearRetablie() {
		HistoriqueCommandeRetablie.clear();
		
	}
}
