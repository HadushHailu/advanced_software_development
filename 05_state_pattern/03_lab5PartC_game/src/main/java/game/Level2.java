package game;

public class Level2 extends LevelState{
    private final String level = "LEVEL-2";
    Level2(Game game){
        super(game);
    }

    @Override
    public String getLevel(){
        return this.level;
    }
    public void checkForUpgrade(){
        if(game.getTotalPoints() > 15){
            LevelState newState = new Level2_5(game);
            game.setLevelState(newState);
            this.addBonusPoints();
        }
    }

    private void addBonusPoints(){
        game.setTotalPoints(game.getTotalPoints() + 1);
    }

    @Override
    public void addPoints(int newPoints){
        game.setTotalPoints(game.getTotalPoints() + 2 * newPoints);
        this.checkForUpgrade();
    }
}
