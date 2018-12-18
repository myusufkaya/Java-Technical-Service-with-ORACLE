package Giris;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Main.MainPage;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Color;

public class Giris_S {

	private JFrame frmLoginSystem;
	private static JTextField txtUsername;
	private static JPasswordField txtPassword;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Giris_S window = new Giris_S();
					window.frmLoginSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Giris_S() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginSystem = new JFrame();
		frmLoginSystem.setBounds(200, 200, 500, 300);
		frmLoginSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginSystem.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(117, 79, 89, 14);
		frmLoginSystem.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("\u015Eifre");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(117, 124, 76, 14);
		frmLoginSystem.getContentPane().add(lblPassword);
		
		JLabel lblNewLabel_2 = new JLabel("Sistem Giri\u015F");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setBounds(189, 11, 123, 27);
		frmLoginSystem.getContentPane().add(lblNewLabel_2);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(216, 78, 177, 20);
		frmLoginSystem.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(216, 123, 177, 20);
		frmLoginSystem.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("Giri\u015F");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password = txtPassword.getText();
				String username = txtUsername.getText();
				if (password.contains("1234") && username.contains("Admin")) {
					txtPassword.setText(null);
					txtUsername.setText(null);					
					
					//MainPage info = new MainPage();
					String[] args = new String[1];
					args[0] = username;
					MainPage.main(args);
									
				}else if (password.contains("1234") && username.contains("Kullanici1")) {
					txtPassword.setText(null);
					txtUsername.setText(null);
										
					//MainPage info = new MainPage();
					MainPage.main(null);
					//panel.setVisible(false);(Main Page);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Geçersiz Kullanýcý Adý ya da Parola ","Giriþ Hatasý !",JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
					txtUsername.setText(null);
				}
				
			}
		});
		btnLogin.setBounds(63, 211, 89, 23);
		frmLoginSystem.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("S\u0131f\u0131rla");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtUsername.setText(null);
				txtPassword.setText(null);
				
				
			}
		});
		btnReset.setBounds(199, 211, 89, 23);
		frmLoginSystem.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("\u00C7\u0131k\u0131\u015F");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmLoginSystem = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit","Login Systems",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
							
				
				
			}
		});
		btnExit.setBounds(332, 211, 89, 23);
		frmLoginSystem.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(34, 185, 420, 2);
		frmLoginSystem.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(34, 36, 420, 2);
		frmLoginSystem.getContentPane().add(separator_1);
	}

	

}
