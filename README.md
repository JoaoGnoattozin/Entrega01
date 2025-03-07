# Entrega01
Reservation menu

Sistema de Reservas de Restaurante
Este projeto é um sistema de gerenciamento de reservas para um restaurante, desenvolvido como parte do Projeto Integrador do 3º período do curso de ADS da Uniamérica Descomplica. O sistema permite que os usuários façam, cancelem e listem reservas de mesas, aplicando conceitos de Programação Orientada a Objetos (POO).

# Sistema de Reservas de Restaurante

Este projeto é um sistema de gerenciamento de reservas para um restaurante, desenvolvido como parte do **Projeto Integrador** do 3º período do curso de Análise e Desenvolvimento de Sistemas (ADS) da Uniamérica Descomplica. O sistema permite que os usuários façam, cancelem e listem reservas de mesas, aplicando conceitos de **Programação Orientada a Objetos (POO)**.

---

## Funcionalidades

O sistema oferece as seguintes funcionalidades:

1. **Fazer Reserva**:
   - Cadastrar um cliente (nome e telefone).
   - Escolher uma mesa disponível (número entre 1 e 10).
   - Definir um horário para a reserva.
   - Validação de telefone (11 dígitos) e número da mesa (1 a 10).

2. **Cancelar Reserva**:
   - Cancelar por número da mesa ou nome do cliente.
   - Liberar a mesa para novas reservas.

3. **Listar Reservas**:
   - Visualizar todas as reservas feitas, com detalhes como cliente, mesa e horário.

4. **Sair**:
   - Encerrar o programa.

---

## Tecnologias e Conceitos Utilizados

- **Linguagem de Programação**: Java.
- **Conceitos de POO**:
  - Classes e Objetos.
  - Encapsulamento (atributos privados e métodos GET/SET).
  - Construtores (padrão, parametrizado e de cópia).
  - Herança e Polimorfismo (classe abstrata e métodos sobrescritos).
  - Composição (uma classe contendo outra como atributo).
  - Interfaces.
- **Estruturas de Dados**: `ArrayList` para armazenar reservas.
- **Interação com o Usuário**: Menu interativo no console usando `Scanner`.

---

## Pré-requisitos

- **Java Development Kit (JDK)**: Versão 11 ou superior.
- **IDE ou Editor de Texto**: Recomenda-se IntelliJ IDEA, Eclipse ou VS Code.

---

O projeto está organizado da seguinte forma:
reservas-restaurante/
├── src/
│   ├── Main.java               // Classe principal com o menu interativo.
│   ├── Restaurante.java        // Classe que gerencia as reservas.
│   ├── Reserva.java            // Classe que representa uma reserva.
│   ├── Mesa.java               // Classe que representa uma mesa.
│   ├── Cliente.java            // Classe que representa um cliente.
│   ├── Reservavel.java         // Interface para gerenciar reservas.
└── README.md                   // Documentação do projeto.


Agradecemos à Uniamérica Descomplica e aos professores pelo suporte e orientação durante o desenvolvimento deste projeto.
