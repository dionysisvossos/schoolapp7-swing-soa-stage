package gr.aueb.cf.schoolapp.view_controller;

import gr.aueb.cf.schoolapp.Main;
import gr.aueb.cf.schoolapp.authentication.AuthenticationManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;

public class LoginPage extends JFrame {

	@Serial
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private final JTextField username;
	private final JPasswordField password;

	public LoginPage() {
		setTitle("Αυθεντικοποίηση Χρήστη");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPage.class.getResource("/images/eduv2.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 334);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Σύνδεση");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(169, 23, 60, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Παρακαλώ εισάγετε τους κωδικούς σας για να συνδεθείτε");
		lblNewLabel_1.setBounds(84, 56, 347, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Χρήστης:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(127, 99, 60, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Κωδικός:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(127, 157, 60, 29);
		contentPane.add(lblNewLabel_3);
		
		username = new JTextField();
		username.setBounds(127, 124, 197, 30);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(127, 183, 197, 30);
		contentPane.add(password);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(47, 89, 360, 1);
		contentPane.add(separator);
		
		JButton btnConnect = new JButton("Σύνδεση");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AuthenticationManager.authenticate(username.getText(), password.getPassword()))	{
					//Main.getLoginPage().setEnabled(false);
					Main.getDashboard().setVisible(true);
					Main.getLoginPage().setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null,  "Λάθος username ή password", "Αδυναμία σύνδεσης", JOptionPane.ERROR_MESSAGE);
					username.setText("");
					password.setText("");
				}
			}
		});
		btnConnect.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConnect.setBackground(new Color(0, 128, 0));
		btnConnect.setForeground(new Color(255, 255, 255));
		btnConnect.setBounds(127, 234, 197, 33);
		contentPane.add(btnConnect);
	}
}
