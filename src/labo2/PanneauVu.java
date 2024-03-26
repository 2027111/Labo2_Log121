package labo2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class PanneauVu extends SujetObserver{

	int borderSize = 2;
	Color borderColor = Color.BLACK;
	Perspective perspective = new Perspective();
    

    public PanneauVu() {
    	borderColor = Color.BLUE;
        setBorder(BorderFactory.createLineBorder(borderColor, borderSize));
        
		NotifierObservateurs();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(perspective.GetPosition().x + borderSize, perspective.GetPosition().y + borderSize, perspective.GetSize(), perspective.GetSize());
    }
	public void Deplacer(int x, int y) {
		Point newPosition = perspective.GetPosition();
		
		newPosition.x += x;
		newPosition.y +=y;
		perspective.SetPosition(newPosition);
		FixPosition();
	}
	
	public void FixPosition() {

		Point newPosition = perspective.GetPosition();
		newPosition.x = Clamp.clamp(perspective.GetPosition().x, 0, this.getSize().width - (perspective.GetSize() + borderSize+ borderSize));
		newPosition.y =Clamp.clamp(perspective.GetPosition().y, 0, this.getSize().height - (perspective.GetSize()+ borderSize+ borderSize));
		perspective.SetPosition(newPosition);
		NotifierObservateurs();
	}

	public void zoomer(int notches) {
		// TODO Auto-generated method stub
		int size = perspective.GetSize();
		size += notches;
		perspective.SetSize(size);
        FixPosition();
		
	}

	public void Paste() {
		// TODO Auto-generated method stub
		perspective = new Perspective(PressePapier.CurrentPerspective);
        FixPosition();
	}

	public void Copy() {
		// TODO Auto-generated method stub
		PressePapier.CurrentPerspective = new Perspective(perspective);
        FixPosition();
	}
		
}
