import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class FileIO {
    public static ArrayList<Rental<?>> createRental(String filename) {
        ArrayList<Rental<?>> rentalArrayList = new ArrayList<>();
        Company company = new Company();
        try {
            File myObj = new File(filename);
            Scanner scanner = new Scanner(myObj);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] fileArray = data.split(",");
                if (fileArray.length > 1){
                    String membership = null;
                    try {
                        Long temp = Long.parseLong(fileArray[1]);
                        membership = "non-member";
                    }
                    catch (NumberFormatException e){
                        for (int i = 0;i<3;i++){
                            if(fileArray[1].startsWith(company.getCommercialCustomerTypeList().get(i).get(0))){
                                membership = company.getCommercialCustomerTypeList().get(i).get(1);
                                }
                            }
                        if(membership == null){
                            membership = "Normal member";
                        }
                    }
                    if (fileArray[0].equals("Individual")) {
                        Rental<?> theContent = new IndividualRental<>(fileArray[0], fileArray[1], Integer.parseInt(fileArray[2]), fileArray[3],Integer.parseInt(fileArray[4]),
                                Double.parseDouble(fileArray[5]),membership);
                        rentalArrayList.add(theContent);
                    }   else {
                        Rental<?> theContent = new CommercialRental<>(fileArray[0], fileArray[1], Integer.parseInt(fileArray[2]), fileArray[3],Integer.parseInt(fileArray[4]),
                                Double.parseDouble(fileArray[5]),membership);
                        rentalArrayList.add(theContent);
                    }
                }
            }
            return rentalArrayList;
        } catch (FileNotFoundException e) {
            System.out.println("File's path is incorrect !!!");
            e.printStackTrace();
            System.exit(-1);
        }
        return rentalArrayList;
    }
}
