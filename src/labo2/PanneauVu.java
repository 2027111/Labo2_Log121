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

public class PanneauVu extends JPanel{

	int borderSize = 5;
	
	public PanneauVu(){
		setBorder(BorderFactory.createLineBorder(Color.BLUE, borderSize));
	}
	

	public PanneauVu(int borderSize){
		this.borderSize = borderSize;
	}
	@Override
	public void paint(Graphics g) {
		g.drawRect(10,  10, 30, 30);
		super.paint(g);
		}
		
}
