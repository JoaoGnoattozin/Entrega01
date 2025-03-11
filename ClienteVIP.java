public class MesaVIP extends Mesa {
    private boolean temVistaExclusiva;

    // Construtor
    public MesaVIP(int numero, int capacidade, boolean temVistaExclusiva) {
        super(numero, capacidade); // Chama o construtor da superclasse
        this.temVistaExclusiva = temVistaExclusiva;
    }

    // Getter e Setter específico
    public boolean isTemVistaExclusiva() {
        return temVistaExclusiva;
    }

    public void setTemVistaExclusiva(boolean temVistaExclusiva) {
        this.temVistaExclusiva = temVistaExclusiva;
    }

    // Sobrescreve o método da superclasse
    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes(); // Chama o método da superclasse
        System.out.println("Vista Exclusiva: " + (temVistaExclusiva ? "Sim" : "Não"));
    }
}
