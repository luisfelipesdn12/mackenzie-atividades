class Lampada {
    boolean ligada = false;
    
    void ligar() {
        this.ligada = true;
    }

    void desligar() {
        this.ligada = false;
    }

    boolean getLigada() {
        return this.ligada;
    }
}
