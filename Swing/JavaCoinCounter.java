package com.midtermexam;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import java.awt.Toolkit;

public class JavaCoinCounter extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JButton divide;
	private JButton times;
	private JButton minus;
	private JButton plus;
	private JLabel coinValue;
	private int total;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaCoinCounter frame = new JavaCoinCounter();
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
	public JavaCoinCounter() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JavaCoinCounter.class.getResource("/com/midtermexam/coin.jpg")));
		setTitle("Coin Counter");
		setResizable(false);
		setPreferredSize(new Dimension(620, 350));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 350);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(700, 400));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		
		JLabel mycoinlbl = new JLabel("MYCOIN");
		
		plus = new JButton("+");
		plus.setFont(new Font("Tahoma", Font.BOLD, 18));
		plus.setBackground(new Color(0, 153, 255));
		plus.addActionListener(this);
		
		minus = new JButton("-");
		minus.setFont(new Font("Tahoma", Font.BOLD, 18));
		minus.setBackground(new Color(0, 153, 255));
		minus.addActionListener(this);
		
		times = new JButton("*");
		times.setFont(new Font("Tahoma", Font.BOLD, 18));
		times.setBackground(new Color(0, 153, 255));
		times.addActionListener(this);
		
		divide = new JButton("/");
		divide.setFont(new Font("Tahoma", Font.BOLD, 18));
		divide.setBackground(new Color(0, 153, 255));
		divide.addActionListener(this);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Coin Counter");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		//addAct
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(mycoinlbl)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(14)
									.addComponent(plus)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(minus)
									.addGap(14)
									.addComponent(times)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(divide))
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(60)
							.addComponent(lblNewLabel_1)))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addComponent(lblNewLabel_1)
					.addGap(35)
					.addComponent(mycoinlbl)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(divide, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(minus, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(plus, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(times, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(97, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("JAVACOIN VALUE");
		
		coinValue = new JLabel("");
		coinValue.setFont(new Font("Tahoma", Font.BOLD, 75));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(122, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(coinValue)
						.addComponent(lblNewLabel))
					.addGap(109))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(106)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(coinValue, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(108, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String value = textField.getText();
		int number = Integer.parseInt(value);
		String command = e.getActionCommand();
		
		//Check if input has character
		Pattern character = Pattern.compile("^[a-zA-Z]*$");
	    Matcher hasCh = character.matcher(value);
	    boolean hasCharac = hasCh.find();
		if(hasCharac) {
			JOptionPane.showMessageDialog(null, "Input should not contain character!", "Invalid input", JOptionPane.WARNING_MESSAGE);
		}
		
		switch(command) {
			case "+":
				total = total + number;
				textField.setText(value);
				coinValue.setText(""+total);
				break;
			case "-":
				total = total - number;
				textField.setText(value);
				coinValue.setText(""+total);
				break;
			case "*":
				total = total * number;
				textField.setText(value);
				coinValue.setText(""+total);
				break;
			case "/":
				total = total / number;
				textField.setText(value);
				coinValue.setText(""+total);
				break;
		}
	}
}
