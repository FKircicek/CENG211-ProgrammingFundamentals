public class IndividualRental<T> extends Rental<T> {

    public IndividualRental(String type, T customerID, int numberOfTime, String carModel, int carModelYear, double basePrice,String membership) {
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
        if (getMembership().equals("non-member")){
            tempPrice = getBasePrice() * modelYearRatio;
            setDailyPrice(tempPrice);
        }
        else if (getMembership().equals("Normal member")){
            tempPrice = (getBasePrice() * modelYearRatio)*90/100;
            setDailyPrice(tempPrice);
        }
    }
}
