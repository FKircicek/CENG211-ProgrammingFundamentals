import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Methods {
    public static ArrayList<ApplicantsInfo> addApplicantInfo(ArrayList<ApplicantsInfo> applicantsInfos,String fileName,int rows){ //I read file here
        FileIO fileIO = new FileIO();

        String infoType = "";
        int applicantID = 0;

        String applicantName = "";

        String passportNumber = "";
        String expirationDate = "";

        String resolution = "";
        String position = "";

        int income = 0;
        int savings = 0;

        String documentType = "";
        int durationInMonths = 0;

        for (String j : fileIO.readValues(fileName)[rows]) {
            if (j.equals(fileIO.readValues(fileName)[rows][0])) {
                infoType = j;
            }else if (j.equals(fileIO.readValues(fileName)[rows][1])) {
                applicantID = Integer.parseInt(j);
            }else if (j.equals(fileIO.readValues(fileName)[rows][2])) {
                if (infoType.equals("A")) {
                    applicantName = j;
                }
                else if(infoType.equals("S")) {
                    passportNumber = j;
                }
                else if(infoType.equals("P")) {
                    resolution = j;
                }
                else if(infoType.equals("F")) {
                    income = Integer.parseInt(j);
                }
                else{
                    documentType = j;
                }
            }else {

                if(infoType.equals("S")) {
                    expirationDate = j;
                }
                else if(infoType.equals("P")) {
                    position = j;
                }
                else if(infoType.equals("F")) {
                    savings = Integer.parseInt(j);
                }
                else{
                    durationInMonths = Integer.parseInt(j);
                }
            }
        }
        if (infoType.equals("A")) {
            ApplicantsInfo applicantI = new ApplicantI(infoType,applicantID,applicantName);
            applicantsInfos.add(applicantI);
        }
        else if(infoType.equals("S")) {
            ApplicantsInfo passport = new Passport(infoType,applicantID,passportNumber,expirationDate);
            applicantsInfos.add(passport);
        }
        else if(infoType.equals("P")) {
            ApplicantsInfo photo = new Photo(infoType,applicantID,resolution,position);
            applicantsInfos.add(photo);
        }
        else if(infoType.equals("F")) {
            ApplicantsInfo financialStatus = new FinancialStatus(infoType,applicantID,income,savings);
            applicantsInfos.add(financialStatus);
        }
        else{
            ApplicantsInfo document = new Document(infoType,applicantID,documentType,durationInMonths);
            applicantsInfos.add(document);
        }
        return applicantsInfos;
    }
    public static ArrayList<ApplicantsInfo> createApplicantsInfoList() {
        ArrayList<ApplicantsInfo> applicantsInfos = new ArrayList<ApplicantsInfo>();
        for(int i = 0; i< 174;i++){
            addApplicantInfo(applicantsInfos,"HW2_ApplicantsInfo.csv",i);
        }
     return applicantsInfos;
    }
    public static ArrayList<Applicant> createApplicantsList(ArrayList<ApplicantsInfo> applicantsInfosList){
        ArrayList<Applicant> applicantList = new ArrayList<Applicant>();
        for(ApplicantsInfo i : applicantsInfosList){
            if(applicantList.isEmpty()){
                addApplicantToList(applicantList,i);
                continue;
            }
            int a = 0;
            for(Applicant j: applicantList) {
                if (i.getApplicantID() == j.getApplicantID()) {
                    a = 1;
                    if (i.getClass().toString().equals("class ApplicantI")) {
                        j.setApplicantI((ApplicantI) i);
                    } else if (i.getClass().toString().equals("class Passport")) {
                        j.setPassport((Passport) i);
                    } else if (i.getClass().toString().equals("class Photo")) {
                        j.setPhoto((Photo) i);
                    } else if (i.getClass().toString().toString().equals("class FinancialStatus")) {
                        j.setFinancialStatus((FinancialStatus) i);
                    } else {
                        ArrayList<Document> documents = j.getDocuments();
                        documents.add((Document) i);
                        j.setDocuments(documents);
                    }
                    break;
                }
            }
            if(a ==0) {
                addApplicantToList(applicantList,i);
            }
        }
        return applicantList;
    }
    public static ArrayList<Applicant> addApplicantToList(ArrayList<Applicant> applicantList,ApplicantsInfo i){
        if (i.getClass().toString().equals("class ApplicantI")) {
            Applicant applicant = new Applicant((ApplicantI) i, null, null, null, i.getApplicantID());
            applicantList.add(applicant);
        } else if (i.getClass().toString().equals("class Passport")) {
            Applicant applicant = new Applicant(null, (Passport) i, null, null, i.getApplicantID());
            applicantList.add(applicant);
        } else if (i.getClass().toString().equals("class Photo")) {
            Applicant applicant = new Applicant(null, null, (Photo) i, null, i.getApplicantID());
            applicantList.add(applicant);
        } else if (i.getClass().toString().equals("class Document")) {
            Applicant applicant = new Applicant(null, null, null, null, i.getApplicantID());
            ArrayList<Document> documents = new ArrayList<>();
            documents.add((Document) i);
            applicant.setDocuments(documents);
            applicantList.add(applicant);
        } else {
            Applicant applicant = new Applicant(null, null, null, (FinancialStatus) i, i.getApplicantID());
            applicantList.add(applicant);
        }
        return applicantList;
    }

    public static ArrayList<Applicant> checkAcceptance(ArrayList<Applicant> applicants,int index){
        int income = 0;
        int saving = 0;
        if(applicants.get(index).getFinancialStatus()!=null) {
           income = applicants.get(index).getFinancialStatus().getIncome();
           saving = applicants.get(index).getFinancialStatus().getSavings();
        }
        boolean checkIL = checkInvitationLetter(applicants.get(index).getDocuments());
        //Rejection Reason: Applicant does not have a passport
        if(applicants.get(index).getPassport() == null){
            applicants.get(index).setAcceptance("Rejected");
            applicants.get(index).setReason("Applicant does not have a passport");
        }
        //Rejection Reason: Passport is not valid
        else if(applicants.get(index).getPassport().getPassportNumber().charAt(0)!='P'|| applicants.get(index).getPassport().getPassportNumber().length()!=10 ||
         !(checkValidDigits(applicants.get(index).getPassport().getPassportNumber().charAt(7))) || !(checkValidDigits(applicants.get(index).getPassport().getPassportNumber().charAt(8))) ||
        !(checkValidDigits(applicants.get(index).getPassport().getPassportNumber().charAt(9))) ){
            applicants.get(index).setAcceptance("Rejected");
            applicants.get(index).setReason("Passport is not valid");
        }
        //Rejection Reason: Passport expiration date is not valid
        else if (checkExpireDate(applicants.get(index).getPassport().getExpirationDate())<6){
            applicants.get(index).setAcceptance("Rejected");
            applicants.get(index).setReason("Passport expiration date is not valid");
        }
        //Rejection Reason: Applicant does not have a photo
        else if(applicants.get(index).getPhoto() == null){
            applicants.get(index).setAcceptance("Rejected");
            applicants.get(index).setReason("Applicant does not have a photo");
        }
        //Rejection Reason: Resolution of photo is not valid
        else if (applicants.get(index).getPhoto() != null &&!(checkSquare(applicants.get(index).getPhoto().getResolution()))){
                applicants.get(index).setAcceptance("Rejected");
                applicants.get(index).setReason("Resolution of photo is not valid");
        }
        //Rejection Position in the photo is not valid
        else if(!(applicants.get(index).getPhoto().getPosition().equals("Neutral Face")) && !(applicants.get(index).getPhoto().getPosition().equals("Natural Smile"))){
            applicants.get(index).setAcceptance("Rejected");
            applicants.get(index).setReason("Position in the photo is not valid");
        }
        //Rejection Reason: Applicant does not have a financial status report
        else if (applicants.get(index).getFinancialStatus() == null){
            applicants.get(index).setAcceptance("Rejected");
            applicants.get(index).setReason("Applicant does not have a financial status report");
        }
        //Rejection Reason: Applicant does not have a stable financial status
        else if(!((applicants.get(index).getApplicantType().equals("tourist") && !(checkIL) && income >= 2000 && income < 3000 && saving > 12000) ||
                (applicants.get(index).getApplicantType().equals("tourist") && !(checkIL) && income >= 3000 && income < 4000 && saving > 6000)  ||
                (applicants.get(index).getApplicantType().equals("tourist") && !(checkIL) && income >= 4000) ||
                (applicants.get(index).getApplicantType().equals("tourist") && checkIL && income >= 1000 && income < 1500 && saving > 6000) ||
                (applicants.get(index).getApplicantType().equals("tourist") && checkIL && income >= 1500 && income < 2000 && saving > 3000) ||
                (applicants.get(index).getApplicantType().equals("tourist") && checkIL && income >= 2000) ||
                (applicants.get(index).getApplicantType().equals("worker")  && saving > 2000) ||
                (applicants.get(index).getApplicantType().equals("educational") && !(checkIL) && income >= 1000 && income < 2000 && saving > 6000)  ||
                (applicants.get(index).getApplicantType().equals("educational") && !(checkIL) && income >= 2000 && income < 3000 && saving > 3000)  ||
                (applicants.get(index).getApplicantType().equals("educational") && !(checkIL) && income >= 3000) ||
                (applicants.get(index).getApplicantType().equals("educational") && checkIL && income >= 500 && income < 1000 && saving > 3000)  ||
                (applicants.get(index).getApplicantType().equals("educational") && checkIL && income >= 1000 && income < 1500 && saving > 1500) ||
                (applicants.get(index).getApplicantType().equals("educational") && checkIL && income >= 1500) ||
                (applicants.get(index).getApplicantType().equals("immigrant") && !(checkIL) && checkGreenCard(applicants.get(index).getDocuments()) && saving > 4000)     ||
                (applicants.get(index).getApplicantType().equals("immigrant") && !(checkIL) && !(checkGreenCard(applicants.get(index).getDocuments())) && saving > 50000) ||
                (applicants.get(index).getApplicantType().equals("immigrant") && checkIL && checkGreenCard(applicants.get(index).getDocuments()) && saving > 2000)  ||
                (applicants.get(index).getApplicantType().equals("immigrant") && checkIL && !(checkGreenCard(applicants.get(index).getDocuments())) && saving > 25000))){
            applicants.get(index).setAcceptance("Rejected");
            applicants.get(index).setReason("Applicant does not have a stable financial status");
        }
        //Rejection Reason: Applicant does not have a letter of acceptance
        else if ((applicants.get(index).getApplicantType().equals("worker") || applicants.get(index).getApplicantType().equals("educational")) &&
                !(checkLA(applicants.get(index).getDocuments()))){
            applicants.get(index).setAcceptance("Rejected");
            applicants.get(index).setReason("Applicant does not have a letter of acceptance");
        }
        //Application is accepted.
        else {
            applicants.get(index).setAcceptance("Accepted");
            double DC = 0;
            if(applicants.get(index).getApplicantType().equals("tourist")){
                if(checkIL){
                    DC = ((income-2000)*6+saving)/6000;
                }
                else {
                    DC = ((income - 2000) * 6 + saving)/12000;
                }
                if(DC>=1 && DC <2){
                    applicants.get(index).setVisaDuration("6 months");
                }
                else if(DC>=2 && DC <4){
                    if(checkExpireDate(applicants.get(index).getPassport().getExpirationDate())<12){
                        applicants.get(index).setVisaDuration("6 months");
                    }
                    else{
                        applicants.get(index).setVisaDuration("1 years");
                    }
                }
                else{
                    if(checkExpireDate(applicants.get(index).getPassport().getExpirationDate())<12){
                        applicants.get(index).setVisaDuration("6 months");
                    }
                    else if(checkExpireDate(applicants.get(index).getPassport().getExpirationDate())>=12&&checkExpireDate(applicants.get(index).getPassport().getExpirationDate())<24){
                        applicants.get(index).setVisaDuration("1 years");
                    }
                    else{
                        applicants.get(index).setVisaDuration("2 years");
                    }
                }

            }
            else if(applicants.get(index).getApplicantType().equals("worker")) {
                Document LA = null ;
                for(Document i: applicants.get(index).getDocuments()){
                    if(i.getDocumentType().equals("LA")){
                        LA = new Document(i);
                    }
                }
                if (LA.getDurationInMonths()<12){
                    if(checkExpireDate(applicants.get(index).getPassport().getExpirationDate())>= 12) {
                        applicants.get(index).setVisaDuration("1 years");
                    }
                    else {
                        applicants.get(index).setAcceptance("Rejected");
                        applicants.get(index).setReason("Passport expiration date is not valid");
                    }
                }
                else if (LA.getDurationInMonths()>=12 && LA.getDurationInMonths()<24){
                    if(checkExpireDate(applicants.get(index).getPassport().getExpirationDate())>= 24){
                        applicants.get(index).setVisaDuration("2 years");
                    }
                    else if(checkExpireDate(applicants.get(index).getPassport().getExpirationDate())>=12 && checkExpireDate(applicants.get(index).getPassport().getExpirationDate())<24){
                        applicants.get(index).setVisaDuration("1 years");
                    }
                    else {
                        applicants.get(index).setAcceptance("Rejected");
                        applicants.get(index).setReason("Passport expiration date is not valid");
                    }
                }
                else{
                    if(checkExpireDate(applicants.get(index).getPassport().getExpirationDate())>= 60){
                        applicants.get(index).setVisaDuration("5 years");
                    }
                    else if(checkExpireDate(applicants.get(index).getPassport().getExpirationDate())>=24 && checkExpireDate(applicants.get(index).getPassport().getExpirationDate())<60){
                        applicants.get(index).setVisaDuration("2 years");
                    }
                    else if(checkExpireDate(applicants.get(index).getPassport().getExpirationDate())>=12 && checkExpireDate(applicants.get(index).getPassport().getExpirationDate())<24){
                        applicants.get(index).setVisaDuration("1 years");
                    }
                    else {
                        applicants.get(index).setAcceptance("Rejected");
                        applicants.get(index).setReason("Passport expiration date is not valid");
                    }
                }
            }
            else if(applicants.get(index).getApplicantType().equals("educational")){
                Document LA = null ;
                for(Document i: applicants.get(index).getDocuments()){
                    if(i.getDocumentType().equals("LA")){
                        LA = new Document(i);
                    }
                }
                if (LA.getDurationInMonths()<12){
                    if(checkExpireDate(applicants.get(index).getPassport().getExpirationDate())>= 12) {
                        applicants.get(index).setVisaDuration("1 years");
                    }
                    else {
                        applicants.get(index).setAcceptance("Rejected");
                        applicants.get(index).setReason("Passport expiration date is not valid");
                    }
                }
                else if (LA.getDurationInMonths()>=12 && LA.getDurationInMonths()<24){
                    if(checkExpireDate(applicants.get(index).getPassport().getExpirationDate())>= 24){
                        applicants.get(index).setVisaDuration("2 years");
                    }
                    else if(checkExpireDate(applicants.get(index).getPassport().getExpirationDate())>=12 && checkExpireDate(applicants.get(index).getPassport().getExpirationDate())<24){
                        applicants.get(index).setVisaDuration("1 years");
                    }
                    else {
                        applicants.get(index).setAcceptance("Rejected");
                        applicants.get(index).setReason("Passport expiration date is not valid");
                    }
                }
                else{
                    if(checkExpireDate(applicants.get(index).getPassport().getExpirationDate())>= 60){
                        applicants.get(index).setVisaDuration("5 years");
                    }
                    else if(checkExpireDate(applicants.get(index).getPassport().getExpirationDate())>=24 && checkExpireDate(applicants.get(index).getPassport().getExpirationDate())<60){
                        applicants.get(index).setVisaDuration("2 years");
                    }
                    else if(checkExpireDate(applicants.get(index).getPassport().getExpirationDate())>=12 && checkExpireDate(applicants.get(index).getPassport().getExpirationDate())<24){
                        applicants.get(index).setVisaDuration("1 years");
                    }
                    else {
                        applicants.get(index).setAcceptance("Rejected");
                        applicants.get(index).setReason("Passport expiration date is not valid");
                    }
                }
            }
            else{
                applicants.get(index).setVisaDuration("Permanent");
            }
        }
        return applicants;
    }
    public static ArrayList<Applicant> checkAllAcceptance(ArrayList<Applicant> applicants){ // The methot i checked whole objects's acceptance in Aplicant arraylist.
        for(int i = 0; i< applicants.size();i++){
            checkAcceptance(applicants,i);
        }
        return applicants;
    }
    public static ArrayList<Applicant> sortArrayList(ArrayList<Applicant> applicants){
        ArrayList<Integer> applicantIDList = new ArrayList<>();
        ArrayList<Applicant> sortedApplicants = new ArrayList<>();
        for (Applicant i: applicants){
            applicantIDList.add(i.getApplicantID());
        }
        Collections.sort(applicantIDList);
        for (int j: applicantIDList){
            for (Applicant k: applicants){
                if (k.getApplicantID() ==j){
                    sortedApplicants.add(k);
                }
            }
        }
        return sortedApplicants;
    }
    public static void displayOutputs(ArrayList<Applicant> applicants){
        for(Applicant i: applicants){
            if(i.getAcceptance().equals("Accepted")){
                System.out.println("Applicant ID: "+i.getApplicantID()+", Name: "+i.getApplicantI().getApplicantName()+ ", Visa Type: "
                        +i.getApplicantType()+", Status: "+i.getAcceptance()+", Visa Duration:"+i.getVisaDuration());
            }
            else {
                System.out.println("Applicant ID: "+i.getApplicantID()+", Name: "+i.getApplicantI().getApplicantName()+ ", Visa Type: "
                        +i.getApplicantType()+", Status: "+i.getAcceptance()+", Reason:"+i.getReason());
            }
        }
    }
    public  static boolean checkGreenCard(ArrayList<Document> documents){
        for(Document i: documents){
            if(i.getDocumentType().equals("GC")){
                return true;
            }
        }
        return false;
    }
    public static boolean checkInvitationLetter(ArrayList<Document> documents){
        for(Document i: documents){
            if(i.getDocumentType().equals("IL")){
                return true;
            }
        }
        return false;
    }
    public static boolean checkLA(ArrayList<Document>documents){
        for(Document i: documents){
            if(i.getDocumentType().equals("LA")){
                return true;
            }
        }
        return false;
    }
    public static boolean checkSquare(String resolution){
        int width;
        int height;
        StringTokenizer reso = new StringTokenizer(resolution, "x");
        width = Integer.parseInt(reso.nextToken());
        height = Integer.parseInt(reso.nextToken());
        if(height != width){
            return false;
        }
        else {
            return true;
        }
    }
    public static boolean checkValidDigits(char digit){
        if(digit == '0' || digit == '1' || digit == '2' || digit == '3'|| digit == '4'|| digit == '5'|| digit == '6'|| digit == '7'|| digit == '8'|| digit == '9'){
            return true;
        }
        else {
            return false;
        }
    }
    public  static int checkExpireDate(String date){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate today = LocalDate.parse(dateFormat.format(currentDate));
        LocalDate expireDate = LocalDate.parse(date);
        int monthsBetween = (int) ChronoUnit.MONTHS.between(today,expireDate);
       return monthsBetween;
    }
}
