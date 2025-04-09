/**
 * Interface que define os métodos básicos para um sistema de reservas.
 */
public interface Reservavel {
    /**
     * Realiza uma reserva.
     * @param cliente Cliente que está fazendo a reserva
     * @param numeroMesa Número da mesa desejada
     * @param horario Horário da reserva no formato "dd/MM/yyyy HH:mm"
     * @throws IllegalArgumentException Se algum parâmetro for inválido
     */
    void fazerReserva(Cliente cliente, int numeroMesa, String horario) throws IllegalArgumentException;

    /**
     * Cancela uma reserva existente.
     * @param reserva Reserva a ser cancelada
     * @throws IllegalArgumentException Se a reserva for inválida
     */
    void cancelarReserva(Reserva reserva) throws IllegalArgumentException;
}
