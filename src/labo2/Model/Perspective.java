package labo2.Model;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import labo2.Command.ICommand;
import labo2.Observateur.SujetObserver;
import labo2.PressePapier.PressePapier;
import labo2.Utils.Clamp;

public class Perspective extends SujetObserver  implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Point panelDimensions = new Point(400, 800);
	private Point size = new Point(55, 55);
    private Point position = new Point(0, 0);
    private String currentImagePath = "";
    private transient BufferedImage currentImage = null;

    public Perspective() {
		// TODO Auto-generated constructor stub
		NotifierObservateurs();
	}
	
	
	public Perspective(Perspective perspective) {
		SetPosition(perspective.GetPosition());
		SetSize(perspective.GetSize());
		//NotifierObservateurs();
		// TODO Auto-generated constructor stub
	}


	public void SetPanelDimensions(int x, int y) {
		panelDimensions = new Point(x, y);
	}
	public void Match(Perspective perspective) {
		SetImage(perspective.currentImagePath);
		SetPosition(perspective.GetPosition());
		SetSize(perspective.GetSize());
		FixPosition();
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
	
	public Point GetDeltaPosition(Point comparativePosition) {
		// TODO Auto-generated method stub
		int DeltaX =  comparativePosition.x - GetPosition().x;
		int DeltaY =  comparativePosition.y - GetPosition().y;
		return new Point(DeltaX, DeltaY);
	}
	public int GetDeltaSize(int Size) {
		// TODO Auto-generated method stub
		int DeltaSize =  Size - GetSize().x;
		return DeltaSize;
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
	    
	    //SetPosition(newPosition);
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
		
		SetSize(new Point(newSizeX, newSizeY));
		
	}

	public void SetImage(String imagePath) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			img = null;
		}
		
		if(img != null) {
			currentImagePath = imagePath;

		currentImage = img;
	    // Ensure the panel's dimensions are considered in case they haven't been set elsewhere
	    if (panelDimensions != null && currentImage != null) {
	        // Maintain aspect ratio of the image based on the panel's height.
	        size.y = panelDimensions.y;
	        // Calculate the width of the image such that the aspect ratio is maintained.
	        size.x = (int)(((float)currentImage.getWidth() / (float)currentImage.getHeight()) * size.y);
	        SetPosition(new Point(0, 0));
	      
	        FixPosition();
	    } else {
	        // Handle the case where panelDimensions or currentImage is null.
	        System.out.println("Panel dimensions or image is null.");
	    }

		}
	}

	
	
	public void SetAsThumbnail(int yPos, int xSize) {
		// TODO Auto-generated method stub
		int ySize = (int)(((float)size.y/(float)size.x)*xSize);
		yPos -= (ySize/2);
		SetPosition(new Point(0, yPos));
		SetSize(new Point(xSize, ySize));
	}
	public BufferedImage GetImage() {
		// TODO Auto-generated method stub
		return currentImage;
	}

    
    
    
    
    
    
    
    
    
    
}
