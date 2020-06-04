package pack2;

import java.util.Timer;
import java.util.TimerTask;

public class GegnerMovement2 {
	Timer tm1 = new Timer();

	public GegnerMovement2() {
		tm1.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (Var2.ballx >= Var2.screenwidth / 2) {

					if (Var2.bally == Var2.gegnery) {

					}

					else if (Var2.bally > Var2.gegnery + 75) {
						if (Var2.gegnery <= Var2.screenheight - 200) {
							Var2.gegnery += 2;
						}
					}

					else if (Var2.gegnery < Var2.gegnery + 75) {
						if (Var2.gegnery >= 20) {
							Var2.gegnery -= 2;
						}
					}

				}
			}

		}, 0, 10);
	}

}
