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
	PanneauVu vuun = new PanneauVu();
	PanneauVuModifiable vudeux = new PanneauVuModifiable();
	PanneauVuModifiable vutrois = new PanneauVuModifiable();
	

	

	public PanneauPrincipal() {
		
		layout = new GridLayout(1, 3);
		setLayout(layout);
		add(vuun);
		add(vudeux);
		add(vutrois);
		}



	public void Attacher(Fenetre fenetre) {
		// TODO Auto-generated method stub
		vuun.AjouterObservateur(fenetre);
		vudeux.AjouterObservateur(fenetre);
		vutrois.AjouterObservateur(fenetre);
	}
	
		
	}



