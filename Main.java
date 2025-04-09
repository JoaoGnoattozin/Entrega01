/**
 * Classe que representa uma mesa do restaurante.
 * Contém informações como número, capacidade e status de ocupação.
 */
public class Mesa {
    private int numero;
    private int capacidade;
    private boolean ocupada;

    // Construtores
    
    /**
     * Construtor padrão vazio.
     */
    public Mesa() {}

    /**
     * Construtor com parâmetros.
     * @param numero Número da mesa (1-10)
     * @param capacidade Capacidade de pessoas
     * @throws IllegalArgumentException Se o número ou capacidade forem inválidos
     */
    public Mesa(int numero, int capacidade) {
        this.setNumero(numero);
        this.setCapacidade(capacidade);
        this.ocupada = false;
    }

    /**
     * Construtor de cópia.
     * @param outraMesa Objeto Mesa a ser copiado
     */
    public Mesa(Mesa outraMesa) {
        this.numero = outraMesa.numero;
        this.capacidade = outraMesa.capacidade;
        this.ocupada = outraMesa.ocupada;
    }

    // Getters e Setters
    
    public int getNumero() {
        return numero;
    }

    /**
     * Define o número da mesa com validação.
     * @param numero Número da mesa (1-10)
     * @throws IllegalArgumentException Se o número for inválido
     */
    public void setNumero(int numero) {
        if (numero < 1 || numero > 10) {
            throw new IllegalArgumentException("Número da mesa deve estar entre 1 e 10.");
        }
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    /**
     * Define a capacidade da mesa com validação.
     * @param capacidade Capacidade de pessoas (mínimo 1)
     * @throws IllegalArgumentException Se a capacidade for inválida
     */
    public void setCapacidade(int capacidade) {
        if (capacidade < 1) {
            throw new IllegalArgumentException("Capacidade deve ser pelo menos 1.");
        }
        this.capacidade = capacidade;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    /**
     * Exibe os detalhes da mesa no console.
     */
    public void exibirDetalhes() {
        System.out.println("Mesa " + numero + 
                         " | Capacidade: " + capacidade + 
                         " | Status: " + (ocupada ? "Ocupada" : "Disponível"));
    }
}
