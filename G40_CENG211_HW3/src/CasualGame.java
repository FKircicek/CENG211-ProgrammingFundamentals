public class CasualGame extends Game{
    public CasualGame(int arrivalDay, int contentNumber, String name, int duration, double averageRating) {
        super(arrivalDay, contentNumber, name, duration, averageRating);
        setLeftDuration(duration*3);
    }
    public CasualGame(CasualGame theCasualGame){
        super(theCasualGame.getArrivalDay(),theCasualGame.getContentNumber(),theCasualGame.getName(),theCasualGame.getDuration(),theCasualGame.getAverageRating());
        setRate(theCasualGame.getRate());
        setLeftDuration(theCasualGame.getLeftDuration()*3);
    }
}
