public class Main {
    public static void main(String[] args) {
        Pedido p = new Pedido(1234, "Luis", "Garrafa");
        p.setValorPedido(1000);
        double valorComImposto = p.valorComImposto(10);

        System.out.println(valorComImposto);
    }
}
