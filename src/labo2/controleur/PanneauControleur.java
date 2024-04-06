package labo2.Controleur;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.Timer;

import labo2.Command.DeplacerCommande;
import labo2.Command.ZoomCommande;
import labo2.Observateur.Observateur;
import labo2.PressePapier.PressePapier;
import labo2.Vu.PanneauVu;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class PanneauControleur extends JPanel implements MouseMotionListener, MouseWheelListener {

	
	private Timer wheelStopTimer;
    private int accumulatedWheelRotation = 0; // Tracks total rotation amount for a "wheel movement
	private int startX, startY = 0; // Starting drag positions
    private int totalDeltaX = 0, totalDeltaY = 0; // Total drag movement
    boolean dragging = false;
    private JPopupMenu popupMenu;
    PanneauVu panneauInterne;

    public PanneauControleur() {
        GridLayout layout = new GridLayout(1, 1);
		setLayout(layout);
        panneauInterne = new PanneauVu();
        add(panneauInterne);
        addMouseMotionListener(this);
        addMouseWheelListener(this);
        initializePopupMenu(); // Call to initialize the popup menu
        SetMouseWheelTimer(500);//Set minimum scrollTimer for zoom command. (parameter is in milliseconds).
        
        
        // Existing constructor code...

        
    }
    public void SetMouseWheelTimer(int millisecondDelay) {
    	// Initialize the timer with a delay and a lambda to execute when the timer fires
        wheelStopTimer = new Timer(millisecondDelay, (e) -> {
            // This code is executed when the wheel has stopped moving
            if (accumulatedWheelRotation != 0) {
                // Create and execute your command here using accumulatedWheelRotation
                ZoomCommande zoomCommande = new ZoomCommande(panneauInterne.GetPerspective(), accumulatedWheelRotation * 15);
                panneauInterne.GiveCommande(zoomCommande);

                // Reset for the next series of wheel movements
                accumulatedWheelRotation = 0;
            }
        });
        wheelStopTimer.setRepeats(false); // Ensure the timer only fires once per sequence of wheel events
    }
    

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int notches = e.getWheelRotation();
        if (notches != 0) {
            // Zoom in or out based on notches
            accumulatedWheelRotation += notches;

            // Restart the timer every time a new wheel event occurs
            if (wheelStopTimer.isRunning()) {
                wheelStopTimer.restart();
            } else {
                wheelStopTimer.start();
            }
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        if (!dragging) {
            startX = e.getXOnScreen();
            startY = e.getYOnScreen();
            dragging = true;
        }
        // Note: We're not moving the panneauInterne here anymore
    }

    // New method to process the end of a drag operation
    private void endDrag(MouseEvent e) {
        if (dragging) {
            int endX = e.getXOnScreen();
            int endY = e.getYOnScreen();
            totalDeltaX = endX - startX;
            totalDeltaY = endY - startY;

            // Here you create and execute the DeplacerCommande
            DeplacerCommande deplacerCommande = new DeplacerCommande(panneauInterne.GetPerspective(), totalDeltaX, totalDeltaY);
            panneauInterne.GiveCommande(deplacerCommande);

            // Resetting for the next drag operation
            dragging = false;
            totalDeltaX = 0;
            totalDeltaY = 0;
        }
    }
    
    
    @Override
    public void mouseMoved(MouseEvent e) {
        // Not needed, but required to implement MouseMotionListener
        if (!dragging) {
            startX = e.getXOnScreen();
            startY = e.getYOnScreen();
        }

    }

    private void initializePopupMenu() {
        popupMenu = new JPopupMenu();
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");

        copyItem.addActionListener((ActionEvent e) -> {
            // Perform copy action
            System.out.println("Copy action performed");
    		PressePapier.Copier(panneauInterne.GetPerspective());
            
        });

        pasteItem.addActionListener((ActionEvent e) -> {
            // Perform paste action

            System.out.println("Paste action performed");
            PressePapier.Coller(panneauInterne.GetPerspective());
            
        });

        popupMenu.add(copyItem);
        popupMenu.add(pasteItem);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                pasteItem.setEnabled(PressePapier.pressePapier != null);
                maybeShowPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                maybeShowPopup(e);
                if (dragging) {
                    endDrag(e); // This will now properly conclude the drag operation
                }
            }


            private void maybeShowPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
            
        });
    }

    public void AjouterObservateur(Observateur O) {
    	if(panneauInterne != null) {
    		panneauInterne.GetPerspective().AjouterObservateur(O);
    	}
    }


}
