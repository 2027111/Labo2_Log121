package labo2.Controleur;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import labo2.PressePapier.PressePapier;

public class PanneauStrategie extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanneauStrategie() {

		 JCheckBox strategie1 = new  JCheckBox("Position");
		 JCheckBox strategie2 = new  JCheckBox("Niveau de Zoom");	
		 strategie1.setSelected(PressePapier.CopyPos);
		 strategie2.setSelected(PressePapier.CopyZoom);
		JButton boutonConfirmer = new JButton("Confirmer");
		JButton boutonAnnuler = new JButton("Annuler");

		boutonConfirmer.addActionListener((ActionEvent e) -> {
			// TODO - Appeler la bonne strat�gie
			System.out.println(strategie1.isSelected());
			System.out.println(strategie2.isSelected());
			
			PressePapier.SetStrategie(strategie1.isSelected(), strategie2.isSelected());
			

			// Fermer la fen�tre du composant
			SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
		});
		boutonAnnuler.addActionListener((ActionEvent e) -> {
			// Fermer la fen�tre du composant
			SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
		});
		add(strategie1);
		add(strategie2);			
		add(boutonConfirmer);		
		add(boutonAnnuler);

	}

	/**
	 * Retourne le bouton s�lectionn� dans un groupe de boutons.
	 * @param groupeBoutons
	 * @return
	 */
	public String getSelectedButtonText(ButtonGroup groupeBoutons) {
		for (Enumeration<AbstractButton> boutons = groupeBoutons.getElements(); boutons.hasMoreElements();) {
			AbstractButton bouton = boutons.nextElement();
			if (bouton.isSelected()) {
				return bouton.getText();
			}
		}

		return null;
	}

}
