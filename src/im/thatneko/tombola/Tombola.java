package im.thatneko.tombola;

import javax.print.attribute.standard.NumberUpSupported;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This code has been created by
 * gatogamer#6666 A.K.A. gatogamer.
 * If you want to use my code, please
 * ask first, and give me the credits.
 * Arigato! n.n
 */
public class Tombola {
    public static void main(String[] args) {
        // Mapa que contiene como clave la modalidad y como valor un mapa de números acertados y su paga.
        Map<Integer, Map<Integer, Double>> paymentTypes = new HashMap<>();

        Map<Integer, Double> prizesFor3 = new HashMap<>();
        prizesFor3.put(3, 60.0);
        paymentTypes.put(3, prizesFor3);
        Map<Integer, Double> prizesFor4 = new HashMap<>();
        prizesFor4.put(3, 9.0);
        prizesFor4.put(4, 180.0);
        paymentTypes.put(4, prizesFor4);
        Map<Integer, Double> prizesFor5 = new HashMap<>();
        prizesFor5.put(3, 3.0);
        prizesFor5.put(4, 24.0);
        prizesFor5.put(5, 900.0);
        paymentTypes.put(5, prizesFor5);
        Map<Integer, Double> prizesFor6 = new HashMap<>();
        prizesFor6.put(3, 1.5);
        prizesFor6.put(4, 9.0);
        prizesFor6.put(5, 90.0);
        prizesFor6.put(6, 3_600.0);
        paymentTypes.put(6, prizesFor6);
        Map<Integer, Double> prizesFor7 = new HashMap<>();
        prizesFor7.put(3, 1.0);
        prizesFor7.put(4, 3.0);
        prizesFor7.put(5, 30.0);
        prizesFor7.put(6, 600.0);
        prizesFor7.put(7, 12_000.0);
        paymentTypes.put(7, prizesFor7);

        Scanner scanner = new Scanner(System.in);
        List<Object[]> plays = new ArrayList<>();
        int[][] result = new int[2][];
        int sorteo = 0;
        while (true) {
            System.out.println("********************** ESI TÓMBOLA **********************");
            System.out.println("Selecciona una opción: ");
            System.out.println(" 1) Ingresar jugada.");
            System.out.println(" 2) Sorteo.");
            System.out.println(" 3) Resultado.");
            System.out.println(" 0) Salir.");
            System.out.print("Ingresa una opción: ");
            String s = scanner.nextLine();
            switch (s) {
                case "0": {
                    return;
                }
                case "1": {
                    ingresarJugada(scanner, plays);
                    break;
                }
                case "2": {
                    sorteo++;
                    sorteo(scanner, result, sorteo);
                    break;
                }
                case "3": {
                    resultado(scanner, result, sorteo);
                    break;
                }
                default: {
                    System.out.println("Opción inválida.");
                    break;
                }
            }
        }
    }

    public static void resultado(Scanner scanner, List<Object[]> plays, int[][] result) {
        System.out.println("--------------------------");
        for (Object[] play : plays) {
            int modalidad = (int) play[0];
            int apuesta = (int) play[1];
            List<Integer> numbers = (List<Integer>) play[2];
            for (Integer randomNumber : numbers) {
                System.out.print("[" + randomNumber + "]");
            }

        }
        System.out.println("--------------------------");
    }

    /**
     * @param scanner: el scanner que se usará para pedir el tipo de sorteo
     * @param result:  el array que contiene el resultado tanto de la vespertina (0) como la nocturna (1).
     * @param sorteo:  el sorteo actual
     */
    public static void sorteo(Scanner scanner, int[][] result, int sorteo) {
        System.out.println("--------------------------");
        System.out.println("Sorteo número: " + sorteo);
        System.out.println("--------------------------");

        int numbersUsed = 0;
        int[] numbers = generateNumbers();
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

        result[0] = numbers;
    }

    public static void ingresarJugada(Scanner scanner, List<Object[]> plays) {
        System.out.print("Ingrese la modalidad (3-7): ");
        int modalidad = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese cantidad de apuesta ($40-$400): ");
        int apuesta = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < modalidad; i++) {
            System.out.print("Ingrese el " + (i + 1) + "° número: ");
            numbers.add(Integer.parseInt(scanner.nextLine()));
        }

        System.out.println("¡Jugada agregada con éxito! Jugarás con los números \"" + numbers + "\" con una apuesta de $" + apuesta + " en la modalidad " + modalidad);
        plays.add(new Object[]{
                modalidad, apuesta, numbers
        });
    }

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