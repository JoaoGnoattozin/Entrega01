# Sistema de Reservas de Restaurante com Java Swing

Este projeto é um sistema completo de reservas para restaurantes, desenvolvido em Java com interface gráfica Swing. Ele permite que clientes façam reservas de mesas, cancelem reservas existentes e visualizem informações sobre disponibilidade, seguindo os princípios de POO e boas práticas de desenvolvimento.

## 📋 Funcionalidades Principais

### 🖥️ Interface Gráfica Intuitiva
- **Sistema baseado em abas** para fácil navegação
- **Formulários validados** para entrada de dados segura
- **Tabelas interativas** para visualização de informações

### ✨ Funcionalidades do Sistema
1. **📅 Fazer Reservas**:
   - Cadastro de clientes (Regulares e VIP)
   - Seleção de mesas disponíveis
   - Agendamento com data/hora específica
   - Validação de conflitos de horários

2. **❌ Cancelamento de Reservas**:
   - Busca por número da mesa ou nome do cliente
   - Liberação automática da mesa após cancelamento

3. **🔍 Consultas**:
   - Listagem completa de todas as reservas
   - Visualização de mesas disponíveis/ocupadas
   - Detalhes sobre mesas VIP

## 🛠️ Tecnologias e Padrões Utilizados

- **Java Swing** para interface gráfica
- **POO** com herança, encapsulamento e polimorfismo
- **Validações robustas** em todos os campos
- **Design Pattern MVC** (Model-View-Controller) implícito
- **Java Date/Time API** para manipulação de horários

## 🖼️ Estrutura do Projeto

### Classes Principais

| Classe | Descrição |
|--------|-----------|
| `MainFrame` | Janela principal com abas do sistema |
| `ReservaPanel` | Painel para fazer novas reservas |
| `CancelarReservaPanel` | Painel para cancelamento de reservas |
| `ListarReservasPanel` | Painel que mostra todas as reservas |
| `MesasDisponiveisPanel` | Painel com status das mesas |

### Classes de Modelo (Mantidas do projeto original)

| Classe | Descrição |
|--------|-----------|
| `Cliente`/`ClienteVIP` | Representação dos clientes |
| `Mesa`/`MesaVIP` | Modelagem das mesas do restaurante |
| `Reserva` | Controle das reservas realizadas |
| `Restaurante` | Lógica principal do sistema |

## 🚀 Como Executar

1. **Pré-requisitos**:
   - JDK 8 ou superior
   - IDE Java (Eclipse, IntelliJ, NetBeans) ou compilador via linha de comando

2. **Compilação e Execução**:
   ```bash
   # Compilar todos os arquivos
   javac *.java
   
   # Executar o sistema
   java Main
   ```

3. **Uso do Sistema**:
   - Navegue entre as abas usando o menu superior
   - Preencha os formulários com os dados solicitados
   - Utilize os botões para confirmar ações

## 💡 Melhorias Futuras

1. **Banco de Dados**:
   - Integração com SQLite ou MySQL para persistência

2. **Novas Funcionalidades**:
   - Cadastro de cardápio digital
   - Sistema de pedidos online
   - Avaliação de clientes

3. **Aprimoramentos de UI**:
   - Temas personalizáveis
   - Gráficos de ocupação
   - Exportação de relatórios

4. **Sistema Multiplataforma**:
   - Versão Web complementar
   - Aplicativo mobile para clientes
