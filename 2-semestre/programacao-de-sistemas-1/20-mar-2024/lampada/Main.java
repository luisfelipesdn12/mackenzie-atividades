public class Main {
    public static void main(String[] args) {
        Lampada l1 = new Lampada();
        l1.ligar();
        l1.desligar();
        l1.ligar();

        Lampada l2 = new Lampada();
        l2.ligar();
        l2.desligar();

        System.out.printf("L1 deveria estar ligada e está %s\n", l1.getLigada() ? "ligada" : "desligada");
        System.out.printf("L2 deveria estar desligada e está %s\n", l2.getLigada() ? "ligada" : "desligada");
    }
}
