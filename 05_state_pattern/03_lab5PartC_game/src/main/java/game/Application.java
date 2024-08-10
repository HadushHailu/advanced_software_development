package game;

public class Application {

	public static void main(String[] args) {
		Game game = new Game();
		LevelState levelState = new Level1(game);
		game.setLevelState(levelState);

		game.play();
		game.play();
		game.play();
		game.play();
		game.play();

	}

}
