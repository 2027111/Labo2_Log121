package labo2.Strategie;

import java.awt.Point;

import labo2.Command.DeplacerCommande;
import labo2.Command.ZoomCommande;
import labo2.Model.Perspective;
import labo2.PressePapier.PressePapier;

public class StrategiePositionZoom implements StrategieCopierColler{

	
	@Override
	public PressePapier Copier(Perspective perspective) {
		
		
		PressePapier pressePapier = new PressePapier();

		pressePapier.SetPosition(new Point(perspective.GetPosition()));
		pressePapier.SetSize(new Point(perspective.GetSize()));
		return pressePapier;
		
	}

	@Override
	public void Coller(Perspective Target) {
		// TODO Auto-generated method stub

        ZoomCommande newZoomCommande = new ZoomCommande(Target, Target.GetDeltaSize(PressePapier.pressePapier.GetPresseSize().x));
        DeplacerCommande newMoveCommande = new DeplacerCommande(Target, Target.GetDeltaPosition(PressePapier.pressePapier.GetPressePosition()).x, Target.GetDeltaPosition(PressePapier.pressePapier.GetPressePosition()).y);
        newZoomCommande.SetCommande(newMoveCommande);
		Target.GiveCommande(newZoomCommande);
		
	}

}
