import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurante restaurante = new Restaurante();
        int opcao;

        do {
            System.out.println("1 - Fazer Reserva");
            System.out.println("2 - Cancelar Reserva");
            System.out.println("3 - Listar Reservas");
            System.out.println("4 - Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Nome do cliente:");
                    String nome = scanner.next();
                    System.out.println("Telefone do cliente:");
                    String telefone = scanner.next();
                    System.out.println("Número da mesa:");
                    int numeroMesa = scanner.nextInt();
                    System.out.println("Horário da reserva:");
                    String horario = scanner.next();

                    Cliente cliente = new Cliente(nome, telefone);
                    Mesa mesa = new Mesa(numeroMesa, 4); // Capacidade fixa para exemplo
                    restaurante.fazerReserva(cliente, mesa, horario);
                    break;

                case 2:
                    // Implementar cancelamento de reserva
                    break;

                case 3:
                    restaurante.listarReservas();
                    break;
            }
        } while (opcao != 4);
    }
}
