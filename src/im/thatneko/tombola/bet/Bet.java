package im.thatneko.tombola.bet;

import java.util.List;

/**
 * This code has been created by
 * gatogamer#6666 A.K.A. gatogamer.
 * If you want to use my code, please
 * ask first, and give me the credits.
 * Arigato! n.n
 */
public class Bet {
    private final int modality;
    private final int bet;
    private final List<Integer> numbers;

    public Bet(int modality, int bet, List<Integer> numbers) {
        this.modality = modality;
        this.bet = bet;
        this.numbers = numbers;
    }

    public int getModality() {
        return this.modality;
    }

    public int getBet() {
        return this.bet;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
