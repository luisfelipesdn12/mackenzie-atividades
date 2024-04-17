import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] vet = {1, 2, 3, 4, 5};

        // Prova A
        /* for (int i = 0; i < vet.length - 1; i++) {
            vet[i] = vet[i+1];
            vet[i+1] = vet[i];
        } */

        // Prova B
       /*  for (int i = 1; i < vet.length; i++) {
            vet[i-1] = vet[i];
            vet[i] = vet[i-1];
        } */

        // Prova C
        for (int i = vet.length; i > 0; i--) {
            vet[i-1] = vet[i];
            vet[i] = vet[i-1];
        }

        System.out.println(Arrays.toString(vet));
    }
}
