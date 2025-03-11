Aqui está um exemplo de como você pode atualizar o arquivo **README.md** para o projeto de sistema de reservas de restaurante, incluindo as informações sobre o uso de `LocalDateTime` para o horário da reserva e outras melhorias:

---

# Sistema de Reservas de Restaurante

Este projeto é um sistema de reservas para um restaurante, desenvolvido em Java. Ele permite que os clientes façam reservas de mesas, cancelem reservas e listem as reservas existentes. O sistema foi projetado seguindo os princípios da Programação Orientada a Objetos (POO), como encapsulamento e composição.

---

## Funcionalidades

1. **Fazer Reserva**:
   - O cliente informa seu nome, telefone, número da mesa e horário da reserva.
   - O horário da reserva é validado e armazenado usando a classe `LocalDateTime`.
   - A mesa é marcada como ocupada após a reserva ser feita.

2. **Cancelar Reserva**:
   - O cliente pode cancelar uma reserva pelo número da mesa ou pelo nome do cliente.
   - A mesa é liberada após o cancelamento.

3. **Listar Reservas**:
   - Exibe todas as reservas feitas no restaurante, mostrando o nome do cliente, o número da mesa e o horário da reserva.

4. **Validações**:
   - O telefone do cliente deve ter 11 dígitos.
   - O número da mesa deve estar entre 1 e 10.
   - O horário da reserva deve estar no formato `dd/MM/yyyy HH:mm`.

---

## Estrutura do Projeto

O projeto é composto pelas seguintes classes:

1. **Cliente**:
   - Representa um cliente do restaurante.
   - Atributos: `nome`, `telefone`.
   - Validação: O telefone deve ter 11 dígitos.

2. **Mesa**:
   - Representa uma mesa do restaurante.
   - Atributos: `numero`, `capacidade`, `ocupada`.
   - Validação: O número da mesa deve estar entre 1 e 10.

3. **Reserva**:
   - Representa uma reserva feita por um cliente para uma mesa em um horário específico.
   - Atributos: `cliente`, `mesa`, `horario` (usando `LocalDateTime`).

4. **Restaurante**:
   - Gerencia as reservas do restaurante.
   - Implementa a interface `Reservavel`.
   - Métodos: `fazerReserva`, `cancelarReserva`, `listarReservas`, `buscarReservaPorMesa`, `buscarReservaPorCliente`.

5. **Main**:
   - Classe principal que controla a interação com o usuário.
   - Oferece um menu para fazer reservas, cancelar reservas e listar reservas.

6. **Reservavel**:
   - Interface que define os métodos `fazerReserva` e `cancelarReserva`.

---

## Melhorias Implementadas

1. **Uso de `LocalDateTime` para o horário da reserva**:
   - O horário da reserva agora é armazenado como um objeto `LocalDateTime`, o que permite validação e manipulação mais eficiente de datas e horários.
   - O formato do horário deve ser `dd/MM/yyyy HH:mm` (ex: `25/10/2023 14:00`).

2. **Validações adicionais**:
   - O telefone do cliente deve ter exatamente 11 dígitos.
   - O número da mesa deve estar entre 1 e 10.
   - O horário da reserva deve seguir o formato especificado.

3. **Encapsulamento**:
   - Todos os atributos das classes são privados e acessados apenas através de métodos `get` e `set`.
   - Isso garante que os dados sejam manipulados de forma segura e controlada.

---

## Como Executar o Projeto

1. **Pré-requisitos**:
   - Java Development Kit (JDK) instalado (versão 8 ou superior).
   - Um ambiente de desenvolvimento (IDE como IntelliJ, Eclipse ou VS Code) ou terminal.

2. **Compilação e Execução**:
   - Compile todos os arquivos `.java`:
     ```bash
     javac *.java
     ```
   - Execute a classe `Main`:
     ```bash
     java Main
     ```

3. **Uso do Sistema**:
   - Siga as instruções no menu para fazer reservas, cancelar reservas ou listar reservas.
   - Insira os dados solicitados, como nome, telefone, número da mesa e horário da reserva.

---

## Exemplo de Uso

### Fazer uma Reserva
1. Escolha a opção **1 - Fazer Reserva**.
2. Insira os dados:
   - Nome: `João Silva`
   - Telefone: `11987654321`
   - Número da mesa: `5`
   - Horário: `25/10/2023 14:00`
3. A reserva será feita se os dados forem válidos.

### Cancelar uma Reserva
1. Escolha a opção **2 - Cancelar Reserva**.
2. Escolha cancelar por número da mesa ou nome do cliente.
3. Insira o número da mesa ou o nome do cliente.
4. A reserva será cancelada se existir.

### Listar Reservas
1. Escolha a opção **3 - Listar Reservas**.
2. Todas as reservas serão exibidas, mostrando o nome do cliente, o número da mesa e o horário.

---

## Melhorias Futuras

1. **Persistência de Dados**:
   - Salvar as reservas em um arquivo ou banco de dados para que não sejam perdidas ao reiniciar o programa.

2. **Interface Gráfica**:
   - Desenvolver uma interface gráfica (GUI) para facilitar a interação com o usuário.

3. **Autenticação de Usuários**:
   - Adicionar um sistema de login para clientes e administradores.

4. **Notificações**:
   - Enviar lembretes de reservas por e-mail ou SMS.

---

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests com melhorias ou correções.

---

## Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais detalhes.

---

Este **README.md** atualizado reflete as melhorias no código, como o uso de `LocalDateTime` para o horário da reserva e as validações adicionais. Ele também fornece instruções claras sobre como executar o projeto e sugere melhorias futuras.
