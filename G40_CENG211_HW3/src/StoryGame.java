public class StoryGame extends Game{
    public StoryGame(int arrivalDay, int contentNumber, String name, int duration, double averageRating) {
        super(arrivalDay, contentNumber, name, duration, averageRating);
        setLeftDuration(duration);
    }
    public StoryGame(StoryGame theStoryGame){
        super(theStoryGame.getArrivalDay(),theStoryGame.getContentNumber(),theStoryGame.getName(),theStoryGame.getDuration(),theStoryGame.getAverageRating());
        setRate(theStoryGame.getRate());
        setLeftDuration(theStoryGame.getLeftDuration());
    }

}
