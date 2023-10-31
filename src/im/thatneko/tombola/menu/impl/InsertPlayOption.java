package im.thatneko.tombola.menu.impl;

import im.thatneko.tombola.bet.Bet;
import im.thatneko.tombola.bet.BetHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This code has been created by
 * gatogamer#6666 A.K.A. gatogamer.
 * If you want to use my code, please
 * ask first, and give me the credits.
 * Arigato! n.n
 */
public class InsertPlayOption implements Runnable {
    private final BetHandler betHandler;
    private final Scanner scanner;

    public InsertPlayOption(BetHandler betHandler, Scanner scanner) {
        this.betHandler = betHandler;
        this.scanner = scanner;
    }

    @Override
    public void run() {
        // Eliminar el último sorteo y cambiar el tiempo al siguiente.
        if (this.betHandler.getLastReward() != null) {
            this.betHandler.setLastReward(null);
            this.betHandler.changeTime();
        }

        System.out.println("Estás jugando una apuesta para el turno " + this.betHandler.getBetTime().getFancyName());
        System.out.print("Ingrese la modalidad (3-7): ");
        int modality = Integer.parseInt(this.scanner.nextLine());
        if (modality < 3 || modality > 7) {
            System.out.println("Apuesta inválida, la modalidad debe ser de 3 a 7 números");
            return;
        }
        System.out.print("Ingrese cantidad de apuesta ($40-$400): ");
        int bet = Integer.parseInt(this.scanner.nextLine());
        if (bet < 40 || bet > 400) {
            System.out.println("Apuesta inválida, debe ser mayor que $40 y menor que $400");
            return;
        }
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < modality; i++) {
            while (true) {
                System.out.print("Ingrese el " + (i + 1) + "° número: ");
                int number = Integer.parseInt(this.scanner.nextLine());
                if (numbers.contains(number)) {
                    System.out.println("Ya agregaste este número, por favor, elige otro...");
                } else {
                    numbers.add(number);
                    break;
                }
            }
        }

        System.out.printf("¡Jugada agregada con éxito! Jugarás con los números %s con una apuesta de $%d en la modalidad %d%n", numbers, bet, modality);
        this.betHandler.addBet(new Bet(modality, bet, numbers));
    }
}