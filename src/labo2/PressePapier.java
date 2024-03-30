package labo2;

import java.awt.Point;

public class PressePapier {
	Point position = new Point(0, 0);
	Point size = new Point(0, 0);
	
	
	public static PressePapier pressePapier = null;


	public static void AddPress(Perspective perspective) {
		// TODO Auto-generated method stub
		pressePapier = new PressePapier();
		pressePapier.position = new Point(perspective.GetPosition());
		pressePapier.size = new Point(perspective.GetSize());
	}
}
