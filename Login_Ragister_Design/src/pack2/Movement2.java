package pack2;

import java.util.Timer;
import java.util.TimerTask;

public class Movement2 
{
	Timer tm = new Timer();
	
	public Movement2()
	{
		tm.scheduleAtFixedRate(new TimerTask()
		{

			@Override
			public void run() 
			{
				if(Var2.close == true)
				{
					System.exit(0);
				}
				
				if (Var2.moveup == true)
				{
					
					if (Var2.y >= 10) 
					{
						Var2.y -=2;
					}
				}
				
				else if (Var2.movedown == true)
				{
					if (Var2.y <= 410)
					Var2.y += 2;
				}
			}
			
		}, 0, 3);
	}
}

