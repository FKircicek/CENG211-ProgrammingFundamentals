import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		
        ArrayList<ApplicantsInfo> applicantsInfoList = Methods.createApplicantsInfoList();
        ArrayList<Applicant> applicantList = Methods.createApplicantsList(applicantsInfoList);
        applicantList = Methods.sortArrayList(Methods.checkAllAcceptance(applicantList));
        Methods.displayOutputs(applicantList);
    }
}
