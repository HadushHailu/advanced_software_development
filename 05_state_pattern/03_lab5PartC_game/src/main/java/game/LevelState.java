package game;

public abstract class LevelState {
    protected final Game game;
    LevelState(Game game){
        this.game = game;
    }
    abstract String getLevel();
    abstract void addPoints(int newPoints);
}
