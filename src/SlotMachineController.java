import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlotMachineController {
	private SlotMachineView view;
	private SlotMachineModel model;
    public SlotMachineController(SlotMachineView view, SlotMachineModel model) {
    	this.view = view;
    	this.model = model;
    	view.addSlotListenter(new SlotMachineListener());
    }
    
    class SlotMachineListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			model.pull();
			String[] results = model.getReels();
			view.setReel1(results[0]);
			view.setReel2(results[1]);
			view.setReel3(results[2]);
			view.refresh();
			int winnings = model.getWinnings(view.getBetAmount());
			
				System.out.println();
				System.out.println(view.getReel2().getText());

				System.out.println(view.getReel3().getText());

		}	
    	
    }
}
