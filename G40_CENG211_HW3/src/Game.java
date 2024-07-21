public abstract class Game extends Content{
    private int leftDuration;
    public Game(int arrivalDay, int contentNumber,String name, int duration, double averageRating){
        super(arrivalDay,contentNumber,name, duration,averageRating);
    }
    public Game(Game theGame){
        super(theGame.getArrivalDay(),theGame.getContentNumber(),theGame.getName(),theGame.getDuration(),theGame.getAverageRating());
        this.leftDuration = theGame.getLeftDuration();
    }

    public int getLeftDuration() {
        return leftDuration;
    }

    public void setLeftDuration(int leftDuration) {
        this.leftDuration = leftDuration;
    }
}
