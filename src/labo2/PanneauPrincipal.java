package labo2;


import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanneauPrincipal extends JPanel{
private static final long serialVersionUID = 1L;
	
	GridLayout layout;

	

	public PanneauPrincipal() {
		
		layout = new GridLayout(1, 3);
		PanneauVu vuun = new PanneauVu();
		PanneauVu vudeux = new PanneauVuModifiable();
		PanneauVuModifiable vutrois = new PanneauVuModifiable();
		setLayout(layout);
		add(vuun);
		add(vudeux);
		add(vutrois);
		}
	
		
	}



