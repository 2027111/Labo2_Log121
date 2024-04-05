package labo2.PressePapier;

import java.awt.Point;

import labo2.Model.Perspective;

public class PressePapier {
	Point position = new Point(0, 0);
	Point size = new Point(0, 0);
	
	
	public static PressePapier pressePapier = null;
	
	public Point GetPressePosition() {
		return position;
	}
	public Point GetPresseSize() {
		return size;
	}

	public static void AddPress(Perspective perspective) {
		// TODO Auto-generated method stub
		pressePapier = new PressePapier();
		pressePapier.position = new Point(perspective.GetPosition());
		pressePapier.size = new Point(perspective.GetSize());
	}
}
