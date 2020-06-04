package pack2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class Draw2 extends JLabel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, Var2.screenwidth, Var2.screenheight);
		
		
		g.setColor(Color.MAGENTA);
		
		g.fillRect(Var2.x, Var2.y, 25, 150);
		g.fillRect(Var2.gegnerx, Var2.gegnery, 25, 150);
		
		g.setColor(Color.GREEN);
		g.fillOval(Var2.ballx, Var2.bally, 15, 15);
		
		g.setColor(Color.CYAN);
		g.drawString("" + Var2.playerPoints, 300, 75);
		g.drawString("" + Var2.gegnerPoints, 500, 75);
		
		g.drawLine(400, 20, 400, 570);
		
		
		repaint();
	}
	
}
