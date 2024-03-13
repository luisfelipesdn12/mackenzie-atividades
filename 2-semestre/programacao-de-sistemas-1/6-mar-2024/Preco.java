import java.util.Scanner;

public class Preco {
    public static void main(String[] args) {
        float[] precos = entrada();
        float media = mediaPrecos(precos);
        int lojasAcimaMedia  = contaLojas(precos, media);

        System.err.printf("A média dos preços é %f\n", media);
        System.err.printf("%d lojas têm prços acima da média\n", lojasAcimaMedia);
    }

    public static float[] entrada() {
        Scanner in = new Scanner(System.in);
        float[] precos = new float[10];
        
        for (int i = 0; i < precos.length; i++) {
            System.out.printf("\nDigite o %dº preço: ", i + 1);
            precos[i] = in.nextFloat();
        }

        in.close();
        return precos;
    }

    public static float mediaPrecos(float[] arr) {
        float soma = 0;

        for (float f : arr) {
            soma += f;
        }

        return soma / arr.length;
    }

    public static int contaLojas(float[] arr, float media) {
        int result = 0;

        for (float f : arr) {
            if (f > media) {
                result++;
            }
        }

        return result;
    }
}
