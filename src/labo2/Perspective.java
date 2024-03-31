package labo2;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Perspective extends SujetObserver{

	
	private Point panelDimensions = new Point(400, 800);
	private Point size = new Point(55, 55);
    private Point position = new Point(0, 0);
    BufferedImage currentImage;

    public void SetPanelDimensions(int x, int y) {
    	panelDimensions = new Point(x, y);
    }
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
	}
    
	public Point GetPosition() {
		// TODO Auto-generated method stub
		return new Point(position);
	}

	public Point GetSize() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public void FixPosition() {
	    Point newPosition = GetPosition();
	    
	    // Calculate the bounds for clamping based on the image and panel sizes.
	    int maxX = Math.max(panelDimensions.x - GetSize().x, 0);
	    int minX = Math.min(0, panelDimensions.x - GetSize().x);
	    
	    int maxY = Math.max(panelDimensions.y - GetSize().y, 0);
	    int minY = Math.min(0, panelDimensions.y - GetSize().y);
	    
	    // Clamp the new position within the calculated bounds.
	    newPosition.x = Clamp.clamp(GetPosition().x, minX, maxX);
	    newPosition.y = Clamp.clamp(GetPosition().y, minY, maxY);
	    
	    SetPosition(newPosition);
	    NotifierObservateurs();
	}

	
	
	public void SetSize(Point newSize) {
		size.x= newSize.x;
		size.y = newSize.y;
		FixPosition();
	}

	public void Deplacer(int deltaX, int deltaY) {
		// TODO Auto-generated method stub
		Point newPosition = new Point(position.x + deltaX, position.y + deltaY);
		SetPosition(newPosition);
		FixPosition();
	}

	public void GiveCommande(ICommand commande) {
		// TODO Auto-generated method stub
		commande.execute();
		
	}

	public void Zoomer(int zoomFactor) {
		// TODO Auto-generated method stub
		int newSizeX = size.x + (zoomFactor);
		int newSizeY = (int)(((float)size.y/(float)size.x) * newSizeX);
		
		if(newSizeY < panelDimensions.y) {
			newSizeY = panelDimensions.y;
			newSizeX = (int)(((float)currentImage.getWidth() / (float)currentImage.getHeight()) * newSizeY);
		}
		System.out.println(newSizeX);
		
		SetSize(new Point(newSizeX, newSizeY));
		
	}

	public void SetImage(BufferedImage image) {
	    currentImage = image;
	    // Ensure the panel's dimensions are considered in case they haven't been set elsewhere
	    if (panelDimensions != null && currentImage != null) {
	        // Maintain aspect ratio of the image based on the panel's height.
	        size.y = panelDimensions.y;
	        // Calculate the width of the image such that the aspect ratio is maintained.
	        size.x = (int)(((float)currentImage.getWidth() / (float)currentImage.getHeight()) * size.y);
	        
	      
	        FixPosition();
	    } else {
	        // Handle the case where panelDimensions or currentImage is null.
	        System.out.println("Panel dimensions or image is null.");
	    }
	}
	public void SetAlikeTo(PressePapier pressePapier) {
		// TODO Auto-generated method stub
		Deplacer(pressePapier.position.x - position.x, pressePapier.position.y - position.y);
		Zoomer(pressePapier.size.y - size.y);
	}
	
	
	
	public void SetAsThumbnail(int yPos, int xSize) {
		// TODO Auto-generated method stub
		int ySize = (int)(((float)size.y/(float)size.x)*xSize);
		yPos -= (ySize/2);
		SetPosition(new Point(0, yPos));
		SetSize(new Point(xSize, ySize));
	}

    
    
    
    
    
    
    
    
    
    
}
