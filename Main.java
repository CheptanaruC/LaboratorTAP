/* În textul dat după fiecare caracter indicat, să se introducă un subşir specificat. */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String sentence = "";
        int charNumber = 0;
        String substringToAdd = "";

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader bis = new BufferedReader(is);

        try {
            System.out.println("Introdu propoziția:");
            sentence = bis.readLine();

            System.out.println("Introdu caracterul după care să se adauge subșirul:");
            charNumber = bis.read(); // Citim un singur caracter
            bis.readLine(); // Consumăm newline

            System.out.println("Introdu subșirul care trebuie adăugat:");
            substringToAdd = bis.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Text myText = new Text(sentence, charNumber, substringToAdd);
        myText.addSubstringAfterChar();
        System.out.println("Propoziția nouă: " + myText.getSentence());
    }
}

class Text {
    private String sentence;
    private char charToAddAfter;
    private String substringToAdd;
    private StringBuilder newSentence = new StringBuilder("1.");

    public Text(String sentence, int charNumber, String substringToAdd) {
        this.sentence = sentence;
        this.charToAddAfter = (char) charNumber;
        this.substringToAdd = substringToAdd;
    }

    public String getSentence() {
        return newSentence.toString();
    }

    public void addSubstringAfterChar() {
        for (int i = 0; i < sentence.length(); i++) {
            newSentence.append(sentence.charAt(i));
            if (sentence.charAt(i) == charToAddAfter) {
                newSentence.append(substringToAdd);
            }
        }
    }
}
