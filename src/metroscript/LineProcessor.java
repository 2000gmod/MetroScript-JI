package metroscript;

import java.util.ArrayList;

public abstract class LineProcessor {
    private static ArrayList<String> preTokenize(String line) {
        String modifyLine = line;

        ArrayList<String> out = new ArrayList<>();
        String greatestValidToken;
        StringBuilder tokenToTry;

        while (!modifyLine.isEmpty()) {
            if(modifyLine.charAt(0) == ' ') modifyLine = modifyLine.substring(1);
            greatestValidToken = "";
            tokenToTry = new StringBuilder();

            for (char c : modifyLine.toCharArray()) {
                if(c >= 32) tokenToTry.append(c);
                else continue;

                Token test1 = new Token(tokenToTry.toString());

                if (test1.getType() != TokenType.ERROR) {
                    greatestValidToken = tokenToTry.toString();

                    if (greatestValidToken.charAt(0) != '\"' && greatestValidToken.charAt(greatestValidToken.length() - 1) != '\"') {
                        greatestValidToken = greatestValidToken.replaceAll(" ", "");
                    }
                }
            }

            if (!greatestValidToken.isEmpty()) {
                out.add(greatestValidToken);
                modifyLine = modifyLine.substring(greatestValidToken.length());
            }
            else {
                out.add("?");
                break;
            }
        }

        return out;
    }

    public static ArrayList<Token> tokenizeString(String input) {
        ArrayList<Token> out = new ArrayList<>();

        for (String stringToken : preTokenize(input)) {
            out.add(new Token(stringToken));
        }
        return out;
    }
}
