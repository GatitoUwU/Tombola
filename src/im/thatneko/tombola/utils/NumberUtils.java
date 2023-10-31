package im.thatneko.tombola.utils;

import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This code has been created by
 * gatogamer#6666 A.K.A. gatogamer.
 * If you want to use my code, please
 * ask first, and give me the credits.
 * Arigato! n.n
 */
public class NumberUtils {
    /**
     * Usando ThreadLocalRandom, genera 20 números del 0 al 99.
     *
     * @return: un set con los números del sorteo.
     */
    public static int[] generateNumbers() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        TreeSet<Integer> randomNumbers = new TreeSet<>();

        while (randomNumbers.size() < 20) {
            int randomNumber = random.nextInt(0, 100);
            randomNumbers.add(randomNumber);
        }

        int[] numbers = new int[randomNumbers.size()];
        int i = 0;
        for (Integer randomNumber : randomNumbers) {
            numbers[i] = randomNumber;
            i++;
        }
        return numbers;
    }
}