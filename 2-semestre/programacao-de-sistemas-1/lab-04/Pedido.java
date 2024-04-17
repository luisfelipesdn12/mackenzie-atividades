class Pedido {
    private int codigoPedido;
    private String nomeDoCliente;
    private String descricaoPedido;
    private double valorPedido;

    public Pedido(int codigoPedido, String nomeDoCliente, String descricaoPedido) {
        this.codigoPedido = codigoPedido;
        this.nomeDoCliente = nomeDoCliente;
        this.descricaoPedido = descricaoPedido;
    }

    public double valorComImposto(double porcentagem) {
        return this.valorPedido + ((this.valorPedido / 100) * porcentagem);
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public String getDescricaoPedido() {
        return descricaoPedido;
    }

    public void setDescricaoPedido(String descricaoPedido) {
        this.descricaoPedido = descricaoPedido;
    }

    public double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }
}
