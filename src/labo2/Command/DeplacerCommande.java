package labo2.Command;

import labo2.Model.Perspective;

public class DeplacerCommande extends CommandeDecoratrice{

	public Perspective Target;
	public int deltaX = 0;
	public int deltaY = 0;
	
	
	
	
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

		super.execute();
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

		Target.Deplacer(-deltaX, -deltaY);

		super.undo();
	}

}
