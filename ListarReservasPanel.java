import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ListarReservasPanel extends JPanel {
    private Restaurante restaurante;
    private JTable reservasTable;
    
    public ListarReservasPanel(Restaurante restaurante) {
        this.restaurante = restaurante;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        initComponents();
        atualizarTabela();
    }
    
    private void initComponents() {
        reservasTable = new JTable();
        reservasTable.setModel(new DefaultTableModel(
            new Object[]{"Cliente", "Telefone", "Mesa", "Horário", "Tipo Cliente"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tabela não editável
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(reservasTable);
        add(scrollPane, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        JButton atualizarButton = new JButton("Atualizar Lista");
        atualizarButton.addActionListener(this::atualizarTabela);
        buttonPanel.add(atualizarButton);
        
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void atualizarTabela(ActionEvent e) {
        atualizarTabela();
    }
    
    private void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) reservasTable.getModel();
        model.setRowCount(0);
        
        for (Reserva reserva : restaurante.getReservas()) {
            String tipoCliente = reserva.getCliente() instanceof ClienteVIP ? "VIP" : "Regular";
            model.addRow(new Object[]{
                reserva.getCliente().getNome(),
                reserva.getCliente().getTelefone(),
                reserva.getMesa().getNumero(),
                reserva.getHorarioFormatado(),
                tipoCliente
            });
        }
    }
}
