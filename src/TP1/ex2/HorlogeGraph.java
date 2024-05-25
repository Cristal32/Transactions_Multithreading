package TP1.ex2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

//HorlogeGraphique
public class HorlogeGraph extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8654411464209241863L;

	//constructeur
	public HorlogeGraph() {
		this.setHorizontalAlignment(JLabel.CENTER);
		Vecteur vect = new Vecteur(0,0,0);
		Thread horl = new Thread(new Afficher(vect, this), "Horloge");
		horl.start();
		
		// Add a WindowListener after the JFrame has been created
        SwingUtilities.invokeLater(() -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    horl.interrupt();
                }
            });
        });
	}
	
	 public void updateHorloge(Vecteur vecteur) {
	        this.setText(vecteur.toString());
	    }

	public static void main(String[] args) {
		JFrame frame = new JFrame("Horloge Graphique");
		frame.setSize(200,200);
		frame.setContentPane(new HorlogeGraph());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
