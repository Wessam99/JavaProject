package login_register_design;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import pack2.BallKollision2;
import pack2.BallMovement2;
import pack2.GegnerMovement2;
import pack2.Gui2;
import pack2.Movement2;
import pack2.Var2;

//import com.mysql.jdbc.PreparedStatement;

public class Login_Form {
	JFrame frame;
	JLabel minimizeLbl;
	JLabel exitLbl;
	JLabel loginLbl;
	JLabel usernameLbl;
	JLabel password;
	JLabel creatAcc;
	JTextField usernameTF;
	JPasswordField tfield2;
	JButton loginB;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	Border label_border;
	Border fields_border;
	Border jpanel_title_border;

	public Login_Form() {
		frame = new JFrame();

		minimizeLbl = new JLabel(" -");
		minimizeLbl.setVerticalAlignment(JLabel.TOP);
		label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		minimizeLbl.setBounds(400, 10, 20, 25);
		minimizeLbl.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		minimizeLbl.setForeground(Color.black);
//		minimierenLbl.setBorder(lebel_border);
		minimizeLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
		minimizeLbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
				minimizeLbl.setBorder(label_border);
				minimizeLbl.setForeground(Color.white);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY);
				minimizeLbl.setBorder(label_border);
				minimizeLbl.setForeground(Color.black);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray);
				minimizeLbl.setBorder(label_border);
				minimizeLbl.setForeground(Color.lightGray);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);

			}
		});
		frame.getContentPane().add(minimizeLbl);

		exitLbl = new JLabel(" X ");
		exitLbl.setBounds(425, 10, 24, 25);
		exitLbl.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		exitLbl.setForeground(Color.black);
//		exitLbl.setBorder(label_border);
		exitLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exitLbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
				exitLbl.setBorder(label_border);
				exitLbl.setForeground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray);
				exitLbl.setBorder(label_border);
				exitLbl.setForeground(Color.black);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray);
				exitLbl.setBorder(label_border);
				exitLbl.setForeground(Color.lightGray);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(exitLbl);

		loginLbl = new JLabel("  Login ");
		jpanel_title_border = BorderFactory.createMatteBorder(0, 1, 1, 1, Color.yellow);
		loginLbl.setBounds(150, 5, 150, 60);
		loginLbl.setFont(new Font("Segoe UI", Font.PLAIN, 38));
		loginLbl.setForeground(Color.white);
		loginLbl.setBorder(jpanel_title_border);
		frame.getContentPane().add(loginLbl);

		usernameLbl = new JLabel("User: ");
		usernameLbl.setFont(new Font("Segoe UI", Font.BOLD, 18));
		usernameLbl.setBounds(64, 120, 53, 30);
//		label4.setForeground(new Color(153,153,153,153));
		frame.getContentPane().add(usernameLbl);

		password = new JLabel("Password: ");
		password.setBounds(20, 170, 98, 30);
		password.setFont(new Font("Segoe UI", Font.BOLD, 18));
//		label3.setForeground(Color.white);
		frame.getContentPane().add(password);

		label_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.red);
		creatAcc = new JLabel(">> No Account? Create One! <<");
		creatAcc.setBounds(145, 290, 205, 30);
		creatAcc.setBorder(label_border);
		creatAcc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		creatAcc.setCursor(new Cursor(Cursor.HAND_CURSOR));
		creatAcc.setForeground(new Color(255, 51, 51));
		creatAcc.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				creatAcc.setForeground(Color.GRAY);
				label_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY);
				creatAcc.setBorder(label_border);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				creatAcc.setBorder(label_border);
				creatAcc.setForeground(new Color(255, 51, 51));
				label_border = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(255, 51, 51));
				creatAcc.setBorder(label_border);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				label_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.pink);
				creatAcc.setBorder(label_border);
				creatAcc.setForeground(Color.pink);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Register_Form1 rf = new Register_Form1();
				rf.frame.setVisible(true);
