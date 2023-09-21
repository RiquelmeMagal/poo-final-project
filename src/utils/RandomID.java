package utils;
import java.security.SecureRandom;
import java.util.Random;


public class RandomID {
    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int DEFAULTLENGTH = 9;

    public static String random(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder idBuilder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            idBuilder.append(randomChar);
        }

        return idBuilder.toString();
    }

    public static String random() {
        return random(DEFAULTLENGTH);
    }

    public static String randomWithoutLetters(int length) {
        Random random = new Random();
        StringBuilder idBuilder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomDigit = random.nextInt(10); 
            idBuilder.append(randomDigit);
        }

        return idBuilder.toString();
    }

    public static String randomWithoutLetters() {
        return randomWithoutLetters(DEFAULTLENGTH);
    }
}
