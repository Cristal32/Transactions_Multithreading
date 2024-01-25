package tp2_multithreading_exC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Billard extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4145614313897603249L;
	private static final int BALL_SIZE = 10;
	private static final int PANEL_WIDTH = 800;
	private static final int PANEL_HEIGHT = 600;
	private boolean isDrawing = false;
	
	public Billard() {
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    if (isDrawing) {
			        isDrawing = false;
			        SwingUtilities.invokeLater(new Runnable() {
			            @Override
			            public void run() {
			                startButton.setText("Start");
			            }
			        });
			    } else {
			        isDrawing = true;
			        SwingUtilities.invokeLater(new Runnable() {
			            @Override
			            public void run() {
			                startButton.setText("Stop");
			            }
			        });
			        startDrawingThread();
			    }
			}
        });
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(startButton);
		setLayout(new BorderLayout());
		add(buttonPanel, BorderLayout.NORTH);
	}
	
	private void startDrawingThread() {
		for (int i = 0; i < 5; i++) { 
			Thread drawingThread = new Thread(new Runnable() {
				@Override
				public void run() {
					drawBalle();
				}
			});
			drawingThread.start();
		}
	}
	
	private void drawBalle() {
		int x = (int) (Math.random() * (PANEL_WIDTH - BALL_SIZE));
		int y = (int) (Math.random() * (PANEL_HEIGHT - BALL_SIZE));
		int dx = (Math.random() > 0.5) ? 1 : -1;
		int dy = (Math.random() > 0.5) ? 1 : -1;
		
		while (isDrawing) {
			x += dx;
			y += dy;
			if (x <= 0 || x >= PANEL_WIDTH - BALL_SIZE) { dx = -dx; }
			if (y <= 0 || y >= PANEL_HEIGHT - BALL_SIZE) { dy = -dy; }
			Graphics g = getGraphics();
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
			g.setColor(Color.WHITE);
			g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
			g.dispose();
			
			try { Thread.sleep(10); } 
			catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame = new JFrame("Billard");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(PANEL_WIDTH, PANEL_HEIGHT);
				Billard billard = new Billard();
				frame.add(billard);
				frame.setVisible(true);
			}
		});
	}
}