package im.thatneko.tombola.menu.impl;

import im.thatneko.tombola.bet.Bet;
import im.thatneko.tombola.bet.BetHandler;
import im.thatneko.tombola.prize.PrizeRegistrar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This code has been created by
 * gatogamer#6666 A.K.A. gatogamer.
 * If you want to use my code, please
 * ask first, and give me the credits.
 * Arigato! n.n
 */
public class ShowRewardOption implements Runnable {
    private final PrizeRegistrar prizeRegistrar;
    private final BetHandler betHandler;

    public ShowRewardOption(PrizeRegistrar prizeRegistrar, BetHandler betHandler) {
        this.prizeRegistrar = prizeRegistrar;
        this.betHandler = betHandler;
    }

    @Override
    public void run() {
        if (this.betHandler.getLastReward() == null) {
            if (this.betHandler.getBets().isEmpty()) {
                System.out.println("No se han hecho ni apuestas ni sorteos, por favor, realiza alguna apuesta para posteriormente usar el sorteo.");
            } else {
                System.out.println("Se han jugado números pero no hay un sorteo hecho, usa la opción 2 antes de utilizar esta.");
            }
            return;
        }

        System.out.println("--------------------------");
        System.out.println("Resultados del sorteo "+this.betHandler.getBetTime().getFancyName());
        if (this.betHandler.getBets().isEmpty()) {
            System.out.println();
            System.out.println("No se han hecho jugadas");
            System.out.println();
        }
        for (Bet bet : this.betHandler.getBets()) {
            int space = 0;
            int[] lastReward = this.betHandler.getLastReward();
            for (Integer randomNumber : bet.getNumbers()) {
                if (space++ > 0) {
                    if (randomNumber < 10) {
                        System.out.print(" ");
                    }
                    System.out.print(" ");
                }
                System.out.print("[" + randomNumber + "]");
            }
            System.out.println();
            Map<Integer, Double> paymentForModality = this.prizeRegistrar.getPaymentForModality(bet.getModality());
            if (paymentForModality == null) {
                System.out.println("No hay pagas para la modalidad \"" + bet.getModality() + " números\"...");
                continue;
            }

            List<Integer> numbersInResult = new ArrayList<>();
            for (int prize : lastReward) {
                if (bet.getNumbers().contains(prize)) {
                    numbersInResult.add(prize);
                }
            }

            int size = numbersInResult.size();
            double multiplier = paymentForModality.getOrDefault(size, 0.0);
            int moneyBet = bet.getBet();

            System.out.printf("Sacaste %d número%s, la paga es de un x%.2f%n", size, (size != 1 ? "s" : ""), multiplier);
            System.out.printf("Dinero ganado: $%.2f%n", ((-moneyBet) + (moneyBet * multiplier)));
        }
        System.out.println("--------------------------");
        this.betHandler.purge();
    }
}
