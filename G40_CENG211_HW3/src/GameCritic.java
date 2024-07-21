public class GameCritic extends  Critic{
    private Game theGame;
    private int workTime;
    public GameCritic(double opinion,String criticType,int criticNumber) {
        super(opinion,criticType,criticNumber);
        setLimit(8);
        theGame = null;
        workTime = 0;
    }

    public GameCritic(GameCritic theGameGritic) {
        super(theGameGritic.getOpinion(),theGameGritic.getCriticType(),theGameGritic.getCriticNumber());
        setLimit(theGameGritic.getLimit());
        setTheGame(theGameGritic.getTheGame());
        setWorkTime(theGameGritic.getWorkTime());
    }

    @Override
    void resetLimit() {
        setLimit(8);
    }

    @Override
    public void rating() {
        if(theGame.getContentNumber() ==1) {
            theGame.setRate(theGame.getAverageRating() + ((10 - theGame.getDuration()) * 0.25) + getOpinion());
        }
        else if(theGame.getContentNumber() ==2) {
            theGame.setRate(theGame.getAverageRating() + (theGame.getDuration() * 0.25) + getOpinion());
        }
        else {
            theGame.setRate(theGame.getAverageRating() + ((theGame.getDuration()-3) * 3) + getOpinion());
        }
    }

    public Game getTheGame() {
        return theGame;
    }

    public void setTheGame(Game theGame) {
        this.theGame = theGame;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }
}
