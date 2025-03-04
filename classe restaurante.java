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
        reservas.remove(reserva);
        reserva.getMesa().setOcupada(false);
        System.out.println("Reserva cancelada com sucesso.");
    }

    public void listarReservas() {
        for (Reserva reserva : reservas) {
            System.out.println("Cliente: " + reserva.getCliente().getNome() +
                               ", Mesa: " + reserva.getMesa().getNumero() +
                               ", Horário: " + reserva.getHorario());
        }
    }
}