//				rf.frame.pack();
				rf.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		frame.getContentPane().add(creatAcc);

		fields_border = BorderFactory.createMatteBorder(1, 5, 1, 1, Color.white);
		usernameTF = new JTextField();
		usernameTF.setBounds(120, 120, 300, 30);
		usernameTF.setText("username");
		usernameTF.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		usernameTF.setForeground(new Color(153, 153, 153, 153));
		usernameTF.setBorder(fields_border);
		usernameTF.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (usernameTF.getText().trim().equals("")
						|| usernameTF.getText().trim().toLowerCase().equals("username")) {
					usernameTF.setText("username");
					usernameTF.setForeground(new Color(153, 153, 153, 153));
				}
				usernameLbl.setBorder(null);
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (usernameTF.getText().trim().toLowerCase().equals("username")) {
					usernameTF.setText("");
					usernameTF.setForeground(Color.DARK_GRAY);
				}
				label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(153, 153, 153));
				usernameLbl.setBorder(label_border);

			}
		});
		frame.getContentPane().add(usernameTF);

		tfield2 = new JPasswordField();
		tfield2.setBounds(120, 170, 300, 30);
		tfield2.setText("password");
		tfield2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		tfield2.setForeground(new Color(153, 153, 153, 153));
		tfield2.setBorder(fields_border);
		tfield2.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				String pass = String.valueOf(tfield2.getPassword());
				if (pass.trim().equals("") || pass.trim().toLowerCase().equals("password")) {
					tfield2.setText("password");
					tfield2.setForeground(new Color(153, 153, 153, 153));
				}
				password.setBorder(null);

			}

			@Override
			public void focusGained(FocusEvent e) {
				String pass = String.valueOf(tfield2.getPassword());
				if (pass.trim().toLowerCase().equals("password")) {
					tfield2.setText("");
					tfield2.setForeground(Color.BLACK);
				}
				label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(153, 153, 153));
				password.setBorder(label_border);

			}
		});
		frame.getContentPane().add(tfield2);

		loginB = new JButton("Login");
		loginB.setBounds(50, 230, 370, 50);
		loginB.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
		loginB.setBackground(new Color(0, 84, 140));
		loginB.setForeground(new Color(255, 255, 255));
		loginB.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginB.addActionListener(e -> {
			PreparedStatement st;
			ResultSet rs;

			String username = usernameTF.getText();
			String password = String.valueOf(tfield2.getPassword());
			StringBuffer sb2 = null;
			try {
				MessageDigest mDigest = MessageDigest.getInstance("SHA1");
				byte[] result = mDigest.digest(password.getBytes());
				sb2 = new StringBuffer();
				for (int i = 0; i < result.length; i++) {
					sb2.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
				}
			} catch (NoSuchAlgorithmException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			String query = "SELECT * FROM `users` WHERE `username` = ? AND `password` = ?";

			if (username.trim().equals("username")) {
				JOptionPane.showMessageDialog(null, "Enter Your Username", "Empty Username", 2);
			}

//			else if (sb2.toString().trim().equals("password")) {
			else if (password.trim().equals("password")) {
				JOptionPane.showMessageDialog(null, "Enter Your Password", "Empty Password", 2);
			} else {
				try {
					st = My_CNX.getConnection().prepareStatement(query);

					st.setString(1, username);
					st.setString(2, sb2.toString());
					rs = st.executeQuery();

					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Login successfully", "Status",
								JOptionPane.INFORMATION_MESSAGE);

//						JMenuBar jmb = new JMenuBar();
//						Var2.jf.setJMenuBar(jmb);
//
//						JMenu jm = new JMenu("File");
//						jmb.add(jm);
//
//						JMenuItem jmi = new JMenuItem("Open...");
//						jm.add(jmi);

						new Gui2();
						new Var2();
						new Movement2();
						new BallMovement2();
						new GegnerMovement2();
						new BallKollision2();

					} else {
						JOptionPane.showMessageDialog(null, "Invalid Username / Password", "Login Error", 2);
						usernameTF.setText("username");
						usernameTF.setForeground(new Color(153, 153, 153, 153));
						tfield2.setText("password");
						tfield2.setForeground(new Color(153, 153, 153, 153));

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		loginB.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				loginB.setBackground(new Color(0, 84, 104));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				loginB.setBackground(new Color(0, 101, 183));
				loginB.setBorder(null);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		frame.getContentPane().add(loginB);

		panel4 = new JPanel();
		panel4.setBackground(new Color(0, 153, 0)); // Dark_Green
		panel4.setBounds(150, 5, 150, 60);
		panel4.setVisible(true);
		frame.getContentPane().add(panel4);

		panel3 = new JPanel();
		panel3.setBackground(Color.lightGray);
		panel3.setBounds(5, 90, 448, 255);
		panel3.setVisible(true);
		frame.getContentPane().add(panel3);

		panel2 = new JPanel();
		panel2.setBackground(Color.gray);
		panel2.setBounds(5, 5, 448, 85);
		panel2.setVisible(true);
		frame.getContentPane().add(panel2);

		panel1 = new JPanel();
		panel1.setBackground(Color.yellow);
		panel1.setSize(461, 352);
		panel1.setVisible(true);
		Border panel_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange);
		panel1.setBorder(panel_border);
		frame.getContentPane().add(panel1);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setUndecorated(true);
//		frame.setSize(461,352);
		frame.setSize(461, 352);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
