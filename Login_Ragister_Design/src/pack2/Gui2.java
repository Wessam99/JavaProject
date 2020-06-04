package pack2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Gui2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Gui2() {

		Var2.jf = new JFrame();
		Var2.jf.setTitle("Pong");
		Var2.jf.setSize(Var2.screenwidth, Var2.screenheight);
		Var2.jf.setVisible(true);
		Var2.jf.setLocationRelativeTo(null);
		Var2.jf.setResizable(false);
		Var2.jf.setLayout(null);
		Var2.jf.requestFocus();
		Var2.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Var2.jf.addKeyListener(new KeyHandler2());

		Var2.bt.setBounds(685, 525, 100, 30);
		Var2.bt.addKeyListener(new KeyHandler2());
		Var2.bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "Exit!");
//				int e1 = JOptionPane.showConfirmDialog(null, "Exit", "Exit", JOptionPane.YES_NO_OPTION);
				int e1 = JOptionPane.showConfirmDialog(null, "Wollen Sie sicher das Fenster schlieﬂen?", "Exit",
						JOptionPane.YES_NO_OPTION);
				if (e1 == 0) {
					System.exit(0);
				}
//				Var2.playerPoints = 0;
//				Var2.gegnerPoints =0;
			}
		});

		Var2.bt2.setBounds(570, 525, 100, 30);
		Var2.bt2.addKeyListener(new KeyHandler2());
		Var2.bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Var2.playerPoints = 0;
				Var2.gegnerPoints = 0;
			}
		});

		Var2.jf.add(Var2.bt);
		Var2.jf.add(Var2.bt2);

		Draw2 d2 = new Draw2();
		d2.setBounds(0, 0, Var2.screenwidth, Var2.screenheight);
		d2.setVisible(true);
		Var2.jf.add(d2);

	}

}
