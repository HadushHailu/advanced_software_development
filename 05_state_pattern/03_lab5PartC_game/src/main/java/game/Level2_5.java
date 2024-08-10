package game;

public class Level2_5 extends LevelState{
    private final String level = "LEVEL-2_5";
    Level2_5(Game game){
        super(game);
    }

    @Override
    public String getLevel(){
        return this.level;
    }
    public void checkForUpgrade(){
        if(game.getTotalPoints() > 20){
            LevelState newState = new Level3(game);
            game.setLevelState(newState);
            this.addBonusPoints(); //GOLD bonus points
        }
    }

    private void addBonusPoints(){
        game.setTotalPoints(game.getTotalPoints() + 2);
    }

    @Override
    public void addPoints(int newPoints){
        game.setTotalPoints(game.getTotalPoints() + newPoints);
        this.checkForUpgrade();
    }
}
