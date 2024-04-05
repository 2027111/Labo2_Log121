package labo2.Command;

import labo2.Model.Perspective;

public class ZoomCommande extends CommandeDecoratrice{

	

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
		super.execute();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

		Target.Zoomer(-zoomFactor);
		super.undo();
	}

}
