public class Conta {

    private int numero;
    private String titular;
    private double saldo;

    public Conta(int n, String t, double s) {
        numero = n;
        titular = t;
        saldo = s;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Conta: " + "{numero = " + numero + " | titular = " + titular + " | saldo = " + saldo + "}";
    }

}