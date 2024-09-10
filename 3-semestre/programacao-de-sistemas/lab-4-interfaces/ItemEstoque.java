/**
 * Uma classe que representa um item de estoque,
 * composta por um produto e a quantidade em estoque desse produto.
 */
public class ItemEstoque {
    private Produto produto;
    private int quantidade;

    public ItemEstoque(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
