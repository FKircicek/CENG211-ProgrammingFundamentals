public class Document extends ApplicantsInfo {

    private String documentType;
    private int durationInMonths;

    public Document(String D,int applicantID, String  documentType, int durationInMonths){
        super(D,applicantID);
        this.documentType = documentType;
        this.durationInMonths = durationInMonths;
    }
    public Document(Document document){
        super(document.getInfoType(),document.getApplicantID());
        this.documentType = document.getDocumentType();
        this.durationInMonths = document.getDurationInMonths();
    }

    public String getDocumentType() {
        return new String(documentType);
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(int durationInMonths) {
        this.durationInMonths = durationInMonths;
    }
}
