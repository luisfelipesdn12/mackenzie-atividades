import java.util.Random;

class Matrizes {
    public static int cont = 0;
    public static final int n = 4;

    public static void main(String[] args) {
        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        // preenche as matrizes A e B com números aleatórios
        preenche(A);
        preenche(B);

        System.out.println("A: ");
        mostraMatriz(A);
        System.out.println("B: ");
        mostraMatriz(B);

        // cria a matriz C para receber o resultado
        int[][] C = new int[A.length][B[0].length];
        C = multiplica(A, B);
        System.out.println("C: ");
        mostraMatriz(C);

        System.out.println("Execução: " + cont);
    }

    public static void preenche(int M[][]) {
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                M[i][j] = new Random().nextInt(10);
            }
        }
    }

    public static int[][] multiplica(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                C[i][j] = 0;
                for (int k = 0; k < A[0].length; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                    cont++;
                }
            }
        }
        return C;
    }

    public static void mostraMatriz(int M[][]) {
        for (int i = 0; i < M.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < M[i].length; j++) {
                System.out.print(M[i][j]);
                System.out.print(" ");
            }
            System.out.println("]");
        }
    }
}