class Elevador {
    int andarAtual;
    int totalDeAndares;
    int capacidade;
    int pessoasPresentes;

    public Elevador(int totalDeAndares, int capacidade) {
        this.totalDeAndares = totalDeAndares;
        this.capacidade = capacidade;
    }

    public void entrar() {
        if (this.pessoasPresentes < this.capacidade) {
            this.pessoasPresentes++;
        }
    }

    public void sair() {
        if (this.pessoasPresentes > 0) {
            this.pessoasPresentes--;
        }
    }

    public void subir() {
        if (this.andarAtual < this.totalDeAndares) {
            this.andarAtual++;
        }
    }

    public void descer() {
        if (this.andarAtual > 0) {
            this.andarAtual--;
        }
    }
}
