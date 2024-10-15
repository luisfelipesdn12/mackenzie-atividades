import java.sql.*;
import java.util.List;
import static java.lang.System.out;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        ContasRepo repo = new ContasRepo();

        while (true){
            out.println("----- MENU DE CONTAS -----");
            out.println("1 - CRIAR NOVA CONTA");
            out.println("2 - LER TODAS AS CONTAS");
            out.println("3 - LER DADOS DE UMA CONTA");
            out.println("4 - ALTERAR OS DADOS DE UMA CONTA");
            out.println("5 - APAGAR UMA CONTA");
            out.println("0 - SAIR");
            out.println("--------------------------");
            out.print("Opção: ");

            int opcao = SCANNER.nextInt();

            if (opcao == 1) {
                Conta conta = criarConta();
                try {
                    int n = repo.criar(conta);
                    out.println("Registros inseridos: " + n);
                } catch (Exception ignored) {
                    out.println("Conta já existente");
                }
            } else if (opcao == 2) {
                List<Conta> contas = repo.lerTodas();
                for(Conta c: contas){
                    out.println("# a conta " + c.getNumero() + " pertence a " + c.getTitular() + " e tem R$ " + c.getSaldo());
                }
            } else if (opcao == 3) {
                out.print("Número da conta que deseja ler: ");
                int nroConta = SCANNER.nextInt();
                try {
                    Conta conta = repo.getConta(nroConta);
                    Objects.requireNonNull(conta);
                    out.println(conta.toString());
                } catch (Exception ignored) {
                    out.println("Conta não encontrada!");
                }
            } else if (opcao == 4) {
                Conta contaParaAlterar = criarConta();
                try {
                    int numero = repo.alterarDados(contaParaAlterar);
                    out.println("Registro alterados: " + numero);
                } catch (Exception ignored) {
                    out.println("Conta não encontrada!");
                }
            } else if (opcao == 5) {
                out.println("Número da conta: ");
                int numeroDaContaParaApagar = SCANNER.nextInt();
                try {
                    int contasApagadas = repo.apagarConta(numeroDaContaParaApagar);
                    out.println("Registros apagados: " + contasApagadas);
                } catch (Exception ignored) {
                    out.println("Conta não encontrada!");
                }
            } else if (opcao == 0) {
                break;
            } else {
                out.println("OPÇÃO INVÁLIDA");
            }
        }
        out.println("----- FIM DO PROGRAMA -----");
    }

    private static Conta criarConta() {

        out.print("Número da conta: ");
        int numero = SCANNER.nextInt();

        out.print("Titular: ");
        String titular = SCANNER.next();

        out.print("Saldo: ");
        double saldo = SCANNER.nextDouble();

        return new Conta(numero, titular, saldo);
    }


}