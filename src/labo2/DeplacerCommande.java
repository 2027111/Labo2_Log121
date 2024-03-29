package labo2;

public class DeplacerCommande implements ICommand{

	public Perspective Target;
	public int deltaX = 0;
	public int deltaY = 0;
	public boolean newCommande = false;
	
	
	
	
	public DeplacerCommande(Perspective Target, int x, int y) {
		System.out.println(x + " " + y);
		this.Target = Target;
		deltaX = x;
		deltaY = y;
		newCommande = true;
	}
	
	
	
	@Override
	public void execute() {
		
		Target.Deplacer(deltaX, deltaY);
		if(newCommande) {
			GestionCommande.Singleton.ClearRetablie();
			newCommande = false;
		}
		GestionCommande.Singleton.ajouterCommandePasser(this);
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

		Target.Deplacer(-deltaX, -deltaY);
		GestionCommande.Singleton.ajouterCommandeAnnuler(this);
	}

}
