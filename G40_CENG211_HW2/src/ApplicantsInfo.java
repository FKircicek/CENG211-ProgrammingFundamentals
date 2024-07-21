public class ApplicantsInfo {
    private String infoType;
    private int applicantID;

    public ApplicantsInfo(String infoType, int applicantID) {
        this.infoType = infoType;
        this.applicantID = applicantID;
    }
    public ApplicantsInfo(ApplicantsInfo applicantsInfo) {
        this.infoType = getInfoType();
        this.applicantID = getApplicantID();
    }

    public String getInfoType() {
        return new String(infoType);
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public int getApplicantID() {
        return applicantID;
    }

    public void setApplicantI(int applicantI) {
        this.applicantID = applicantI;
    }
}
