package im.thatneko.tombola.menu.impl;

import im.thatneko.tombola.bet.BetHandler;
import im.thatneko.tombola.utils.NumberUtils;

/**
 * This code has been created by
 * gatogamer#6666 A.K.A. gatogamer.
 * If you want to use my code, please
 * ask first, and give me the credits.
 * Arigato! n.n
 */
public class StartRewardOption implements Runnable {
    private final BetHandler betHandler;

    public StartRewardOption(BetHandler betHandler) {
        this.betHandler = betHandler;
    }

    @Override
    public void run() {
        // Si ya se encuentra hecho un sorteo, borra todos los datos para hacer otro.
        // Sí, estará vacío, pero bueno, tampoco es plan de hacer 500 veces sorteo en el mismo tiempo
        if (this.betHandler.getLastReward() != null) {
            this.betHandler.purge();
        }

        System.out.println("--------------------------");
        System.out.println("Sorteo " + this.betHandler.getBetTime().getFancyName());
        System.out.println("--------------------------");

        int numbersUsed = 0;
        int[] numbers = NumberUtils.generateNumbers();
        for (Integer randomNumber : numbers) {
            System.out.print("[" + randomNumber + "]");
            if ((numbersUsed + 1) % 10 == 0) {
                System.out.println();
            } else {
                System.out.print(" ");
                if (randomNumber < 10) {
                    System.out.print(" ");
                }
            }
            numbersUsed++;
        }

        this.betHandler.setLastReward(numbers);
    }
}
