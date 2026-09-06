# Evolution Bank System

O Evolution Bank System é um projeto evolutivo em Java projetado para simular as operações cruciais de um ecossistema bancário. O objetivo principal deste repositório é documentar a transição técnica da aplicação, partindo dos fundamentos da linguagem até arquiteturas robustas em nuvem com Spring Boot.

---
### 💻 Estado Atual do Projeto (Fase 1)

Nesta etapa inicial, a aplicação opera via CLI (Console/Terminal) com foco em persistência de dados local:

* **Gerenciamento de Contas:** Criação e manipulação de contas bancárias (ex: `Corrente`, `Conta`, `Usuario`).

* **Persistência em Arquivo TXT:** Gravação contínua dos dados dos usuários em arquivo de texto plano via manipulação de fluxos com `BufferedWriter` e `FileWriter` em modo _append_.

* **Organização Modular:** Divisão clara de responsabilidades entre regras de negócio (`Metodos.java`), modelo de dados (`Usuario.java`, `Conta.java`, `Corrente.java`), gerenciamento de arquivos (`Arquivo.java`) e fluxo de execução (`Main.java`).

---
### 🚀 Roadmap de Evolução Pretendida

O projeto passará por quatro grandes fases de refatoração e expansão arquitetural:

Fase | Status | Descrição & Tecnologias
:---: | :---: | :---
Fase 1  | 🟢 Concluido  | Aplicações via Console & TXT: Manipulação de IO em Java, POO pura e persistência de dados em arquivos locais .txt.
Fase 2 | 🟡 Em Breve | Interface Gráfica (Desktop): Substituição do fluxo CLI por telas interativas construídas com Java Swing / AWT.
Fase 3 | 🔴 Planejado | Persistência com Banco de Dados: Substituição da manipulação de arquivos TXT por um SGBD relacional (ex: PostgreSQL / MySQL) com JDBC.
Fase 4 | 🔴 Planejado | Ecossistema Web & Spring Boot: Transição da aplicação para uma API RESTful completa com Spring Boot, Spring Data JPA e segurança de dados.

---
### 🛠️ Tecnologias Utilizadas (Fase Atual)

* **Linguagem:** Java (JDK 8+)

* **Paradigma:** Programação Orientada a Objetos (POO)

* **Entrada/Saída (I/O):** Pacote `java.io.*` (`BufferedWriter`, `FileWriter`, tratamento de exceções com `IOException`)

---
### 📂 Estrutura do Projeto
```
Plaintext

EvolutionBankSystem/
│
├── src/
│   ├── Arquivo.java     # Manipulação de leitura e gravação no arquivo TXT
│   ├── Conta.java       # Classe base de conta bancária
│   ├── Corrente.java    # Especialização de conta corrente
│   ├── Main.java        # Ponto de entrada da aplicação
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
