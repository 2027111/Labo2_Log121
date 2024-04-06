package labo2.Strategie;

import java.awt.Point;

import labo2.Command.DeplacerCommande;
import labo2.Command.ZoomCommande;
import labo2.Model.Perspective;
import labo2.PressePapier.PressePapier;

public class StrategiePosition implements StrategieCopierColler{

	
	@Override
	public PressePapier Copier(Perspective perspective) {
		
		
		PressePapier pressePapier = new PressePapier();

		pressePapier.SetPosition(new Point(perspective.GetPosition()));
		return null;
		
	}

	@Override
	public void Coller(Perspective Target) {
		// TODO Auto-generated method stub

        DeplacerCommande newMoveCommande = new DeplacerCommande(Target, Target.GetDeltaPosition(PressePapier.pressePapier.GetPressePosition()).x, Target.GetDeltaPosition(PressePapier.pressePapier.GetPressePosition()).y);
		Target.GiveCommande(newMoveCommande);
		
	}

}
