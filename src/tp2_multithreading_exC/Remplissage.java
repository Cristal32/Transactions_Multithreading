package tp2_multithreading_exC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Remplissage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1487899685634542410L;
	private  boolean isDrawing = false;

    public Remplissage() {
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isDrawing = !isDrawing;
                if (isDrawing) {
                    startButton.setText("Stop");
                    startDrawingThread();
                } else {
                    startButton.setText("Start");
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
    }

    private void startDrawingThread() {
        Thread drawingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int y = 0; y < 100; y += 10) {
                    for (int x = 0; x < 300; x += 10) {
                        if (!isDrawing) {
                            // If drawing is stopped, wait until it's resumed
                            while (!isDrawing) {
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        drawBalle(x, y);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        drawingThread.start();
    }

    private void drawBalle(int x, int y) {
        Graphics g = getGraphics();
        g.fillOval(x, y, 10, 10);
        g.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Remplissage");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                Remplissage remplissage = new Remplissage();
                frame.add(remplissage);
                frame.setVisible(true);
                remplissage.startDrawingThread(); // Start drawing when the program begins
            }
        });
    }
}

