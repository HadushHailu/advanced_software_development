package game;

public class Level1 extends LevelState{
    private final String level = "LEVEL-1";
    Level1(Game game){
        super(game);
    }

    @Override
    public String getLevel(){
        return this.level;
    }
    public void checkForUpgrade(){
        if(game.getTotalPoints() > 10){
            LevelState newState = new Level2(game);
            game.setLevelState(newState);
            this.addBonusPoints();
        }
    }

    private void addBonusPoints(){
        game.setTotalPoints(game.getTotalPoints() + 1);
    }

    @Override
    public void addPoints(int newPoints){
        game.setTotalPoints(game.getTotalPoints() + newPoints);
        this.checkForUpgrade();
    }

}
