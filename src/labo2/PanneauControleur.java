package labo2;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class PanneauControleur extends JPanel implements MouseMotionListener, MouseWheelListener {

    private int startX, startY = 0;
    boolean dragging = false;
    private JPopupMenu popupMenu;
    boolean isThumbnail = false;
    PanneauVu panneauInterne;

    public PanneauControleur(boolean thumbnail) {
        isThumbnail = thumbnail;
        panneauInterne = new PanneauVu();
        add(panneauInterne);
        addMouseMotionListener(this);
        addMouseWheelListener(this);
        initializePopupMenu(); // Call to initialize the popup menu
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int notches = e.getWheelRotation();
        if (notches != 0) {
            // Zoom in
            panneauInterne.zoomer(notches);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        dragging = true;
        int x = e.getXOnScreen();
        int y = e.getYOnScreen();

        int deltaX = x - startX;
        int deltaY = y - startY;

        panneauInterne.Deplacer(x, y);
        System.out.println("DeltaX: " + deltaX + ", DeltaY: " + deltaY);

        // Trigger an event with the x and y movement of the mouse
        // You can define your event handling logic here

        // Update the starting position for the next drag event
        startX = x;
        startY = y;
        dragging = false;
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
        });

        pasteItem.addActionListener((ActionEvent e) -> {
            // Perform paste action
            System.out.println("Paste action performed");
        });

        popupMenu.add(copyItem);
        popupMenu.add(pasteItem);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                maybeShowPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                maybeShowPopup(e);
            }

            private void maybeShowPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }
}
