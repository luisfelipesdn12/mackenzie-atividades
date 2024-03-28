class Funcionario {
    String rg;
    String nome;
    String departamento;
    double salario;

    public Funcionario(String rg, String nome, String departamento, double salario) {
        this.rg = rg;
        this.nome = nome;
        this.departamento = departamento;
        this.salario = salario;
    }

    public void recebeAumento(double porcentagemAumento) {
        salario += (salario / 100) * porcentagemAumento;
    }

    public double calculaGanhoAnual() {
        return salario * 12;
    }

    public void exibeInformações() {
        System.out.printf("Nome = %s\nDepartamento = %s\nSalário = R$ %.2f\n", nome, departamento, salario);
    }
}
