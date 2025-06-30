import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CancelarReservaPanel extends JPanel {
    private Restaurante restaurante;
    private JTextField buscaField;
    private JComboBox<String> tipoBuscaCombo;
    
    public CancelarReservaPanel(Restaurante restaurante) {
        this.restaurante = restaurante;
        setLayout(new GridLayout(0, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        initComponents();
    }
    
    private void initComponents() {
        add(new JLabel("Buscar por:"));
        tipoBuscaCombo = new JComboBox<>(new String[]{"Número da Mesa", "Nome do Cliente"});
        add(tipoBuscaCombo);
        
        add(new JLabel("Valor para busca:"));
        buscaField = new JTextField();
        add(buscaField);
        
        add(new JLabel()); // Espaço vazio
        JButton buscarButton = new JButton("Buscar e Cancelar");
        buscarButton.addActionListener(this::cancelarReserva);
        add(buscarButton);
    }
    
    private void cancelarReserva(ActionEvent e) {
        try {
            int tipoBusca = tipoBuscaCombo.getSelectedIndex();
            String valorBusca = buscaField.getText();
            
            if (valorBusca == null || valorBusca.trim().isEmpty()) {
                throw new IllegalArgumentException("Digite um valor para busca.");
            }
            
            Reserva reserva;
            if (tipoBusca == 0) { // Por mesa
                int numeroMesa = Integer.parseInt(valorBusca);
                reserva = restaurante.buscarReservaPorMesa(numeroMesa);
            } else { // Por cliente
                reserva = restaurante.buscarReservaPorCliente(valorBusca);
            }
            
            if (reserva != null) {
                restaurante.cancelarReserva(reserva);
                JOptionPane.showMessageDialog(this, "Reserva cancelada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Reserva não encontrada!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Número da mesa deve ser um valor inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
