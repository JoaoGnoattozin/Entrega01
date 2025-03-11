public interface Reservavel {
    void fazerReserva(Cliente cliente, int numeroMesa, String horario);
    void cancelarReserva(Reserva reserva);
}
