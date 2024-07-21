public class Movie extends Content {
    private int year;
    public Movie(int arrivalDay, int contentNumber,String name, int year, int duration, double averageRating) {
        super(arrivalDay,contentNumber,name,duration,averageRating);
        this.year = year;
    }
    public Movie(Movie theMovie){
        super(theMovie.getArrivalDay(),theMovie.getContentNumber(),theMovie.getName(),theMovie.getDuration(),theMovie.getAverageRating());
        this.year = theMovie.getYear();
    }
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
