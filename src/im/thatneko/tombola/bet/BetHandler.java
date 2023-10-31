package im.thatneko.tombola.bet;

import java.util.ArrayList;
import java.util.List;

/**
 * This code has been created by
 * gatogamer#6666 A.K.A. gatogamer.
 * If you want to use my code, please
 * ask first, and give me the credits.
 * Arigato! n.n
 */
public class BetHandler {
    private final List<Bet> bets = new ArrayList<>();
    private BetTime betTime = BetTime.EVENING;
    private int[] lastReward;

    public void addBet(Bet bet) {
        this.bets.add(bet);
    }

    public void changeTime() {
        if (this.betTime == BetTime.EVENING) {
            this.betTime = BetTime.NIGHT;
        } else {
            this.betTime = BetTime.EVENING;
        }
    }

    public void purge() {
        this.lastReward = null;
        this.changeTime();
        this.bets.clear();
    }

    public List<Bet> getBets() {
        return this.bets;
    }

    public BetTime getBetTime() {
        return this.betTime;
    }

    public int[] getLastReward() {
        return this.lastReward;
    }

    public void setLastReward(int[] lastReward) {
        this.lastReward = lastReward;
    }
}