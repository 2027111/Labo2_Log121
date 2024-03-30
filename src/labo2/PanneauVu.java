package labo2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class PanneauVu extends JPanel{

	int borderSize = 2;
	Color borderColor = Color.BLUE;
	Perspective perspective = new Perspective();
    

    public PanneauVu() {
    	borderColor = Color.BLUE;
        setBorder(BorderFactory.createLineBorder(borderColor, borderSize));
        
    }
    

    public PanneauVu(Color color, int BorderSize) {
    	borderSize = BorderSize;
    	borderColor = color;
        setBorder(BorderFactory.createLineBorder(borderColor, borderSize));
        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(perspective.currentImage, perspective.GetPosition().x + borderSize, perspective.GetPosition().y + borderSize, perspective.GetSize().x, perspective.GetSize().y, this);
    }

    public void SetAsThumbnail() {
    	
    	int yPos = this.getHeight()/2;
    	int xSize = this.getWidth();
    	
    	perspective.SetAsThumbnail(yPos, xSize);
    	
    }



	public void Paste() {
		// TODO Auto-generated method stub
		perspective.SetAlikeTo(PressePapier.pressePapier);
		
        
	}

	public void Copy() {
		// TODO Auto-generated method stub
		PressePapier.AddPress(perspective);
        
	}

	public Perspective GetPerspective() {
		// TODO Auto-generated method stub
		return perspective;
	}

	public void GiveCommande(ICommand Commande) {
		// TODO Auto-generated method stub
		perspective.GiveCommande(Commande);
		
	}


	public void SetImage(BufferedImage image) {
		// TODO Auto-generated method stub
		perspective.SetPanelDimensions(this.getWidth(), this.getHeight());
		perspective.SetImage(image);
		
	}
		
}
