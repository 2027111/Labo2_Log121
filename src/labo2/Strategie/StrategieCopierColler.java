package labo2.Strategie;

import labo2.Model.Perspective;
import labo2.PressePapier.PressePapier;

public interface StrategieCopierColler {
	
	public void Coller(Perspective Target);
	public PressePapier Copier(Perspective perspective);

}
