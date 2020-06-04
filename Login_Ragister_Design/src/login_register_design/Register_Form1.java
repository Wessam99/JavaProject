package login_register_design;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Register_Form1 {

	String image_path = null;

	JFrame frame;

	JPanel pTitle;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;

	JLabel minimizeLbl;
	JLabel exitLbl;
	JLabel lTitle;
	JLabel lName;
	JLabel lUser;
	JLabel lPassword;
	JLabel lConPassword;
	JLabel lPhone;
	JLabel lGender;
	JLabel lImage;
	JLabel lPath;
	JLabel lLogin;

	JTextField tfName;
	JTextField tfUser;
	JTextField tfPhone;

	JPasswordField tfPassword;
	JPasswordField tfConPassword;

	JRadioButton rbMale;
	JRadioButton rbFemale;

	JButton bRegister;
	JButton bImage;

	ButtonGroup bg;

	Border fields_border;
	Border lMin_border;
	Border lExit_border;
	Border title_border;
	Border label_border;

	public Register_Form1() {
		frame = new JFrame();

		lMin_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		minimizeLbl = new JLabel(" -");
		minimizeLbl.setBounds(475, 10, 20, 25);
		minimizeLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		minimizeLbl.setForeground(Color.black);
		minimizeLbl.setBorder(lMin_border);
		minimizeLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
		minimizeLbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				lMin_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
				minimizeLbl.setBorder(lMin_border);
				minimizeLbl.setForeground(Color.white);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lMin_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY);
				minimizeLbl.setBorder(lMin_border);
				minimizeLbl.setForeground(Color.black);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lMin_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray);
				minimizeLbl.setBorder(lMin_border);
				minimizeLbl.setForeground(Color.lightGray);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);

			}
		});
		frame.getContentPane().add(minimizeLbl);

		exitLbl = new JLabel(" X ");
		lExit_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		exitLbl.setBounds(505, 10, 24, 25);
		exitLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		exitLbl.setForeground(Color.black);
		exitLbl.setBorder(lExit_border);
		exitLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exitLbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				lExit_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
				exitLbl.setBorder(lExit_border);
				exitLbl.setForeground(Color.red);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lExit_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray);
				exitLbl.setBorder(lExit_border);
				exitLbl.setForeground(Color.black);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lExit_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray);
				exitLbl.setBorder(lExit_border);
				exitLbl.setForeground(Color.lightGray);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);

			}
		});
		frame.getContentPane().add(exitLbl);

		lTitle = new JLabel(" Register");
		title_border = BorderFactory.createMatteBorder(0, 1, 1, 1, Color.yellow);
		lTitle.setBounds(190, 5, 175, 60);
		lTitle.setFont(new Font("Arail", Font.BOLD, 38));
		lTitle.setForeground(Color.white);
		lTitle.setBorder(title_border);
		frame.getContentPane().add(lTitle);

		lName = new JLabel("Full Name: ");
		lName.setFont(new Font("Arail", Font.PLAIN, 18));
		lName.setBounds(95, 150, 100, 30);
		frame.getContentPane().add(lName);

		lUser = new JLabel("User Name: ");
		lUser.setFont(new Font("Arail", Font.PLAIN, 18));
		lUser.setBounds(86, 200, 110, 30);
		frame.getContentPane().add(lUser);

		lPassword = new JLabel("Password: ");
		lPassword.setBounds(98, 250, 98, 30);
		lPassword.setFont(new Font("Arail", Font.PLAIN, 18));
		frame.getContentPane().add(lPassword);

		lConPassword = new JLabel("Confirm Password: ");
		lConPassword.setBounds(30, 300, 160, 30);
		lConPassword.setFont(new Font("Arail", Font.PLAIN, 18));
		frame.getContentPane().add(lConPassword);

		lPhone = new JLabel("Phone: ");
		lPhone.setFont(new Font("Arail", Font.PLAIN, 18));
		lPhone.setBounds(125, 350, 100, 30);
		frame.getContentPane().add(lPhone);

		lGender = new JLabel("Gender: ");
		lGender.setFont(new Font("Arail", Font.PLAIN, 18));
		lGender.setBounds(117, 400, 100, 30);
		frame.getContentPane().add(lGender);

		lImage = new JLabel("Image: ");
		lImage.setFont(new Font("Arail", Font.PLAIN, 18));
		lImage.setBounds(110, 450, 100, 30);
		frame.getContentPane().add(lImage);

		lPath = new JLabel("image path");
		lPath.setFont(new Font("Sylfaen", Font.PLAIN, 11));
		lPath.setBounds(295, 460, 200, 20);
		frame.getContentPane().add(lPath);

		label_border = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 204, 0));
		lLogin = new JLabel(">> Already Have an Account? Login!");
		lLogin.setBounds(145, 550, 240, 30);
		lLogin.setBorder(label_border);
		lLogin.setFont(new Font("Arial", Font.PLAIN, 14));
		lLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lLogin.setForeground(new Color(0, 204, 0));
		lLogin.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				lLogin.setForeground(Color.gray);
				Border label_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray);
				lLogin.setBorder(label_border);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 204, 0));
				lLogin.setBorder(label_border);
				lLogin.setForeground(new Color(0, 204, 0));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.green);
				lLogin.setBorder(label_border);
				lLogin.setForeground(Color.GREEN);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Login_Form lf = new Login_Form();
				lf.frame.setVisible(true);
				frame.pack();
				lf.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		frame.getContentPane().add(lLogin);

		fields_border = BorderFactory.createMatteBorder(1, 5, 1, 1, Color.white);

		tfName = new JTextField();
		tfName.setBounds(185, 150, 300, 30);
		tfName.setFont(new Font("Arail", Font.PLAIN, 18));
