package pack2;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main2{

	public static void main(String[] args) 
	{
		JMenuBar jmb = new JMenuBar();
		Var2.jf.setJMenuBar(jmb);
		
		JMenu jm = new JMenu("File");
		jmb.add(jm);
		
		JMenuItem jmi = new JMenuItem("Open...");
		jm.add(jmi);
		
		new Gui2();
		new Var2();
		new Movement2();
		new BallMovement2();
		new GegnerMovement2();
		new BallKollision2();
		
		
		
		
	}
}
