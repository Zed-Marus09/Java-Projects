package com.bouncingbox;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;


public class Bouncing_Box extends JFrame {
	private static final long serialVersionUID = -8376037929059666388L;
	private JPanel contentPane;
	private Thread thread;
	private Rectangle box;
	private long start;
	private long end;
	private boolean goDown;
	private boolean goRight;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bouncing_Box frame = new Bouncing_Box();
					frame.setVisible(true);
					frame.startBouncing();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Bouncing_Box() {
		setTitle("Bouncing Box");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		box = new Rectangle(100, 100, 100, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					try {

						box.x = box.x + 5;
						box.y = box.y + 5;
						if (box.x < 0) 
							goRight = true;
						if( box.x > 600 - 100) 
							goRight = false;
						if (box.y < 20) 
							goDown = true;
						if (box.y > 600 - 100) 
							goDown = false;
						if (goRight) 
							box.x = box.x + 5;
						if (!goRight) 
							box.x = box.x - 10;
						if (goDown) 
							box.y = box.y + 5;
						if (!goDown) 
							box.y = box.y - 10;
						
						start = System.currentTimeMillis();
						repaint();
						end = System.currentTimeMillis();

						Thread.sleep(40 - (end - start));

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	@Override
	public void paint(Graphics graph) {
		Graphics2D graphic = (Graphics2D) graph;

		graphic.setColor(getBackground());
		graphic.fillRect(0, 0, 600, 600);
		graphic.setColor(Color.red);

		graphic.fillRect((int) box.getX(), (int) box.getY(), (int) box.getWidth(), (int) box.getHeight());
	}
	
	public void startBouncing() {
		thread.start();
	}
}
