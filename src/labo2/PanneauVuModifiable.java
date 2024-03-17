package labo2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class PanneauVuModifiable extends PanneauVu{

	int borderSize = 5;
	Color borderColer = Color.BLUE;
	
	public PanneauVuModifiable(){
		setBorder(BorderFactory.createLineBorder(Color.BLUE, borderSize));
	}
	

	public PanneauVuModifiable(int borderSize){
		this.borderSize = borderSize;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		}
		
}
