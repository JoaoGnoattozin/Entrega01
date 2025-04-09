/**
 * Classe que representa um cliente VIP, herda de Cliente.
 * Possui um atributo adicional de desconto.
 */
public class ClienteVIP extends Cliente {
    private double desconto;

    /**
     * Construtor para ClienteVIP.
     * @param nome Nome do cliente
     * @param telefone Telefone do cliente
     * @param desconto Percentual de desconto (0-100)
     * @throws IllegalArgumentException Se o desconto for inválido
     */
    public ClienteVIP(String nome, String telefone, double desconto) {
        super(nome, telefone);
        this.setDesconto(desconto);
    }

    // Getter e Setter específico
    
    public double getDesconto() {
        return desconto;
    }

    /**
     * Define o desconto do cliente VIP.
     * @param desconto Percentual de desconto (0-100)
     * @throws IllegalArgumentException Se o desconto for inválido
     */
    public void setDesconto(double desconto) {
        if (desconto < 0 || desconto > 100) {
            throw new IllegalArgumentException("Desconto deve estar entre 0 e 100%.");
        }
        this.desconto = desconto;
    }

    /**
     * Sobrescreve o método da superclasse para incluir informações do VIP.
     */
    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Desconto VIP: " + desconto + "%");
    }
}
