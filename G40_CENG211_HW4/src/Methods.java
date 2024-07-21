import java.util.ArrayList;

public class Methods {
    public static ArrayList<Rental<?>> createRentalArrayList (String fileName){
        ArrayList<Rental<?>> rentalArrayList = FileIO.createRental(fileName);
        return rentalArrayList;
    }
    public static void calculatePricesOfRentals(ArrayList<Rental<?>> rentalArrayList,Company company){
        for( Rental<?> i : rentalArrayList){
            i.daily_price(company);
        }
    }
    public static void  generateInteger(ArrayList<Rental<?>> rentalArrayList, Company company) {
        for (Rental<?> a: rentalArrayList) {
            Long random = Math.round(Math.random() * 10000000);
            int check = 0;
            while (check == 0) {
            	if (company.getGenerategenerateIntegerList().size() == 0) {
                    if (random / 1000000 == 0) {
                        check = 2;
                        random = Math.round(Math.random() * 10000000);
                    }
                } else{
                    for (Long i : company.getGenerategenerateIntegerList()) {
                        if (i == random || random / 1000000 == 0) {
                            check = 2;
                            random = Math.round(Math.random() * 10000000);
                            break;
                        }
                    }
                }
                if (check == 2) {
                    check = 0;
                } else {
                    ArrayList<Long> tempList = new ArrayList<>(company.getGenerategenerateIntegerList());
                    tempList.add(random);
                    company.setgenerateIntegerList(tempList);
                    check = 1;
                    a.setRentalCode(random);
                }
            }
        }
    }
    public static void simulation(ArrayList<Rental<?>> rentalArrayList){
        int commercialRentals = 0;
        int commercialRentalMonth = 0;
        int individualRentals = 0;
        int individualRentalDay = 0;
        int individualNonNemberRentals = 0;
        int individualNemberRentals = 0;
        int silverMembers = 0;
        int goldMembers = 0;
        int platinumMembers = 0;
        for(Rental<?> i: rentalArrayList){
            if(i.getType().equals("Commercial")){
                commercialRentals ++;
                commercialRentalMonth = commercialRentalMonth + i.getNumberOfTime();
                if(i.getMembership().equals("Silver member")){
                    silverMembers ++;
                }
                else if(i.getMembership().equals("Gold member")){
                    goldMembers ++;
                }
                else{
                    platinumMembers ++;
                }
            }
            else{
                individualRentals ++;
                individualRentalDay = individualRentalDay + i.getNumberOfTime();
                if(i.getMembership().equals("non-member")){
                    individualNonNemberRentals ++;
                }
                else {
                    individualNemberRentals ++;
                }
            }
        }
        System.out.println("Welcome!\n");
        System.out.println("Total number of cars rented: " + rentalArrayList.size()+"\n");
        System.out.println("Total number of commerical rentals: " + commercialRentals+"\n");
        System.out.println("Total number of commercial rental-month: " + commercialRentalMonth+"\n");
        System.out.println("Total number of individual rentals: " + individualRentals+"\n");
        System.out.println("Total number of individual rental-day: " + individualRentalDay+"\n");
        System.out.println("Total number of rentals of individual non-member customers: "+ individualNonNemberRentals+"\n");
        System.out.println("Total number of rentals of individual member customers: " + individualNemberRentals+"\n");
        System.out.println("Total number of rentals of silver commercial customers: " + silverMembers+"\n");
        System.out.println("Total number of rentals of gold commercial customers: " + goldMembers+"\n");
        System.out.println("Total number of rentals of platinum commercial customers: " + platinumMembers+"\n");

        System.out.println("\nIndividual Rentals:\n");
        int no = 1;
        System.out.println("No      Rental Code     Customer ID     isMember    Number of Days      Car Model         Model Year      Rental Price");
        for(Rental<?> i: rentalArrayList) {
            if (i.getType().equals("Individual")) {
                String isMember = "yes";
                if(i.getMembership().equals("non-member")){
                    isMember = "no";
                }
                String numberOfDays = String.valueOf(i.getNumberOfTime());
                String customerID = String.valueOf(i.getCustomerID());

                    System.out.print(no + "         " + i.getRentalCode() + "       " + i.getCustomerID() + " ".repeat(18-customerID.length()) + isMember +" ".repeat(17-isMember.length())
                            + i.getNumberOfTime() + " ".repeat(13-numberOfDays.length()) + i.getCarModel() + " ".repeat(21-i.getCarModel().length())
                            + i.getCarModelYear() + "           ");
                    System.out.printf("%.2f",(i.getDailyPrice() * i.getNumberOfTime()));
                    System.out.println();
                    no++;
            }
        }
        System.out.println("\n\nCommercial Rentals:\n");
        no = 1;
        System.out.println("No      Rental Code     Customer ID     Customer Type    Number of Months      Car Model           Model Year      Rental Price");
        for(Rental<?> i: rentalArrayList) {
            if (i.getType().equals("Commercial")) {
                String numberOfMonths = String.valueOf(i.getNumberOfTime());
                String customerID = String.valueOf(i.getCustomerID());
                    System.out.print(+no + "         " + i.getRentalCode() + "        " + i.getCustomerID() + " ".repeat(14-customerID.length())  + i.getMembership()+ " ".repeat(25-i.getMembership().length())
                            + i.getNumberOfTime() + " ".repeat(15-numberOfMonths.length()) + i.getCarModel() + " ".repeat(23-i.getCarModel().length()) + i.getCarModelYear()
                            + "           " ); 
                    System.out.printf("%.2f",(i.getDailyPrice() * i.getNumberOfTime()*30));
                    System.out.println();
                    no++;
            }
        }
    }
}
