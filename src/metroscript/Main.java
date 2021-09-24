package metroscript;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            if(args.length == 0) runPrompt();
            else runFile(args[0]);
        }
        catch (IOException e) {
            System.out.println("Fatal error: file not found or can't be opened.");
            return;
        }
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
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        ArrayList<Token> tokens = new ArrayList<>();

        while (scanner.hasNextLine()) {
            tokens.addAll(LineProcessor.tokenizeString(scanner.nextLine()));
        }

        scanner.close();

        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}
