import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SlotMachineView extends JFrame {
	// Intialize components.
	JPanel panel = new JPanel();
	JPanel gamblePanel = new JPanel();
	JButton pull = new JButton("PULL");
	JLabel reel1 = new JLabel();
	JLabel reel2 = new JLabel();
	JLabel reel3 = new JLabel();
	JLabel winnings = new JLabel("Winnings", JLabel.CENTER);
	JLabel betLabel = new JLabel("Bet Amount", JLabel.LEFT);
	JLabel winAmount = new JLabel("0", JLabel.CENTER);
	JLabel totalMoney = new JLabel("0", JLabel.CENTER);
	JTextField bet = new JTextField(2);
	ImageIcon CHERRIES = new ImageIcon("cherries.png");
	ImageIcon SEVEN = new ImageIcon("seven.png");
	ImageIcon BAR = new ImageIcon("bar.png");
	ImageIcon LEMON = new ImageIcon("lemon.png");
	ImageIcon SPACE = new ImageIcon("space.png");
	int scroll = 0;
	public SlotMachineView() {
		this.setLayout(new GridLayout(2, 1));
		add(gamblePanel);
		this.add(panel);
		panel.add(reel1);
		panel.add(reel2);
		panel.add(reel3);
		panel.add(pull);
		gamblePanel.add(totalMoney);
		gamblePanel.add(betLabel);
		gamblePanel.add(bet);
		gamblePanel.add(winnings);
		gamblePanel.add(winAmount);
		String a = JOptionPane.showInputDialog("How Much money do you have?");
		totalMoney.setText("$" + a);
		panel.setLayout(new GridLayout(1, 3));
		pack();
	}

	void setReel1(String symbol) {
		//this.reel1.setText(symbol);
		this.reel1.setIcon(getIcon(symbol));
	}
	
	void scrollReels(){
		if(scroll < 256)
			scroll++;
			else{
				scroll = 0;
			}
			reel1.setBounds(0, scroll, 256,256); 
		    reel1.setIcon(reel1.getIcon());
			reel2.setBounds(0, scroll*2, 256,256); 
			reel3.setBounds(0, scroll*3, 256,256); 
	}

	private ImageIcon getIcon(String iconName) {
		if (iconName != null) {
			switch (iconName) {
			case "cherries":
				return CHERRIES;
			case "lemon":
				return LEMON;
			case "bar":
				return BAR;
			case "seven":
				return SEVEN;
			default:
				return SPACE;
			}
		} else
			return null;
	}

	void setReel2(String symbol) {
		// this.reel2.setText(symbol);
		this.reel2.setIcon(getIcon(symbol));
	}

	void setReel3(String symbol) {
		// this.reel3.setText(symbol);
		this.reel3.setIcon(getIcon(symbol));
	}

	int getBetAmount() {
		return Integer.parseInt(bet.getText());
	}

	void refresh() {
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

	void setWinAmount(int winnings) {
		winAmount.setText("" + winnings);
	}

	public int getWinnings() {
		return Integer.parseInt(winAmount.getText());
	}

	public JButton getPull() {
		return pull;
	}
}
