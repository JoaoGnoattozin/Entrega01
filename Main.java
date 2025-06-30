import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            Restaurante restaurante = new Restaurante();
            new MainFrame(restaurante).setVisible(true);
        });
    }
}

class MainFrame extends JFrame {
    private Restaurante restaurante;
    
    public MainFrame(Restaurante restaurante) {
        this.restaurante = restaurante;
        setTitle("Sistema de Reservas de Restaurante");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initUI();
    }
    
    private void initUI() {
        JTabbedPane tabbedPane = new JTabbedPane();
        
        tabbedPane.addTab("Fazer Reserva", new ReservaPanel(restaurante));
        tabbedPane.addTab("Cancelar Reserva", new CancelarReservaPanel(restaurante));
        tabbedPane.addTab("Listar Reservas", new ListarReservasPanel(restaurante));
        tabbedPane.addTab("Mesas Disponíveis", new MesasDisponiveisPanel(restaurante));
        
        add(tabbedPane);
    }
}
