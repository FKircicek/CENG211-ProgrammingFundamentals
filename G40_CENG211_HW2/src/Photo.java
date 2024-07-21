public class Photo extends ApplicantsInfo {

    private String resolution;
    private String position;

    public Photo(String P,int applicantID, String resolution, String position){
       super(P,applicantID);
        this.resolution = resolution;
        this.position = position;
    }
    public Photo(Photo photo){
       super(photo.getInfoType(),photo.getApplicantID());
        this.resolution = new String(photo.getResolution());
        this.position = new String(photo.getPosition());
    }
    public String getResolution() {
        return new String(resolution);
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getPosition() {
        return new String(position);
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
