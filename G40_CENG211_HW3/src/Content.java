public abstract class Content{
    private int arrivalDay;
    private int contentNumber;
    private int duration;
    private double averageRating;
    private double rate;
    private String name;
    public Content(int arrivalDay, int contentNumber,String name, int duration, double averageRating) {
        this.arrivalDay = arrivalDay;
        this.contentNumber = contentNumber;
        this.name = name;
        this.duration = duration;
        this.averageRating = averageRating;
        this.rate = 0;
    }
    public int getArrivalDay() {
        return arrivalDay;
    }

    public void setArrivalDay(int arrivalDay) {
        this.arrivalDay = arrivalDay;
    }

    public int getContentNumber() {
        return contentNumber;
    }

    public void setContentNumber(int contentNumber) {
        this.contentNumber = contentNumber;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rating) {
        this.rate = rating;
    }
    
}
