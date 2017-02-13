import java.util.Random;

public class SlotMachineModel {
	final String[] image = { "cherries", "7", "Bar" };
	String[] reels;

	void pull() {
		reels = new String[] { getRandomString(), getRandomString(), getRandomString() };
	}

	String[] getReels() {
		return reels;
	}

	private String getRandomString() {
		return image[new Random().nextInt(image.length)];
	}

	public int getWinnings(int betAmount) {
		int multiplier = 5;
		return betAmount * multiplier;
	}
}
