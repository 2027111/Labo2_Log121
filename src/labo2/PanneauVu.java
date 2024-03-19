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

	int borderSize = 5;
	Color borderColor = Color.BLACK;
	Point position = new Point(0, 0);
    private Point currentMovement = new Point(0, 0);
    

    public PanneauVu() {
    	borderColor = Color.BLUE;
        setBorder(BorderFactory.createLineBorder(borderColor, borderSize));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(currentMovement.x, currentMovement.y, 55, 55);
    }
	public void Deplacer(int x, int y) {
		
	}

	public void zoomer(int notches) {
		// TODO Auto-generated method stub
		
	}
		
}
