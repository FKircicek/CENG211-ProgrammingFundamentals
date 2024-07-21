public class MovieCritic extends Critic{
    private Movie theMovie;
    public MovieCritic(double opinion,String criticType,int criticNumber) {
        super(opinion,criticType,criticNumber);
        setLimit(1);
        theMovie = null;

    }
    public MovieCritic(MovieCritic theMovieCritic){
        super(theMovieCritic.getOpinion(),theMovieCritic.getCriticType(),theMovieCritic.getCriticNumber());
        setLimit(theMovieCritic.getLimit());
        setTheMovie(theMovieCritic.getTheMovie());
    }

    @Override
    void resetLimit() {
        setLimit(1);
    }

    @Override
    public void rating() {
        theMovie.setRate(theMovie.getAverageRating()+((theMovie.getDuration()-150)*0.1)-((2021-theMovie.getYear())*0.1)+getOpinion());
    }

    public Movie getTheMovie() {
        return theMovie;
    }

    public void setTheMovie(Movie theMovie) {
        this.theMovie = theMovie;
    }
}
