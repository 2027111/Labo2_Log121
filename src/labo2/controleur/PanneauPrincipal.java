package labo2.Controleur;


import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import labo2.Command.GestionCommande;
import labo2.Model.Perspective;

public class PanneauPrincipal extends JPanel{
private static final long serialVersionUID = 1L;
	
	GridLayout layout;
	PanneauThumbnail vuun = new PanneauThumbnail();
	PanneauControleur vudeux = new PanneauControleur();
	PanneauControleur vutrois = new PanneauControleur();
	
	

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
		
		
		if(absolutePath != null) {
			// TODO Auto-generated method stub
			vuun.panneauInterne.SetImage(absolutePath);
			vuun.panneauInterne.SetAsThumbnail();
			vudeux.panneauInterne.SetImage(absolutePath);
			vutrois.panneauInterne.SetImage(absolutePath);
		}
	}


	public Object GetSerialization() {
		// TODO Auto-generated method stub
		return vudeux.panneauInterne.GetPerspective();
	}
	
	
	public void SetSerialization(ArrayList<Perspective> perspectives) {
		vuun.panneauInterne.GetPerspective().Match(perspectives.get(0));
		vudeux.panneauInterne.GetPerspective().Match(perspectives.get(1));
		vutrois.panneauInterne.GetPerspective().Match(perspectives.get(2));
	}


	public ArrayList<Perspective> GetPerspectives() {
		
		
		
		
		ArrayList<Perspective> perspectives = new ArrayList<>();
		perspectives.add(vuun.panneauInterne.GetPerspective());
		perspectives.add(vudeux.panneauInterne.GetPerspective());
		perspectives.add(vutrois.panneauInterne.GetPerspective());
		// TODO Auto-generated method stub
		return perspectives;
	}


	public boolean HasImageLoaded() {
		// TODO Auto-generated method stub
		return vuun.panneauInterne.GetPerspective().GetImage() != null;
	}
	
	
		
	}



