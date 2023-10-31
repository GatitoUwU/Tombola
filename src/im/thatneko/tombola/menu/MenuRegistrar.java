package im.thatneko.tombola.menu;

import im.thatneko.tombola.Tombola;
import im.thatneko.tombola.menu.impl.ShowRewardOption;
import im.thatneko.tombola.menu.impl.InsertPlayOption;
import im.thatneko.tombola.menu.impl.StartRewardOption;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This code has been created by
 * gatogamer#6666 A.K.A. gatogamer.
 * If you want to use my code, please
 * ask first, and give me the credits.
 * Arigato! n.n
 */
public class MenuRegistrar {
    private final Tombola tombola;
    private final Map<String, Runnable> options;

    public MenuRegistrar(Tombola tombola) {
        this.tombola = tombola;
        this.options = new HashMap<>();
        this.options.put("0", () -> {
            System.out.println("Saliendo de ESI Tómbola, gracias por jugar...");
            System.exit(0);
        });
        this.options.put("1", new InsertPlayOption(tombola.getBetHandler(), tombola.getScanner()));
        this.options.put("2", new StartRewardOption(tombola.getBetHandler()));
        this.options.put("3", new ShowRewardOption(tombola.getPrizeRegistrar(), tombola.getBetHandler()));
    }

    public void startMenuBucle() {
        while (true) {
            menu(options, this.tombola.getScanner());
        }
    }

    public void menu(Map<String, Runnable> options, Scanner scanner) {
        System.out.println("********************** ESI TÓMBOLA **********************");
        System.out.println("Selecciona una opción: ");
        System.out.println(" 1) Ingresar jugada.");
        System.out.println(" 2) Sorteo.");
        System.out.println(" 3) Resultado.");
        System.out.println(" 0) Salir.");
        System.out.print("Ingresa una opción: ");
        String s = scanner.nextLine();

        Runnable runnable = options.get(s);
        if (runnable == null) {
            System.out.println("Opción inválida.");
        } else {
            runnable.run();
        }
    }
}