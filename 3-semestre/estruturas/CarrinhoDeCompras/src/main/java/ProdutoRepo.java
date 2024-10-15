// Luis Felipe 10420572 
// Marcos Minhano 10428577
// Matheus Fernandes 10420439

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.*;

public class ProdutoRepo extends DAO<Produto> {
    public ProdutoRepo() throws SQLException {
    }

    @Override
    public List<Produto> getAll() throws SQLException {
        this.init();
        PreparedStatement query = this.con.prepareStatement("select * from produtos");
        ResultSet res = query.executeQuery();

        List<Produto> produtos = new ArrayList<Produto>();

        while (res.next()) {
            String id = res.getString("id");
            String name = res.getString("name");
            double price = res.getDouble("price");
            produtos.add(new Produto(Integer.parseInt(id), name, price));
        }

        this.con.close();
        return produtos;
    }

    public void buscaProduto() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o código: ");
        String codigoString = sc.next();
        Integer codigo = Integer.parseInt(codigoString);

        for (Produto p : this.getAll()) {
            if (codigo == p.getCodigo()) {
                System.out.println(p);
                int quantidade = InputHelper.getIntInput("Insira a quantidade: ");
                ItemCompra ic = new ItemCompra(p.getDescricao(), quantidade, p.getPreco() * quantidade);
                System.out.println("Item adicionado com sucesso!");
                System.out.println(ic);
                sc.close();
                return;
            }
        }

        System.out.println("Não foi encontrado nenhum produto.");
        sc.close();
    }
}
