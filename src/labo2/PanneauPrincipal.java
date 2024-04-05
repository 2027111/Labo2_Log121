package labo2;


import java.awt.Component;
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
	PanneauThumbnail vuun = new PanneauThumbnail();
	PanneauControleur vudeux = new PanneauControleur();
	PanneauControleur vutrois = new PanneauControleur();
	public String currentImgPath = null;
	

	public PanneauPrincipal() {
		
		layout = new GridLayout(1, 3);
		setLayout(layout);
		add(vuun);
		add(vudeux);
		add(vutrois);
		
		
		GestionCommande patron = new GestionCommande();
		}


	public void Attacher(Fenetre fenetre) {
		// TODO Auto-generated method stub
		vudeux.AjouterObservateur(fenetre);
		vutrois.AjouterObservateur(fenetre);
	}

	public void SetImage(String absolutePath) {
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(absolutePath));
			currentImgPath = absolutePath;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			img = null;
			currentImgPath = null;
		}
		
		if(img != null) {
			// TODO Auto-generated method stub
			vuun.panneauInterne.SetImage(img);
			vudeux.panneauInterne.SetImage(img);
			vutrois.panneauInterne.SetImage(img);
			vuun.panneauInterne.SetAsThumbnail();
		}
	}
	
		
	}



