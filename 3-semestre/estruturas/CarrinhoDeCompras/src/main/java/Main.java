
// Luis Felipe 10420572 
// Marcos Minhano 10428577
// Matheus Fernandes 10420439

import java.sql.SQLException;

public class Main {
  public static void main(String[] args) throws SQLException {
    ProdutoRepo produtoRepo = new ProdutoRepo();
    produtoRepo.buscaProduto();
  }
}