package metroscript;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        if(args.length == 0) runPrompt();
        else runFile(args[0]);
    }

    private static void runPrompt() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        for(;;) {
            System.out.print(">> ");
            String line = reader.readLine();
            if (line == null) {
                return;
            }
            ArrayList<Token> tokens = LineProcessor.tokenizeString(line);
            for (Token token : tokens) System.out.println(token);
        }
    }

    public static void runFile(String filename) throws IOException {
        String fileContent = Files.readString(Paths.get(filename));

        ArrayList<Token> tokens = LineProcessor.tokenizeString(fileContent);

        for (Token token : tokens) System.out.println(token);
    }
}
