import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

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
		view.addSlotListenter(listener);
		timer = new Timer(1000 / 30, listener);

	}

	/**
	 * 
	 * @author The LEAGUE of Amazing Programmers
	 *
	 */
	class SlotMachineListener implements ActionListener, MouseMotionListener {
		double delay= 10;
		public SlotMachineListener() {

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			timer.setDelay((int) delay);
			delay=(int) timer.getDelay()*1.2;
			if(delay>1000){
				timer.stop();
				delay = 10;
				int winnings = model.getWinnings(view.getBetAmount());
				view.setWinAmount((winnings + view.getWinnings()));
				setReels();
				view.pack();
				JOptionPane.showMessageDialog(null, "lost" +view.getWinnings());
			}
			System.out.println(timer.getDelay());
			if (e.getSource() == view.getPull()) {
				delay = 10; 
				timer.start();
				model.pull();
				view.refresh();
		
				//timer.start();
			} else {
				model.pull();
				setReels();
				view.refresh();
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

		@Override
		public void mouseDragged(MouseEvent e) {
			timer.start();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
