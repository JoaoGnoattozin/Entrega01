import java.util.Scanner;

/**
 * Classe principal que controla a interação com o usuário.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurante restaurante = new Restaurante();
        int opcao;

        do {
            exibirMenu();
            opcao = lerOpcao(scanner);

            switch (opcao) {
                case 1:
                    fazerReserva(scanner, restaurante);
                    break;
                case 2:
                    cancelarReserva(scanner, restaurante);
                    break;
                case 3:
                    restaurante.listarReservas();
                    break;
                case 4:
                    restaurante.listarMesasDisponiveis();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--- Sistema de Reservas de Restaurante ---");
        System.out.println("1 - Fazer Reserva");
        System.out.println("2 - Cancelar Reserva");
        System.out.println("3 - Listar Reservas");
        System.out.println("4 - Listar Mesas Disponíveis");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número.");
            scanner.next(); // Limpa a entrada inválida
            System.out.print("Escolha uma opção: ");
        }
        return scanner.nextInt();
    }

    private static void fazerReserva(Scanner scanner, Restaurante restaurante) {
        scanner.nextLine(); // Limpar buffer
        
        System.out.println("\n--- Fazer Reserva ---");
        
        // Dados do cliente
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        
        System.out.print("Telefone do cliente (11 dígitos): ");
        String telefone = scanner.nextLine();
        
        System.out.print("Tipo de cliente (1 - Regular, 2 - VIP): ");
        int tipoCliente = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        
        Cliente cliente;
        try {
            if (tipoCliente == 2) {
                System.out.print("Desconto VIP (%): ");
                double desconto = scanner.nextDouble();
                scanner.nextLine(); // Limpar buffer
                cliente = new ClienteVIP(nome, telefone, desconto);
            } else {
                cliente = new Cliente(nome, telefone);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar cliente: " + e.getMessage());
            return;
        }

        // Listar mesas disponíveis
        restaurante.listarMesasDisponiveis();
        
        // Dados da reserva
        System.out.print("Número da mesa (1 a 10): ");
        int numeroMesa = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        
        System.out.print("Horário da reserva (dd/MM/yyyy HH:mm): ");
        String horario = scanner.nextLine();

        try {
            restaurante.fazerReserva(cliente, numeroMesa, horario);
        } catch (Exception e) {
            System.out.println("Erro ao fazer reserva: " + e.getMessage());
        }
    }

    private static void cancelarReserva(Scanner scanner, Restaurante restaurante) {
        scanner.nextLine(); // Limpar buffer
        
        System.out.println("\n--- Cancelar Reserva ---");
        System.out.println("1 - Cancelar por número da mesa");
        System.out.println("2 - Cancelar por nome do cliente");
        System.out.print("Escolha uma opção: ");
        
        int opcaoCancelar = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        try {
            switch (opcaoCancelar) {
                case 1:
                    System.out.print("Digite o número da mesa: ");
                    int numeroMesa = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    
                    Reserva reservaMesa = restaurante.buscarReservaPorMesa(numeroMesa);
                    if (reservaMesa != null) {
                        restaurante.cancelarReserva(reservaMesa);
                    } else {
                        System.out.println("Nenhuma reserva encontrada para a mesa " + numeroMesa);
                    }
                    break;
                    
                case 2:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    
                    Reserva reservaCliente = restaurante.buscarReservaPorCliente(nomeCliente);
                    if (reservaCliente != null) {
                        restaurante.cancelarReserva(reservaCliente);
                    } else {
                        System.out.println("Nenhuma reserva encontrada para o cliente " + nomeCliente);
                    }
                    break;
                    
                default:
                    System.out.println("Opção inválida.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao cancelar reserva: " + e.getMessage());
        }
    }
}
