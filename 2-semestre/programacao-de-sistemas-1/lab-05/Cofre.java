import java.util.ArrayList;

public class Cofre {
    private ArrayList<Moeda> moedas;

    public Cofre() {
        this.moedas = new ArrayList<Moeda>();
    }

    public void adicionar(Moeda m) {
        moedas.add(m);
    }

    public double calcularTotal() {
        double total = 0;
        
        for (Moeda moeda : moedas) {
            total += moeda.getValor();
        }

        return total;
    }

    public int contarMoedas(Moeda m) {
        int quantidade = 0;

        for (Moeda moeda : moedas) {
            quantidade += moeda.getValor() == m.getValor() ? 1 : 0;
        }

        return quantidade;
    }
}
