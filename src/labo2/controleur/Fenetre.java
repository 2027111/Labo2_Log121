package labo2.controleur;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

import labo2.Observateur.Observateur;

public class Fenetre extends JFrame implements Observateur{
	
	private static final long serialVersionUID = 1L;
	private static final String TITRE_FENETRE = "Laboratoire 2 : LOG121 - Architecture MVC";
	private static final Dimension DIMENSION = new Dimension(1600, 900);
	
	
	
	public Fenetre() {
		MenuFenetre menuFenetre = new MenuFenetre();
		
		add(menuFenetre, BorderLayout.NORTH);
		// Faire en sorte que le X de la fen�tre ferme la fen�tre
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(TITRE_FENETRE);
		setSize(DIMENSION);
		PanneauPrincipal panneauPrincipal = new PanneauPrincipal();
		panneauPrincipal.Attacher(this);
		add(panneauPrincipal);
		menuFenetre.SetPanneau(panneauPrincipal);
		repaint();
		// Rendre la fen�tre visible
		setVisible(true);
		// Mettre la fen�tre au centre de l'�cran
		setLocationRelativeTo(null);
		// Emp�cher la redimension de la fen�tre
		setResizable(false);
	}
	
	
	




	@Override
	public void actualiser() {
		repaint();
		
	}
	
	
}
