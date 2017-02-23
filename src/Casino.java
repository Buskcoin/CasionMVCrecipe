import javax.swing.SwingUtilities;

public class Casino {
	public static void main(String[] args) {
		SlotMachineView view = new SlotMachineView();
		SlotMachineModel model = new SlotMachineModel();
		SlotMachineController controller = new SlotMachineController(view, model);
		view.setVisible(true);
	}
}
