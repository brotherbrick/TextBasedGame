package game;

import java.util.Random;

public class Setting {
	Random rand = new Random();

	private String setting;

	public void die() {
		int die = rand.nextInt(5);
		if (die == 5) {
			setting = "desert";
		} else if (die == 4) {
			setting = "forest";
		} else if (die == 3) {
			setting = "city";
		} else if (die == 2) {
			setting = "farm";
		} else if (die == 1) {
			setting = "Wal-mart";
		} else {
			setting = "jungle";
		}
	}

	public String getSetting() {
		return setting;
	}
}
