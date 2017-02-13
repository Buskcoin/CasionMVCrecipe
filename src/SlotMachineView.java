import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SlotMachineView extends JFrame {
	// Intialize components.
	JPanel panel = new JPanel();
	JPanel gamblePanel = new JPanel();
	JButton pull = new JButton("PULL");
	JLabel reel1 = new JLabel("Space ", JLabel.CENTER);
	JLabel reel2 = new JLabel("Space", JLabel.CENTER);
	JLabel reel3 = new JLabel("Space", JLabel.CENTER);
	JLabel winnings = new JLabel("Winnings", JLabel.CENTER);
	JLabel betLabel = new JLabel("Bet Amount", JLabel.LEFT);
	JLabel winAmount = new JLabel("0", JLabel.CENTER);
	JTextField bet = new JTextField(2);



	public SlotMachineView() {
		this.setLayout(new GridLayout(2,1));
		add(gamblePanel);
		this.add(panel);
		panel.add(pull);
		panel.add(reel1);
		panel.add(reel2);
		panel.add(reel3);
		gamblePanel.add(betLabel);
		gamblePanel.add(bet);
		gamblePanel.add(winnings);
		gamblePanel.add(winAmount);
		panel.setLayout(new GridLayout(1,3));
		//gamblePanel.setLayout(new GridLayout(1,3));
		pack();
	}
	void setReel1(String symbol) {
		this.reel1.setText(symbol);
	}
	void setReel2(String symbol) {
		this.reel2.setText(symbol);
	}
	void setReel3(String symbol) {
		this.reel3.setText(symbol);
	}
	int getBetAmount(){
		return Integer.parseInt(bet.getText());
	}
	void refresh(){
		repaint();
	}
	public JLabel getReel1() {
		return reel1;
	}

	public JLabel getReel2() {
		return reel2;
	}

	public JLabel getReel3() {
		return reel3;
	}
	public void addSlotListenter(ActionListener pullListener) {
		pull.addActionListener(pullListener);
	}

}
