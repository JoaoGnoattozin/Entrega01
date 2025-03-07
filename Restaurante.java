import java.util.ArrayList;
import java.util.List;

public class Restaurante implements Reservavel {
    private List<Reserva> reservas;

    public Restaurante() {
        this.reservas = new ArrayList<>();
    }

    @Override
    public void fazerReserva(Cliente cliente, Mesa mesa, String horario) {
        if (!mesa.isOcupada()) {
            Reserva reserva = new Reserva(cliente, mesa, horario);
            reservas.add(reserva);
            mesa.setOcupada(true);
            System.out.println("Reserva feita com sucesso para " + cliente.getNome());
        } else {
            System.out.println("Mesa ocupada. Escolha outra mesa.");
        }
    }

    @Override
    public void cancelarReserva(Reserva reserva) {
        if (reservas.remove(reserva)) {
            reserva.getMesa().setOcupada(false);
            System.out.println("Reserva cancelada com sucesso.");
        } else {
            System.out.println("Reserva não encontrada.");
        }
    }

    public void listarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
        } else {
            System.out.println("--- Lista de Reservas ---");
            for (Reserva reserva : reservas) {
                System.out.println("Cliente: " + reserva.getCliente().getNome() +
                                   ", Mesa: " + reserva.getMesa().getNumero() +
                                   ", Horário: " + reserva.getHorario());
            }
        }
    }

    // Método para buscar uma reserva pelo número da mesa
    public Reserva buscarReservaPorMesa(int numeroMesa) {
        for (Reserva reserva : reservas) {
            if (reserva.getMesa().getNumero() == numeroMesa) {
                return reserva;
            }
        }
        return null; // Retorna null se não encontrar a reserva
    }

    // Método para buscar uma reserva pelo nome do cliente
    public Reserva buscarReservaPorCliente(String nomeCliente) {
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().getNome().equalsIgnoreCase(nomeCliente)) {
                return reserva;
            }
        }
        return null; // Retorna null se não encontrar a reserva
    }
}
