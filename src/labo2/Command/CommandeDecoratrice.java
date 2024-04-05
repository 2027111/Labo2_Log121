package labo2.Command;

public class CommandeDecoratrice implements ICommand{

	ICommand commandeAjouter = null;

	public boolean newCommande;
	public boolean individual = true;
	
	public void SetCommande(ICommand commande) {
		
		commandeAjouter = commande;
		if(commandeAjouter.getClass() == CommandeDecoratrice.class) {

			((CommandeDecoratrice)(commandeAjouter)).individual = (false);
		}
	}
	
	public void SetNew(boolean isNew) {
		newCommande = isNew;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if(commandeAjouter != null) {
			commandeAjouter.execute();
		}
		if(individual) {
			GestionCommande.Singleton.ajouterCommandePasser(this);
		}
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

		if(commandeAjouter != null) {
			commandeAjouter.undo();
		}
		if(individual) {
			GestionCommande.Singleton.ajouterCommandeAnnuler(this);
		}
	}

}
