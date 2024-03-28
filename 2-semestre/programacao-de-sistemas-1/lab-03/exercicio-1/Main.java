public class Main {
    public static void main(String[] args) {
        Conta c = new Conta("Luis Felipe", 1223, 500);
        c.depositar(300);
        c.sacar(150);

        System.out.println(c.saldo);
    }
}
