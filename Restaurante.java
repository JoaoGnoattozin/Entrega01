import java.util.ArrayList;
import java.util.List;

public class Restaurante implements Reservavel {
    private List<Reserva> reservas;
    private List<Mesa> mesasDisponiveis;

    public Restaurante() {
        this.reservas = new ArrayList<>();
        this.mesasDisponiveis = new ArrayList<>();

        // Inicializa as mesas disponíveis (números de 1 a 10)
        for (int i = 1; i <= 10; i++) {
            mesasDisponiveis.add(new Mesa(i, 4)); // Capacidade fixa para exemplo
        }
    }

    @Override
    public void fazerReserva(Cliente cliente, int numeroMesa, String horario) {
        Mesa mesa = buscarMesaPorNumero(numeroMesa);

        if (mesa == null) {
            System.out.println("Mesa não encontrada.");
            return;
        }

        if (mesa.isOcupada()) {
            System.out.println("Mesa " + numeroMesa + " já está ocupada.");
            return;
        }

        Reserva reserva = new Reserva(cliente, mesa, horario);
        reservas.add(reserva);
        mesa.setOcupada(true);
        mesasDisponiveis.remove(mesa); // Remove a mesa da lista de disponíveis
        System.out.println("Reserva feita com sucesso para " + cliente.getNome());
    }

    @Override
    public void cancelarReserva(Reserva reserva) {
        if (reservas.remove(reserva)) {
            reserva.getMesa().setOcupada(false);
            mesasDisponiveis.add(reserva.getMesa()); // Adiciona a mesa de volta à lista de disponíveis
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

    public void listarMesasDisponiveis() {
        System.out.println("--- Mesas Disponíveis ---");
        for (Mesa mesa : mesasDisponiveis) {
            System.out.println("Mesa " + mesa.getNumero() + " | Capacidade: " + mesa.getCapacidade());
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

    // Método para buscar uma mesa pelo número
    public Mesa buscarMesaPorNumero(int numeroMesa) {
        for (Mesa mesa : mesasDisponiveis) {
            if (mesa.getNumero() == numeroMesa) {
                return mesa;
            }
        }
        return null; // Retorna null se não encontrar a mesa
    }
}
