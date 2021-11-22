package com.testing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Dimension;

public class KeyListener_Demo extends JFrame implements KeyListener{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel1;
	private JLabel W;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KeyListener_Demo frame = new KeyListener_Demo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KeyListener_Demo() {
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel2 = new JPanel();
		contentPane.add(panel2, BorderLayout.WEST);
		panel2.setLayout(new BorderLayout(0, 0));
		
		JLabel A = new JLabel("A Key");
		panel2.add(A);
		
		panel3 = new JPanel();
		contentPane.add(panel3, BorderLayout.EAST);
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
		
		JLabel D = new JLabel("D Key");
		D.setHorizontalAlignment(SwingConstants.CENTER);
		D.setHorizontalTextPosition(SwingConstants.CENTER);
		panel3.add(D);
		
		panel4 = new JPanel();
		panel4.setPreferredSize(new Dimension(10, 28));
		contentPane.add(panel4, BorderLayout.SOUTH);
		panel4.setLayout(new BorderLayout(0, 0));
		
		JLabel X = new JLabel("X Key");
		X.setPreferredSize(new Dimension(10, 28));
		X.setHorizontalTextPosition(SwingConstants.CENTER);
		X.setHorizontalAlignment(SwingConstants.CENTER);
		panel4.add(X, BorderLayout.CENTER);
		
		panel5 = new JPanel();
		contentPane.add(panel5, BorderLayout.CENTER);
		panel5.setLayout(new BorderLayout(0, 0));
		
		JLabel S = new JLabel("S Key");
		S.setHorizontalAlignment(SwingConstants.CENTER);
		panel5.add(S);
		
		panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(10, 28));
		contentPane.add(panel1, BorderLayout.NORTH);
		panel1.setLayout(new BorderLayout(0, 0));
		
		W = new JLabel("W Key");
		W.setHorizontalAlignment(SwingConstants.CENTER);
		W.setVerticalAlignment(SwingConstants.CENTER);
		W.setEnabled(true);
		panel1.add(W);
		addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			panel1.setBackground(Color.GREEN);
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			panel2.setBackground(Color.GREEN);
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			panel3.setBackground(Color.GREEN);
		}
		if (e.getKeyCode() == KeyEvent.VK_X) {
			panel4.setBackground(Color.GREEN);
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			panel5.setBackground(Color.GREEN);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			panel1.setBackground(getBackground());
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			panel2.setBackground(getBackground());
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			panel3.setBackground(getBackground());
		}
		if (e.getKeyCode() == KeyEvent.VK_X) {
			panel4.setBackground(getBackground());
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			panel5.setBackground(getBackground());
		}
	}
}
