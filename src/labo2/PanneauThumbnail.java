package labo2;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.Timer;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class PanneauThumbnail extends JPanel{

	
	
    PanneauVu panneauInterne;

    public PanneauThumbnail() {
        GridLayout layout = new GridLayout(1, 1);
		setLayout(layout);
        panneauInterne = new PanneauVu(Color.BLACK, 2);
        add(panneauInterne);
        panneauInterne.SetAsThumbnail();
        
        
    }
    


    
    
    

}
