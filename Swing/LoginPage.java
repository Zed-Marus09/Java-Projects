package com.login;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class LoginPage extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField usertextField;
	private JPasswordField passwordField;
	private JButton loginBtn;
	private JButton clearBtn;
	private final String user = "Admin";
	private final String pass = "Admin123";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 350);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(34, 214, 163));
		panel.setBounds(0, 0, 174, 321);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginPage.class.getResource("/com/login/logoIcon2.png")));
		lblNewLabel.setBounds(35, 79, 95, 91);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Aicrag Company");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1.setBounds(36, 164, 114, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Best tech comany\r\n in Asia.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(27, 171, 123, 49);
		panel.add(lblNewLabel_2);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(173, 0, 348, 321);
		contentPane.add(loginPanel);
		loginPanel.setLayout(null);
		
		JLabel loginLabel = new JLabel("Log In");
		loginLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		loginLabel.setBounds(138, 46, 73, 26);
		loginPanel.add(loginLabel);
		
		JLabel userLabel = new JLabel("Username:");
		userLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		userLabel.setBounds(72, 101, 73, 14);
		loginPanel.add(userLabel);
		
		JLabel passwordlbl = new JLabel("Password:");
		passwordlbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		passwordlbl.setBounds(72, 170, 73, 14);
		loginPanel.add(passwordlbl);
		
		usertextField = new JTextField();
		usertextField.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		usertextField.setFont(new Font("Tahoma", Font.BOLD, 14));
		usertextField.setBounds(72, 126, 200, 33);
		loginPanel.add(usertextField);
		usertextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		passwordField.setBounds(72, 195, 200, 33);
		loginPanel.add(passwordField);
		
		loginBtn = new JButton("Login");
		loginBtn.setBackground(new Color(34, 214, 163));
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		loginBtn.setBounds(87, 251, 80, 23);
		loginBtn.addActionListener(this);
		loginPanel.add(loginBtn);
		
		clearBtn = new JButton("clear");
		clearBtn.setBackground(new Color(12, 179, 131));
		clearBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		clearBtn.setBounds(184, 251, 80, 23);
		clearBtn.addActionListener(this);
		loginPanel.add(clearBtn);
	}
	
	public boolean usernameChecker(String username) {
		boolean check = false;
		Pattern ch = Pattern.compile("[A-Za-z]");
	    Matcher hascharacter = ch.matcher(username);
	    boolean hasCh = hascharacter.find();
	     
	    Pattern digit = Pattern.compile("[0-9]");
	    Matcher hasDigit = digit.matcher(username);
	    boolean hasDigi = hasDigit.find();
		if(username.equals("")){
			JOptionPane.showMessageDialog(null, "Username field is empty");
			check = true;
		} else if(!username.equals(user)){
			JOptionPane.showMessageDialog(null, "Username does not match default values");
			if(check == hasCh) {
				JOptionPane.showMessageDialog(null, "Username does not contains a characters");
				check = true;
			} else if(check == hasDigi) {
				JOptionPane.showMessageDialog(null, "Username does not contains a numbers");
				JOptionPane.showMessageDialog(null,"","",JOptionPane.ERROR_MESSAGE);
				check = true;
			} else if(username.length() >= 1 && username.length() <= 4) {
				JOptionPane.showMessageDialog(null, "Username contains 4 or less characters");
				check = true;
			} else if(username.length() >= 15) {
				JOptionPane.showMessageDialog(null, "Username contains 15 or more characters");
				check = true;
			} else if(check == hasCh) {
				JOptionPane.showMessageDialog(null, "Username does not contains a characters");
				check = true;
			}
		} /**else if(username.length() >= 1 && username.length() <= 4) {
			JOptionPane.showMessageDialog(null, "Username contains 4 or less characters");
			check = true;
		} else if(username.length() >= 15) {
			JOptionPane.showMessageDialog(null, "Username contains 15 or more characters");
			check = true;
		} else if(check == hasCh) {
			JOptionPane.showMessageDialog(null, "Username does not contains a characters");
			check = true;
		} else if(check == hasDigi) {
			JOptionPane.showMessageDialog(null, "Username does not contains a numbers");
			check = true;
		}*/
		
		return check;
	}
	
	public boolean passwordChecker(String password) {
		boolean check = false;
		if(password.equals("")){
			JOptionPane.showMessageDialog(null, "Password field is empty");
			check = true;
		} else if(!password.equals(pass)){
			JOptionPane.showMessageDialog(null, "Password does not match default values");
			check = true;
		}
		return check;
	}
	
	
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == clearBtn) {
			usertextField.setText("");
			passwordField.setText("");
		}
		if(e.getSource() == loginBtn) {
			String username = usertextField.getText();
			String password = String.valueOf(passwordField.getPassword());
			boolean userCheck = usernameChecker(username);
			boolean passCheck = passwordChecker(password);
			
			if(pass.equals(password) && user.equals(username)) { 
				JOptionPane.showMessageDialog(null, "Login Successfully");
			}
		}
	}
}
