public interface Reservavel {
    void fazerReserva(Cliente cliente, Mesa mesa, String horario);
    void cancelarReserva(Reserva reserva);
}
