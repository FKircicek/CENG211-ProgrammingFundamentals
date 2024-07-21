import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Methods {
    public static Stack<Content> createContentStack(String fileName) throws IOException {
        Stack<Content> contentStack = new Stack<>();
        Stack<Content> tempStack = new Stack<>();
        for (Content i: FileIO.readMovieValues(fileName)) {
            tempStack.push(i);
        }
        for (Content i: FileIO.readGameValues(fileName)) {
                tempStack.push(i);
            }
        int size = tempStack.size();
        for(int i = 1;i<6;i++){
            for(int j = 0; j<size;j++){
                contentStack.push(tempStack.pop());
                size--;
            }
        }
        return contentStack;
    }
    public static Queue<MovieCritic> createMovieCriticQueue(){
        Queue<MovieCritic> criticMovieQueue = new LinkedList<>();
        MovieCritic movieCritic1 = new MovieCritic(0.1,"movie critic",1);
        MovieCritic movieCritic2 = new MovieCritic(-0.2,"movie critic",2);
        MovieCritic movieCritic3 = new MovieCritic(0.3,"movie critic",3);

        criticMovieQueue.add(movieCritic1);
        criticMovieQueue.add(movieCritic2);
        criticMovieQueue.add(movieCritic3);

        return criticMovieQueue;
    }
    public static Queue<GameCritic> createGameCriticQueue(){
        Queue<GameCritic> criticGameQueue = new LinkedList<>();
        GameCritic gameCritic1 = new GameCritic(5,"game critic",1);
        GameCritic gameCritic2 = new GameCritic(9,"game critic",2);
        GameCritic gameCritic3 = new GameCritic(-3,"game critic",3);
        GameCritic gameCritic4 = new GameCritic(2,"game critic",4);
        GameCritic gameCritic5 = new GameCritic(-7,"game critic",5);

        criticGameQueue.add(gameCritic1);
        criticGameQueue.add(gameCritic2);
        criticGameQueue.add(gameCritic3);
        criticGameQueue.add(gameCritic4);
        criticGameQueue.add(gameCritic5);

        return criticGameQueue;
    }
    public static void xd(Stack<Content> contentStack,Queue<MovieCritic> criticMovieQueue,Queue<GameCritic> criticGameQueue){
        ArrayList<Game> gameArrayList = new ArrayList<>();
        ArrayList<GameCritic> evaluateGameArrayList = new ArrayList<>();
        ArrayList<GameCritic> removeGameCriticsArrayList = new ArrayList<>();
        ArrayList<Movie> movieArrayList = new ArrayList<>();
        for(int i = 1;i<6;i++){
            System.out.println(i+". day:");
                for(int l = 0;l < contentStack.size(); l++){
                    Content theContent = contentStack.get(contentStack.size()-l-1);
                    MovieCritic theMovieCritic = criticMovieQueue.peek();
                    if(theContent.getContentNumber()==0 && theContent.getArrivalDay()<=i && theMovieCritic.getLimit()>0){
                        theMovieCritic.setTheMovie((Movie) theContent);
                        theMovieCritic.rating();
                        theMovieCritic.setLimit(0);
                        criticMovieQueue.poll();
                        criticMovieQueue.add(theMovieCritic);
                        System.out.println(theMovieCritic.getCriticNumber()+". "+theMovieCritic.getCriticType()+" evaluated "+theContent.getName());
                        movieArrayList.add((Movie) theContent);
                        contentStack.remove(theContent);
                        theMovieCritic.setTheMovie(null);
                        l --;
                    }
                    else {
                        if (theContent.getContentNumber() != 0){
                            int check = 0;
                            for (GameCritic theGameCritic : criticGameQueue) {
                                if (theGameCritic.getLimit() > 0) {

                                    if (theContent.getContentNumber() != 0 && theContent.getArrivalDay() <= i) {
                                        Game tempGame;
                                        if (theContent.getContentNumber() == 1) {
                                            tempGame = new IndefiniteGame((IndefiniteGame) theContent);
                                            if (tempGame.getDuration() > 4)
                                                tempGame.setLeftDuration(4);
                                        } else if (theContent.getContentNumber() == 2) {
                                            tempGame = new StoryGame((StoryGame) theContent);
                                        } else {
                                            tempGame = new CasualGame((CasualGame) theContent);
                                            tempGame.setLeftDuration(tempGame.getDuration() * 3);
                                        }
                                        if (theGameCritic.getTheGame() == null) {
                                            if(check == 0){
                                            theGameCritic.setTheGame(tempGame);
                                            if (theGameCritic.getLimit() >= tempGame.getLeftDuration()) {
                                                theGameCritic.setLimit(theGameCritic.getLimit() - tempGame.getLeftDuration());
                                                theGameCritic.rating();
                                                theGameCritic.setWorkTime(tempGame.getLeftDuration());
                                                theGameCritic.getTheGame().setLeftDuration(0);
                                                System.out.println(theGameCritic.getCriticNumber() + ". " + theGameCritic.getCriticType() + " works on " + theContent.getName());
                                                evaluateGameArrayList.add(theGameCritic);
                                                removeGameCriticsArrayList.add(theGameCritic);
                                                gameArrayList.add(theGameCritic.getTheGame());
                                                contentStack.remove(theContent);
                                                l--;
                                                check = 1;
                                            } else {
                                                theGameCritic.getTheGame().setLeftDuration(theGameCritic.getTheGame().getLeftDuration() - theGameCritic.getLimit());
                                                theGameCritic.setWorkTime(theGameCritic.getLimit());
                                                theGameCritic.setLimit(0);
                                                System.out.println(theGameCritic.getCriticNumber() + ". " + theGameCritic.getCriticType() + " works on " + theGameCritic.getTheGame().getName());
                                                contentStack.remove(theContent);
                                                l--;
                                                check = 1;
                                            }
                                        }
                                        } else {
                                            if (theGameCritic.getLimit() >= theGameCritic.getTheGame().getLeftDuration()) {
                                                theGameCritic.setLimit(theGameCritic.getLimit() - theGameCritic.getTheGame().getLeftDuration());
                                                theGameCritic.rating();
                                                theGameCritic.setWorkTime(theGameCritic.getTheGame().getLeftDuration());
                                                theGameCritic.getTheGame().setLeftDuration(0);
                                                evaluateGameArrayList.add(theGameCritic);
                                                removeGameCriticsArrayList.add(theGameCritic);
                                                gameArrayList.add(theGameCritic.getTheGame());
                                            }else {
                                                theGameCritic.getTheGame().setLeftDuration(theGameCritic.getTheGame().getLeftDuration() - theGameCritic.getLimit());
                                                theGameCritic.setWorkTime(theGameCritic.getLimit());
                                                theGameCritic.setLimit(0);
                                            }
                                        }
                                    }
                                }
                            }
                            for (GameCritic removeCritic: removeGameCriticsArrayList){
                                criticGameQueue.remove(removeCritic);
                            }
                            removeGameCriticsArrayList.clear();
                        int a = 0;
                        for (GameCritic m : criticGameQueue) {
                            if (m.getLimit() != 0) {
                                a = 1;
                            }
                        }
                        if (a == 0 && !evaluateGameArrayList.isEmpty()) {
                            sortList(evaluateGameArrayList);
                            for (GameCritic n : evaluateGameArrayList) {
                                System.out.println(n.getCriticNumber() + ". " + n.getCriticType() + " evaluated " + n.getTheGame().getName());
                                n.setTheGame(null);
                                criticGameQueue.add(n);
                            }
                            evaluateGameArrayList.clear();
                        }
                    }
                }
            }
            for(MovieCritic k: criticMovieQueue){
               k.resetLimit();
            }
            for(GameCritic k: criticGameQueue) {
                k.resetLimit();
            }
        }

        System.out.println("Ratings:");
        for (Movie a : movieArrayList){
            System.out.println(a.getName()+" "+a.getYear()+" "+a.getRate());
        }
        for (Game a : gameArrayList){
            System.out.println(a.getName()+" "+a.getRate());
        }
    }
    public static ArrayList<GameCritic> sortList(ArrayList<GameCritic> gameCriticArrayList){ // Method for sorting Critics according to their work time (lower to higher).
      for (int i = 0;i< gameCriticArrayList.size();i++) {
          if (i > 0) {
              if (gameCriticArrayList.get(i-1).getWorkTime()> gameCriticArrayList.get(i).getWorkTime()) {
                  GameCritic tempCritic = new GameCritic(gameCriticArrayList.get(i));
                  gameCriticArrayList.set(i, gameCriticArrayList.get(i - 1));
                  gameCriticArrayList.set(i - 1, tempCritic);
                  return sortList(gameCriticArrayList);
              }
          }
      }
      return gameCriticArrayList;
    }
}

