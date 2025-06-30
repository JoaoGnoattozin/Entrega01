import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ReservaPanel extends JPanel {
    private Restaurante restaurante;
    private JTextField nomeField, telefoneField, descontoField, mesaField, horarioField;
    private JComboBox<String> tipoClienteCombo;
    
    public ReservaPanel(Restaurante restaurante) {
        this.restaurante = restaurante;
        setLayout(new GridLayout(0, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        initComponents();
    }
    
    private void initComponents() {
        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);
        
        add(new JLabel("Telefone (11 dígitos):"));
        telefoneField = new JTextField();
        add(telefoneField);
        
        add(new JLabel("Tipo de Cliente:"));
        tipoClienteCombo = new JComboBox<>(new String[]{"Regular", "VIP"});
        add(tipoClienteCombo);
        
        add(new JLabel("Desconto VIP (%):"));
        descontoField = new JTextField();
        descontoField.setEnabled(false);
        add(descontoField);
        
        tipoClienteCombo.addActionListener(e -> {
            descontoField.setEnabled(tipoClienteCombo.getSelectedIndex() == 1);
        });
        
        add(new JLabel("Número da Mesa (1-10):"));
        mesaField = new JTextField();
        add(mesaField);
        
        add(new JLabel("Horário (dd/MM/yyyy HH:mm):"));
        horarioField = new JTextField();
        add(horarioField);
        
        add(new JLabel()); // Espaço vazio
        JButton reservarButton = new JButton("Fazer Reserva");
        reservarButton.addActionListener(this::fazerReserva);
        add(reservarButton);
    }
    
    private void fazerReserva(ActionEvent e) {
        try {
            String nome = nomeField.getText();
            String telefone = telefoneField.getText();
            int tipoCliente = tipoClienteCombo.getSelectedIndex();
            int numeroMesa = Integer.parseInt(mesaField.getText());
            String horario = horarioField.getText();
            
            Cliente cliente;
            if (tipoCliente == 1) { // VIP
                double desconto = Double.parseDouble(descontoField.getText());
                cliente = new ClienteVIP(nome, telefone, desconto);
            } else {
                cliente = new Cliente(nome, telefone);
            }
            
            restaurante.fazerReserva(cliente, numeroMesa, horario);
            JOptionPane.showMessageDialog(this, "Reserva realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limparCampos() {
        nomeField.setText("");
        telefoneField.setText("");
        tipoClienteCombo.setSelectedIndex(0);
        descontoField.setText("");
        mesaField.setText("");
        horarioField.setText("");
    }
}
