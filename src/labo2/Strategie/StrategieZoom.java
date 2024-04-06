package labo2.Strategie;

import java.awt.Point;

import labo2.Command.DeplacerCommande;
import labo2.Command.ZoomCommande;
import labo2.Model.Perspective;
import labo2.PressePapier.PressePapier;

public class StrategieZoom implements StrategieCopierColler{

	
	@Override
	public PressePapier Copier(Perspective perspective) {
		
		
		PressePapier pressePapier = new PressePapier();

		pressePapier.SetSize(new Point(perspective.GetSize()));
		return null;
		
	}

	@Override
	public void Coller(Perspective Target) {
		// TODO Auto-generated method stub

        ZoomCommande newZoomCommande = new ZoomCommande(Target, Target.GetDeltaSize(PressePapier.pressePapier.GetPresseSize().x));
        
		Target.GiveCommande(newZoomCommande);
		
	}

}
