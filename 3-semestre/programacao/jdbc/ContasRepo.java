import java.sql.*;
import java.util.*;

public class ContasRepo {

    PreparedStatement stmC;
    PreparedStatement stmR;
    PreparedStatement stmU;
    PreparedStatement stmD;

    public ContasRepo() throws SQLException {
        String url = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:6543/postgres";
        String username = "postgres.shaiudghbkjdasdsahuqw";
        String passowrd = "cNM0bB7xH6i5J23H";

        Connection con = DriverManager.getConnection(url, username, passowrd);
        String sqlC = "INSERT INTO contas VALUES (?,?,?)";
        stmC = con.prepareStatement(sqlC);
        String sqlR = "SELECT * FROM contas";
        stmR = con.prepareStatement(sqlR);
        String sqlU = "UPDATE contas SET titular = ?, saldo = ? WHERE nro_conta = ?";
        stmU = con.prepareStatement(sqlU);
        String sqlD = "DELETE FROM contas where nro_conta = ?";
        stmD = con.prepareStatement(sqlD);
    }

    public List<Conta> lerTodas() throws SQLException {
        List<Conta> contas = new ArrayList<>();
        ResultSet rs = stmR.executeQuery();
        while(rs.next()){
            int numero = rs.getInt("nro_conta");
            String titular = rs.getString("titular");
            double saldo = rs.getDouble("saldo");
            Conta conta = new Conta(numero,titular,saldo);
            contas.add(conta);
        }
        return contas;
    }

    public int criar(Conta conta) throws SQLException {
        stmC.setInt(1,conta.getNumero());
        stmC.setDouble(2,conta.getSaldo());
        stmC.setString(3,conta.getTitular());
        return stmC.executeUpdate();
    }

    public Conta getConta(int nroConta) throws SQLException {
        List<Conta> contas = lerTodas();
        return contas.stream()
                .filter(conta -> conta.getNumero() == nroConta)
                .findFirst()
                .orElse(null);
    }

    public int alterarDados(Conta contaParaAlternar) throws Exception {
        stmU.setString(1, contaParaAlternar.getTitular());
        stmU.setDouble(2, contaParaAlternar.getSaldo());
        stmU.setInt(3, contaParaAlternar.getNumero());
        return stmU.executeUpdate();
    }

    public int apagarConta(int nroConta) throws SQLException {
        stmD.setInt(1, nroConta);
        return stmD.executeUpdate();
    }
}