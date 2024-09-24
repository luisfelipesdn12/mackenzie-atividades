// Luis Felipe 10420572 
// Marcos Minhano 10428577
// Matheus Fernandes 10420439

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdutoRepo {
    private List<Produto> produtos;

    public ProdutoRepo() {
        this.produtos = lerProdutos("src/main/java/produtos.txt");
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    private static List<Produto> lerProdutos(String path) {
        List<Produto> produtos = new ArrayList<Produto>();
        try {
            Path arq_produtos = Paths.get(path);
            String aux[] = Files.readAllLines(arq_produtos).toArray(new String[0]);
            for (String produto : aux) {
                String atributosProduto[] = produto.split(";");
                Integer codigo = Integer.parseInt(atributosProduto[0]);
                String descricao = atributosProduto[1];
                Double preco = Double.parseDouble(atributosProduto[2]);
                Produto novoProduto = new Produto(codigo, descricao, preco);
                produtos.add(novoProduto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produtos;
    }

    public void buscaProduto() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o código: ");
        String codigoString = sc.next();
        Integer codigo = Integer.parseInt(codigoString);

        for (Produto p : this.produtos) {
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
