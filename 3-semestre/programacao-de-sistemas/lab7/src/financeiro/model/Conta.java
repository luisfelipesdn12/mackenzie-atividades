package financeiro.model;

import java.math.BigDecimal;

public class Conta {
    private int numero;
    private BigDecimal saldo;

    
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public BigDecimal getSaldo() {
        return saldo;
    }
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
