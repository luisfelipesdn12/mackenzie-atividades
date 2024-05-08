class Main {
    public static void main(String[] args) {
        Moeda umReal = new Moeda(1, "um real");
        Moeda cinquentaCentavos = new Moeda(0.5, "cinquenta centavos");

        Cofre c = new Cofre();
        c.adicionar(umReal);
        c.adicionar(umReal);
        c.adicionar(umReal);
        c.adicionar(cinquentaCentavos);

        System.out.println(c.calcularTotal());
        System.out.println(c.contarMoedas(cinquentaCentavos));
    }
}
