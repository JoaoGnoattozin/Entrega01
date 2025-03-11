public class ClienteVIP extends Cliente {
    private double desconto;

    // Construtor
    public ClienteVIP(String nome, String telefone, double desconto) {
        super(nome, telefone); // Chama o construtor da superclasse
        this.desconto = desconto;
    }

    // Getter e Setter específico
    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    // Sobrescreve o método da superclasse
    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes(); // Chama o método da superclasse
        System.out.println("Desconto VIP: " + desconto + "%");
    }
}
