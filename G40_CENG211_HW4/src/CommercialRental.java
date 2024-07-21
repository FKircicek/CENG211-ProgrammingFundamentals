import java.util.ArrayList;

public class CommercialRental<T> extends Rental<T>{
    public CommercialRental(String type, T customerID, int numberOfTime, String carModel, int carModelYear, double basePrice,String membership) {
        super(type, customerID, numberOfTime, carModel, carModelYear, basePrice,membership);
    }

    @Override
    public void daily_price(Company company) {
        double modelYearRatio;
        double tempPrice ;

        if(getCarModelYear() == 2017 || getCarModelYear() == 2018 || getCarModelYear() == 2019 ){
            modelYearRatio = 0.9;
        }
        else if(getCarModelYear() == 2020 || getCarModelYear() == 2021){
            modelYearRatio = 0.95;
        }
        else {
            modelYearRatio = 1;
        }
        for (ArrayList<String> i : company.getCommercialCustomerTypeList()){
            if(i.get(1).equals(getMembership())) {
                tempPrice = (getBasePrice() * modelYearRatio) * (100-Integer.parseInt(i.get(2))) / 100;
                setDailyPrice(tempPrice);
            }
        }
    }
}
