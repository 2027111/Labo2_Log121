package labo2.Controleur;


import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import labo2.Command.GestionCommande;
import labo2.Controleur.FenetreStrategie;

public class MenuFenetre extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private static final String MENU_FICHIER_TITRE = "Fichier";
	private static final String MENU_FICHIER_CHARGER_PERS = "Charger Perspective";
	private static final String MENU_FICHIER_SAUVEGARDER_PERS = "Sauvegarder Perspective";
	private static final String MENU_FICHIER_CHARGER = "Charger Image";
	private static final String MENU_FICHIER_QUITTER = "Quitter";
	private static final String MENU_MODIFIER_TITRE = "Édition";
	private static final String MENU_MODIFIER_ANNULER = "Annuler";
	private static final String MENU_MODIFIER_RETABLIR = "Rétablir";
	private static final String MENU_PRESSE_TITRE = "Presse-Papier";
	private static final String MENU_PRESSE_STRATEGIE = "Choisir Strategie";

	private PanneauPrincipal panneauPrincipal;
	
	public MenuFenetre() {
		ajouterMenuFichier();
		ajouterMenuModifier();
		ajouterMenuPressePapier();

	}


	/**
	 * Cr�er le menu de Fichier
	 */
	private void ajouterMenuFichier() {
		JMenu menuFichier = new JMenu(MENU_FICHIER_TITRE);
		JMenuItem menuCharger = new JMenuItem(MENU_FICHIER_CHARGER);
		JMenuItem menuQuitter = new JMenuItem(MENU_FICHIER_QUITTER);

		menuCharger.addActionListener((ActionEvent e) -> {
			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			fileChooser.setDialogTitle("S�lectionnez un fichier de configuration");
			fileChooser.setAcceptAllFileFilterUsed(false);
			// Cr�er un filtre
			FileNameExtensionFilter filtre = new FileNameExtensionFilter(".png", "png", ".jpeg", ".jgp", "jpg", "jpeg");
			fileChooser.addChoosableFileFilter(filtre);

			int returnValue = fileChooser.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				// TODO - Parser le fichier XML s�lectionn�
				File selectedFile = fileChooser.getSelectedFile();
				panneauPrincipal.SetImage(selectedFile.getAbsolutePath());
				System.out.println(selectedFile.getAbsolutePath());
			}
		});
		
		menuQuitter.addActionListener((ActionEvent e) -> {
			System.exit(0);
		});

		menuFichier.add(menuCharger);
		menuFichier.add(menuQuitter);

		add(menuFichier);

	}

	/**
	 * Cr�er le menu de Simulation
	 */
	private void ajouterMenuModifier() {
		JMenu menuModifier = new JMenu(MENU_MODIFIER_TITRE);
		JMenuItem menuAnnuler = new JMenuItem(MENU_MODIFIER_ANNULER);
		JMenuItem menuRetablir = new JMenuItem(MENU_MODIFIER_RETABLIR);
		menuModifier.add(menuAnnuler);
		menuModifier.add(menuRetablir);

		menuAnnuler.addActionListener((ActionEvent e) -> {
			// Ouvrir la fen�tre de s�lection
			// TODO - R�cup�rer la bonne strat�gie de vente
			//Faire truc machian redo, undo
			GestionCommande.Singleton.AnnulerCommande();
		});

		menuRetablir.addActionListener((ActionEvent e) -> {
			// Ouvrir la fen�tre de s�lection
			// TODO - R�cup�rer la bonne strat�gie de vente
			//Faire truc machian redo, undo
			GestionCommande.Singleton.RetablirCommande();
		});
		add(menuModifier);

	}

	/**
	 * Cr�er le menu Aide
	 */
	private void ajouterMenuPressePapier() {
		JMenu menuAide = new JMenu(MENU_PRESSE_TITRE);
		JMenuItem menuPropos = new JMenuItem(MENU_PRESSE_STRATEGIE);
		menuAide.add(menuPropos);

		menuPropos.addActionListener((ActionEvent e) -> {

			new FenetreStrategie();
		});

		add(menuAide);
	}


	public void SetPanneau(PanneauPrincipal panneauPrincipal) {
		// TODO Auto-generated method stub
		this.panneauPrincipal = panneauPrincipal;
	}
	
}
