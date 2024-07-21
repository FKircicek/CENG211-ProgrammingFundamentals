import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        ArrayList<Rental<?>> rentalArrayList = Methods.createRentalArrayList("HW4_Rentals.csv");
        Methods.calculatePricesOfRentals(rentalArrayList, company);
        Methods.generateInteger(rentalArrayList,company);
        Methods.simulation(rentalArrayList);
    }
}
