import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurante restaurante = new Restaurante();
        int opcao;

        do {
            System.out.println("\n--- Sistema de Reservas de Restaurante ---");
            System.out.println("1 - Fazer Reserva");
            System.out.println("2 - Cancelar Reserva");
            System.out.println("3 - Listar Reservas");
            System.out.println("4 - Listar Mesas Disponíveis");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Fazer Reserva ---");
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone do cliente: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Tipo de cliente (1 - Regular, 2 - VIP): ");
                    int tipoCliente = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    Cliente cliente;
                    if (tipoCliente == 2) {
                        System.out.print("Desconto VIP (%): ");
                        double desconto = scanner.nextDouble();
                        scanner.nextLine(); // Consumir a quebra de linha
                        cliente = new ClienteVIP(nome, telefone, desconto);
                    } else {
                        cliente = new Cliente(nome, telefone);
                    }

                    restaurante.listarMesasDisponiveis(); // Lista as mesas disponíveis
                    System.out.print("Número da mesa (1 a 10): ");
                    int numeroMesa = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Horário da reserva: ");
                    String horario = scanner.nextLine();

                    try {
                        restaurante.fazerReserva(cliente, numeroMesa, horario);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("\n--- Cancelar Reserva ---");
                    System.out.println("Escolha uma opção:");
                    System.out.println("1 - Cancelar por número da mesa");
                    System.out.println("2 - Cancelar por nome do cliente");
                    int opcaoCancelar = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    switch (opcaoCancelar) {
                        case 1:
                            System.out.print("Digite o número da mesa: ");
                            int numeroMesaCancelar = scanner.nextInt();
                            scanner.nextLine(); // Consumir a quebra de linha

                            Reserva reservaPorMesa = restaurante.buscarReservaPorMesa(numeroMesaCancelar);
                            if (reservaPorMesa != null) {
                                restaurante.cancelarReserva(reservaPorMesa);
                            } else {
                                System.out.println("Nenhuma reserva encontrada para a mesa " + numeroMesaCancelar);
                            }
                            break;

                        case 2:
                            System.out.print("Digite o nome do cliente: ");
                            String nomeCliente = scanner.nextLine();

                            Reserva reservaPorCliente = restaurante.buscarReservaPorCliente(nomeCliente);
                            if (reservaPorCliente != null) {
                                restaurante.cancelarReserva(reservaPorCliente);
                            } else {
                                System.out.println("Nenhuma reserva encontrada para o cliente " + nomeCliente);
                            }
                            break;

                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    break;

                case 3:
                    System.out.println("\n--- Listar Reservas ---");
                    restaurante.listarReservas();
                    break;

                case 4:
                    System.out.println("\n--- Listar Mesas Disponíveis ---");
                    restaurante.listarMesasDisponiveis();
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 5);

        scanner.close();
    }
}
