import java.util.ArrayList;

public class Applicant {
    private ApplicantI applicantI;
    private Passport passport;
    private Photo photo;
    private FinancialStatus financialStatus;
    private ArrayList<Document> documents;
    private int applicantID;
    private String acceptance;
    private String reason;
    private String applicantType;
    private String visaDuration;

    public Applicant(ApplicantI applicantI, Passport passport, Photo photo, FinancialStatus financialStatus,int applicantID) {
        this.applicantI = applicantI;
        this.passport = passport;
        this.photo = photo;
        this.financialStatus = financialStatus;
        this.documents = new ArrayList<>();
        this.acceptance = null;
        this.reason = null;
        this.applicantID = applicantID;
        this.visaDuration = null;
        if(applicantID/10000== 11){
            this.applicantType = "tourist";
        }
        else if(applicantID/10000== 23){
            this.applicantType = "worker";
        }
        else if(applicantID/10000== 25){
            this.applicantType = "educational";
        }
        else {
            this.applicantType = "immigrant";
        }

    }

    public Applicant(Applicant applicant) {
        this.applicantI = applicant.getApplicantI();
        this.passport = applicant.getPassport();
        this.photo = applicant.getPhoto();
        this.financialStatus = applicant.getFinancialStatus();
        this.documents = applicant.getDocuments();
        this.applicantID = applicant.getApplicantID();
        this.acceptance = applicant.getAcceptance();
        this.reason = applicant.getReason();
        this.applicantType = applicant.getApplicantType();
        this.visaDuration = applicant.getVisaDuration();

    }
    public ApplicantI getApplicantI() {
        return new ApplicantI(applicantI);
    }

    public void setApplicantI(ApplicantI applicantI) {
        this.applicantI = applicantI;
    }

    public Passport getPassport() {
        if (passport != null){
            return new Passport(passport);
        }
        else{
            return null;
        }
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Photo getPhoto() {
        if (photo != null){
            return new Photo(photo);
        }
        else{
            return null;
        }
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public FinancialStatus getFinancialStatus() {
        if (financialStatus != null){
            return new FinancialStatus(financialStatus);
        }
        else{
            return null;
        }
    }

    public void setFinancialStatus(FinancialStatus financialStatus) {
        this.financialStatus = financialStatus;
    }

    public ArrayList<Document> getDocuments() {
        ArrayList<Document> temp = new ArrayList<>();
        for (Document i : documents){
            temp.add(new Document(i));
        }
        return temp;
    }

    public void setDocuments(ArrayList<Document> documents) {
        this.documents = documents;
    }

    public int getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(int applicantID) {
        this.applicantID = applicantID;
    }

    public String getAcceptance() {

        if (acceptance != null){
            return new String(acceptance);
        }
        else{
            return null;
        }
    }

    public void setAcceptance(String acceptance) {
        this.acceptance = acceptance;
    }

    public String getReason() {
        if (reason != null){
            return new String(reason);
        }
        else{
            return null;
        }
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getApplicantType() {
        if (applicantType != null){
            return new String(applicantType);
        }
        else{
            return null;
        }
    }

    public void setApplicantType(String applicantType) {
        this.applicantType = applicantType;
    }

    public String getVisaDuration() {
        if (visaDuration != null){
            return new String(visaDuration);
        }
        else{
            return null;
        }
    }

    public void setVisaDuration(String visaDuration) {
        this.visaDuration = visaDuration;
    }
}
