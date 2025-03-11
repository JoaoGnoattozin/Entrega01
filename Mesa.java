public class Mesa {
    private int numero;
    private int capacidade;
    private boolean ocupada;

    // Construtores
    public Mesa() {} // Construtor padrão

    public Mesa(int numero, int capacidade) {
        if (numero < 1 || numero > 10) {
            throw new IllegalArgumentException("Número da mesa deve estar entre 1 e 10.");
        }
        this.numero = numero;
        this.capacidade = capacidade;
        this.ocupada = false;
    }

    public Mesa(Mesa outraMesa) { // Construtor de cópia
        this.numero = outraMesa.numero;
        this.capacidade = outraMesa.capacidade;
        this.ocupada = outraMesa.ocupada;
    }

    // Getters e Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero < 1 || numero > 10) {
            throw new IllegalArgumentException("Número da mesa deve estar entre 1 e 10.");
        }
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    // Método comum
    public void exibirDetalhes() {
        System.out.println("Mesa " + numero + " | Capacidade: " + capacidade);
    }
}
