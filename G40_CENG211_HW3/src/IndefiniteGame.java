public class IndefiniteGame extends Game{
    public IndefiniteGame(int arrivalDay, int contentNumber, String name, int duration, double averageRating) {
        super(arrivalDay, contentNumber, name, duration, averageRating);
        setLeftDuration(4);
    }
    public IndefiniteGame(IndefiniteGame theIndefiniteGame){
        super(theIndefiniteGame.getArrivalDay(),theIndefiniteGame.getContentNumber(),theIndefiniteGame.getName(),theIndefiniteGame.getDuration(),theIndefiniteGame.getAverageRating());
        setRate(theIndefiniteGame.getRate());
        setLeftDuration(4);
    }
}
