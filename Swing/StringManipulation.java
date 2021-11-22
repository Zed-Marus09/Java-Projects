package com.strings;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class StringManipulation extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JButton lowerBtn;
	private JButton clearBtn;
	private JButton upperBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StringManipulation frame = new StringManipulation();
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
	public StringManipulation() {
		setPreferredSize(new Dimension(400, 350));
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 394, 321);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField.setForeground(new Color(50, 205, 50));
		textField.setBackground(Color.BLACK);
		textField.setSelectedTextColor(Color.WHITE);
		textField.setBounds(50, 118, 297, 46);
		panel.add(textField);
		textField.setColumns(10);
		
		upperBtn = new JButton("Uppercase");
		upperBtn.setForeground(Color.WHITE);
		upperBtn.setBackground(Color.BLACK);
		upperBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		upperBtn.setBounds(50, 197, 101, 40);
		upperBtn.addActionListener(this);
		panel.add(upperBtn);
		
		lowerBtn = new JButton("Lowercase");
		lowerBtn.setForeground(Color.WHITE);
		lowerBtn.setBackground(Color.BLACK);
		lowerBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lowerBtn.setBounds(157, 197, 101, 40);
		lowerBtn.addActionListener(this);
		panel.add(lowerBtn);
		
		clearBtn = new JButton("Cancel");
		clearBtn.setBackground(new Color(255, 69, 0));
		clearBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		clearBtn.setBounds(268, 197, 79, 40);
		clearBtn.addActionListener(this);
		panel.add(clearBtn);
		
		JLabel lblNewLabel = new JLabel("Case Converter");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(102, 60, 181, 29);
		panel.add(lblNewLabel);
	}
	
	public boolean checkHasDigit(String text) {
		boolean check = false;
		Pattern digit = Pattern.compile("[0-9]");
		Matcher hasDigit = digit.matcher(text);
		boolean hasDigi = hasDigit.find();

		if (check != hasDigi) {
			JOptionPane.showMessageDialog(null, "Input should not contains a numbers!", "Error",
					JOptionPane.WARNING_MESSAGE);
			check = true;
		}
		return check;
	}
	
	public boolean checkHasSpecialCharater(String text){
        boolean check = false;
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher hasSpecial = special.matcher(text);
        boolean hasCh = hasSpecial.find();
        
        if(check != hasCh){ 
            JOptionPane.showMessageDialog(null, "Input should not contains a Special Charater!","Error",JOptionPane.WARNING_MESSAGE);
            check = true;
        }
        return check;
    }
	
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		String text = textField.getText();
		
		if (e.getSource() == clearBtn) {
			textField.setText("");
		}
		boolean checkDigit = checkHasDigit(text);
		boolean checkSpecialChar = checkHasSpecialCharater(text);
		if(e.getSource() == lowerBtn){
            textField.setText(text.toLowerCase());
        }
        if(e.getSource() == upperBtn){
            textField.setText(text.toUpperCase());
        }
	}
}
