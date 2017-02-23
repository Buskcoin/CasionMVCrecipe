import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class SlotMachineController {
	private SlotMachineView view;
	private SlotMachineModel model;
	private SlotMachineListener listener;
	public Timer timer;

	public SlotMachineController(SlotMachineView view, SlotMachineModel model) {
		this.view = view;
		this.model = model;
		listener = new SlotMachineListener();
		timer = new Timer(1000 / 30, listener);
		view.addSlotListenter(listener);
		view.pack();
	}

	/**
	 * 
	 * @author The LEAGUE of Amazing Programmers
	 *
	 */
	class SlotMachineListener implements ActionListener {
		int delay = 10;

		public SlotMachineListener() {

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			timer.setDelay(delay);
			delay *= 1.2;
			model.pull();
			setReels();
			if (delay > 1000) {
				delay = 1;
				timer.stop();
				int winnings = model.getWinnings(view.getBetAmount());
				view.setWinAmount((winnings));
				view.setTotalMonet((winnings + view.getTotalMoney()));
				view.pack();
			}
			System.out.println("Delay : "+timer.getDelay());
			if (e.getSource() == view.getPull()) {
				delay = new Random().nextInt(50) + 5;
				timer.start();
				view.refresh();
			} else if ((e.getSource() == view.getCashout())) {
				JOptionPane.showMessageDialog(view, "You must gamble MORE!!");
			}
		}

		/**
		 * 
		 */
		void setReels() {
			view.setReel1(model.getReel1());
			view.setReel2(model.getReel2());
			view.setReel3(model.getReel3());
		}

	}
}
