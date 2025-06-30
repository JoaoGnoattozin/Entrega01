import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MesasDisponiveisPanel extends JPanel {
    private Restaurante restaurante;
    private JTable mesasTable;
    
    public MesasDisponiveisPanel(Restaurante restaurante) {
        this.restaurante = restaurante;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        initComponents();
        atualizarTabela();
    }
    
    private void initComponents() {
        mesasTable = new JTable();
        mesasTable.setModel(new DefaultTableModel(
            new Object[]{"Número", "Capacidade", "Status", "Tipo", "Vista Exclusiva"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tabela não editável
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(mesasTable);
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
        DefaultTableModel model = (DefaultTableModel) mesasTable.getModel();
        model.setRowCount(0);
        
        for (Mesa mesa : restaurante.getMesas()) {
            String tipo = mesa instanceof MesaVIP ? "VIP" : "Regular";
            String vistaExclusiva = mesa instanceof MesaVIP ? 
                (((MesaVIP)mesa).isTemVistaExclusiva() ? "Sim" : "Não") : "N/A";
            
            model.addRow(new Object[]{
                mesa.getNumero(),
                mesa.getCapacidade(),
                mesa.isOcupada() ? "Ocupada" : "Disponível",
                tipo,
                vistaExclusiva
            });
        }
    }
}
