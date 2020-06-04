package pack2;

import java.util.Timer;
import java.util.TimerTask;

public class BallMovement2 {
	Timer tm2 = new Timer();

	public BallMovement2() {
		tm2.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				Var2.ballx += Var2.balldirx;
				Var2.bally += Var2.balldiry;

			}
		}, 0, 3);
	}

}
