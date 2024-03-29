package labo2;

import java.awt.Point;

public class Perspective extends SujetObserver{

	int cubeSize = 55;
    private Point position = new Point(0, 0);



	public Perspective() {
		// TODO Auto-generated constructor stub
		NotifierObservateurs();
	}

	public Perspective(Perspective perspective) {
		SetPosition(perspective.GetPosition());
		SetSize(perspective.GetSize());
		NotifierObservateurs();
		// TODO Auto-generated constructor stub
	}

	public void SetPosition(Point newPosition) {
		position.x = newPosition.x;
		position.y = newPosition.y;
		NotifierObservateurs();
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
		NotifierObservateurs();
	}

	public void Deplacer(int deltaX, int deltaY) {
		// TODO Auto-generated method stub
		Point newPosition = new Point(position.x + deltaX, position.y + deltaY);
		SetPosition(newPosition);
	}

	public void GiveCommande(ICommand commande) {
		// TODO Auto-generated method stub
		commande.execute();
		System.out.println("Executer Commande");
		
	}

	public void Zoomer(int zoomFactor) {
		// TODO Auto-generated method stub
		int newSize = cubeSize + zoomFactor;
		System.out.println(newSize);
		SetSize(newSize);
		
	}
    
    
    
    
    
    
    
    
    
    
    
}
