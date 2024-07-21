import java.util.ArrayList;

public class Company implements CompanyI {
    private ArrayList<ArrayList <String>> commercialCustomerTypeList;
    private ArrayList<Long> generateIntegerList;

    public Company() {
        ArrayList<ArrayList <String>> commercialCustomerTypeList = new ArrayList<ArrayList <String>>();
        ArrayList<Long> generateInteger = new ArrayList<>();
        for(int i = 0; i<3;i++){
            commercialCustomerTypeList.add(new ArrayList<String>());
        }
        commercialCustomerTypeList.get(0).add("S");
        commercialCustomerTypeList.get(0).add("Silver member");
        commercialCustomerTypeList.get(0).add("20");
        commercialCustomerTypeList.get(1).add("G");
        commercialCustomerTypeList.get(1).add("Gold member");
        commercialCustomerTypeList.get(1).add("25");
        commercialCustomerTypeList.get(2).add("P");
        commercialCustomerTypeList.get(2).add("Platinum member");
        commercialCustomerTypeList.get(2).add("30");
        this.commercialCustomerTypeList = commercialCustomerTypeList;
        this.generateIntegerList = generateInteger;
    }

    public ArrayList<ArrayList <String>> getCommercialCustomerTypeList() {
    	return new ArrayList<>(commercialCustomerTypeList);
    }

    public void setCommercialCustomerTypeList(ArrayList<ArrayList <String>> commercialCustomerTypeList) {
        this.commercialCustomerTypeList = commercialCustomerTypeList;
    }

    public ArrayList<Long> getGenerategenerateIntegerList() {
        ArrayList<Long> tempList = new ArrayList<>(generateIntegerList);
        return tempList;
    }

    public void setgenerateIntegerList(ArrayList<Long> generateInteger) {
        this.generateIntegerList = generateInteger;
    }

    @Override
    public void addCommercialCustomerType(String memberCharacter,String memberFullTypeName,String Discount) {
        commercialCustomerTypeList.add(new ArrayList<String>());
        commercialCustomerTypeList.get(commercialCustomerTypeList.size()-1).add(memberCharacter);
        commercialCustomerTypeList.get(commercialCustomerTypeList.size()-1).add(memberFullTypeName);
        commercialCustomerTypeList.get(commercialCustomerTypeList.size()-1).add(Discount);
    }
}
