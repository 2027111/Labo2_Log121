package labo2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	
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
		GridLayout layout = new GridLayout(1, 3);
		PanneauPrincipal panneauPrincipal = new PanneauPrincipal();

		PanneauVu vuun = new PanneauVu();
		PanneauVu vudeux = new PanneauVu();
		PanneauVu vutrois = new PanneauVu();
		add(panneauPrincipal);
		panneauPrincipal.setLayout(layout);
		panneauPrincipal.add(vuun);
		panneauPrincipal.add(vudeux);
		panneauPrincipal.add(vutrois);
	}
	
	
}
