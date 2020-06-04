package pack2;

import java.util.Timer;
import java.util.TimerTask;

public class BallKollision2 
{
	
	Timer tm3 = new Timer();
	
	public BallKollision2() 
	{
		tm3.scheduleAtFixedRate(new TimerTask() 
		{

			@Override
			public void run() 
			{
				
				
				if (Var2.bally + 50 >= Var2.screenheight)
				{
					Var2.balldiry = -1;
				}
				
				if (Var2.bally <= 0)
				{
					Var2.balldiry = 1;
				}
				
				if (Var2.ballx + 20 >= Var2.screenwidth) 
				{
					Var2.ballx = Var2.screenwidth / 2 - 10;
					Var2.bally = Var2.screenheight / 2 - 10;
					
					Var2.balldirx = -1;
					Var2.playerPoints = +1;
				}
				
				if (Var2.ballx <= 0)
				{
					Var2.ballx = Var2.screenwidth / 2 - 10;
					Var2.bally = Var2.screenheight / 2 - 10;
					
					Var2.balldirx = 1;
					Var2.gegnerPoints += 1;
				}
				
				if (Var2.ballx < Var2.x + 25 && Var2.ballx > Var2.x && Var2.bally - 20 < Var2.y + 150 && Var2.bally > Var2.y) {

					Var2.balldirx = 1;
				}

				if (Var2.ballx < Var2.gegnerx && Var2.ballx > Var2.gegnerx - 20 && Var2.bally - 20 < Var2.gegnery + 150
						&& Var2.bally > Var2.gegnery) {

					Var2.balldirx = -1;
				}
				
			}
			
		}, 0, 6);
	}

}
