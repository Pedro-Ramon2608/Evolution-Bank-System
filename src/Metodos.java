import java.util.Scanner;

public class Metodos {
    public static void iniciar(String caminhoArquivo) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true; // flag para encerrar o while

        while (continuar) {
            System.out.print("\nDigite a opção desejada: " +
                    "\n[ 1 ] - Login" +
                    "\n[ 2 ] - Criar conta" +
                    "\n[ 0 ] - Sair" +
                    "\nOpção: ");

            int opcao = sc.nextInt();
            sc.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    logar(sc, caminhoArquivo);
                    break;
                case 2:
                    criar(sc, caminhoArquivo);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Escolha uma opção válida.");
            }
        }
    } // Fim do metodo iniciar


    public static void criar(Scanner sc, String caminhoArquivo) {
        System.out.print("\nDigite seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite seu CPF: ");
        String cpf = sc.next();
        sc.nextLine(); // Limpar buffer

        System.out.print("Digite sua cidade: ");
        String cidade = sc.nextLine();

        System.out.print("Digite seu e-mail: ");
        String email = sc.next().trim();

        sc.nextLine(); // Limpar buffer

        System.out.print("Digite seu senha: ");
        String senha = sc.next().trim();

        sc.nextLine(); // Limpar buffer

        Corrente conta = Arquivo.criarConta(caminhoArquivo, nome, cpf, cidade, email, senha);

        if (conta != null) {
            home(sc, conta);
        }
    } // Fim do metodo criar


    public static void logar(Scanner sc, String caminhoArquivo) {
        System.out.print("\nDigite seu e-mail: ");
        String email = sc.next().trim();

        sc.nextLine(); // Limpar buffer

        System.out.print("Digite seu senha: ");
        String senha = sc.next().trim();

        sc.nextLine(); // Limpar buffer

        Corrente conta = Arquivo.loginConta(caminhoArquivo, email, senha);

        if (conta != null) {
            home(sc, conta);
        }
    } // Fim do metodo logar

    public static void home(Scanner sc, Corrente conta) {
        boolean continuar = true; // flag para encerrar o while

        double valor;

        System.out.println("\n------------------------------------------");
        System.out.println("Seja Bem-Vindo, " + conta.getNome());
        System.out.println("------------------------------------------");

        while (continuar) {
            System.out.print("\nDigite a opção desejada: " +
                    "\n[ 1 ] - Status da conta" +
                    "\n[ 2 ] - Depositar" +
                    "\n[ 3 ] - Sacar" +
                    "\n[ 0 ] - Sair" +
                    "\nOpção: ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    // Mostrar Status da conta
                    System.out.println(conta.status());
                    break;

                case 2:
                    // Depositar
                    System.out.print("Digite o valor que deseja depositar: ");
                    valor = sc.nextDouble();

                    conta.depositar(conta.getSenha(), valor);
                    break;

                case 3:
                    // Sacar
                    System.out.print("Digite o valor que deseja sacar: ");
                    valor = sc.nextDouble();

                    conta.sacar(conta.getSenha(), valor);
                    break;

                case 0:
                    // Encerra o programa
                    continuar = false;
                    break;
                default:
                    System.out.println("Escolha uma opção válida.");
            } // Fim switch

            sc.nextLine(); // Limpar buffer
        }

    } // Fim do metodo home

} // Fim classe