//			tfName.setForeground(new Color(153, 153, 153, 153));
		tfName.setBorder(fields_border);
		frame.getContentPane().add(tfName);

		tfUser = new JTextField();
		tfUser.setBounds(185, 200, 300, 30);
//			tfUser.setText("username");
		tfUser.setFont(new Font("Arail", Font.PLAIN, 18));
//			tfUser.setForeground(new Color(153, 153, 153, 153));
		tfUser.setBorder(fields_border);
//			tfUser.addFocusListener(new FocusListener() {
//
//				@Override
//				public void focusLost(FocusEvent e) {
//					if (tfUser.getText().trim().equals("") || tfName.getText().trim().toLowerCase().equals("username")) {
//						tfUser.setText("username");
//						tfUser.setForeground(new Color(153, 153, 153));
//					}
//					lUser.setBorder(null);
//				}
//
//				@Override
//				public void focusGained(FocusEvent e) {
//					if (tfUser.getText().trim().toLowerCase().equals("username")) {
//						tfUser.setText("");
//						tfUser.setForeground(Color.BLACK);
//					}
//					Border fields_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray);
//					lUser.setBorder(fields_border);
//
//				}
//			});
		frame.getContentPane().add(tfUser);

		tfPassword = new JPasswordField();
		tfPassword.setBounds(185, 250, 300, 30);
//			tfPassword.setText("password");
		tfPassword.setFont(new Font("Arail", Font.PLAIN, 18));
//			tfPassword.setForeground(new Color(153, 153, 153, 153));
		tfPassword.setBorder(fields_border);
//			tfPassword.addFocusListener(new FocusListener() {
//
//				@Override
//				public void focusLost(FocusEvent e) {
//					String pass = String.valueOf(tfPassword.getPassword());
//					if (pass.trim().equals("") || pass.trim().toLowerCase().equals("password")) {
//						tfPassword.setText("password");
//						tfPassword.setForeground(new Color(153, 153, 153));
//					}
//					lPassword.setBorder(null);
//
//				}
//
//				@Override
//				public void focusGained(FocusEvent e) {
//					String pass = String.valueOf(tfPassword.getPassword());
//					if (pass.trim().toLowerCase().equals("password")) {
//						tfPassword.setText("");
//						tfPassword.setForeground(Color.BLACK);
//					}
//					Border fields_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray);
//					lPassword.setBorder(fields_border);
//
//				}
//			});
		frame.getContentPane().add(tfPassword);

		tfConPassword = new JPasswordField();
		tfConPassword.setBounds(185, 300, 300, 30);
