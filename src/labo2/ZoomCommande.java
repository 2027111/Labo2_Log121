package labo2;

public class ZoomCommande implements ICommand{

	

	public Perspective Target;
	public int zoomFactor = 0;
	public boolean newCommande = false;
	
	public ZoomCommande(Perspective Target, int zoomFactor) {
		this.Target = Target;
		this.zoomFactor = zoomFactor;
		newCommande = true;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Target.Zoomer(zoomFactor);
		if(newCommande) {
			GestionCommande.Singleton.ClearRetablie();
			newCommande = false;
		}
		GestionCommande.Singleton.ajouterCommandePasser(this);
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

		Target.Zoomer(-zoomFactor);
		GestionCommande.Singleton.ajouterCommandeAnnuler(this);
	}

}
