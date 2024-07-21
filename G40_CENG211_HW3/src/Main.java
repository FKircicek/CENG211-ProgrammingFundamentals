import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Methods.xd(Methods.createContentStack("contents.csv"),Methods.createMovieCriticQueue(),Methods.createGameCriticQueue());

    }
}