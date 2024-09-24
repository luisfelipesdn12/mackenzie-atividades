// Luis Felipe 10420572 
// Marcos Minhano 10428577
// Matheus Fernandes 10420439

public class Produto{

  private int codigo;
  private String descricao;
  private double preco;

  public Produto(int codigo, String descricao, double preco){
    this.codigo = codigo;
    this.descricao = descricao;
    this.preco = preco;
  }
  
  public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

  @Override
  public String toString(){
    return "Produto: {item = " + descricao + " | preco = " + preco + " | codigo = " + codigo + "}" ; 
  }

}