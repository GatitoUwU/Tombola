package im.thatneko.tombola.bet;

/**
 * This code has been created by
 * gatogamer#6666 A.K.A. gatogamer.
 * If you want to use my code, please
 * ask first, and give me the credits.
 * Arigato! n.n
 */
public enum BetTime {
    EVENING("Vespertino"),
    NIGHT("Nocturno");

    private final String fancyName;

    BetTime(String fancyName) {
        this.fancyName = fancyName;
    }

    public String getFancyName() {
        return fancyName;
    }
}