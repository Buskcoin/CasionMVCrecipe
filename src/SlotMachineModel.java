
public class SlotMachineModel {
	private String reel1;
	private String reel2;
	private String reel3;
	void pull() {
		reel1 = getRandomString();
		reel2 = getRandomString();
		reel3 = getRandomString();
	}

	private String getRandomString() {
		float f = (float) Math.random();
		if (f < .20) {
			return "cherries";
		} else if (f < .50) {
			return "lemon";
		} else if (f < .75) {
			return "bar";
		} else {
			return "bar";
		}
	}

	public int getWinnings(int betAmount) {
		int multiplier = calulateMultiplier();
		return betAmount * multiplier;
	}

	private int calulateMultiplier() {
		if (reel1.equals(reel2) && reel2.equals(reel3)) {
			return 2;
		} else if (reel1.equals(reel2)) {
			return 1;
		}
		return -1;
	}

	public String getReel1() {
		return reel1;
	}

	public String getReel2() {
		return reel2;
	}

	public String getReel3() {
		return reel3;
	}
}
