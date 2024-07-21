public class FinancialStatus extends ApplicantsInfo {

    private int income;
    private int savings;

    public FinancialStatus(String F,int applicantID, int income, int savings){
        super(F,applicantID);
        this.income = income;
        this.savings = savings;
    }
    public FinancialStatus(FinancialStatus financialStatus){
        super(financialStatus.getInfoType(),financialStatus.getApplicantID());
        this.income = financialStatus.getIncome();
        this.savings = financialStatus.getSavings();
    }


    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getSavings() {
        return savings;
    }

    public void setSavings(int savings) {
        this.savings = savings;
    }
}
