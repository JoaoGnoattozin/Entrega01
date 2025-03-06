public class Reserva {
    private Cliente cliente;
    private Mesa mesa;
    private String horario;

    // Construtores
    public Reserva() {} // Construtor padrão
    public Reserva(Cliente cliente, Mesa mesa, String horario) { // Construtor parametrizado
        this.cliente = cliente;
        this.mesa = mesa;
        this.horario = horario;
    }
    public Reserva(Reserva outraReserva) { // Construtor de cópia
        this.cliente = new Cliente(outraReserva.cliente);
        this.mesa = new Mesa(outraReserva.mesa);
        this.horario = outraReserva.horario;
    }

    // Getters e Setters
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Mesa getMesa() {
        return mesa;
    }
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
}
