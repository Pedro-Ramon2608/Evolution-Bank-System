# Evolution Bank System

O Evolution Bank System é um projeto evolutivo em Java projetado para simular as operações cruciais de um ecossistema bancário. O objetivo principal deste repositório é documentar a transição técnica da aplicação, partindo dos fundamentos da linguagem até arquiteturas robustas em nuvem com Spring Boot.

---
### 💻 Estado Atual do Projeto (Fase 1)

Nesta etapa inicial, a aplicação opera via CLI (Console/Terminal) com foco em persistência de dados local:

* **Cadastro e Gerenciamento de Contas:** Registro de novos usuários com gravação contínua dos dados em arquivo de texto plano (`BufferedWriter` e `FileWriter` em modo append).

* **Sistema de Autenticação (Login):** Leitura e parseamento do arquivo TXT para realizar a verificação de credenciais, comparando o e-mail e a senha informados pelo usuário com os registros salvos para autorizar o acesso.

* **Organização Modular:** Divisão clara de responsabilidades entre regras de negócio (`Metodos.java`), modelo de dados (`Usuario.java`, `Conta.java`, `Corrente.java`), gerenciamento de arquivos (`Arquivo.java`) e fluxo de execução (`Main.java`).

---
### 🚀 Roadmap de Evolução Pretendida

O projeto passará por quatro grandes fases de refatoração e expansão arquitetural:

Fase | Status | Descrição & Tecnologias
:---: | :---: | :---
Fase 1  | 🟢 Concluido  | Console, TXT & Autenticação: Manipulação de IO em Java, POO pura, cadastro e sistema de login com validação de e-mail e senha em arquivo local.
Fase 2 | 🟡 Em Breve | Interface Gráfica (Desktop): Substituição do fluxo CLI por telas interativas construídas com Java Swing / AWT.
Fase 3 | 🔴 Planejado | Persistência com Banco de Dados: Substituição da manipulação de arquivos TXT por um SGBD relacional (ex: PostgreSQL / MySQL) com JDBC.
Fase 4 | 🔴 Planejado | Ecossistema Web & Spring Boot: Transição da aplicação para uma API RESTful completa com Spring Boot, Spring Data JPA e segurança de dados.

---
### 🛠️ Tecnologias Utilizadas (Fase Atual)

* **Linguagem:** Java (JDK 8+)

* **Paradigma:** Programação Orientada a Objetos (POO)

* **Entrada/Saída (I/O) & Validação:** Pacote `java.io.*` (`BufferedReader` / `BufferedWriter`) para leitura de dados, comparação de `Strings` e tratamento de exceções com `IOException`.

---
### 📂 Estrutura do Projeto
```
Plaintext

EvolutionBankSystem/
│
├── src/
│   ├── Arquivo.java     # Leitura/escrita no TXT e lógica de comparação para login
│   ├── Conta.java       # Classe base de conta bancária
│   ├── Corrente.java    # Especialização de conta corrente
│   ├── Main.java        # Ponto de entrada da aplicação e menu CLI
│   ├── Metodos.java     # Regras de negócio e operações bancárias
│   └── Usuario.java     # Entidade de dados do usuário
│
├── .gitignore
├── LICENSE
└── README.md
```
---
### ⚙️ Como Executar (Fase 1)

Pré-requisitos

Ter o JDK (Java Development Kit) instalado na sua máquina.

```Bash
Bash
# 1. Clone o repositório
git clone https://github.com/Pedro-Ramon2608/EvolutionBankSystem.git

# 2. Acesse a pasta do projeto
cd EvolutionBankSystem

# 3. Compile os arquivos Java
javac src/*.java

# 4. Execute a aplicação
java -cp src Main
```
