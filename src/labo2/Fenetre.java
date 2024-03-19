package labo2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

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
		// Rendre la fen�tre visible
		setVisible(true);
		// Mettre la fen�tre au centre de l'�cran
		setLocationRelativeTo(null);
		// Emp�cher la redimension de la fen�tre
		setResizable(false);
		PanneauPrincipal panneauPrincipal = new PanneauPrincipal();
		panneauPrincipal.Attacher(this);
		add(panneauPrincipal);
		repaint();
	}
	
	
	




	@Override
	public void actualiser() {
		repaint();
		
	}
	
	
}
