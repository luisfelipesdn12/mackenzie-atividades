public class Main {
    public static void main(String[] args) {
        Elevador e = new Elevador(10, 8);
        e.entrar();
        e.subir();
        e.subir();
        e.subir();
        e.sair();
        e.descer();
        e.descer();

        System.out.println(e.andarAtual);
    }
}
