class Conta {
    String nomeDoCliente;
    int numeroDaConta;
    double saldo;

    public Conta(String nomeDoCliente, int numeroDaConta, double saldo) {
        this.nomeDoCliente = nomeDoCliente;
        this.numeroDaConta = numeroDaConta;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }
}
