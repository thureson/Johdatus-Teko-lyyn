package spamham;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SpamHam {
    private final static String SPAM_PATH = "spamcount.txt";
    private final static String HAM_PATH  = "hamcount.txt";
    private final static String MESSAGE_PATH = "hamesim.txt";

    private static List<String> readMessage(String file) throws IOException {
        String teksti = new String(Files.readAllBytes(Paths.get(file)));
        return Arrays.asList(teksti.split("\\s+"));
    }

    private static Map<String, Integer> readOccurences(String file)
            throws FileNotFoundException {
        Map<String, Integer> counts;
        try (Scanner lukija = new Scanner(new File(file))) {
            counts = new HashMap<>();
            while (lukija.hasNext()) {
                int occurences = lukija.nextInt();
                String word = lukija.next();
                counts.put(word, occurences);
            }
        }

        return counts;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Map<String, Integer> spam = readOccurences(SPAM_PATH);
        Map<String, Integer> ham = readOccurences(HAM_PATH);
        
        Iterator<String> spamKeySet = spam.keySet().iterator();
        while (spamKeySet.hasNext()){
            String next = spamKeySet.next();
            System.out.println(next + "  P: " + conditionalProbability(spam.get(next), true) + "  F: " + spam.get(next));
        }
        
        String content = readFile("spamesim.txt", Charset.defaultCharset());
//        String msg = "free win";
        String[] words = content.split(" ");
        double R = bayes(true, words, spam, ham);
        System.out.println("Spamesim: " + R/(1+R));
        
        content = readFile("hamesim.txt", Charset.defaultCharset());
        words = content.split(" ");
        R = bayes(true, words, spam, ham);
        System.out.println("Hamesim: " + R/(1+R));
        
    }
    
    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
    
    public static double bayes(boolean testingForSpam, String[] words, Map<String, Integer> spam, Map<String, Integer> ham){
        double R = 0.258/0.742;
//        double R = 0.5/0.5;
        for (int i = 0; i < words.length; i++){
            int spamAmount = 0;
            int hamAmount = 0;
            try {
                spamAmount = spam.get(words[i]);
                hamAmount = ham.get(words[i]);
            } catch (NullPointerException e){
                ;
            }

            R = R*conditionalProbability(testingForSpam ? spamAmount : hamAmount, testingForSpam)/conditionalProbability(!testingForSpam ? spamAmount : hamAmount, !testingForSpam);
        }
        return R;
    }
    
    public static double conditionalProbability(int wordFreq, boolean spam){
        if (wordFreq > 0){
            return spam ? (double) wordFreq/75268 : (double) wordFreq/290673;
        }
        return 0.000001;
    }
}
