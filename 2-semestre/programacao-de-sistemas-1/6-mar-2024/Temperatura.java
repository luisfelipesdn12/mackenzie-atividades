import java.util.Scanner;

/**
 * Temperatura
 */
public class Temperatura {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Conversor de temperatura");
        
        int option;
        
        do {
            System.out.println("Escolha qual grandeza você vai digitar:\n");
            System.out.println("1 - Celsius");
            System.out.println("2 - Fahrenheit\n");
            System.out.printf("Digite sua opção: ");
            option = in.nextInt();
        } while (option != 1 && option != 2);

        
        if (option == 1) {
            System.out.printf("Digite a temperatura (em C): ");
            float c = in.nextFloat();
            float f = celsiusToFahrenheit(c);
            System.out.printf("Temperatura (em F): %f\n", f);
        } else {
            System.out.printf("Digite a temperatura (em F): ");
            float f = in.nextFloat();
            float c = fahrenheitToCelsius(f);
            System.out.printf("Temperatura (em C): %f\n", c);
        }

        in.close();
    }

    /**
     * @param c
     * @return F = ( 9 . C / 5 ) + 32
     */
    public static float celsiusToFahrenheit(float c) {
        return (9 * c / 5) + 32;
    }

    /**
     * @param f
     * @return C = 5 . ( F - 32 ) / 9
     */
    public static float fahrenheitToCelsius(float f) {
        return 5 * (f - 32) / 9;
    }
}
