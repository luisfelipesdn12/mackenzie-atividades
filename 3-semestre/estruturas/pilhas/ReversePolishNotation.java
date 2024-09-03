import java.util.Scanner;
import java.util.Stack;

class ReversePolishNotation {
    public static void main(String[] args) {
        // Recebendo a expressão do terminal
        System.err.print("Expression: ");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        sc.close();

        // Criando a pilha de operações
        Stack<Float> operations = new Stack<Float>();

        // Separando os elementos da expressão em um array
        String[] components = expression.split(" ");

        // Para cada elemento
        for (String c : components) {
            float a, b;
            // Caso seja um operador, opere com os dois ultimos da pilha
            switch (c) {
                case "+":
                    operations.push(operations.pop() + operations.pop());
                    break;
                case "-":
                    b = operations.pop();
                    a = operations.pop();
                    operations.push(a - b);
                    break;
                case "x":
                    operations.push(operations.pop() * operations.pop());
                    break;
                case "/":
                    b = operations.pop();
                    a = operations.pop();
                    operations.push(a / b);
                    break;

                // Caso contrário, considera que é um inteiro e o adiciona na pilha
                default:
                    operations.push(Float.parseFloat(c));
                    break;
            }
        }

        // Mostre o resultado, o topo da pilha
        System.out.println(operations.pop());
    }
}
