public class Passport extends ApplicantsInfo {

    private String passportNumber;
    private String expirationDate;

    public Passport(String S,int applicantID, String passportNumber, String expirationDate){
        super(S,applicantID);
        this.passportNumber = passportNumber;
        this.expirationDate = expirationDate;

    }
    public Passport(Passport passport){
        super(passport.getInfoType(),passport.getApplicantID());
        this.passportNumber = passport.getPassportNumber();
        this.expirationDate = passport.getExpirationDate();
    }


    public String getPassportNumber() {
        return new String(passportNumber);
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getExpirationDate() {
        return new String(expirationDate);
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
