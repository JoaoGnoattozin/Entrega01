import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um restaurante e gerencia as reservas.
 * Implementa a interface Reservavel.
 */
public class Restaurante implements Reservavel {
    private List<Reserva> reservas;
    private List<Mesa> mesas;

    /**
     * Construtor que inicializa as listas e cria as mesas.
     */
    public Restaurante() {
        this.reservas = new ArrayList<>();
        this.mesas = new ArrayList<>();
        inicializarMesas();
    }

    /**
     * Inicializa as mesas do restaurante.
     */
    private void inicializarMesas() {
        // Mesas regulares
        for (int i = 1; i <= 8; i++) {
            mesas.add(new Mesa(i, 4)); // Capacidade padrão de 4 pessoas
        }
        
        // Mesas VIP
        mesas.add(new MesaVIP(9, 6, true));  // Mesa grande com vista
        mesas.add(new MesaVIP(10, 4, false)); // Mesa padrão sem vista
    }

    @Override
    public void fazerReserva(Cliente cliente, int numeroMesa, String horario) {
        validarParametrosReserva(cliente, numeroMesa, horario);
        
        Mesa mesa = buscarMesa(numeroMesa);
        if (mesa == null) {
            throw new IllegalArgumentException("Mesa " + numeroMesa + " não encontrada.");
        }

        if (mesa.isOcupada()) {
            throw new IllegalStateException("Mesa " + numeroMesa + " já está ocupada.");
        }

        // Verifica se já existe reserva para esta mesa no mesmo horário
        if (existeReservaNoHorario(numeroMesa, horario)) {
            throw new IllegalStateException("Já existe uma reserva para a mesa " + 
                                          numeroMesa + " no horário " + horario);
        }

        Reserva reserva = new Reserva(cliente, mesa, horario);
        reservas.add(reserva);
        mesa.setOcupada(true);
        
        System.out.println("Reserva confirmada para " + cliente.getNome() + 
                         " na mesa " + numeroMesa + 
                         " às " + horario);
    }

    @Override
    public void cancelarReserva(Reserva reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("Reserva não pode ser nula.");
        }

        if (reservas.remove(reserva)) {
            reserva.getMesa().setOcupada(false);
            System.out.println("Reserva cancelada com sucesso.");
        } else {
            throw new IllegalArgumentException("Reserva não encontrada.");
        }
    }

    /**
     * Lista todas as reservas atuais.
     */
    public void listarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
            return;
        }

        System.out.println("\n--- Lista de Reservas ---");
        for (Reserva reserva : reservas) {
            System.out.println("Cliente: " + reserva.getCliente().getNome() +
                             " | Mesa: " + reserva.getMesa().getNumero() +
                             " | Horário: " + reserva.getHorarioFormatado());
        }
    }

    /**
     * Lista todas as mesas disponíveis.
     */
    public void listarMesasDisponiveis() {
        System.out.println("\n--- Mesas Disponíveis ---");
        for (Mesa mesa : mesas) {
            if (!mesa.isOcupada()) {
                mesa.exibirDetalhes();
            }
        }
    }

    /**
     * Busca uma reserva pelo número da mesa.
     * @param numeroMesa Número da mesa
     * @return Reserva encontrada ou null se não existir
     */
    public Reserva buscarReservaPorMesa(int numeroMesa) {
        for (Reserva reserva : reservas) {
            if (reserva.getMesa().getNumero() == numeroMesa) {
                return reserva;
            }
        }
        return null;
    }

    /**
     * Busca uma reserva pelo nome do cliente.
     * @param nomeCliente Nome do cliente
     * @return Reserva encontrada ou null se não existir
     */
    public Reserva buscarReservaPorCliente(String nomeCliente) {
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            return null;
        }

        for (Reserva reserva : reservas) {
            if (reserva.getCliente().getNome().equalsIgnoreCase(nomeCliente)) {
                return reserva;
            }
        }
        return null;
    }

    // Métodos auxiliares privados
    
    private Mesa buscarMesa(int numeroMesa) {
        for (Mesa mesa : mesas) {
            if (mesa.getNumero() == numeroMesa) {
                return mesa;
            }
        }
        return null;
    }

    private boolean existeReservaNoHorario(int numeroMesa, String horario) {
        for (Reserva reserva : reservas) {
            if (reserva.getMesa().getNumero() == numeroMesa && 
                reserva.getHorarioFormatado().equals(horario)) {
                return true;
            }
        }
        return false;
    }

    private void validarParametrosReserva(Cliente cliente, int numeroMesa, String horario) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo.");
        }
        if (numeroMesa < 1 || numeroMesa > 10) {
            throw new IllegalArgumentException("Número da mesa deve estar entre 1 e 10.");
        }
        if (horario == null || horario.trim().isEmpty()) {
            throw new IllegalArgumentException("Horário não pode ser vazio.");
        }
    }
}
