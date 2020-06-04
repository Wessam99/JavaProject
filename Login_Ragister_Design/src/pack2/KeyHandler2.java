package pack2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class KeyHandler2 implements KeyListener
{

	@Override
	public void keyPressed(KeyEvent e) 
	{
	
		if(e.getKeyCode()== KeyEvent.VK_S)
		{
			JOptionPane.showMessageDialog(null, "Deine Punkte: " + Var2.playerPoints + ", Gegner Punkte: " + Var2.gegnerPoints);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			JOptionPane.showMessageDialog(null, "Exit!");
			System.exit(0);
			
		}
		
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			Var2.close = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP) 
		{
			Var2.moveup = true;
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) 
		{
			Var2.movedown = true;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_UP) 
		{
			Var2.moveup = false;
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) 
		{
			Var2.movedown = false;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

}
