package im.thatneko.tombola;

import im.thatneko.tombola.bet.BetHandler;
import im.thatneko.tombola.menu.MenuRegistrar;
import im.thatneko.tombola.prize.PrizeRegistrar;

import java.util.Scanner;

/**
 * This code has been created by
 * gatogamer#6666 A.K.A. gatogamer.
 * If you want to use my code, please
 * ask first, and give me the credits.
 * Arigato! n.n
 */
public class Tombola {
    private final Scanner scanner;
    private final PrizeRegistrar prizeRegistrar;
    private final BetHandler betHandler;
    private final MenuRegistrar menuRegistrar;

    public Tombola() {
        this.scanner  = new Scanner(System.in);
        this.prizeRegistrar = new PrizeRegistrar();
        this.betHandler = new BetHandler();
        this.menuRegistrar = new MenuRegistrar(this);
        this.menuRegistrar.startMenuBucle();
    }


    public Scanner getScanner() {
        return this.scanner;
    }

    public PrizeRegistrar getPrizeRegistrar() {
        return this.prizeRegistrar;
    }

    public BetHandler getBetHandler() {
        return this.betHandler;
    }
}