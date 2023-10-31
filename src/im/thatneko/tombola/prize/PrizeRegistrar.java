package im.thatneko.tombola.prize;

import java.util.HashMap;
import java.util.Map;

/**
 * This code has been created by
 * gatogamer#6666 A.K.A. gatogamer.
 * If you want to use my code, please
 * ask first, and give me the credits.
 * Arigato! n.n
 */
public class PrizeRegistrar {
    private final Map<Integer, Map<Integer, Double>> paymentTypes = new HashMap<>();

    public PrizeRegistrar() {
        Map<Integer, Double> prizesFor3 = new HashMap<>();
        prizesFor3.put(3, 60.0);
        this.paymentTypes.put(3, prizesFor3);
        Map<Integer, Double> prizesFor4 = new HashMap<>();
        prizesFor4.put(3, 9.0);
        prizesFor4.put(4, 180.0);
        this.paymentTypes.put(4, prizesFor4);
        Map<Integer, Double> prizesFor5 = new HashMap<>();
        prizesFor5.put(3, 3.0);
        prizesFor5.put(4, 24.0);
        prizesFor5.put(5, 900.0);
        this.paymentTypes.put(5, prizesFor5);
        Map<Integer, Double> prizesFor6 = new HashMap<>();
        prizesFor6.put(3, 1.5);
        prizesFor6.put(4, 9.0);
        prizesFor6.put(5, 90.0);
        prizesFor6.put(6, 3_600.0);
        this.paymentTypes.put(6, prizesFor6);
        Map<Integer, Double> prizesFor7 = new HashMap<>();
        prizesFor7.put(3, 1.0);
        prizesFor7.put(4, 3.0);
        prizesFor7.put(5, 30.0);
        prizesFor7.put(6, 600.0);
        prizesFor7.put(7, 12_000.0);
        this.paymentTypes.put(7, prizesFor7);
    }

    public Map<Integer, Double> getPaymentForModality(int modality) {
        return this.paymentTypes.get(modality);
    }
}