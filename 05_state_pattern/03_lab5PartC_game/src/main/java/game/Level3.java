package game;

public class Level3 extends LevelState{
    private final String level = "LEVEL-3";
    Level3(Game game){
        super(game);
    }

    @Override
    public String getLevel(){
        return this.level;
    }

    private void addBonusPoints(){
        game.setTotalPoints(game.getTotalPoints() + 2);
    }

    @Override
    public void addPoints(int newPoints){
        game.setTotalPoints(game.getTotalPoints() + 3 * newPoints);
    }
}
