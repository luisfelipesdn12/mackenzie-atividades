public class Main {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario(
            "12345678-0",
            "Antonio Ferreira",
            "Vendas",
            3000
        );

        f1.recebeAumento(20);
        f1.exibeInformações();
        System.out.println(f1.calculaGanhoAnual());

        Funcionario f2 = new Funcionario(
            "87654321-0",
            "Luis Felipe",
            "Desenvolvimento",
            4000
        );

        f2.recebeAumento(50);
        f2.exibeInformações();
        System.out.println(f2.calculaGanhoAnual());
    }
}
