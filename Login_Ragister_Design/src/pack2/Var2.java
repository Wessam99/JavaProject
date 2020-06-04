package pack2;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Var2 extends JFrame 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static int screenwidth = 800, screenheight = 600, x = 10, y = 185, ballx = 200, bally = 200, balldirx = 1, balldiry = -1,
			   playerPoints = 0, gegnerPoints = 0, gegnerx = 760, gegnery = 185;
	
	static boolean moveup = false, movedown = false, close = false;
	
	
	public static JFrame jf = new JFrame();
	
	
	
	
	static JButton bt = new JButton("Exit");
	static JButton bt2 = new JButton("Rest");
	
	
	
	public Var2() 
	{
		
	}
	
}
