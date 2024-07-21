import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
    public static ArrayList<Content> readGameValues(String filename) {
        ArrayList<Content> gameArrayList = new ArrayList<>();
        try {
            File myObj = new File(filename);
            Scanner scanner = new Scanner(myObj);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] emptyStringArray = data.split(",");
                if (emptyStringArray.length > 1){
                    if (Integer.parseInt(emptyStringArray[1]) == 1) {
                        Content theContent = new IndefiniteGame(Integer.parseInt(emptyStringArray[0]), Integer.parseInt(emptyStringArray[1]), emptyStringArray[2], Integer.parseInt(emptyStringArray[3]),
                                Double.parseDouble(emptyStringArray[4]));
                        gameArrayList.add(theContent);
                    } else if (Integer.parseInt(emptyStringArray[1]) == 2) {
                        Content theContent = new StoryGame(Integer.parseInt(emptyStringArray[0]), Integer.parseInt(emptyStringArray[1]), emptyStringArray[2], Integer.parseInt(emptyStringArray[3]),
                                Double.parseDouble(emptyStringArray[4]));
                        gameArrayList.add(theContent);
                    } else {
                        if (Integer.parseInt(emptyStringArray[1]) == 3) {
                            Content theContent = new CasualGame(Integer.parseInt(emptyStringArray[0]), Integer.parseInt(emptyStringArray[1]), emptyStringArray[2], Integer.parseInt(emptyStringArray[3]),
                                    Double.parseDouble(emptyStringArray[4]));
                            gameArrayList.add(theContent);
                        }
                    }
                }
            }
            return gameArrayList;
        } catch (FileNotFoundException error) {
            System.out.println("Path is incorrect pls check the path!!");
            error.printStackTrace();
            System.exit(-1);
        }
        return gameArrayList;
    }
    public static ArrayList<Content> readMovieValues(String filename) {
        ArrayList<Content> movieArraylist = new ArrayList<>();
        try {
            File myObj = new File(filename);
            Scanner scanner = new Scanner(myObj);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] emptyStringArray = data.split(",");
                if (emptyStringArray.length > 1){
                    if (Integer.parseInt(emptyStringArray[1]) == 0) {
                        Content theContent = new Movie(Integer.parseInt(emptyStringArray[0]), Integer.parseInt(emptyStringArray[1]), emptyStringArray[2], Integer.parseInt(emptyStringArray[3]),
                                Integer.parseInt(emptyStringArray[4]),Double.parseDouble(emptyStringArray[5]));
                        movieArraylist.add(theContent);
                    }
                }
            }
            return movieArraylist;
        } catch (FileNotFoundException error) {
            System.out.println("Path is incorrect pls check the path!!");
            error.printStackTrace();
            System.exit(-1);
        }
        return movieArraylist;
    }
}