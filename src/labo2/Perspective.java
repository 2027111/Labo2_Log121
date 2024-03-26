package labo2;

import java.awt.Point;

public class Perspective {

	int cubeSize = 55;
    private Point position = new Point(0, 0);



	public Perspective() {
		// TODO Auto-generated constructor stub
	}

	public Perspective(Perspective perspective) {
		SetPosition(perspective.GetPosition());
		SetSize(perspective.GetSize());
		// TODO Auto-generated constructor stub
	}

	public void SetPosition(Point newPosition) {
		position.x = newPosition.x;
		position.y = newPosition.y;
	}
    
	public Point GetPosition() {
		// TODO Auto-generated method stub
		return new Point(position);
	}

	public int GetSize() {
		// TODO Auto-generated method stub
		return cubeSize;
	}
	
	
	
	
	public void SetSize(int newSize) {
		cubeSize = newSize;
	}
    
    
    
    
    
    
    
    
    
    
    
}
