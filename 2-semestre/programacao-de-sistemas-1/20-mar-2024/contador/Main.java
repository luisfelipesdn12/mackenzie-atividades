public class Main {
    public static void main(String[] args) {
        Contador c1 = new Contador();
        c1.incrementar();
        c1.zerar();
        c1.incrementar();
        c1.zerar();

        Contador c2 = new Contador();
        c2.incrementar();
        c2.zerar();
        c2.incrementar();
        c2.incrementar();

        System.out.printf("C1 deveria ser 0 e é %d\n", c1.getValor());
        System.out.printf("C2 deveria ser 2 e é %d\n", c2.getValor());
    }
}
