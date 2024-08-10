package game;

import java.util.Random;

public class Game {
	private int totalPoints = 0;
	private LevelState levelState;

	public void play() {
		Random random = new Random();
		int pt = random.nextInt(7);
		levelState.addPoints(pt);
		System.out.println("new point="+pt+" total points="+totalPoints+" level="+levelState.getLevel());
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setLevelState(LevelState levelState) {
		this.levelState = levelState;
	}
}
