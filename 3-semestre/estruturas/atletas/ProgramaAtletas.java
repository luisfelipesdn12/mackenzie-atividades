import java.util.*;

class Atleta implements Comparable<Atleta> {
    private String nome;
    private int idade;
    private int pontuacao;

    public Atleta(String nome, int idade, int pontuacao) {
        this.nome = nome;
        this.idade = idade;
        this.pontuacao = pontuacao;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    @Override
    public String toString() {
        return "Atleta{nome='" + nome + "', idade=" + idade + ", pontuacao=" + pontuacao + "}";
    }

    @Override
    public int compareTo(Atleta outro) {
        return this.nome.compareTo(outro.nome);
    }
}

class ComparadorIdade implements Comparator<Atleta> {
    @Override
    public int compare(Atleta a1, Atleta a2) {
        return Integer.compare(a1.getIdade(), a2.getIdade());
    }
}

class ComparadorPontuacaoDecrescente implements Comparator<Atleta> {
    @Override
    public int compare(Atleta a1, Atleta a2) {
        return Integer.compare(a2.getPontuacao(), a1.getPontuacao());
    }
}

class ComparadorNome implements Comparator<Atleta> {
    @Override
    public int compare(Atleta a1, Atleta a2) {
        return a1.getNome().compareTo(a2.getNome());
    }
}

public class ProgramaAtletas {
    public static void main(String[] args) {
        List<Atleta> atletas = new ArrayList<>();
        atletas.add(new Atleta("Carlos", 25, 80));
        atletas.add(new Atleta("Ana", 22, 95));
        atletas.add(new Atleta("Bruno", 28, 85));
        atletas.add(new Atleta("Diana", 20, 90));

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nEscolha uma opção de visualização:");
            System.out.println("1 - Ordem alfabética do nome (Comparable)");
            System.out.println("2 - Ordem crescente de idade (Comparator)");
            System.out.println("3 - Ordem decrescente de pontuação (Comparator)");
            System.out.println("4 - Ordem alfabética do nome (Comparator)");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Collections.sort(atletas);
                    break;
                case 2:
                    atletas.sort(new ComparadorIdade());
                    break;
                case 3:
                    atletas.sort(new ComparadorPontuacaoDecrescente());
                    break;
                case 4:
                    atletas.sort(new ComparadorNome());
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    continue;
            }

            if (opcao != 0) {
                System.out.println("\nLista de Atletas:");
                for (Atleta atleta : atletas) {
                    System.out.println(atleta);
                }
            }
        } while (opcao != 0);

        scanner.close();
    }
}