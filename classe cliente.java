public class Cliente {
    private String nome;
    private String telefone;

    // Construtores
    public Cliente() {} // Construtor padrão
    public Cliente(String nome, String telefone) { // Construtor parametrizado
        this.nome = nome;
        this.telefone = telefone;
    }
    public Cliente(Cliente outroCliente) { // Construtor de cópia
        this.nome = outroCliente.nome;
        this.telefone = outroCliente.telefone;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
