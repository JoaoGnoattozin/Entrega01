/**
 * Classe que representa um cliente do restaurante.
 * Possui atributos básicos como nome e telefone, com validações.
 */
public class Cliente {
    private String nome;
    private String telefone;

    // Construtores
    
    /**
     * Construtor padrão vazio.
     */
    public Cliente() {}

    /**
     * Construtor com parâmetros.
     * @param nome Nome do cliente
     * @param telefone Telefone do cliente (deve conter 11 dígitos)
     * @throws IllegalArgumentException Se o telefone for inválido
     */
    public Cliente(String nome, String telefone) {
        this.nome = nome;
        this.setTelefone(telefone); // Usa o setter para validar
    }

    /**
     * Construtor de cópia.
     * @param outroCliente Objeto Cliente a ser copiado
     */
    public Cliente(Cliente outroCliente) {
        this.nome = outroCliente.nome;
        this.telefone = outroCliente.telefone;
    }

    // Getters e Setters
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do cliente com validação.
     * @param telefone Telefone com 11 dígitos
     * @throws IllegalArgumentException Se o telefone for inválido
     */
    public void setTelefone(String telefone) {
        if (telefone == null || !telefone.matches("\\d{11}")) {
            throw new IllegalArgumentException("Telefone deve conter exatamente 11 dígitos.");
        }
        this.telefone = telefone;
    }

    /**
     * Exibe os detalhes do cliente no console.
     */
    public void exibirDetalhes() {
        System.out.println("Cliente: " + nome + " | Telefone: " + telefone);
    }
}
