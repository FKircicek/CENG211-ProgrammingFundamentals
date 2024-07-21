import java.util.ArrayList;

public abstract class Rental<T> implements RentalI {
    private String type;
    private T customerID;
    private int    numberOfTime; //For individual rental it is number of days, for commerical rental it is number of months.
    private String carModel;
    private int carModelYear;
    private double basePrice;
    private String membership;
    private double dailyPrice;
    private Long rentalCode;

    public Rental(String type, T customerID, int numberOfTime, String carModel, int carModelYear, double basePrice,String membership) {
        this.type = type;
        this.customerID = customerID;
        this.numberOfTime = numberOfTime;
        this.carModel = carModel;
        this.carModelYear = carModelYear;
        this.basePrice = basePrice;
        this.membership = membership;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getCustomerID() {
        return customerID;
    }

    public void setCustomerID(T customerID) {
        this.customerID = customerID;
    }

    public int getNumberOfTime() {
        return numberOfTime;
    }

    public void setNumberOfTime(int numberOfTime) {
        this.numberOfTime = numberOfTime;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarModelYear() {
        return carModelYear;
    }

    public void setCarModelYear(int carModelYear) {
        this.carModelYear = carModelYear;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public Long getRentalCode() {
        return rentalCode;
    }

    public void setRentalCode(Long generatedInteger) {
        this.rentalCode = generatedInteger;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

}
