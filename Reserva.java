import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Classe que representa uma reserva no restaurante.
 * Contém informações sobre cliente, mesa e horário.
 */
public class Reserva {
    private Cliente cliente;
    private Mesa mesa;
    private LocalDateTime horario;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    // Construtores
    
    /**
     * Construtor padrão vazio.
     */
    public Reserva() {}

    /**
     * Construtor com parâmetros.
     * @param cliente Cliente que fez a reserva
     * @param mesa Mesa reservada
     * @param horarioString Horário no formato "dd/MM/yyyy HH:mm"
     * @throws IllegalArgumentException Se o horário for inválido
     */
    public Reserva(Cliente cliente, Mesa mesa, String horarioString) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.setHorario(horarioString);
    }

    /**
     * Construtor de cópia.
     * @param outraReserva Objeto Reserva a ser copiado
     */
    public Reserva(Reserva outraReserva) {
        this.cliente = new Cliente(outraReserva.cliente);
        this.mesa = new Mesa(outraReserva.mesa);
        this.horario = outraReserva.horario;
    }

    // Getters e Setters
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo.");
        }
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        if (mesa == null) {
            throw new IllegalArgumentException("Mesa não pode ser nula.");
        }
        this.mesa = mesa;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    /**
     * Define o horário a partir de uma string formatada.
     * @param horarioString Horário no formato "dd/MM/yyyy HH:mm"
     * @throws IllegalArgumentException Se o formato for inválido
     */
    public void setHorario(String horarioString) {
        if (horarioString == null || horarioString.trim().isEmpty()) {
            throw new IllegalArgumentException("Horário não pode ser vazio.");
        }
        
        try {
            this.horario = LocalDateTime.parse(horarioString, FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de horário inválido. Use dd/MM/yyyy HH:mm");
        }
    }

    /**
     * Retorna o horário formatado como string.
     * @return Horário formatado
     */
    public String getHorarioFormatado() {
        return horario.format(FORMATTER);
    }
}
