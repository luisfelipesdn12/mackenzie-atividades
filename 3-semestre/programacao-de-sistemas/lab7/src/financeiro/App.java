package financeiro;

import java.math.BigDecimal;

import financeiro.dao.DAO;
import financeiro.dao.DaoConta;
import financeiro.model.Conta;

public class App {
    public static void main(String[] args) {
        DAO dao = new DaoConta();

        Conta c1 = new Conta();
        c1.setNumero(300);
        c1.setSaldo(new BigDecimal(9000));

        dao.create(c1);

        System.out.println(dao.buscaTudo());
    }
}
