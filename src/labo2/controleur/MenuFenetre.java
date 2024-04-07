package labo2.Controleur;


import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import labo2.Model.Perspective;

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
	private JMenuItem menuSauvegarderPerspective; // Field to access it outside the constructor

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
		JMenuItem menuChargerPerspective = new JMenuItem(MENU_FICHIER_CHARGER_PERS);
		menuSauvegarderPerspective = new JMenuItem(MENU_FICHIER_SAUVEGARDER_PERS);
		
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

			updateMenuItemsBasedOnImageLoaded();
		});
		
		
		
		menuSauvegarderPerspective.addActionListener((ActionEvent e) -> {
			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			fileChooser.setDialogTitle("Préciser un chemin pour sauvegarder");
			fileChooser.setAcceptAllFileFilterUsed(false);
			// Cr�er un filtre
			FileNameExtensionFilter filtre = new FileNameExtensionFilter("Perspective Files", ".perspective");
			fileChooser.addChoosableFileFilter(filtre);
			int returnValue = fileChooser.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				// TODO - Parser le fichier XML s�lectionn�
				File selectedFile = fileChooser.getSelectedFile();
				if (!selectedFile.getAbsolutePath().endsWith(".perspective")) {
		            selectedFile = new File(selectedFile + ".perspective");
		        }
			
			try {
		         FileOutputStream fileOut = new FileOutputStream(selectedFile.getAbsolutePath());
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         ArrayList<Perspective> perspectives = panneauPrincipal.GetPerspectives();
		         out.writeObject(perspectives);
		         out.close();
		         fileOut.close();
		         System.out.printf("Serialized data is saved in /tmp/employee.perspective");
		      } catch (IOException i) {
		         i.printStackTrace();
		      }
			}
		});
		menuChargerPerspective.addActionListener((ActionEvent e) -> {

			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			fileChooser.setDialogTitle("S�lectionnez un fichier de configuration");
			fileChooser.setAcceptAllFileFilterUsed(false);
			// Cr�er un filtre

			FileNameExtensionFilter filter = new FileNameExtensionFilter("Perspective Files", "perspective");
			fileChooser.addChoosableFileFilter(filter);

			int returnValue = fileChooser.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				// TODO - Parser le fichier XML s�lectionn�
				File selectedFile = fileChooser.getSelectedFile();
			 try {
			        FileInputStream fis=new FileInputStream(selectedFile.getAbsolutePath());
			        ObjectInputStream ois=new ObjectInputStream(fis);

			        ArrayList<Perspective> woi=new ArrayList<>();
			        woi=(ArrayList<Perspective>)ois.readObject();
			        panneauPrincipal.SetSerialization(woi);
		      } catch (IOException i) {
		         i.printStackTrace();
		      } catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
			updateMenuItemsBasedOnImageLoaded();
		});
		
		menuQuitter.addActionListener((ActionEvent e) -> {
			System.exit(0);
		});

		menuFichier.add(menuCharger);
		menuFichier.add(menuQuitter);
		menuFichier.add(menuSauvegarderPerspective);
		menuFichier.add(menuChargerPerspective);

		add(menuFichier);
		menuSauvegarderPerspective.setEnabled(false);
	}

	
	private void updateMenuItemsBasedOnImageLoaded() {
        if (panneauPrincipal != null) {
            // Update to use the HasImageLoaded method
            menuSauvegarderPerspective.setEnabled(panneauPrincipal.HasImageLoaded());
        }
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
