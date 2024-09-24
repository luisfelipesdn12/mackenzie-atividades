// Luis Felipe 10420572 
// Marcos Minhano 10428577
// Matheus Fernandes 10420439

import java.util.Scanner;

public class InputHelper {
    public static int getIntInput(String message) {
        int input = 0;
        boolean valid = false;
        
        do {
            System.out.print(message);
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                valid = true;
                sc.close();
            } catch (Exception e) {
                System.out.println("Insira um inteiro válido.");
            }
        } while (!valid);
        return input;
    }
}
