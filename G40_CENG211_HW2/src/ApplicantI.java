public class ApplicantI extends ApplicantsInfo {

    private String applicantName;

    public ApplicantI(String A, int applicantID, String applicantName){
        super(A,applicantID);
        this.applicantName = applicantName;
    }
    public ApplicantI(ApplicantI applicant){
        super(applicant.getInfoType(), applicant.getApplicantID());
        this.applicantName = new String(applicant.getApplicantName());
    }

    public String getApplicantName() {
        return new String(applicantName);
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }
}