//			tfConPassword.setText("password");
		tfConPassword.setFont(new Font("Arail", Font.PLAIN, 18));
//			tfConPassword.setForeground(new Color(153, 153, 153, 153));
		tfConPassword.setBorder(fields_border);
		frame.getContentPane().add(tfConPassword);

		tfPhone = new JTextField();
		tfPhone.setBounds(185, 350, 300, 30);
		tfPhone.setFont(new Font("Arail", Font.PLAIN, 18));
		tfPhone.setBorder(fields_border);
		tfPhone.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		frame.getContentPane().add(tfPhone);

		rbMale = new JRadioButton("Male");
		rbMale.setBounds(200, 400, 55, 30);
		rbMale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbMale.setBackground(Color.lightGray);
		rbMale.setSelected(true);
		frame.getContentPane().add(rbMale);

		rbFemale = new JRadioButton("Female");
		rbFemale.setBounds(260, 400, 95, 30);
		rbFemale.setBackground(Color.lightGray);
		frame.getContentPane().add(rbFemale);

		bg = new ButtonGroup();
		bg.add(rbMale);
		bg.add(rbFemale);

		bRegister = new JButton("Register");
		bRegister.setBounds(30, 500, 475, 50);
		bRegister.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
		bRegister.setBackground(new Color(235, 47, 6));
		bRegister.setForeground(new Color(255, 255, 255));
		bRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bRegister.addActionListener(e -> {
			String fname = tfName.getText();
			String uname = tfUser.getText();
			String phone = tfPhone.getText();
			String pass1 = String.valueOf(tfPassword.getPassword());
			StringBuffer sb = null;
			try {
				MessageDigest mDigest = MessageDigest.getInstance("SHA1");
				byte[] result = mDigest.digest(pass1.getBytes());
				sb = new StringBuffer();
				for (int i = 0; i < result.length; i++) {
					sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
				}
			} catch (NoSuchAlgorithmException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			String pass2 = String.valueOf(tfConPassword.getPassword());
			String gender = "Male";

			if (rbFemale.isSelected()) {
				gender = "Female";
			}

			if (verifyFields()) {
				if (!checkUsername(uname)) {
					PreparedStatement ps;
					ResultSet rs;

					String registerUserQuery = "INSERT INTO `users`(`full_name`, `username`, `password`, `phone`, `gender`, `picture`) VALUES (?,?,?,?,?,?)";

					try {
						ps = My_CNX.getConnection().prepareStatement(registerUserQuery);
						ps.setString(1, fname);
						ps.setString(2, uname);
//							ps.setString(3, pass1);
						ps.setString(3, sb.toString());
						ps.setString(4, phone);
						ps.setString(5, gender);

						try {
							if (image_path != null) {
								InputStream image = new FileInputStream(new File(image_path));
								ps.setBlob(6, image);
							} else {
								ps.setNull(6, Types.NULL);
							}

							if (ps.executeUpdate() != 0) {
								JOptionPane.showMessageDialog(null, "Your Account  Has Been Created");
							} else {
								JOptionPane.showMessageDialog(null, "Error: Check Your Information");
							}
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
//			bRegister.addActionListener(e -> {
//				PreparedStatement st;
//				ResultSet rs;
//
//				String username = tfName.getText();
//				String passwort = String.valueOf(tfPassword.getPassword());
//
//				String query = "SELECT * FROM `users` WHERE `username` = ? AND `password` = ?";
//
//				try {
//					st = My_CNX.getConnection().prepareStatement(query);
//
//					st.setString(1, username);
//					st.setString(2, passwort);
//					rs = st.executeQuery();
//
//					if (rs.next()) {
//						JOptionPane.showMessageDialog(null, "OK", "Login successfully", JOptionPane.INFORMATION_MESSAGE);
//					} else {
//						JOptionPane.showMessageDialog(null, "Invalid Username / Password", "Login Error", 2);
//					}
//
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//
//			});
		bRegister.addMouseListener(new MouseListener() {

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
				bRegister.setBackground(new Color(235, 47, 6));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				bRegister.setBackground(new Color(225, 20, 2));
				bRegister.setBorder(null);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		frame.getContentPane().add(bRegister);

		bImage = new JButton("select image");
		bImage.setBounds(170, 455, 120, 25);
		bImage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bImage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String path = null;
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File(System.getProperty("user.home")));

				FileNameExtensionFilter extension = new FileNameExtensionFilter("*Images", "jpg", "png", "jpeg");
				chooser.addChoosableFileFilter(extension);

				int filestate = chooser.showSaveDialog(null);

				if (filestate == JFileChooser.APPROVE_OPTION) {
					File selectedImage = chooser.getSelectedFile();
					path = selectedImage.getAbsolutePath();
					lPath.setText(path);
					image_path = path;
				}
			}
		});
		frame.getContentPane().add(bImage);

		pTitle = new JPanel();
		pTitle.setBackground(new Color(0, 84, 140));
		pTitle.setBounds(190, 5, 175, 60);
		pTitle.setVisible(true);
		frame.getContentPane().add(pTitle);

		panel2 = new JPanel();
		panel2.setBackground(Color.gray);
		panel2.setBounds(5, 5, 532, 95);
		panel2.setVisible(true);
		frame.getContentPane().add(panel2);

		panel3 = new JPanel();
		panel3.setBackground(Color.lightGray);
		panel3.setBounds(5, 90, 532, 504);
		panel3.setVisible(true);
		frame.getContentPane().add(panel3);

		panel1 = new JPanel();
		panel1.setBackground(Color.yellow);
		panel1.setSize(542, 600);
		panel1.setVisible(true);
		Border panel_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange);
		panel1.setBorder(panel_border);
		frame.getContentPane().add(panel1);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setUndecorated(true);
//				frame.setSize(461,352);
		frame.setSize(542, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public boolean verifyFields() {
		String fname = tfName.getText();
		String uname = tfUser.getText();
		String phone = tfPhone.getText();
		String pass1 = String.valueOf(tfPassword.getPassword());

		StringBuffer sb = null;
		try {
			MessageDigest mDigest = MessageDigest.getInstance("SHA1");
			byte[] result = mDigest.digest(pass1.getBytes());
			sb = new StringBuffer();
			for (int i = 0; i < result.length; i++) {
				sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch (NoSuchAlgorithmException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		String pass2 = String.valueOf(tfConPassword.getPassword());

		StringBuffer sb2 = null;
		try {
			MessageDigest mDigest = MessageDigest.getInstance("SHA1");
			byte[] result = mDigest.digest(pass2.getBytes());
			sb2 = new StringBuffer();
			for (int i = 0; i < result.length; i++) {
				sb2.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch (NoSuchAlgorithmException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		if (fname.trim().equals("") || uname.trim().equals("") || phone.trim().equals("")
				|| sb.toString().trim().equals("") || sb2.toString().trim().equals("")) {

			JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty", "Empty Fields", 2);
			return false;
		} else if (!sb.toString().equals(sb2.toString())) {
			JOptionPane.showMessageDialog(null, "Password Doesn't Match", "Confirm Password", 2);
			return false;
		} else {
			return true;
		}
	}

	public boolean checkUsername(String username) {
		PreparedStatement st;
		ResultSet rs;

		boolean username_exist = false;

		String query = "SELECT * FROM `users` WHERE `username` = ?";

		try {
			st = My_CNX.getConnection().prepareStatement(query);
			st.setString(1, username);
			rs = st.executeQuery();

			if (rs.next()) {
				username_exist = true;
				JOptionPane.showMessageDialog(null, "This Username is Already Taken, Choose Another One",
						"Username Failed", 2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return username_exist;
	}

}
